package com.david.restaurante.controller;

import com.david.restaurante.model.Mesa;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MesaController {

    private List<Mesa> mesas = new ArrayList<>();

    public MesaController(){

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

    }

    @GetMapping("/mesas")
    public String listarMesas(Model model){

        model.addAttribute("mesas",mesas);

        return "mesas";

    }

    @GetMapping("/mesas/nueva")
    public String nuevaMesa(Model model){

        model.addAttribute("mesa",new Mesa());

        return "nueva-mesa";

    }

    @PostMapping("/mesas/guardar")
    public String guardarMesa(@ModelAttribute Mesa mesa){

        mesa.setId(mesas.size()+1);

        mesas.add(mesa);

        return "redirect:/mesas";

    }

    @GetMapping("/mesas/editar/{id}")
    public String editarMesa(@PathVariable int id, Model model){

        Mesa mesa = buscarMesa(id);

        model.addAttribute("mesa",mesa);

        return "nueva-mesa";

    }

    @PostMapping("/mesas/actualizar")
    public String actualizarMesa(@ModelAttribute Mesa mesa){

        for(int i=0;i<mesas.size();i++){

            if(mesas.get(i).getId()==mesa.getId()){

                mesas.set(i,mesa);

            }

        }

        return "redirect:/mesas";

    }

    @GetMapping("/mesas/eliminar/{id}")
    public String eliminarMesa(@PathVariable int id){

        mesas.removeIf(m->m.getId()==id);

        return "redirect:/mesas";

    }

    private Mesa buscarMesa(int id){

        for(Mesa mesa:mesas){

            if(mesa.getId()==id){

                return mesa;

            }

        }

        return null;

    }

}