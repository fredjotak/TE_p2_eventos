package com.emergentes.dao;

import com.emergentes.modelo.Seminario;
import com.emergentes.utiles.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SeminarioDAOimpl extends ConexionBD implements SeminarioDAO{

    @Override
    public void insert(Seminario seminario) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO seminarios(titulo, expositor, fecha, hora, cupo) VALUES(?, ?, ?, ?, ?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, seminario.getTitulo());
            ps.setString(2, seminario.getExpositor());
            ps.setString(3, seminario.getFecha().toString());
            ps.setString(4, seminario.getHora());
            ps.setInt(5, seminario.getCupo());
            
            // Ejecutar para insertar
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally{
            this.desconectar();
        }
    }

    @Override
    public void update(Seminario seminario) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE seminarios SET titulo = ?, expositor = ?, fecha = ?, hora = ?, cupo = ? WHERE id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, seminario.getTitulo());
            ps.setString(2, seminario.getExpositor());
            ps.setString(3, seminario.getFecha());
            ps.setString(4, seminario.getHora());
            ps.setInt(5, seminario.getCupo());
            ps.setInt(6, seminario.getId());
            
            // Ejecutar pára actualizar
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally{
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            String sql = "DELETE FROM seminarios  WHERE id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            
            // Ejecutar para eliminar
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally{
            this.desconectar();
        }
    }

    @Override
    public Seminario getById(int id) throws Exception {
        Seminario seminario = new Seminario();
        try {
            this.conectar();
            
            String sql = "SELECT * FROM seminarios WHERE id = ?";
            PreparedStatement  ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet rs =  ps.executeQuery();
            if(rs.next()){
                seminario.setId(rs.getInt("id"));
                seminario.setTitulo(rs.getString("titulo"));
                seminario.setExpositor(rs.getString("expositor"));
                seminario.setFecha(rs.getString("fecha"));
                seminario.setHora(rs.getString("hora"));
                seminario.setCupo(rs.getInt("cupo"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return seminario;
    }

    @Override
    public List<Seminario> getAll() throws Exception {
        List<Seminario> lista = null;
        try {
            this.conectar();
            String sql = "SELECT * FROM seminarios";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<>();
            while(rs.next()){
                Seminario seminario = new Seminario();
                seminario.setId(rs.getInt("id"));
                seminario.setTitulo(rs.getString("titulo"));
                seminario.setExpositor(rs.getString("expositor"));
                seminario.setFecha(rs.getString("fecha"));
                seminario.setHora(rs.getString("hora"));
                seminario.setCupo(rs.getInt("cupo"));
                lista.add(seminario);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return lista;
    }
    
}
