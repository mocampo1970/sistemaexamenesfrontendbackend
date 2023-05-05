package com.sistema.examenes;

import com.sistema.examenes.model.Rol;
import com.sistema.examenes.model.Usuario;
import com.sistema.examenes.model.UsuarioRol;
import com.sistema.examenes.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SistemaExamenesBackendApplication implements CommandLineRunner {

	@Autowired
	private UsuarioService usuarioService;

	public static void main(String[] args) {
		SpringApplication.run(SistemaExamenesBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Usuario usuario = new Usuario();

		usuario.setNombre("Mauricio");
		usuario.setApellido("Ocampo");
		usuario.setUsername("mocampo");
		usuario.setPassword("12345");
		usuario.setEmail("maoocampo@hotmail.com");
		usuario.setTelefono("3163670820");
		usuario.setPerfil("foto.png");

		// Vamos a crear un rol
		Rol rol = new Rol();
		rol.setRolId(1L);
		rol.setNombre("ADMIN");

		// vamos a relacionar estos 2 con el SET
		Set<UsuarioRol> usuarioRoles = new HashSet<>();
		UsuarioRol usuarioRol = new UsuarioRol();
		usuarioRol.setRol(rol);
		usuarioRol.setUsuario(usuario);
		usuarioRoles.add(usuarioRol);

		// Ahora vamos a guardar esto en la BD
		Usuario usuarioGuardado = usuarioService.guardarUsuario(usuario, usuarioRoles);

		System.out.println("usuario guardado" + usuarioGuardado.getUsername());
	}
}
