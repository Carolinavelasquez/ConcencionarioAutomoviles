
package modelo;


public class MarcaVehiculo {
    private int marca;
    private String nombre;

    public MarcaVehiculo() {
    }

    public MarcaVehiculo(int marca, String nombre) {
        this.marca = marca;
        this.nombre = nombre;
    }

    public int getMarca() {
        return marca;
    }

    public void setMarca(int marca) {
        this.marca = marca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
