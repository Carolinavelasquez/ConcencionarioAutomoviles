
package modelo;

public class Vehiculos {
    private String placa;
    private int codigoEmp;
    private int codigoMarc;
    private int codigoModelo;
    private int codigoTipo;
    private int codigoColor;

    public Vehiculos() {
    }

    public Vehiculos(String placa, int codigoEmp, int codigoMarc, int codigoModelo, int codigoTipo, int codigoColor) {
        this.placa = placa;
        this.codigoEmp = codigoEmp;
        this.codigoMarc = codigoMarc;
        this.codigoModelo = codigoModelo;
        this.codigoTipo = codigoTipo;
        this.codigoColor = codigoColor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getCodigoEmp() {
        return codigoEmp;
    }

    public void setCodigoEmp(int codigoEmp) {
        this.codigoEmp = codigoEmp;
    }

    public int getCodigoMarc() {
        return codigoMarc;
    }

    public void setCodigoMarc(int codigoMarc) {
        this.codigoMarc = codigoMarc;
    }

    public int getCodigoModelo() {
        return codigoModelo;
    }

    public void setCodigoModelo(int codigoModelo) {
        this.codigoModelo = codigoModelo;
    }

    public int getCodigoTipo() {
        return codigoTipo;
    }

    public void setCodigoTipo(int codigoTipo) {
        this.codigoTipo = codigoTipo;
    }

    public int getCodigoColor() {
        return codigoColor;
    }

    public void setCodigoColor(int codigoColor) {
        this.codigoColor = codigoColor;
    }
    
    
}
