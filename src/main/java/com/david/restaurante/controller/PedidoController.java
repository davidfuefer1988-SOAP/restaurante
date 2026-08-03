package com.david.restaurante.controller;

import com.david.restaurante.model.Cliente;
import com.david.restaurante.model.Mesa;
import com.david.restaurante.model.Pedido;
import com.david.restaurante.model.Producto;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
public class PedidoController {


    private List<Pedido> pedidos = new ArrayList<>();

    private List<Cliente> clientes = new ArrayList<>();

    private List<Mesa> mesas = new ArrayList<>();

    private List<Producto> productos = new ArrayList<>();



    public PedidoController(){


        clientes.add(
                new Cliente(
                        1,
                        "David",
                        "600123456"
                )
        );


        clientes.add(
                new Cliente(
                        2,
                        "María",
                        "611987654"
                )
        );



        mesas.add(
                new Mesa(
                        1,
                        1,
                        4
                )
        );


        mesas.add(
                new Mesa(
                        2,
                        2,
                        6
                )
        );



        productos.add(
                new Producto(
                        1,
                        "Hamburguesa",
                        12.50
                )
        );


        productos.add(
                new Producto(
                        2,
                        "Pizza",
                        14.90
                )
        );



        pedidos.add(
                new Pedido(
                        1,
                        clientes.get(0),
                        mesas.get(0),
                        productos.get(0),
                        2
                )
        );


    }





    @GetMapping("/pedidos")
    public String listarPedidos(Model model){


        model.addAttribute(
                "pedidos",
                pedidos
        );


        return "pedidos";

    }





    @GetMapping("/pedidos/nuevo")
    public String nuevoPedido(Model model){


        model.addAttribute(
                "clientes",
                clientes
        );


        model.addAttribute(
                "mesas",
                mesas
        );


        model.addAttribute(
                "productos",
                productos
        );


        return "nuevo-pedido";

    }





    @PostMapping("/pedidos/guardar")
    public String guardarPedido(

            @RequestParam int clienteId,

            @RequestParam int mesaId,

            @RequestParam int productoId,

            @RequestParam int cantidad

    ){



        Cliente cliente = null;

        Mesa mesa = null;

        Producto producto = null;



        for(Cliente c:clientes){

            if(c.getId()==clienteId){

                cliente=c;

            }

        }



        for(Mesa m:mesas){

            if(m.getId()==mesaId){

                mesa=m;

            }

        }



        for(Producto p:productos){

            if(p.getId()==productoId){

                producto=p;

            }

        }



        pedidos.add(

                new Pedido(

                        pedidos.size()+1,

                        cliente,

                        mesa,

                        producto,

                        cantidad

                )

        );



        return "redirect:/pedidos";


    }





    @GetMapping("/pedidos/eliminar/{id}")
    public String eliminarPedido(
            @PathVariable int id
    ){


        pedidos.removeIf(

                pedido ->
                        pedido.getId()==id

        );


        return "redirect:/pedidos";


    }



}