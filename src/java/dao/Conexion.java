
package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String URL="jdbc:mysql://localhost:3306/java19_cuentahabientes";
    private static final String USER="root";
    private static final String PASSWORD="";
    
    private Connection miConexion;

    public Connection getMiConexion() {
        return miConexion;
    }

    public void setMiConexion(Connection miConexion) {
        this.miConexion = miConexion;
    }
    
   
    
    public void abrirConexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.miConexion= DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexion realizada con exito");
        }   catch (ClassNotFoundException e) {
            System.out.println("Error en driver o conexion "+e);
        }catch(SQLException ex){
            System.out.println("Error en la conexion: "+ex);
        }
    }
    
    public void cerrarConexion(){
        try {
            if(this.miConexion.isClosed()== false && this.miConexion!=null){
                this.miConexion.close();
                System.out.println("Conexion Cerrada con Exito");
            }
        } catch (SQLException e) {
            System.out.println("La conexion ya se encuentra cerrada"+e);
        }
    }
}
