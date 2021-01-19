/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.util.Date;

/**
 *
 * @author braya
 */
public class Cliente {
    private int id;
    private String cedula;
    private String nombre;
    private String direccion;
    private String telefono;
    private Date fecha_Inicio;
    private Date fecha_Fin;
    private String estado_Tramite;

    public Cliente() {
    }
    
    public Cliente(int id, String cedula, String nombre, String direccion, String telefono, Date fecha_Inicio, Date fecha_Fin, String estado_Tramite) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fecha_Inicio = fecha_Inicio;
        this.fecha_Fin = fecha_Fin;
        this.estado_Tramite = estado_Tramite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFecha_Inicio() {
        return fecha_Inicio;
    }

    public void setFecha_Inicio(Date fecha_Inicio) {
        this.fecha_Inicio = fecha_Inicio;
    }

    public Date getFecha_Fin() {
        return fecha_Fin;
    }

    public void setFecha_Fin(Date fecha_Fin) {
        this.fecha_Fin = fecha_Fin;
    }

    public String getEstado_Tramite() {
        return estado_Tramite;
    }

    public void setEstado_Tramite(String estado_Tramite) {
        this.estado_Tramite = estado_Tramite;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", cedula=" + cedula + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono + ", fecha_Inicio=" + fecha_Inicio + ", fecha_Fin=" + fecha_Fin + ", estado_Tramite=" + estado_Tramite + '}';
    }
    
}
