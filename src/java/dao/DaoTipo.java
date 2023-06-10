
package dao;

import interfaces.InterfaceTipo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.TipoVehiculos;


public class DaoTipo implements InterfaceTipo{
      private final Conexion cn = new Conexion();
    private String sql = "";
    private String mensaje = "";
    private ResultSet result;
    private PreparedStatement ejecutar;
    private TipoVehiculos datoTipo;
    private int contTipo;

    @Override
    public String insertTipo(TipoVehiculos tipo) {
        try {
            cn.abrirConexion();
            sql="insert into tipos_vehiculos values(?,?)";
            ejecutar=cn.getMiConexion().prepareStatement(sql);
            ejecutar.setInt(1, tipo.getCodigo());
            ejecutar.setString(2, tipo.getNombre());
            contTipo=ejecutar.executeUpdate();
            if (contTipo==0) {
                mensaje="No se a podido Ingresar un nuevo Registro";
            } else {
                mensaje="Registro Ingresado con Exito";
            }
        } catch (SQLException e) {
            mensaje="Error al ingresar un nuevo Tipo";
        }finally{
            cn.cerrarConexion();
        }
        return mensaje;
          }

    @Override
    public String updateTipo(TipoVehiculos tipo) {
        try {
            cn.abrirConexion();
            sql="update tipos_vehiculos set tiv_nombre=? where tiv_codigo=?";   
            ejecutar=cn.getMiConexion().prepareStatement(sql);
            ejecutar.setString(1, tipo.getNombre());
            ejecutar.setInt(2, tipo.getCodigo());
            contTipo=ejecutar.executeUpdate();
            if (contTipo==0) {
                mensaje="No se a podido Modificar el Registro";
            }else{
                mensaje="Registro Modificado con Exito";
            }
        } catch (SQLException e) {
            mensaje="Error al modifivad tipos: "+e;
        }finally{
            cn.cerrarConexion();
        }
        return mensaje;
        }

    @Override
    public String deletTipo(TipoVehiculos tipo) {
        try {
            cn.abrirConexion();
            sql="delete from tipos_vehiculos where tiv_codigo=?";
            ejecutar=cn.getMiConexion().prepareStatement(sql);
            ejecutar.setInt(1, tipo.getCodigo());
            contTipo=ejecutar.executeUpdate();
            if (contTipo==0) {
                mensaje="No se a podido Eliminar el registro";
            } else {
                mensaje="Registro eliminado con Exito";
            }
        } catch (SQLException e) {
            mensaje="Error al Eliminar Tipo: "+e;
        }finally{
            cn.cerrarConexion();
        }
        return mensaje;
        }

    @Override
    public TipoVehiculos selectTipo(TipoVehiculos id) {
        try {
            cn.abrirConexion();
            sql="select from tipos_vihiculos where tiv_codigo=?";
            ejecutar=cn.getMiConexion().prepareStatement(sql);
            ejecutar.setInt(1, id.getCodigo());
            result=ejecutar.executeQuery();
            while (result.next()) {                
                datoTipo.setCodigo(result.getInt("tiv_codigo"));
                datoTipo.setNombre(result.getString("tiv_nombre"));
            }
        } catch (SQLException e) {
            System.out.println("Error al selecionar Tipo: "+e);
        }finally{
            cn.cerrarConexion();
        }
        return datoTipo;
       }

    @Override
    public ArrayList<TipoVehiculos> listTipo() {
        ArrayList<TipoVehiculos> list;
        TipoVehiculos tip;
        list=new ArrayList();
        try {
            cn.abrirConexion();
            sql="select * from tipos_vehiculos";
            ejecutar=cn.getMiConexion().prepareStatement(sql);
            result=ejecutar.executeQuery();
            while (result.next()) {                
                tip=new TipoVehiculos();
                tip.setCodigo(result.getInt("tiv_codigo"));
                tip.setNombre(result.getString("tiv_nombre"));
                
                list.add(tip);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar Tipos: "+e);
        }finally{
            cn.cerrarConexion();
        }
        return list;
         }
    
}
