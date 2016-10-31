/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tascmanager.beans;

import java.util.List;
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
public class SubCausaBasica {
    
    
   
    
    private final IntegerProperty index;
    private final StringProperty subCausaBasica;
    private final BooleanProperty estado;

    
   public SubCausaBasica(int index, String subCausaBasica, Boolean estado) {
        this.index = new SimpleIntegerProperty(this, "index", index);
        this.subCausaBasica = new SimpleStringProperty(this, "subCausaBasica", subCausaBasica);
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

    public String getSubCausaBasica() {
        return subCausaBasica.get();
    }

    public void setSubCausaBasica(String subCausaBasica) {
        this.subCausaBasica.set(subCausaBasica);
    }

    public StringProperty subCausaBasicaProperty() {
        return subCausaBasica;
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
            return index.get() + " " + subCausaBasica.get() + (estado.get() ? " (verdadero)" : "");
        }
    
}
