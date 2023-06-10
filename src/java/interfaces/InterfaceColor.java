
package interfaces;

import java.util.ArrayList;
import modelo.ColoresVehiculos;

public interface InterfaceColor {
    public String insertColor(ColoresVehiculos color);
    public String updateColor(ColoresVehiculos color);
    public String deletColor(ColoresVehiculos color);
    public ColoresVehiculos selectColor(ColoresVehiculos id);
    public ArrayList<ColoresVehiculos>listColores();
}
