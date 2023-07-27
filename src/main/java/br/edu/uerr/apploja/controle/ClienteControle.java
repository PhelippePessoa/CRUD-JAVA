package br.edu.uerr.apploja.controle;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.uerr.apploja.modelo.Cliente;
import br.edu.uerr.apploja.repositorio.ClienteRepositorio;

import br.edu.uerr.apploja.modelo.ClientePessoaFisica;
import br.edu.uerr.apploja.modelo.ClientePessoaJuridica;

import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class ClienteControle {

	@Autowired
	ClienteRepositorio clienteRepositorio;

	@GetMapping("/cliente")
	public String Cliente(Model modelo) {
		modelo.addAttribute("listaClientes", clienteRepositorio.findAll());
		return "cliente";
	}

	@GetMapping("/cadastroCliente")
	public String abreformCliente(Model modelo) {
		Cliente cliente = new Cliente();
		ClientePessoaFisica clientePessoaFisica = new ClientePessoaFisica();
		ClientePessoaJuridica clientePessoaJuridica = new ClientePessoaJuridica();
		modelo.addAttribute("cliente", cliente);
		modelo.addAttribute("clientePessoaFisica", clientePessoaFisica);
		modelo.addAttribute("clientePessoaJuridica", clientePessoaJuridica);
		return "formCliente";
	}

	@PostMapping("/salvarCliente")
	public String salvar(@ModelAttribute("cliente") Cliente cliente,
			@ModelAttribute("clientePessoaFisica") ClientePessoaFisica clientePessoaFisica,
			@ModelAttribute("clientePessoaJuridica") ClientePessoaJuridica clientePessoaJuridica,
			Model modelo) {
		if (cliente.getTipoCliente() != null) {
			if (cliente.getTipoCliente() == 1) { // Cliente Físico
				clienteRepositorio.save(clientePessoaFisica);
			} else if (cliente.getTipoCliente() == 2) { // Cliente Jurídico
				clienteRepositorio.save(clientePessoaJuridica);
			}
		} else {
			// Tratar o caso em que o tipoCliente é nulo, se necessário
			// Por exemplo, exibir uma mensagem de erro ao usuário
		}
		modelo.addAttribute("listaClientes", clienteRepositorio.findAll());
		return "redirect:/cliente";
	}

	@GetMapping("/deletarCliente/{id}")
	public String delCliente(@PathVariable("id") Integer id, Model modelo) {
		Cliente cliente = clienteRepositorio.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Este cliente não existe: " + id));
		clienteRepositorio.delete(cliente);
		modelo.addAttribute("listaClientes", clienteRepositorio.findAll());
		return "redirect:/cliente";
	}
}
