package br.edu.uerr.apploja.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.uerr.apploja.modelo.Produtos;

@Repository
public interface ProdutosRepositorio extends JpaRepository<Produtos, Integer>{

	//public produtos save();
}



