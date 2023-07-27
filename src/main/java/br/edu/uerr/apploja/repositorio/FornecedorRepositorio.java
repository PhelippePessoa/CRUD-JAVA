package br.edu.uerr.apploja.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.uerr.apploja.modelo.Fornecedor;

@Repository
public interface FornecedorRepositorio extends JpaRepository<Fornecedor, Integer> {

	//public fornecedor save();
}

