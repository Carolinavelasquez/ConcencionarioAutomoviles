
package dao;

import interfaces.InterfaceMarca;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.MarcaVehiculo;



public class DaoMarca implements InterfaceMarca{
     private final Conexion cn = new Conexion();
    private String sql = "";
    private String mensaje = "";
    private ResultSet result;
    private PreparedStatement ejecutar;
    private MarcaVehiculo datoMar;
    private int contMarca;

    @Override
    public String insertMarca(MarcaVehiculo marca) {
        try {
            cn.abrirConexion();
            sql="insert into marcas_vehiculos values(?,?)";
            ejecutar=cn.getMiConexion().prepareStatement(sql);
            ejecutar.setInt(1, marca.getMarca());
            ejecutar.setString(2, marca.getNombre());
            contMarca=ejecutar.executeUpdate();
            if (contMarca==0) {
                mensaje="No se a podido Ingresar el Registro";
            } else {
                mensaje="Registro ingresado con Exito";
            }
        } catch (SQLException e) {
            mensaje="Error al ingresar la Marca: "+e;
        }finally{
            cn.cerrarConexion();
        }
        return mensaje;
         }

    @Override
    public String updateMarca(MarcaVehiculo marca) {
        try {
            cn.abrirConexion();
            sql="update marcas_vehiculos set mar_nombre=? where mar_codigo";
            ejecutar=cn.getMiConexion().prepareStatement(sql);
            ejecutar.setString(1, marca.getNombre());
            ejecutar.setInt(2, marca.getMarca());
            contMarca=ejecutar.executeUpdate();
            if (contMarca==0) {
                mensaje="No se a podido Modificar el Registro";
            } else {
                mensaje="Registro modificado con Exito";
            }
            
        } catch (SQLException e) {
            mensaje="Error al Modificar Marcas: "+e;
        }
        finally{
            cn.cerrarConexion();
        }
        return mensaje;
        }
    

    @Override
    public String deletMarca(MarcaVehiculo marca) {
        try {
            cn.abrirConexion();
            sql="delete from marcas_vehiculos where mar_codigo=?";
            ejecutar=cn.getMiConexion().prepareStatement(sql);
            ejecutar.setInt(1, marca.getMarca());
            contMarca=ejecutar.executeUpdate();
            if (contMarca==0) {
                mensaje="No se a podido Eliminar el Registro";
            } else {
                mensaje="Registro Eliminado con Exito";
            }
        } catch (SQLException e) {
            mensaje="Error al eliminar Marca";
        }finally{
            cn.cerrarConexion();
        }
        return mensaje;
         }

    @Override
    public MarcaVehiculo select(MarcaVehiculo id) {
        try {
            cn.abrirConexion();
            sql="select from marcas_vehiculos where mar_codigo=?";
            ejecutar=cn.getMiConexion().prepareStatement(sql);
            ejecutar.setInt(1, id.getMarca());
            result=ejecutar.executeQuery();
            while (result.next()) {                
                datoMar.setMarca(result.getInt("mar_codigo"));
                datoMar.setNombre(result.getString("mar_nombre"));
            }
        } catch (SQLException e) {
            System.out.println("Error al selecionar Marca: "+e);
        }finally{
            cn.cerrarConexion();
        }
        return datoMar;
         }

    @Override
    public ArrayList<MarcaVehiculo> listMarca() {
        ArrayList<MarcaVehiculo> list;
        MarcaVehiculo mar;
        list=new ArrayList();
        try {
            cn.abrirConexion();
            sql="select *from marcas_vehiculos";
            ejecutar=cn.getMiConexion().prepareStatement(sql);
            result=ejecutar.executeQuery();
            while (result.next()) {                
                mar=new MarcaVehiculo();
                mar.setMarca(result.getInt("mar_codigo"));
                mar.setNombre(result.getString("mar_nombre"));
                list.add(mar);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar Marcas: "+e);
        }finally{
            cn.cerrarConexion();
        }
        return list;
         }

}
