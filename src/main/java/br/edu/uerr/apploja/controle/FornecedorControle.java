package br.edu.uerr.apploja.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.uerr.apploja.modelo.Fornecedor;
import br.edu.uerr.apploja.repositorio.FornecedorRepositorio;

@Controller
public class FornecedorControle {

    @Autowired
    FornecedorRepositorio fornecedorRepositorio;

    // Abrir lista
    @GetMapping("/fornecedores")
    public String abrirFornecedor(Model model) {
        model.addAttribute("listaFornecedores", fornecedorRepositorio.findAll());
        return "fornecedor";
    }

    // Abrir Form de Fornecedor
    @GetMapping("/fornecedores/cadastro")
    public String abrirFormFornecedor(Model model) {
        Fornecedor fornecedor = new Fornecedor();
        model.addAttribute("fornecedor", fornecedor);
        return "formFornecedor";
    }

    @PostMapping("/salvarFornecedor")
    public String salvarFornecedor(@ModelAttribute("fornecedor") Fornecedor fornecedor, Model modelo) {

        fornecedorRepositorio.save(fornecedor);

        modelo.addAttribute("listaFornecedor", fornecedorRepositorio.findAll());
        return "redirect:/fornecedores";
    }

    @GetMapping("/fornecedores/alterar/{id}")
    public String editar(@PathVariable("id") Integer id, Model model) {

        Fornecedor fornecedor = fornecedorRepositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Fornecedor não encontrado: " + id));

        model.addAttribute("fornecedor", fornecedor);
        return "formFornecedor";
    }

    @GetMapping("/fornecedores/excluir/{id}")
    public String excluirFornecedor(@PathVariable("id") Integer id) {
        Fornecedor fornecedor = fornecedorRepositorio.findById(id).orElse(null);

        if (fornecedor == null) {
            return "redirect:/fornecedores"; 
        }

        fornecedorRepositorio.deleteById(id);
        return "redirect:/fornecedores";
    }

}
