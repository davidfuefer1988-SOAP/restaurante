package com.david.restaurante.controller;

import com.david.restaurante.model.Cliente;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ClienteController {

    private List<Cliente> clientes = new ArrayList<>();

    public ClienteController() {

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

    }

    @GetMapping("/clientes")
    public String listarClientes(Model model){

        model.addAttribute(
                "clientes",
                clientes
        );

        return "clientes";

    }

    @GetMapping("/clientes/nuevo")
    public String nuevoCliente(Model model){

        model.addAttribute(
                "cliente",
                new Cliente()
        );

        return "nuevo-cliente";

    }

    @PostMapping("/clientes/guardar")
    public String guardarCliente(
            @ModelAttribute Cliente cliente
    ){

        cliente.setId(
                clientes.size()+1
        );

        clientes.add(cliente);

        return "redirect:/clientes";

    }

    @GetMapping("/clientes/editar/{id}")
    public String editarCliente(
            @PathVariable int id,
            Model model
    ){

        Cliente cliente = buscarCliente(id);

        model.addAttribute(
                "cliente",
                cliente
        );

        return "nuevo-cliente";

    }

    @PostMapping("/clientes/actualizar")
    public String actualizarCliente(
            @ModelAttribute Cliente cliente
    ){

        for(int i=0;i<clientes.size();i++){

            if(clientes.get(i).getId()==cliente.getId()){

                clientes.set(i,cliente);

            }

        }

        return "redirect:/clientes";

    }

    @GetMapping("/clientes/eliminar/{id}")
    public String eliminarCliente(
            @PathVariable int id
    ){

        clientes.removeIf(
                cliente->cliente.getId()==id
        );

        return "redirect:/clientes";

    }

    private Cliente buscarCliente(int id){

        for(Cliente cliente:clientes){

            if(cliente.getId()==id){

                return cliente;

            }

        }

        return null;

    }

}