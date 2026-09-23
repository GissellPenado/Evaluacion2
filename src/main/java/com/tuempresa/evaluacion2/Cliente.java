package com.tuempresa.evaluacion2;

public class Cliente {

    private String nombreCompleto;
    private String tipoCliente;
    private String ciudad;
    private String fechaNacimiento;
    private String tipoSolicitud;

    public Cliente(String nombreCompleto, String tipoCliente, String ciudad, String fechaNacimiento, String tipoSolicitud) {
        this.nombreCompleto = nombreCompleto;
        this.tipoCliente = tipoCliente;
        this.ciudad = ciudad;
        this.fechaNacimiento = fechaNacimiento;
        this.tipoSolicitud = tipoSolicitud;
    }

    public String getNombreCompleto() { return nombreCompleto; }
    public String getTipoCliente() { return tipoCliente; }
    public String getCiudad() { return ciudad; }
    public String getFechaNacimiento() { return fechaNacimiento; }
    public String getTipoSolicitud() { return tipoSolicitud; }


    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }
    public void setTipoCliente(String tipoCliente) { this.tipoCliente = tipoCliente; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }
    public void setFechaNacimiento(String fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }
    public void setTipoSolicitud(String tipoSolicitud) { this.tipoSolicitud = tipoSolicitud; }
}