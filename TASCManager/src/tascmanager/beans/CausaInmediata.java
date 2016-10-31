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
 * @author Freddy
 */
public class CausaInmediata {

    private final IntegerProperty index;
    private final StringProperty causaInmediata;
    private final BooleanProperty estado;

    public CausaInmediata(int index, String causaInmediata, Boolean estado) {
        this.index = new SimpleIntegerProperty(this, "index", index);
        this.causaInmediata = new SimpleStringProperty(this, "causaInmediata", causaInmediata);
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

    public String getCausaInmediata() {
        return causaInmediata.get();
    }

    public void setCausaInmediata(String causaInmediata) {
        this.causaInmediata.set(causaInmediata);
    }

    public StringProperty causaInmediataProperty() {
        return causaInmediata;
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
            return index.get() + " " + causaInmediata.get() + (estado.get() ? " (verdadero)" : "");
        }
}
