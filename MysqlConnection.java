/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * gerencia a conexão de banco de dados. possui as instruções para conectar a banco
 * @author devsys-b
 */
public class MysqlConnection {
    //define strings de conexão com o banco.
    private static final String Driver = "com.mysql.jdbc.driver";
    private static final String URL = "jdbc:ysql://localhost:3306/ygo_dukemarket";
    
    private static final String USER = "yasmin";
    private static final String PASS = "21262821";


/**
 * cria conexão com o banco de dados MYSQL.
 * @return
 */
   public static Connection getConnection(){
       try{
           return DriverManager.getConnection(URL, USER, PASS);
           
       } catch (SQLException ex){
         throw new RuntimeException("erro na conexão com o BD. Verifique!", ex);
 
       }
       }
/**
 * fecha a conexão com DB.
 * @paran conn Connection a ser fechada.
 */
   public static void closeConnection(Connection conn){
       try {
           if (conn !=null){
               conn.close();
           }
       } catch (SQLException ex) {
          Logger.getLogger(MysqlConnection.class.getName()).log(Level.SEVERE, null, ex);
               
           
       }
   }
   public static void closeConnection (Connection conn, PreparedStatement stmt) {
        closeConnection(conn);
        
        try {
            if (stmt !=null){
                stmt.close();
            }
        } catch (SQLException ex){
            Logger.getLogger(
            MysqlConnection.class.getName()).log(Level.SEVERE,null,ex);
            
            
        }
        
    }

   public static void closeConnection (Connection conn, PreparedStatement stmt, ResultSet rs) {
        closeConnection(conn, stmt);
        
        try {
            if (rs !=null){
                rs.close();
            }
        } catch (SQLException ex){
            Logger.getLogger(
            MysqlConnection.class.getName()).log(Level.SEVERE,null,ex);
            
            
        }
        
    }
}
   

