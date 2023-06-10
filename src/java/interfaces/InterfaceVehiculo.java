
package interfaces;

import java.util.ArrayList;
import modelo.Vehiculos;


public interface InterfaceVehiculo {
   public String insertVehiculo(Vehiculos vehiculo);
   public String updateVehiculo(Vehiculos vehiculo);
   public String deleteVehiculo(Vehiculos vehiculo);
   public Vehiculos selectVehiculo(Vehiculos id);
   public ArrayList<Vehiculos>listVehiculo();
}
