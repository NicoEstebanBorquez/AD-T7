package Beans;

import java.beans.*;
import java.io.Serializable;

public class Venta implements Serializable {

    private int idVenta;
    private String matricula;
    private PropertyChangeSupport propertySupport;

    public Venta() {
        propertySupport = new PropertyChangeSupport(this);
    }

    public Venta(int idVenta, String matricula) {
        this.idVenta = idVenta;
        this.matricula = matricula;
        this.propertySupport = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdVenta() {
        return idVenta;
    }

    //Método Setter que lanzará el evento
    public void setMatricula(String matriculaActual) {
        if (!matriculaActual.equals(this.matricula)) {
            String valorAntiguo = this.matricula;
            this.matricula = matriculaActual;
            //Se dispara el evento "CocheVendido:"
            propertySupport.firePropertyChange("CocheVendido", 
                    valorAntiguo, matriculaActual);
        } else {
            this.matricula = matriculaActual;
        }
    }

    public String getMatricula() {
        return matricula;
    }
}
