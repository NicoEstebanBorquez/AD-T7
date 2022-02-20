package Beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serializable;

public class Coche implements Serializable, PropertyChangeListener {

    private String matricula;
    private String marca;
    private String modelo;
    private float precio;
    private boolean vendido;

    public Coche() {
    }

    public Coche(String matricula, String marca, String modelo,
            float precio, boolean vendido) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.vendido = vendido;
    }

    //Método "escuchador" que recibirá el evento lanzado por "Venta":
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        //Recibe el evento "CocheVendido"
        if (evt.getPropertyName().equals("CocheVendido")) {
            System.out.println(
                    "Se ha vendido el coche con matrícula: " + evt.getNewValue() + "\n"
                    + "Información del vehículo: " + "\n"
                    + "Marca: " + marca + "\n"
                    + "Modelo: " + modelo + "\n"
                    + "Precio: " + precio + " €");
            setVendido(true);
        }
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public boolean isVendido() {
        return vendido;
    }

    public void setVendido(boolean vendido) {
        this.vendido = vendido;
    }

    @Override
    public String toString() {
        return "Coche{" + "matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", precio=" + precio + ", vendido=" + vendido + '}';
    }

}
