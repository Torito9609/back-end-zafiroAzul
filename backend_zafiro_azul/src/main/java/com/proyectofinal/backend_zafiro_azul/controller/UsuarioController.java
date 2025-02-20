package com.proyectofinal.backend_zafiro_azul.controller;
import com.proyectofinal.backend_zafiro_azul.model.Usuario;
import com.proyectofinal.backend_zafiro_azul.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    //Obtener todos los usuarios
    @GetMapping("/traer")
    public List<Usuario> getAllUsuarios() {
        return usuarioService.getAllUsuarios();
    }

    //Obtener un usuario por ID
    @GetMapping("/traer/{id}")
    public ResponseEntity<Usuario> findUsuario(@PathVariable Long id) {
        Usuario usuario = usuarioService.findUsuario(id);
        return ResponseEntity.ok(usuario);
    }

    //Registro de un nuevo usuario
    @PostMapping("/registrar")
    public ResponseEntity<String> createUsuario(@RequestBody Usuario usuario) {
        usuarioService.createUsuario(usuario);
        return ResponseEntity.ok("Usuario creado exitosamente");
    }

    //Actualizar un usuario existente
    @PutMapping("/editar/{id}")
    public ResponseEntity<String> updateUsuario(@PathVariable Long id, @RequestBody Usuario usuarioUpdated) {
        Usuario usuarioExistente = usuarioService.findUsuario(id);
        if (usuarioExistente != null) {
            usuarioService.updateUsuario(id, usuarioUpdated);
            return ResponseEntity.ok("Usuario actualizado correctamente");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Eliminar un usuario
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<String> deleteUsuario(@PathVariable Long id) {
        Usuario usuarioExistente = usuarioService.findUsuario(id);
        if (usuarioExistente != null) {
            usuarioService.deleteUsuario(id);
            return ResponseEntity.ok("Usuario eliminado exitosamente");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Autenticar un usuario
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody Usuario loginRequest){
        Usuario usuario = usuarioService.findByCorreo(loginRequest.getCorreoUsuario());

        if(usuario != null && usuario.getPasswordHash().equals(loginRequest.getPasswordHash())){
            return ResponseEntity.ok("Ha iniciado sesión exitosamente");
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
