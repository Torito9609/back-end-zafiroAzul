package com.proyectofinal.backend_zafiro_azul.repository;


import com.proyectofinal.backend_zafiro_azul.model.Usuario_temporal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuario_TemporalRepository extends JpaRepository <Usuario_temporal, Long> {

}
