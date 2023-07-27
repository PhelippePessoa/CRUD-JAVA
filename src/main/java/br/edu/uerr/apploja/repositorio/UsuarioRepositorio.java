package br.edu.uerr.apploja.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.uerr.apploja.modelo.Usuario;

public interface UsuarioRepositorio  extends JpaRepository<Usuario , Integer>{
    
public Usuario findByLoginAndSenha(String login, String senha);

}