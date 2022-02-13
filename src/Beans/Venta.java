package Beans;

import java.beans.*;
import java.io.Serializable;

public class Venta implements Serializable {

    private int idVenta;
    private String matricula;
    private PropertyChangeSupport propertySupport;

    public Venta() { propertySupport = new PropertyChangeSupport(this); }

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
    public void setMatricula(String nuevaMatricula) {
        if (!nuevaMatricula.equals(this.matricula)) {
            String matriculaAntigua = this.matricula;
            String matriculaActual = nuevaMatricula;
            propertySupport.firePropertyChange("CocheVendido", 
                            matriculaAntigua, matriculaActual);
        } else {
            this.matricula = nuevaMatricula;
        }
    }
    public String getMatricula() {
        return matricula;
    }
}
