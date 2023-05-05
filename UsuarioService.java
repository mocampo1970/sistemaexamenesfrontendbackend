package com.sistema.examenes.services;

import com.sistema.examenes.model.Usuario;
import com.sistema.examenes.model.UsuarioRol;

import java.util.Set;

public interface UsuarioService {

    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception;

    // Metodo para obtener un usuario
    public Usuario obtenerUsuario(String username);

    // Eliminar
    public void eliminarUsuario(Long usuarioId);

}
