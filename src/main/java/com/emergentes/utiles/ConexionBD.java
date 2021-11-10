package com.emergentes.utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    static String driver = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/bd_eventos";
    static String usuario = "root";
    static String password = "";
    
    protected Connection conn = null;
    
    public ConexionBD(){
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, usuario, password);
            
            if(conn!=null){
                System.out.println("Conexión exitosa ...");
            }
        } catch(ClassNotFoundException ex){
            System.out.println("ERROR en Driver: "+ex.getMessage());
        } catch(SQLException ex){
            System.out.println("ERROR al conectar: "+ex.getMessage());
        }
    }
    
    public Connection conectar(){
        return conn;
    }
    
    public void desconectar(){
        try {
            conn.close();
        } catch(SQLException ex){
            System.out.println("ERROR al cerrar la base de datos: "+ex.getMessage());
        }
    }
}