/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;
import java.sql.*;

/**
 *
 * @author davi1
 * 
 * conexión a la base de datos
 */
public class Conexion {
    private static Connection cnx = null;
    
   public static Connection obtener() throws SQLException, ClassNotFoundException { 
      if (cnx == null) {
         try {
            Class.forName("com.mysql.jdbc.Driver"); //importanción del driver
            cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/contactos", "root", ""); //base de datos local
         } catch (SQLException ex) {
            throw new SQLException(ex);
         } catch (ClassNotFoundException ex) {
            throw new ClassCastException(ex.getMessage());
         }
      }
      return cnx;
    }
   
   public static void cerrar() throws SQLException { //método para terminar conexión a bd
      if (cnx != null) {
         cnx.close();
      }
    }
}
