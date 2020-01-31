/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import logica.Contacto;

/**
 *
 * @author davi1
 */
public class ContactosPersistencia {
    private final String tabla = "contacto";
    
    public void guardar(Connection conexion, Contacto contacto) throws SQLException{ //inserta o actualiza contacto
      try{
         PreparedStatement consulta;
         if(contacto.getId() == null){
            consulta = conexion.prepareStatement("INSERT INTO " + this.tabla + "(nombre, email, num_fijo, num_movil, direccion, categoria) VALUES(?, ?, ?, ?, ?, ?)");
            consulta.setString(1, contacto.getNombre());
            consulta.setString(2, contacto.getEmail());
            consulta.setLong(3, contacto.getNum_fijo());
            consulta.setLong(4, contacto.getNum_movil());
            consulta.setString(5, contacto.getDireccion());
            consulta.setString(6, contacto.getCategoria());
         }else{
            consulta = conexion.prepareStatement("UPDATE " + this.tabla + " SET nombre = ?, email = ?, num_fijo = ?, num_movil = ?, direccion = ?, categoria = ? WHERE id = ?");
            consulta.setString(1, contacto.getNombre());
            consulta.setString(2, contacto.getEmail());
            consulta.setLong(3, contacto.getNum_fijo());
            consulta.setLong(4, contacto.getNum_movil());
            consulta.setString(5, contacto.getDireccion());
            consulta.setString(6, contacto.getCategoria());
            consulta.setInt(7, contacto.getId());
         }
         consulta.executeUpdate();
      }catch(SQLException ex){
         throw new SQLException(ex);
      }
   }
    
    public void eliminar(Connection conexion, Contacto contacto) throws SQLException{ //elimina un registro por su id
      try{
         PreparedStatement consulta = conexion.prepareStatement("DELETE FROM " + this.tabla + " WHERE id = ?");
         consulta.setInt(1, contacto.getId());
         consulta.executeUpdate();
      }catch(SQLException ex){
         throw new SQLException(ex);
      }
   }
    
    public List<Contacto> recuperarTodas(Connection conexion) throws SQLException{ //lista todos los registros
      List<Contacto> contactos = new ArrayList<>();
      try{
         PreparedStatement consulta = conexion.prepareStatement("SELECT * FROM " + this.tabla + " ORDER BY nombre");
         ResultSet resultado = consulta.executeQuery();
         while(resultado.next()){
            contactos.add(new Contacto(resultado.getInt("id"), resultado.getString("nombre"), resultado.getString("email"), resultado.getLong("num_fijo"), resultado.getLong("num_movil"), resultado.getString("direccion"), resultado.getString("categoria")));
         }
      }catch(SQLException ex){
         throw new SQLException(ex);
      }
      return contactos;
   }
}
