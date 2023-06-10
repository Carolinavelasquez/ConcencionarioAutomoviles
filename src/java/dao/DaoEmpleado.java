
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Empleados;


public class DaoEmpleado implements interfaces.InterfaceEmpleado{
    private final Conexion conexion=new Conexion();
    private String sql="";
    private String mensaje="";
    private ResultSet result;
    private PreparedStatement ejecutar;
    private Empleados datoEmpleado;
    private int contEmpleado;

    @Override
    public String insertEmpleado(Empleados empleado) {
        try {
            conexion.abrirConexion();
            sql="insert into empleados values(?,?,?,?,?,?,?)";
            ejecutar=conexion.getMiConexion().prepareStatement(sql);
            ejecutar.setInt(1, empleado.getCodigo());
            ejecutar.setString(2, empleado.getNombre());
            ejecutar.setString(3, empleado.getApellido());
            ejecutar.setInt(4, empleado.getMovil());
            ejecutar.setString(5, empleado.getPass());
            ejecutar.setString(6, empleado.getDireccion());
            ejecutar.setString(7, empleado.getCorreo());
            contEmpleado=ejecutar.executeUpdate();
            if (contEmpleado==0) {
                mensaje="No se a podido Ingresar el Registro";
            } else {
                mensaje="Registro Ingresado con Exito";
            }
        } catch (SQLException e) {
            mensaje="Error al Ingresar Empleado: "+e;
        }finally{
            conexion.cerrarConexion();
        }
        return mensaje;
    }

    @Override
    public String updateEmpleado(Empleados empleado) {
        try {
            conexion.abrirConexion();
            sql="update empleados set nombre=?, apellido=?, telmovil=?, contrasenia=?, direccion=?,  correo=? where emp_codigo=?";
            ejecutar= conexion.getMiConexion().prepareStatement(sql);
            ejecutar.setString(1, empleado.getNombre());
            ejecutar.setString(2, empleado.getApellido());
            ejecutar.setInt(3, empleado.getMovil());
            ejecutar.setString(4, empleado.getPass());
            ejecutar.setString(5, empleado.getDireccion());
            ejecutar.setString(6, empleado.getCorreo());
            ejecutar.setInt(7, empleado.getCodigo());
            contEmpleado=ejecutar.executeUpdate();
            if (contEmpleado==0) {
                mensaje="No se a podido Modificar el Registro ";
            } else {
                mensaje="Registro Modificado con Exito";
            }
        } catch (SQLException e) {
            mensaje="Error al Modificar Empleado: "+e;
        }finally{
            conexion.cerrarConexion();
        }
        return mensaje;
        }

    @Override
    public String deleteEmpleado(Empleados empleado) {
        try {
            conexion.abrirConexion();
            sql="delete from empleados where  emp_codigo=?";
            ejecutar=conexion.getMiConexion().prepareStatement(sql);
            ejecutar.setInt(1, empleado.getCodigo());
            contEmpleado=ejecutar.executeUpdate();
            if (contEmpleado==0) {
                mensaje="No se a podido Eliminar el Registro";
            } else {
                mensaje="Registro eliminado con Exito";
            }
        } catch (SQLException e) {
            mensaje="Error al eliminar empleado: "+e;
        }finally{
            conexion.cerrarConexion();
        }
        return mensaje;
    }

    @Override
    public Empleados selectEmpleado(Empleados id) {
        try {
            conexion.abrirConexion();
            sql="Select from empleados where emp_codigo=?";
            ejecutar=conexion.getMiConexion().prepareStatement(sql);
            ejecutar.setInt(1, id.getCodigo());
            result=ejecutar.executeQuery();
            
            while (result.next()) {                
                datoEmpleado.setCodigo(result.getInt("emp_codigo"));
                datoEmpleado.setNombre(result.getString("nombre"));
                datoEmpleado.setApellido(result.getString("apellido"));
                datoEmpleado.setMovil(result.getInt("telmovil"));
                datoEmpleado.setPass(result.getString("contrasenia"));
                datoEmpleado.setDireccion(result.getString("direccion"));
                datoEmpleado.setCorreo(result.getString("correo"));
            }
            
        } catch (SQLException e) {
            System.out.println("Error al selecionar Empleado: "+e);
        }finally{
            conexion.cerrarConexion();
        }
        return datoEmpleado;
        }

    @Override
    public ArrayList<Empleados> listEmpleado() {
        ArrayList<Empleados>list;
        Empleados emplea;
        list= new ArrayList();
        try {
            conexion.abrirConexion();
            sql="Select * from empleados";
            ejecutar=conexion.getMiConexion().prepareStatement(sql);
            result=ejecutar.executeQuery();
            while (result.next()) {                
                emplea=new Empleados();
                emplea.setCodigo(result.getInt("emp_codigo"));
                emplea.setNombre(result.getString("nombre"));
                emplea.setNombre(result.getString("apellido"));
                emplea.setMovil(result.getInt("telmovil"));
                emplea.setPass(result.getString("contrasenia"));
                emplea.setDireccion(result.getString("direccion"));
                emplea.setCorreo(result.getString("correo"));
                list.add(emplea);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar Empleados: "+e);
        }finally{
            conexion.cerrarConexion();
        }
        return list;
          }
    
}
