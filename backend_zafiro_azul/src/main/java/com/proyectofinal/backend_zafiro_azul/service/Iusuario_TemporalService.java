package com.proyectofinal.backend_zafiro_azul.service;

import com.proyectofinal.backend_zafiro_azul.model.Usuario_temporal;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface Iusuario_TemporalService {

    List <Usuario_temporal> getUsuario_Temporal();

    //guardar
    public void saveUsuario_Temporal (Usuario_temporal tempo);

    public void deleteUsuario_Temporal(Long id);

    public Usuario_temporal findUsuario_Temporal(long id);

    public void editUsuario_Temporal(Long id,
                                     Usuario_temporal UsuarioTemporalActualizado);
    


}
