package com.proyectofinal.backend_zafiro_azul.service;

import com.proyectofinal.backend_zafiro_azul.model.Usuario_temporal;
import com.proyectofinal.backend_zafiro_azul.repository.IUsuario_TemporalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Usuario_TemporalService implements Iusuario_TemporalService{

    @Autowired
    private IUsuario_TemporalRepository iUsuarioTemporalRepository;


    @Override
    public List<Usuario_temporal> getUsuario_Temporal() {
        List<Usuario_temporal>ListaUsuarioTemporal =
                iUsuarioTemporalRepository.findAll();
        return ListaUsuarioTemporal;
    }

    @Override
    public void saveUsuario_Temporal(Usuario_temporal tempo) {
        iUsuarioTemporalRepository.save(tempo);

    }

    @Override
    public void deleteUsuario_Temporal(Long id) {
        iUsuarioTemporalRepository.deleteById(id);
    }

    @Override
    public Usuario_temporal findUsuario_Temporal(long id) {
        Usuario_temporal tempo =
        iUsuarioTemporalRepository.findById(id).orElse(null);
        return tempo;
    }

    @Override
    public void editUsuario_Temporal(Long id, Usuario_temporal UsuarioTemporalActualizado) {
        Usuario_temporal temporalExistente =
                iUsuarioTemporalRepository.findById(id).orElse(null);

        if (temporalExistente != null) {

            temporalExistente.setNombre_Usuario_Temp(UsuarioTemporalActualizado.getNombre_Usuario_Temp());
            temporalExistente.setCorreo_Usuario_Temp(UsuarioTemporalActualizado.getCorreo_Usuario_Temp());
            temporalExistente.setTelefono_Usuario_Temp(UsuarioTemporalActualizado.getTelefono_Usuario_Temp());
            temporalExistente.setDireccio_Usuario_Temp(UsuarioTemporalActualizado.getDireccio_Usuario_Temp());

            iUsuarioTemporalRepository.save(temporalExistente);
        }else{
            System.out.println("No se encontro ningun usuaripo con el id: "+ id);
        }



    }
}
