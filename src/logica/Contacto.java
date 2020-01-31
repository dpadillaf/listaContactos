/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author davi1
 * 
 * 
 */
public class Contacto {
    private final Integer id;
    private String nombre;
    private String email;
    private long num_fijo;
    private long num_movil;
    private String direccion;
    private String categoria;

    public Contacto() {
        this.id = null;
    }

    public Contacto(Integer id, String nombre, String email, long num_fijo, long num_movil, String direccion, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.num_fijo = num_fijo;
        this.num_movil = num_movil;
        this.direccion = direccion;
        this.categoria = categoria;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getNum_fijo() {
        return num_fijo;
    }

    public void setNum_fijo(long num_fijo) {
        this.num_fijo = num_fijo;
    }

        public long getNum_movil() {
        return num_movil;
    }

    public void setNum_movil(long num_movil) {
        this.num_movil = num_movil;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() { 
        //para darle un formato en la lista de contactos
        return "<html><font color='blue' face='Comic Sans MS' size='4'>"+nombre+"</font><br>Fijo: "+num_fijo+" Móvil: "+num_movil+"</html>";
    }
    
    
}
