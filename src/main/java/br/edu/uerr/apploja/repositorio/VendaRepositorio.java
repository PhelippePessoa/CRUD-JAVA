package br.edu.uerr.apploja.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.uerr.apploja.modelo.Venda;

@Repository
public interface VendaRepositorio extends JpaRepository <Venda, Integer>{


}