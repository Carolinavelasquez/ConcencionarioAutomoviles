
package interfaces;

import java.util.ArrayList;
import modelo.TipoVehiculos;


public interface InterfaceTipo {
    public String insertTipo(TipoVehiculos tipo);
    public String updateTipo(TipoVehiculos tipo);
    public String deletTipo(TipoVehiculos tipo);
    public TipoVehiculos selectTipo(TipoVehiculos id);
    public ArrayList<TipoVehiculos>listTipo();
    
}
