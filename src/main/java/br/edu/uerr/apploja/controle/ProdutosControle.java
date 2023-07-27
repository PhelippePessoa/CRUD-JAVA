package br.edu.uerr.apploja.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.uerr.apploja.modelo.Produtos;
import br.edu.uerr.apploja.repositorio.EmpresaRepositorio;
import br.edu.uerr.apploja.repositorio.FornecedorRepositorio;
import br.edu.uerr.apploja.repositorio.ProdutosRepositorio;

@Controller

public class ProdutosControle {

	@Autowired
	private ProdutosRepositorio produtoRepositorio;

	@Autowired
	private EmpresaRepositorio empresaRepositorio;

	@Autowired
	private FornecedorRepositorio fornecedorRepositorio;

	// Listar produtos
	@GetMapping("/produtos")
	public String listarProdutos(Model model) {
		model.addAttribute("listaProdutos", produtoRepositorio.findAll());
		return "produtos";
	}

	// Abrir formulário de cadastro de produto
	@GetMapping("/cadastroProduto")
	public String abrirFormularioProduto(Model model) {
		Produtos produto = new Produtos();
		model.addAttribute("listaEmpresas", empresaRepositorio.findAll());
		model.addAttribute("listaFornecedores", fornecedorRepositorio.findAll());
		model.addAttribute("produto", produto);
		return "formProduto";
	}

	// Salvar novo produto
	@PostMapping("/salvarProduto")
	public String salvarProduto(@ModelAttribute("produto") Produtos produto) {
		produtoRepositorio.save(produto);
		return "redirect:/produtos";
	}

	@GetMapping("/alterarProduto/{id}")
	public String editarProduto(@PathVariable("id") Integer id, Model model) {
		Produtos produtos = produtoRepositorio.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Produto não encontrado: " + id));

		model.addAttribute("produto", produtos);
		return "formProduto";
	}

	@GetMapping("/produtos/excluir/{id}")
	public String excluirProduto(@PathVariable("id") Integer id) {
		Produtos produto = produtoRepositorio.findById(id).orElse(null);

		if (produto == null) {
			return "redirect:/produtos";
		}

		produtoRepositorio.delete(produto);
		return "redirect:/produtos";
	}
}
