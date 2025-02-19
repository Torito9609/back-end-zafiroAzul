package com.proyectofinal.backend_zafiro_azul.model;

import jakarta.persistence.*;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private Long idUsuario;
    @Column(nullable = false)
    private String nombreUsuario;
    @Column(nullable = false)
    private String telefonoUsuario;
    @Column(nullable = false)
    private String correoUsuario;
    @Column(nullable = false)
    private String direccionUsuario;
    @Column(nullable = false)
    private String passwordHash;
    @Column(nullable = false)
    private String passwordSalt;

    public Usuario(String correoUsuario, String direccionUsuario, Long idUsuario, String nombreUsuario, String passwordHash, String passwordSalt, String telefonoUsuario) {
        this.correoUsuario = correoUsuario;
        this.direccionUsuario = direccionUsuario;
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.passwordHash = passwordHash;
        this.passwordSalt = passwordSalt;
        this.telefonoUsuario = telefonoUsuario;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public String getDireccionUsuario() {
        return direccionUsuario;
    }

    public void setDireccionUsuario(String direccionUsuario) {
        this.direccionUsuario = direccionUsuario;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    public String getTelefonoUsuario() {
        return telefonoUsuario;
    }

    public void setTelefonoUsuario(String telefonoUsuario) {
        this.telefonoUsuario = telefonoUsuario;
    }
}
