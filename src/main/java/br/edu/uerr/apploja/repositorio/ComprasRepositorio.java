package br.edu.uerr.apploja.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.uerr.apploja.modelo.Compras;

@Repository
public interface ComprasRepositorio extends JpaRepository <Compras, Integer>{


}