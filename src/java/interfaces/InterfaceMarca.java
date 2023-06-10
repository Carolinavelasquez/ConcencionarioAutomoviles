
package interfaces;

import java.util.ArrayList;
import modelo.MarcaVehiculo;


public interface InterfaceMarca {
   public String insertMarca(MarcaVehiculo marca);
   public String updateMarca(MarcaVehiculo marca);
   public String deletMarca(MarcaVehiculo marca);
   public MarcaVehiculo select(MarcaVehiculo id);
   public ArrayList<MarcaVehiculo>listMarca();
}
