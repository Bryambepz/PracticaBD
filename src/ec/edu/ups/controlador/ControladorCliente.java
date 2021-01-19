/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author braya
 */
public class ControladorCliente {
//    private Connection con = null;
    List<Cliente> listadoClientes = null;

    public ControladorCliente() {
        listadoClientes = new ArrayList<>();
        this.read();
    }
    
    public boolean create(Cliente cliente){
        Connection con = ControladorBD.conectar();
        try {
            String createSql = "insert into Clientes(id,cedula_cliente,nombre,direccion,telefono,fecha_inicio,fecha_finalizacion,estado_tramite)"
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(createSql);
            ps.setInt(1, cliente.getId());
            ps.setString(2, cliente.getCedula());
            ps.setString(3, cliente.getNombre());
            ps.setString(4, cliente.getDireccion());
            ps.setString(5, cliente.getTelefono());
            ps.setDate(6, new java.sql.Date(cliente.getFecha_Fin().getDate()));
            ps.setDate(7, new java.sql.Date(cliente.getFecha_Fin().getDate()));
            ps.setString(8, cliente.getEstado_Tramite());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally{
            ControladorBD.closeBD(con);
        }
        return true;
    }
    
    public void read(){
        listadoClientes.clear();
        Connection con = ControladorBD.conectar();
        try {
            String buscarSQL = "SELECT * FROM clientes";
            PreparedStatement ps = con.prepareStatement(buscarSQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cl = new Cliente();
                cl.setId(rs.getInt(1));
                cl.setCedula(rs.getString(2));
                cl.setNombre(rs.getString(3));
                cl.setDireccion(rs.getString(4));
                cl.setTelefono(rs.getString(5));
                cl.setFecha_Inicio(new Date(rs.getDate(6).getTime()));
                cl.setFecha_Fin(new Date(rs.getDate(7).getTime()));
                cl.setEstado_Tramite(rs.getString(8));
                listadoClientes.add(cl);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            ControladorBD.closeBD(con);
        }
    }
    
    public boolean update(Cliente cliente){
        Connection con = ControladorBD.conectar();
        try {
            String updateSQL = "UPDATE clientes SET cedula = ?, nombre = ?, direccion = ?, telefono = ?, fecha_inicio = ?, fecha_finalizacion = ?, estado_tramite where id = ?";
//            String updateSQL = "UPDATE clientes SET cedula = '"+cliente.getCedula()+"',nombre = '" + cliente.getNombre() + "',direccion = '" + cliente.getDireccion() + "',telefono = '" + cliente.getTelefono() + "',fecha_inicio = " + cliente.getFecha_Inicio() + ",fecha_finaliacion = " + cliente.getFecha_Fin() + ",estado_tramite = '" + cliente.getEstado_Tramite() + "' WHERE id = " + cliente.getId();
            PreparedStatement ps = con.prepareStatement(updateSQL);
            ps.setInt(1, cliente.getId());
            ps.setString(2, cliente.getCedula());
            ps.setString(3, cliente.getNombre());
            ps.setString(4, cliente.getDireccion());
            ps.setString(5, cliente.getTelefono());
            ps.setDate(6, new java.sql.Date(cliente.getFecha_Inicio().getTime()));
            ps.setDate(7, new java.sql.Date(cliente.getFecha_Fin().getTime()));
            ps.setString(8, cliente.getEstado_Tramite());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        } finally{
            ControladorBD.closeBD(con);
        }
    }
    
    public boolean delete(int codigo){
        Connection con = ControladorBD.conectar();
        try {
            String deleteSQL = "DELETE FROM clientes WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(deleteSQL);
            ps.setInt(1, codigo);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        } finally{
            ControladorBD.closeBD(con);
        }
    }
    
    
    public void imprimir(){
        listadoClientes.stream().forEach(c -> System.out.println(c));
    }
    
    public int id(){
        if (!listadoClientes.isEmpty()) {
            return listadoClientes.size();
        }
        return 0;
    }
    
    public List findAll(){
        return listadoClientes;
    }
}
