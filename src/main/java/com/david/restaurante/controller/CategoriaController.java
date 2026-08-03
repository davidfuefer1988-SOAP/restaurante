package com.david.restaurante.controller;

import com.david.restaurante.model.Categoria;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CategoriaController {


    private List<Categoria> categorias = new ArrayList<>();


    public CategoriaController(){


        categorias.add(
                new Categoria(
                        1,
                        "Entrantes",
                        "Platos para compartir"
                )
        );


        categorias.add(
                new Categoria(
                        2,
                        "Postres",
                        "Dulces y cafés"
                )
        );


    }




    @GetMapping("/categorias")
    public String listarCategorias(Model model){


        model.addAttribute(
                "categorias",
                categorias
        );


        return "categorias";

    }





    @GetMapping("/categorias/nueva")
    public String nuevaCategoria(Model model){


        model.addAttribute(
                "categoria",
                new Categoria()
        );


        return "nueva-categoria";

    }





    @PostMapping("/categorias/guardar")
    public String guardarCategoria(
            @ModelAttribute Categoria categoria
    ){


        categoria.setId(
                categorias.size()+1
        );


        categorias.add(categoria);


        return "redirect:/categorias";

    }





    @GetMapping("/categorias/editar/{id}")
    public String editarCategoria(
            @PathVariable int id,
            Model model
    ){


        Categoria categoria =
                buscarCategoria(id);



        model.addAttribute(
                "categoria",
                categoria
        );



        return "nueva-categoria";

    }





    @PostMapping("/categorias/actualizar")
    public String actualizarCategoria(
            @ModelAttribute Categoria categoria
    ){


        for(int i=0;i<categorias.size();i++){


            if(categorias.get(i).getId()
                    == categoria.getId()){


                categorias.set(
                        i,
                        categoria
                );


            }


        }


        return "redirect:/categorias";

    }





    @GetMapping("/categorias/eliminar/{id}")
    public String eliminarCategoria(
            @PathVariable int id
    ){


        categorias.removeIf(
                categoria ->
                        categoria.getId()==id
        );


        return "redirect:/categorias";

    }





    private Categoria buscarCategoria(int id){


        for(Categoria categoria:categorias){


            if(categoria.getId()==id){


                return categoria;

            }


        }


        return null;

    }


}
