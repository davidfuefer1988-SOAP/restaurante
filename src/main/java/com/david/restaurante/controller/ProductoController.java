package com.david.restaurante.controller;

import com.david.restaurante.model.Producto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductoController {

    private List<Producto> productos = new ArrayList<>();

    public ProductoController(){

        productos.add(
                new Producto(
                        1,
                        "Hamburguesa Completa",
                        12.50
                )
        );

        productos.add(
                new Producto(
                        2,
                        "Pizza Barbacoa",
                        14.90
                )
        );

    }

    @GetMapping("/productos")
    public String listarProductos(Model model){

        model.addAttribute("productos",productos);

        return "productos";

    }

    @GetMapping("/productos/nuevo")
    public String nuevoProducto(Model model){

        model.addAttribute("producto",new Producto());

        return "nuevo-producto";

    }

    @PostMapping("/productos/guardar")
    public String guardarProducto(@ModelAttribute Producto producto){

        producto.setId(productos.size()+1);

        productos.add(producto);

        return "redirect:/productos";

    }

    @GetMapping("/productos/editar/{id}")
    public String editarProducto(@PathVariable int id, Model model){

        Producto producto = buscarProducto(id);

        model.addAttribute("producto",producto);

        return "nuevo-producto";

    }

    @PostMapping("/productos/actualizar")
    public String actualizarProducto(@ModelAttribute Producto producto){

        for(int i=0;i<productos.size();i++){

            if(productos.get(i).getId()==producto.getId()){

                productos.set(i,producto);

            }

        }

        return "redirect:/productos";

    }

    @GetMapping("/productos/eliminar/{id}")
    public String eliminarProducto(@PathVariable int id){

        productos.removeIf(producto -> producto.getId()==id);

        return "redirect:/productos";

    }

    private Producto buscarProducto(int id){

        for(Producto producto : productos){

            if(producto.getId()==id){

                return producto;

            }

        }

        return null;

    }

}