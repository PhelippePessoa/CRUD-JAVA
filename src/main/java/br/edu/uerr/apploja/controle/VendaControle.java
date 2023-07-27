package br.edu.uerr.apploja.controle;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.uerr.apploja.modelo.Venda;
import br.edu.uerr.apploja.repositorio.VendaRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

@Controller
public class VendaControle {

    @Autowired
    VendaRepositorio vendaRepositorio;
    private JpaRepository<Venda, Integer> produtosRepositorio;

    @GetMapping("/venda")
    public String venda(Model modelo) {

        modelo.addAttribute("listaVenda", vendaRepositorio.findAll());

        return "venda";

    }

    @GetMapping("/cadastroVenda")
    public String abreformvenda(Model modelo) {
        Venda venda = new Venda();
        modelo.addAttribute("venda", venda);
        return "formVenda";
    }

    @PostMapping("/salvarVenda")
    public String salvar(@ModelAttribute("Venda") Venda venda, Model modelo) {

        vendaRepositorio.save(venda);
         modelo.addAttribute("listaProdutos", produtosRepositorio.findAll());	
        modelo.addAttribute("listaVenda", vendaRepositorio.findAll());
        return "redirect:venda";

    }

    @GetMapping("/deletarvenda/{id}")
    public String delVenda(@PathVariable("id") Integer id, Model modelo) {

        Venda Venda = vendaRepositorio.findById(id)

                .orElseThrow(() -> new IllegalArgumentException("Este cliente não existe: " + id));

        vendaRepositorio.delete(Venda);

        modelo.addAttribute("listaVenda", vendaRepositorio.findAll());
        return "redirect:/venda";
    }
}