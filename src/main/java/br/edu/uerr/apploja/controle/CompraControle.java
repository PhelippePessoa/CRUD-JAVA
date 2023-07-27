package br.edu.uerr.apploja.controle;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import br.edu.uerr.apploja.modelo.Compras;
import br.edu.uerr.apploja.repositorio.ComprasRepositorio;



import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class CompraControle {
    

@Autowired
ComprasRepositorio compraRepositorio;


@GetMapping("/compra")
public String compra (Model modelo){

    modelo.addAttribute("listaCompra", compraRepositorio.findAll());
    
    return"Compras";

}

@GetMapping("/cadastroCompra")
    public String cadatroCompra(Model modelo) {
        Compras compra = new Compras();
        modelo.addAttribute("compra", compra);
        return "formCompra";
        }

@PostMapping("/salvarCompra")
    public String salvar(@ModelAttribute("Compra")Compras compra, Model modelo) {
        
        compraRepositorio.save(compra);
        
        modelo.addAttribute("listaCompra", compraRepositorio.findAll());
        return "redirect:compra";

        }
@GetMapping("/deletarcompra/{id}")
    public String delCompra(@PathVariable("id") Integer id, Model modelo) {
        
        Compras compra = compraRepositorio.findById(id)
                
                
                .orElseThrow(()->new IllegalArgumentException("Este cliente não existe: "+id));

                compraRepositorio.delete(compra);

        modelo.addAttribute("listaCompra", compraRepositorio.findAll());
        return "redirect:/compra";
    }
}