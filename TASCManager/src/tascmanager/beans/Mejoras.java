/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tascmanager.beans;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author turtle
 */
public class Mejoras {
    
    private final IntegerProperty index;
    private final StringProperty mejora;
    private final BooleanProperty estado;

    public Mejoras(int index, String mejora, Boolean estado) {
        this.index = new SimpleIntegerProperty(this, "index", index);
        this.mejora = new SimpleStringProperty(this, "mejora", mejora);
        this.estado = new SimpleBooleanProperty(this, "estado", estado);
    }

    public Integer getIndex() {
        return index.get();
    }

    public void setIndex(Integer index) {
        this.index.set(index);
    }

    public IntegerProperty indexProperty() {
        return index;
    }

    public String getMejora() {
        return mejora.get();
    }

    public void setMejora(String mejora) {
        this.mejora.set(mejora);
    }

    public StringProperty mejoraProperty() {
        return mejora;
    }

    public boolean isEstado() {
        return estado.get();
    }

    public void setEstado(boolean estado) {
        this.estado.set(estado);
    }

    public BooleanProperty estadoProperty() {
        return estado;
    }
    
    
        @Override
        public String toString() {
            return index.get() + " " + mejora.get() + (estado.get() ? " (verdadero)" : "");
        }
    
}
