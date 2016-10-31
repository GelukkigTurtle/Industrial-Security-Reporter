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
public class DesgloseCausaBasica {

    List<SubCausaBasica> listaSubCausasBasicas;
    private final IntegerProperty index;
    private final StringProperty causaBasica;
    private final BooleanProperty estado;

    public DesgloseCausaBasica(int index, String causaBasica, List<SubCausaBasica> listaSubCausasBasicas, Boolean estado) {
        this.index = new SimpleIntegerProperty(this, "index", index);
        this.causaBasica = new SimpleStringProperty(this, "causaBasica", causaBasica);
        this.listaSubCausasBasicas = listaSubCausasBasicas;
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

    public String getCausaBasica() {
        return causaBasica.get();
    }

    public void setCausaBasica(String causaBasica) {
        this.causaBasica.set(causaBasica);
    }

    public StringProperty causaBasicaProperty() {
        return causaBasica;
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

    public List<SubCausaBasica> getListaSubCausasBasicas() {
        return listaSubCausasBasicas;
    }

    public void setListaSubCausasBasicas(List<SubCausaBasica> listaSubCausasBasicas) {
        this.listaSubCausasBasicas = listaSubCausasBasicas;
    }

    @Override
    public String toString() {
        return index.get() + " " + causaBasica.get() + (estado.get() ? " (verdadero)" : "");
    }
}
