package com.sistema.examenes.repository;

import com.sistema.examenes.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Este metodo esta aqui y no hay necesidad de implementarlo porque spring hace
    // esa magia. pero eso si tiene que llamarse
    // findByUserName o sea con mayusculas ByUserName asi tal cual sino no funciona
    public Usuario findByUsername(String username);
}
