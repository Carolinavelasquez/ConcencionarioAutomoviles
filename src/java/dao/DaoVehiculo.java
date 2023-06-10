package dao;

import interfaces.InterfaceVehiculo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Vehiculos;

public class DaoVehiculo implements InterfaceVehiculo {

    private final Conexion cn = new Conexion();
    private String sql = "";
    private String mensaje = "";
    private ResultSet result;
    private PreparedStatement ejecutar;
    private Vehiculos datoVehi;
    private int contVehi;

    @Override
    public String insertVehiculo(Vehiculos vehiculo) {
        try {
            cn.abrirConexion();
            sql = "Insert into vehiculos values(?,?,?,?,?,?)";
            ejecutar = cn.getMiConexion().prepareStatement(sql);
            ejecutar.setString(1, vehiculo.getPlaca());
            ejecutar.setInt(2, vehiculo.getCodigoEmp());
            ejecutar.setInt(3, vehiculo.getCodigoMarc());
            ejecutar.setInt(4, vehiculo.getCodigoModelo());
            ejecutar.setInt(5, vehiculo.getCodigoTipo());
            ejecutar.setInt(6, vehiculo.getCodigoColor());
            contVehi = ejecutar.executeUpdate();
            if (contVehi == 0) {
                mensaje = "No se a podido Ingresar el Registro";
            } else {
                mensaje = "Registro Ingresado con Exito";
            }
        } catch (SQLException e) {
            mensaje = "Error al Ingresar Vehiculos: " + e;
        } finally {
            cn.cerrarConexion();
        }
        return mensaje;
    }

    @Override
    public String updateVehiculo(Vehiculos vehiculo) {
        try {
            cn.abrirConexion();
            sql = "update vehiculos set emp_codigo=?, veh_marca=?, veh_modelo=?,veh_tipo=?, veh_color=? where veh_placa=?";
            ejecutar = cn.getMiConexion().prepareStatement(sql);

            ejecutar.setInt(1, vehiculo.getCodigoEmp());
            ejecutar.setInt(2, vehiculo.getCodigoMarc());
            ejecutar.setInt(3, vehiculo.getCodigoModelo());
            ejecutar.setInt(4, vehiculo.getCodigoTipo());
            ejecutar.setInt(5, vehiculo.getCodigoColor());
            ejecutar.setString(6, vehiculo.getPlaca());
            contVehi = ejecutar.executeUpdate();
            if (contVehi == 0) {
                mensaje = "No se a podido Modificar el Registro";
            } else {
                mensaje = "Registro Modificado con Exito";
            }
        } catch (SQLException e) {
            mensaje = "Error al modificar Vehiculos: " + e;
        } finally {
            cn.cerrarConexion();
        }
        return mensaje;
    }

    @Override
    public String deleteVehiculo(Vehiculos vehiculo) {
        try {
            cn.abrirConexion();
            sql = "delete from vehiculos where veh_placa=?";
            ejecutar = cn.getMiConexion().prepareStatement(sql);
            ejecutar.setString(1, vehiculo.getPlaca());
            contVehi = ejecutar.executeUpdate();
            if (contVehi == 0) {
                mensaje = "No se a Podido Eliminar el Registro";
            } else {
                mensaje = "Registro Eliminado Con Exito";
            }
        } catch (SQLException e) {
            mensaje = "Error al eliminar Vehiculos: " + e;
        } finally {
            cn.cerrarConexion();
        }
        return mensaje;
    }

    @Override
    public Vehiculos selectVehiculo(Vehiculos id) {
        try {
            cn.abrirConexion();
            sql = "select from vehiculos where veh_placa=?";
            ejecutar = cn.getMiConexion().prepareStatement(sql);
            ejecutar.setString(1, id.getPlaca());
            result = ejecutar.executeQuery();
            while (result.next()) {
                datoVehi.setPlaca(result.getString("veh_placa"));
                datoVehi.setCodigoEmp(result.getInt("emp_codigo"));
                datoVehi.setCodigoMarc(result.getInt("veh_marca"));
                datoVehi.setCodigoModelo(result.getInt("veh_modelo"));
                datoVehi.setCodigoTipo(result.getInt("veh_tipo"));
                datoVehi.setCodigoColor(result.getInt("veh_color"));
            }

        } catch (SQLException e) {
            System.out.println("Error al seleccionar Vehiculo: " + e);
        } finally {
            cn.cerrarConexion();
        }
        return datoVehi;
    }

    @Override
    public ArrayList<Vehiculos> listVehiculo() {
        ArrayList<Vehiculos>list;
        Vehiculos vehi;
        list=new ArrayList();
        try {
            cn.abrirConexion();
            sql="Select * from vehiculos";
            ejecutar=cn.getMiConexion().prepareStatement(sql);
            result=ejecutar.executeQuery();
            while (result.next()) {                
                vehi=new Vehiculos();
                vehi.setPlaca(result.getString("veh_placa"));
                vehi.setCodigoEmp(result.getInt("emp_codigo"));
                vehi.setCodigoMarc(result.getInt("veh_marca"));
                vehi.setCodigoModelo(result.getInt("veh_modelo"));
                vehi.setCodigoTipo(result.getInt("veh_tipo"));
                vehi.setCodigoColor(result.getInt("veh_color"));
                
                list.add(vehi);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar Vehiculos: "+e);
        }finally{
            cn.cerrarConexion();
        }
        return list;
                
        }

}
