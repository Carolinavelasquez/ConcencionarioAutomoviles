package dao;

import interfaces.InterfaceColor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.ColoresVehiculos;

public class DaoColor implements InterfaceColor {

    private final Conexion cn = new Conexion();
    private String sql = "";
    private String mensaje = "";
    private ResultSet result;
    private PreparedStatement ejecutar;
    private ColoresVehiculos datoColor;
    private int contColor;

    @Override
    public String insertColor(ColoresVehiculos color) {
        try {
            cn.abrirConexion();
            sql = "insert into colores_vehiculos values(?,?)";
            ejecutar = cn.getMiConexion().prepareStatement(sql);
            ejecutar.setInt(1, color.getCodigo());
            ejecutar.setString(2, color.getNombre());
            contColor = ejecutar.executeUpdate();
            if (contColor == 0) {
                mensaje = "No se a podido Ingresar un nuevo Registro";
            } else {
                mensaje = "Registro Agredado con Exito";
            }
        } catch (SQLException e) {
            mensaje = "Error al Agreagar Color: " + e;
        } finally {
            cn.cerrarConexion();
        }
        return mensaje;
    }

    @Override
    public String updateColor(ColoresVehiculos color) {
        try {
            cn.abrirConexion();
            sql = "update colores_vehiculos set col_nombre=? where col_codigo=?";
            ejecutar = cn.getMiConexion().prepareStatement(sql);
            ejecutar.setString(1, color.getNombre());
            ejecutar.setInt(2, color.getCodigo());
            contColor = ejecutar.executeUpdate();
            if (contColor == 0) {
                mensaje = "No se a podido modificar el Registro.";
            } else {
                mensaje = "Registro Modificado con Exito";
            }
        } catch (SQLException e) {
            mensaje = "Error al modificar el Color: " + e;
        } finally {
            cn.cerrarConexion();
        }
        return mensaje;
    }

    @Override
    public String deletColor(ColoresVehiculos color) {
        try {
            cn.abrirConexion();
            sql = "delete from colores_vehiculos where col_codigo=?";
            ejecutar = cn.getMiConexion().prepareStatement(sql);
            ejecutar.setInt(1, color.getCodigo());
            contColor = ejecutar.executeUpdate();
            if (contColor == 0) {
                mensaje = "No se a podido Eliminar El Registro: ";
            } else {
                mensaje = "Registro Eliminado con Exito";
            }

        } catch (SQLException e) {
            mensaje = "Error al Eliminar Color: " + e;
        } finally {
            cn.cerrarConexion();
        }
        return mensaje;
    }

    @Override
    public ColoresVehiculos selectColor(ColoresVehiculos id) {
        try {
            cn.abrirConexion();
            sql = "select from colores_vehiculos where col_codigo=?";
            ejecutar = cn.getMiConexion().prepareStatement(sql);
            ejecutar.setInt(1, id.getCodigo());
            result = ejecutar.executeQuery();
            while (result.next()) {
                datoColor.setCodigo(result.getInt("col_codigo"));
                datoColor.setNombre(result.getString("col_nombre"));
            }
        } catch (SQLException e) {
            System.out.println("Error al seleccionar Color: " + e);
        } finally {
            cn.cerrarConexion();
        }
        return datoColor;
    }

    @Override
    public ArrayList<ColoresVehiculos> listColores() {
        ArrayList<ColoresVehiculos> list;
        ColoresVehiculos col;
        list = new ArrayList();
        try {
            cn.abrirConexion();
            sql = "select * from colores_vehiculos";
            ejecutar = cn.getMiConexion().prepareStatement(sql);
            result = ejecutar.executeQuery();
            while (result.next()) {
                col = new ColoresVehiculos();
                col.setCodigo(result.getInt("col_codigo"));
                col.setNombre(result.getString("col_nombre"));

                list.add(col);

            }
        } catch (SQLException e) {
            System.out.println("Error al listar Colores: " + e);
        } finally {
            cn.cerrarConexion();
        }
        return list;
    }
}
