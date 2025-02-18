package com.proyectofinal.backend_zafiro_azul.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario_temporal {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long Id_Usuario_Temp;
    private String Nombre_Usuario_Temp;
    private String Correo_Usuario_Temp;
    private String Telefono_Usuario_Temp;
    private String Direccio_Usuario_Temp;


    public Usuario_temporal(Long id_Usuario_Temp, String nombre_Usuario_Temp, String correo_Usuario_Temp, String telefono_Usuario_Temp, String direccio_Usuario_Temp) {
        Id_Usuario_Temp = id_Usuario_Temp;
        Nombre_Usuario_Temp = nombre_Usuario_Temp;
        Correo_Usuario_Temp = correo_Usuario_Temp;
        Telefono_Usuario_Temp = telefono_Usuario_Temp;
        Direccio_Usuario_Temp = direccio_Usuario_Temp;
    }

    public Usuario_temporal() {
    }


    public Long getId_Usuario_Temp() {
        return Id_Usuario_Temp;
    }

    public void setId_Usuario_Temp(Long id_Usuario_Temp) {
        Id_Usuario_Temp = id_Usuario_Temp;
    }

    public String getNombre_Usuario_Temp() {
        return Nombre_Usuario_Temp;
    }

    public void setNombre_Usuario_Temp(String nombre_Usuario_Temp) {
        Nombre_Usuario_Temp = nombre_Usuario_Temp;
    }

    public String getCorreo_Usuario_Temp() {
        return Correo_Usuario_Temp;
    }

    public void setCorreo_Usuario_Temp(String correo_Usuario_Temp) {
        Correo_Usuario_Temp = correo_Usuario_Temp;
    }

    public String getTelefono_Usuario_Temp() {
        return Telefono_Usuario_Temp;
    }

    public void setTelefono_Usuario_Temp(String telefono_Usuario_Temp) {
        Telefono_Usuario_Temp = telefono_Usuario_Temp;
    }

    public String getDireccio_Usuario_Temp() {
        return Direccio_Usuario_Temp;
    }

    public void setDireccio_Usuario_Temp(String direccio_Usuario_Temp) {
        Direccio_Usuario_Temp = direccio_Usuario_Temp;
    }
}
