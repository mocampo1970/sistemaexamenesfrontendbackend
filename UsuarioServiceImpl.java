package com.sistema.examenes.impl;

import com.sistema.examenes.model.Usuario;
import com.sistema.examenes.model.UsuarioRol;
import com.sistema.examenes.repository.RolRepository;
import com.sistema.examenes.repository.UsuarioRepository;
import com.sistema.examenes.services.UsuarioService;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

// Clase de service que va a implementar la interfaz con los metodos vacios alla

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    @Override
    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception {

        // Este metodo esta en la interfaz y alla no hay necesidad de implementarlo porque spring hace
        // esa magia
        Usuario usuarioLocal = usuarioRepository.findByUsername(usuario.getUsername());

        if (usuarioLocal != null){
            System.out.println("Usuario ya existe");
            throw new Exception("El usuario ya esta presente");
        }else{
            for (UsuarioRol usuarioRol: usuarioRoles){
                // Aqui voy a guardar el rol que le estoy pasando
                rolRepository.save(usuarioRol.getRol());
            }
            // Este metodo me sacaba error y era porque en la entidad no estaba el get y set de esa lista
            usuario.getUsuarioRoles().addAll(usuarioRoles);
            // Aqu guarda el usuario
            usuarioLocal = usuarioRepository.save(usuario);
        }

        return usuarioLocal;
    }

    @Override
    public Usuario obtenerUsuario(String username) {
        return usuarioRepository.findByUsername(username);
    }

    @Override
    public void eliminarUsuario(Long usuarioId) {
        usuarioRepository.deleteById(usuarioId);
    }


}
