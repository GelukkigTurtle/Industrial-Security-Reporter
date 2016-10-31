/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tascmanager.controller;

import com.sun.media.sound.InvalidFormatException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import tascmanager.beans.Caso;
import tascmanager.beans.CausaInmediata;
import tascmanager.beans.DesgloseCausaBasica;
import tascmanager.beans.Mejoras;
import tascmanager.beans.SubCausaBasica;
import tascmanager.composer.Dialogs;

/**
 * FXML Controller class
 *
 * @author Freddy
 */
public class ManagerController {

    @FXML
    private ResourceBundle resources;
    @FXML //  fx:id="opAcercaDe"
    private MenuItem opAcercaDe; // Value injected by FXMLLoader
    @FXML //  fx:id="opCerrar"
    private MenuItem opCerrar; // Value injected by FXMLLoader
    @FXML
    private Label lblMensajeAlerta;
    @FXML
    private URL location;
    @FXML
    private Button btnReporte;
    @FXML
    private Button btnSiguiente;
    @FXML
    private ChoiceBox<String> cmbTipoContacto;
    @FXML
    private MenuItem iniciarDenuevo;
    @FXML
    private TabPane tabPaneWizard;
    @FXML
    private Tab tab1;
    @FXML
    private Tab tab2;
    @FXML
    private Tab tab3;
    @FXML
    private Tab tab4;
    @FXML
    private Tab tab5;
    @FXML
    private Tab tab6;
    @FXML
    private TableView<DesgloseCausaBasica> tbVwSubCausasBasicas;
    @FXML
    private TableView<DesgloseCausaBasica> tbVwCausasBasicas;
    @FXML
    private TableView<CausaInmediata> tbVwCausasInmediatas;
    @FXML
    private TableView<Mejoras> tbVwMejoras;
    //private TableModel model = new TableModel();
//    private Caso modeloCaso = new Caso();
    SimpleObjectProperty sp;
    CheckBox[] cb;
    Boolean[] checksInmediatas;
    int cont = 0;
    String pathFiles;
    public static DesgloseCausaBasica desgloseCauBasicaGlobal;
    public final ObservableList<Long> checkedMessages = FXCollections
            .observableArrayList(new Long(1));
    ObservableList<String> listaTipoDeContacto = FXCollections.observableArrayList(
            "1 - Golpeado contra ( corriendo hacia o tropezando con )",
            "2 - Golpeado por ( Objeto en movimiento )",
            "3 - Caida a un nivel bajo",
            "4 - Caida al mismo nivel ( rebalar y caer , volcarse)",
            "5 - Atrapado por ( Puntos filosos o cortantes )",
            "6 - Atrapado en (agarrado, colgado)",
            "7 - Atrapado entre o debajo ( aplastado o amputado )",
            "8 - Contacto con (electricidad, calor, frio, radiación, sustancias causticas, sustancias toxicas, biologicas,ruido.)",
            "9 - Sobretensión, sobreesfuerzo, sobrecarga, ergonomía",
            "10 - Falla del equipo",
            "11 - Derrame o escape al ambiente");
    List<CausaInmediata> causasInmediatasValidas = new ArrayList();
    List<DesgloseCausaBasica> causasBasicasValidas = new ArrayList();
    List<Mejoras> mejorasValidas = new ArrayList();
    //Configuraciones de causas inmediatas segun tipo de contacto
    Integer[] vCauInm1 = {1, 2, 4, 5, 12, 14, 15, 16, 17, 18, 19, 26};
    Integer[] vCauInm2 = {1, 2, 4, 5, 6, 9, 10, 12, 13, 14, 15, 16, 20, 26};
    Integer[] vCauInm3 = {3, 5, 6, 7, 11, 12, 13, 14, 15, 16, 17, 22};
    Integer[] vCauInm4 = {4, 9, 13, 14, 15, 16, 19, 22, 26};
    Integer[] vCauInm5 = {5, 6, 11, 13, 14, 15, 16, 18};
    Integer[] vCauInm6 = {5, 6, 11, 12, 13, 14, 15, 16, 18};
    Integer[] vCauInm7 = {1, 2, 5, 6, 9, 11, 12, 13, 14, 15, 16, 22, 28};
    Integer[] vCauInm8 = {5, 6, 7, 11, 12, 13, 14, 15, 16, 17, 18, 20, 21, 22, 23, 24, 25, 27, 28, 29};
    Integer[] vCauInm9 = {8, 9, 10, 11, 13, 14, 15};
    Integer[] vCauInm10 = {1, 4, 6, 8, 15};
    Integer[] vCauInm11 = {1, 2, 3, 4, 5, 6, 8, 9, 12, 15, 18, 19, 20, 22, 25, 27, 28, 29};
    //Configuraciones de causas inmediatas segun causas inmediatas
    Integer[][] vCausaBasica = {
        {2, 4, 5, 7, 8, 9, 12, 13, 15},
        {1, 2, 3, 4, 5, 6, 7, 8, 9, 12, 13, 15},
        {2, 3, 4, 5, 6, 7, 8, 9, 12, 13, 15},
        {2, 3, 4, 5, 6, 7, 8, 9, 12, 13, 15},
        {2, 3, 4, 5, 6, 7, 8, 9, 12, 13, 15},
        {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15},
        {2, 3, 4, 5, 6, 7, 8, 10, 12, 13, 15},
        {1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 13, 15},
        {1, 2, 3, 4, 5, 6, 7, 8, 9, 12, 13, 15},
        {1, 2, 3, 4, 5, 6, 7, 8, 9, 12, 13, 15},
        {1, 2, 3, 4, 5, 6, 7, 8, 9, 12, 13, 15},
        {2, 3, 4, 5, 6, 7, 8, 9, 12, 13, 15},
        {2, 3, 4, 5, 7, 8, 13, 15},
        {2, 3, 4, 5, 7, 8, 13, 15},
        {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 15},
        {1, 2, 3, 4, 5, 6, 7, 8, 13, 14},
        {5, 7, 8, 9, 10, 11, 12, 13, 15},
        {5, 7, 8, 9, 10, 12, 13},
        {8, 9, 10, 11, 12, 13, 14, 15},
        {8, 9, 13},
        {8, 9, 10, 11, 12, 13, 14, 15},
        {5, 6, 7, 8, 9, 10, 11, 12, 13, 15},
        {5, 6, 7, 8, 9, 10, 11, 12, 13, 15},
        {5, 6, 7, 8, 9, 10, 11, 12, 13, 14},
        {5, 6, 7, 8, 9, 10, 11, 12, 13, 14},
        {1, 2, 3, 8, 9, 11, 12},
        {8, 9, 10, 11, 12, 13},
        {8, 9, 10, 11, 12, 13},
        {8, 9, 10, 11, 12, 13}};
    Integer[][] vMejoras = {
        {2, 3, 5, 7, 8, 11, 14},
        {6, 7, 8, 11, 14},
        {5, 6, 7, 8, 11, 14},
        {1, 6, 7, 8, 11, 14},
        {2, 6, 7, 8, 11, 12, 14},
        {6, 7, 8, 11, 14},
        {1, 4, 6, 7, 8, 11, 16, 17},
        {1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 13, 14, 15, 16, 17},
        {1, 2, 3, 6, 11, 12, 14, 16, 17},
        {1, 2, 3, 4, 6, 11, 12, 16, 17},
        {1, 2, 3, 6, 11, 12, 17},
        {1, 2, 6, 11, 12, 14, 17},
        {1, 2, 5, 6, 7, 11, 12, 14, 15, 16, 17},
        {1, 2, 6, 7, 11, 12, 14},
        {1, 6, 11, 12, 13, 16, 17}};
    //Instancias activas
    public  Caso casoActivo;
    CausaInmediata ci;
    DesgloseCausaBasica dc;

    @FXML
    void initialize() {
        configuracionInicial();
        //cargamos combo de contactos
        ObservableList<String> lstTipContact = FXCollections.observableArrayList(listaTipoDeContacto);
        cmbTipoContacto.setItems(lstTipContact);

        cmbTipoContacto.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> ov, String t, String t1) {
                lblMensajeAlerta.setText("");

            }
        });
        
        opCerrar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
               System.exit(0);
            }
        });
        
        iniciarDenuevo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                configuracionInicial();
            }
        });
        
        opAcercaDe.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Dialogs.showInformacion();
            }
        });
    }

    private void crearTablaCausasInmediatas() {

        ObservableList<CausaInmediata> listaDeCausasInmediatas = FXCollections.observableArrayList(casoActivo.getListaCausasInmediatas());
        tbVwCausasInmediatas.setItems(listaDeCausasInmediatas);


        final TableColumn colIndex = new TableColumn("Número");
        colIndex.setCellValueFactory(
                new PropertyValueFactory<CausaInmediata, String>("index"));

        final TableColumn colCausaInmediata = new TableColumn("Causa Inmediata");
        colCausaInmediata.setCellValueFactory(
                new PropertyValueFactory<CausaInmediata, String>("causaInmediata"));

        final TableColumn colEstado = new TableColumn("Estado");
        colEstado.setCellValueFactory(new PropertyValueFactory<CausaInmediata, Boolean>("estado"));
        final Callback<TableColumn<CausaInmediata, Boolean>, TableCell<CausaInmediata, Boolean>> cellFactory = CheckBoxTableCell.forTableColumn(colEstado);
        colEstado.setCellFactory(new Callback<TableColumn<CausaInmediata, Boolean>, TableCell<CausaInmediata, Boolean>>() {
            @Override
            public TableCell<CausaInmediata, Boolean> call(TableColumn<CausaInmediata, Boolean> column) {
                TableCell<CausaInmediata, Boolean> cell = cellFactory.call(column);
                cell.setAlignment(Pos.CENTER_LEFT);
                return cell;
            }
        });
        colEstado.setEditable(true);
        tbVwCausasInmediatas.setEditable(true);

        if (tbVwCausasInmediatas.getColumns().isEmpty()) {
            tbVwCausasInmediatas.getColumns().addAll(colIndex, colCausaInmediata, colEstado);
        } else {
            tbVwCausasInmediatas.getColumns().clear();
            tbVwCausasInmediatas.getColumns().addAll(colIndex, colCausaInmediata, colEstado);
        }


        tbVwCausasInmediatas.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                for (CausaInmediata p : tbVwCausasInmediatas.getItems()) {
                    System.out.println(p);

                }
                System.out.println();

            }
        });
    }

    private void crearTablaCausasBasicas() {

        ObservableList<DesgloseCausaBasica> listaDeCausasBasicas = FXCollections.observableArrayList(casoActivo.getListaCausasBasicas());
        tbVwCausasBasicas.setItems(listaDeCausasBasicas);


        final TableColumn colIndex = new TableColumn("Número");
        colIndex.setCellValueFactory(
                new PropertyValueFactory<DesgloseCausaBasica, String>("index"));

        final TableColumn colDesgloseCausaBasica = new TableColumn("Desglose de Causas Basicas");
        colDesgloseCausaBasica.setCellValueFactory(
                new PropertyValueFactory<DesgloseCausaBasica, String>("causaBasica"));

        final TableColumn colEstado = new TableColumn("Estado");
        colEstado.setCellValueFactory(new PropertyValueFactory<DesgloseCausaBasica, Boolean>("estado"));
        final Callback<TableColumn<DesgloseCausaBasica, Boolean>, TableCell<DesgloseCausaBasica, Boolean>> cellFactory = CheckBoxTableCell.forTableColumn(colEstado);
        colEstado.setCellFactory(new Callback<TableColumn<DesgloseCausaBasica, Boolean>, TableCell<DesgloseCausaBasica, Boolean>>() {
            @Override
            public TableCell<DesgloseCausaBasica, Boolean> call(TableColumn<DesgloseCausaBasica, Boolean> column) {
                TableCell<DesgloseCausaBasica, Boolean> cell = cellFactory.call(column);
                cell.setAlignment(Pos.CENTER_LEFT);
                return cell;
            }
        });
        colEstado.setEditable(true);
        tbVwCausasBasicas.setEditable(true);

        if (tbVwCausasBasicas.getColumns().isEmpty()) {
            tbVwCausasBasicas.getColumns().addAll(colIndex, colDesgloseCausaBasica, colEstado);
        } else {
            tbVwCausasBasicas.getColumns().clear();
            tbVwCausasBasicas.getColumns().addAll(colIndex, colDesgloseCausaBasica, colEstado);
        }


        tbVwCausasBasicas.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                for (DesgloseCausaBasica p : tbVwCausasBasicas.getItems()) {
                    System.out.println(p);

                }
                System.out.println();

            }
        });
    }

    private void crearTablaCausasBasicasVerdaderas() {

        ObservableList<DesgloseCausaBasica> listaDeCausasBasicas = FXCollections.observableArrayList(casoActivo.getListaCausasBasicas());
        tbVwSubCausasBasicas.setItems(listaDeCausasBasicas);


        final TableColumn colIndex = new TableColumn("Número");
        colIndex.setCellValueFactory(
                new PropertyValueFactory<DesgloseCausaBasica, String>("index"));

        final TableColumn colDesgloseCausaBasica = new TableColumn("Desglose de Causas Basicas Seleccionadas");
        colDesgloseCausaBasica.setCellValueFactory(
                new PropertyValueFactory<DesgloseCausaBasica, String>("causaBasica"));

        final TableColumn colEstado = new TableColumn("Estado");
        colEstado.setCellValueFactory(new PropertyValueFactory<DesgloseCausaBasica, Boolean>("estado"));
        final Callback<TableColumn<DesgloseCausaBasica, Boolean>, TableCell<DesgloseCausaBasica, Boolean>> cellFactory = CheckBoxTableCell.forTableColumn(colEstado);
        colEstado.setCellFactory(new Callback<TableColumn<DesgloseCausaBasica, Boolean>, TableCell<DesgloseCausaBasica, Boolean>>() {
            @Override
            public TableCell<DesgloseCausaBasica, Boolean> call(TableColumn<DesgloseCausaBasica, Boolean> column) {
                TableCell<DesgloseCausaBasica, Boolean> cell = cellFactory.call(column);
                cell.setAlignment(Pos.CENTER_LEFT);
                return cell;
            }
        });
        colEstado.setEditable(true);
        // tbVwSubCausasBasicas.setEditable(true);

        if (tbVwSubCausasBasicas.getColumns().isEmpty()) {
            tbVwSubCausasBasicas.getColumns().addAll(colIndex, colDesgloseCausaBasica, colEstado);
        } else {
            tbVwSubCausasBasicas.getColumns().clear();
            tbVwSubCausasBasicas.getColumns().addAll(colIndex, colDesgloseCausaBasica, colEstado);
        }


        tbVwSubCausasBasicas.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                
                desgloseCauBasicaGlobal = tbVwSubCausasBasicas.getSelectionModel().getSelectedItem();
                if(desgloseCauBasicaGlobal != null ){
                    Dialogs.showErrorDialog();
                }
            }
        });
    }

    private void crearTablaDeMejoras() {
        ObservableList<Mejoras> listaDeMejoras = FXCollections.observableArrayList(casoActivo.getListaMejoras());
        tbVwMejoras.setItems(listaDeMejoras);


        final TableColumn colIndex = new TableColumn("Número");
        colIndex.setCellValueFactory(
                new PropertyValueFactory<Mejoras, String>("index"));

        final TableColumn colMejoras = new TableColumn("Acciones de Mejora Continua del Sistema");
        colMejoras.setCellValueFactory(
                new PropertyValueFactory<Mejoras, String>("mejora"));

        final TableColumn colEstado = new TableColumn("Estado");
        colEstado.setCellValueFactory(new PropertyValueFactory<Mejoras, Boolean>("estado"));
        final Callback<TableColumn<Mejoras, Boolean>, TableCell<Mejoras, Boolean>> cellFactory = CheckBoxTableCell.forTableColumn(colEstado);
        colEstado.setCellFactory(new Callback<TableColumn<Mejoras, Boolean>, TableCell<Mejoras, Boolean>>() {
            @Override
            public TableCell<Mejoras, Boolean> call(TableColumn<Mejoras, Boolean> column) {
                TableCell<Mejoras, Boolean> cell = cellFactory.call(column);
                cell.setAlignment(Pos.CENTER_LEFT);
                return cell;
            }
        });
        colEstado.setEditable(true);
        
        tbVwMejoras.setEditable(true);

        if (tbVwMejoras.getColumns().isEmpty()) {
            tbVwMejoras.getColumns().addAll(colIndex, colMejoras, colEstado);
        } else {
            tbVwMejoras.getColumns().clear();
            tbVwMejoras.getColumns().addAll(colIndex, colMejoras, colEstado);
        }


        tbVwMejoras.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                for (Mejoras p : tbVwMejoras.getItems()) {
                    System.out.println(p);

                }
                System.out.println();

            }
        });
    }

    private void configuracionInicial() {
        
        
        //Configuracion de pestanias
        tabPaneWizard.getSelectionModel().select(tab1);
        cmbTipoContacto.getSelectionModel().clearSelection();
        cmbTipoContacto.setDisable(false);
        btnSiguiente.setDisable(false);
        tab2.setDisable(true);
        tab3.setDisable(true);
        tab4.setDisable(true);
        tab5.setDisable(true);
        tab6.setDisable(true);
       
        //Resetamos todas las variables globales;
        casoActivo = new Caso();
        causasInmediatasValidas.clear();
        causasBasicasValidas.clear();
        mejorasValidas.clear();
        //tablas
        tbVwCausasInmediatas.getItems().clear();
        tbVwCausasBasicas.getItems().clear();
        tbVwSubCausasBasicas.getItems().clear();
        tbVwMejoras.getItems().clear();
         
    }

    @FXML
    void accionSiguiente(ActionEvent event) {

        if (tab1.isSelected()) {
            if (!analisisTab1()) {
                // lblMensajeAlerta.setText("ALERTA: Debe Seleccionar una opción !!!");
                Dialogs.showAlerta();
                return;
            }
            tab2.setDisable(false);
            cmbTipoContacto.setDisable(true);
            tabPaneWizard.getSelectionModel().select(tab2);
            lblMensajeAlerta.setText("");
            configuracionTab2();
        } else if (tab2.isSelected()) {
            if (!analisisTab2()) {
                //lblMensajeAlerta.setText("ALERTA: Debe checkear por lo menos una opción !!!");
                Dialogs.showAlerta();
                return;
            }
            tab3.setDisable(false);
            tbVwCausasInmediatas.setEditable(false);
            tabPaneWizard.getSelectionModel().select(tab3);
            lblMensajeAlerta.setText("");
            configuracionTab3();
        } else if (tab3.isSelected()) {
            if (!analisisTab3()) {
                //lblMensajeAlerta.setText("ALERTA: Debe checkear por lo menos una opción !!!");
                Dialogs.showAlerta();
                return;
            }
            tab4.setDisable(false);
            tbVwCausasBasicas.setEditable(false);
            tabPaneWizard.getSelectionModel().select(tab4);
            lblMensajeAlerta.setText("");
            configuracionTab4();
        } else if (tab4.isSelected()) {
            if (!analisisTab4()) {
                //lblMensajeAlerta.setText("ALERTA: Debe checkear por lo menos una opción !!!");
                Dialogs.showAlerta();
                return;
            }
            tab5.setDisable(false);
            tabPaneWizard.getSelectionModel().select(tab5);
            configuracionTab5();
        } else if (tab5.isSelected()) {
            if (!analisisTab5()) {
                // lblMensajeAlerta.setText("ALERTA: Debe checkear por lo menos una opción !!!");
                Dialogs.showAlerta();
                return;
            }
            tab6.setDisable(false);
            tbVwMejoras.setEditable(false);
            btnSiguiente.setDisable(true);
            tabPaneWizard.getSelectionModel().select(tab6);
            lblMensajeAlerta.setText("");
        } else if (tab6.isSelected()) {
           
        }
    }

    public boolean analisisTab1() {
        String tipoDeContacto = null;
        boolean valido = false;
        tipoDeContacto = cmbTipoContacto.getValue();
        if (tipoDeContacto != null) {
            casoActivo.setTipoContacto(tipoDeContacto);
            valido = true;
        }
        return valido;
    }

    public boolean analisisTab2() {
        boolean estado = false;
        causasInmediatasValidas.clear();
        for (CausaInmediata p : tbVwCausasInmediatas.getItems()) {

            if (p.isEstado()) {
                //guardamos las validas
                causasInmediatasValidas.add(p);
                estado = true;
            }

        }
        // las asignamos al caso activo
        casoActivo.setListaCausasInmediatas(causasInmediatasValidas);
        return estado;
    }

    public boolean analisisTab3() {
        boolean estado = false;
        causasBasicasValidas.clear();
        for (DesgloseCausaBasica p : tbVwCausasBasicas.getItems()) {

            if (p.isEstado()) {
                //guardamos las validaspero les ponemos estado falso para despues elegir en su lista y ponerlas true
                p.setEstado(false);
                causasBasicasValidas.add(p);
                estado = true;
            }

        }
        // las asignamos al caso activo
        casoActivo.setListaCausasBasicas(causasBasicasValidas);
        return estado;
    }

    public boolean analisisTab4() {
        boolean estado = false;
        boolean falsoActivado = false;
        causasBasicasValidas.clear();
        for (DesgloseCausaBasica p : tbVwSubCausasBasicas.getItems()) {

            if (p.isEstado()) {
                causasBasicasValidas.add(p);
                estado = true;
            } else {
                falsoActivado = true;
            }

        }
        if (falsoActivado) {
            estado = false;
        }
        // las asignamos al caso activo
        casoActivo.setListaCausasBasicas(causasBasicasValidas);
        return estado;
    }

    public boolean analisisTab5() {
        boolean estado = false;
        mejorasValidas.clear();
        for (Mejoras p : tbVwMejoras.getItems()) {

            if (p.isEstado()) {
                //guardamos las validas
                mejorasValidas.add(p);
                estado = true;
            }

        }
        // las asignamos al caso activo
        casoActivo.setListaMejoras(mejorasValidas);
        return estado;
    }

    public void configuracionTab2() {

        if (casoActivo.getTipoContacto().equals(listaTipoDeContacto.get(0))) {
            for (int i = 0; i < casoActivo.getListaCausasInmediatas().size(); i++) {
                for (int x = 0; x < vCauInm1.length; x++) {
                    if (casoActivo.getListaCausasInmediatas().get(i).getIndex() == vCauInm1[x]) {
                        causasInmediatasValidas.add(casoActivo.getListaCausasInmediatas().get(i));
                    }
                }
            }

        }
        if (casoActivo.getTipoContacto().equals(listaTipoDeContacto.get(1))) {
            for (int i = 0; i < casoActivo.getListaCausasInmediatas().size(); i++) {
                for (int x = 0; x < vCauInm2.length; x++) {
                    if (casoActivo.getListaCausasInmediatas().get(i).getIndex() == vCauInm2[x]) {
                        causasInmediatasValidas.add(casoActivo.getListaCausasInmediatas().get(i));
                    }
                }
            }
        }
        if (casoActivo.getTipoContacto().equals(listaTipoDeContacto.get(2))) {
            for (int i = 0; i < casoActivo.getListaCausasInmediatas().size(); i++) {
                for (int x = 0; x < vCauInm3.length; x++) {
                    if (casoActivo.getListaCausasInmediatas().get(i).getIndex() == vCauInm3[x]) {
                        causasInmediatasValidas.add(casoActivo.getListaCausasInmediatas().get(i));
                    }
                }
            }
        }
        if (casoActivo.getTipoContacto().equals(listaTipoDeContacto.get(3))) {
            for (int i = 0; i < casoActivo.getListaCausasInmediatas().size(); i++) {
                for (int x = 0; x < vCauInm4.length; x++) {
                    if (casoActivo.getListaCausasInmediatas().get(i).getIndex() == vCauInm4[x]) {
                        causasInmediatasValidas.add(casoActivo.getListaCausasInmediatas().get(i));
                    }
                }
            }
        }
        if (casoActivo.getTipoContacto().equals(listaTipoDeContacto.get(4))) {
            for (int i = 0; i < casoActivo.getListaCausasInmediatas().size(); i++) {
                for (int x = 0; x < vCauInm5.length; x++) {
                    if (casoActivo.getListaCausasInmediatas().get(i).getIndex() == vCauInm5[x]) {
                        causasInmediatasValidas.add(casoActivo.getListaCausasInmediatas().get(i));
                    }
                }
            }
        }
        if (casoActivo.getTipoContacto().equals(listaTipoDeContacto.get(5))) {
            for (int i = 0; i < casoActivo.getListaCausasInmediatas().size(); i++) {
                for (int x = 0; x < vCauInm6.length; x++) {
                    if (casoActivo.getListaCausasInmediatas().get(i).getIndex() == vCauInm6[x]) {
                        causasInmediatasValidas.add(casoActivo.getListaCausasInmediatas().get(i));
                    }
                }
            }
        }
        if (casoActivo.getTipoContacto().equals(listaTipoDeContacto.get(6))) {
            for (int i = 0; i < casoActivo.getListaCausasInmediatas().size(); i++) {
                for (int x = 0; x < vCauInm7.length; x++) {
                    if (casoActivo.getListaCausasInmediatas().get(i).getIndex() == vCauInm7[x]) {
                        causasInmediatasValidas.add(casoActivo.getListaCausasInmediatas().get(i));
                    }
                }
            }
        }
        if (casoActivo.getTipoContacto().equals(listaTipoDeContacto.get(7))) {
            for (int i = 0; i < casoActivo.getListaCausasInmediatas().size(); i++) {
                for (int x = 0; x < vCauInm8.length; x++) {
                    if (casoActivo.getListaCausasInmediatas().get(i).getIndex() == vCauInm8[x]) {
                        causasInmediatasValidas.add(casoActivo.getListaCausasInmediatas().get(i));
                    }
                }
            }
        }
        if (casoActivo.getTipoContacto().equals(listaTipoDeContacto.get(8))) {
            for (int i = 0; i < casoActivo.getListaCausasInmediatas().size(); i++) {
                for (int x = 0; x < vCauInm9.length; x++) {
                    if (casoActivo.getListaCausasInmediatas().get(i).getIndex() == vCauInm9[x]) {
                        causasInmediatasValidas.add(casoActivo.getListaCausasInmediatas().get(i));
                    }
                }
            }
        }
        if (casoActivo.getTipoContacto().equals(listaTipoDeContacto.get(9))) {
            for (int i = 0; i < casoActivo.getListaCausasInmediatas().size(); i++) {
                for (int x = 0; x < vCauInm10.length; x++) {
                    if (casoActivo.getListaCausasInmediatas().get(i).getIndex() == vCauInm10[x]) {
                        causasInmediatasValidas.add(casoActivo.getListaCausasInmediatas().get(i));
                    }
                }
            }
        }
        if (casoActivo.getTipoContacto().equals(listaTipoDeContacto.get(10))) {
            for (int i = 0; i < casoActivo.getListaCausasInmediatas().size(); i++) {
                for (int x = 0; x < vCauInm11.length; x++) {
                    if (casoActivo.getListaCausasInmediatas().get(i).getIndex() == vCauInm11[x]) {
                        causasInmediatasValidas.add(casoActivo.getListaCausasInmediatas().get(i));
                    }
                }
            }
        }
        casoActivo.getListaCausasInmediatas().clear();
        casoActivo.setListaCausasInmediatas(causasInmediatasValidas);
        crearTablaCausasInmediatas();

    }

    public void configuracionTab3() {
        int index;
        HashSet hs = new HashSet();
        System.out.println("tam causas inm :" + casoActivo.getListaCausasInmediatas().size());
        for (int x = 0; x < casoActivo.getListaCausasInmediatas().size(); x++) {
            index = casoActivo.getListaCausasInmediatas().get(x).getIndex();
            System.out.println("index de causa select :" + index);
            for (int z = 0; z < casoActivo.getListaCausasBasicas().size(); z++) {
                for (int y = 0; y < vCausaBasica[index - 1].length; y++) {
                    if (casoActivo.getListaCausasBasicas().get(z).getIndex() == vCausaBasica[index - 1][y]) {
                        causasBasicasValidas.add(casoActivo.getListaCausasBasicas().get(z));
                        //vCausaBasica[index - 1][y] = 0;

                    }

                }
            }

        }

        hs.addAll(causasBasicasValidas);
        causasBasicasValidas.clear();
        causasBasicasValidas.addAll(hs);
        casoActivo.getListaCausasBasicas().clear();
        casoActivo.setListaCausasBasicas(causasBasicasValidas);
        crearTablaCausasBasicas();

    }

    public void configuracionTab4() {
        crearTablaCausasBasicasVerdaderas();

    }

    public void configuracionTab5() {
        int index;
        HashSet hs = new HashSet();

        System.out.println("tam causas inm :" + casoActivo.getListaCausasBasicas().size());
        for (int x = 0; x < casoActivo.getListaCausasBasicas().size(); x++) {
            index = casoActivo.getListaCausasBasicas().get(x).getIndex();
            System.out.println("index de causa basica select :" + index);
            for (int z = 0; z < casoActivo.getListaMejoras().size(); z++) {
                for (int y = 0; y < vMejoras[index - 1].length; y++) {
                    if (casoActivo.getListaMejoras().get(z).getIndex() == vMejoras[index - 1][y]) {
                        mejorasValidas.add(casoActivo.getListaMejoras().get(z));
                       // vMejoras[index - 1][y] = 0;

                    }

                }
            }

        }
        //Eliminamos duplicados con HS
        hs.addAll(mejorasValidas);
        mejorasValidas.clear();
        mejorasValidas.addAll(hs);
        casoActivo.getListaMejoras().clear();
        casoActivo.setListaMejoras(mejorasValidas);
        crearTablaDeMejoras();


    }

    @FXML
    void tipoContactoSelecciondo(DragEvent event) {
        lblMensajeAlerta.setText("");
    }

    @SuppressWarnings({"deprecation", "deprecation"})
    public void onClick$btnDummyGenerar() throws InterruptedException, SQLException, IOException, InvalidFormatException, ParseException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy  HH:mm:ss");
        Date fecha = new Date();
        String fechaActual = sdf.format(fecha);
        

        List<CausaInmediata> lstCI = casoActivo.getListaCausasInmediatas();
        List<DesgloseCausaBasica> lstCB = casoActivo.getListaCausasBasicas();

        List<Mejoras> lstM = casoActivo.getListaMejoras();
        try {

          //  System.out.println("r0: "+this.getClass().getResource("/reporte/reporteTASC.xlsx"));
            
            File rutaArchivoExcel = new File("../reporte/reporteTASC.xlsx");
            String master = System.getProperty("user.dir") + "\\reporte\\reporteTASC.xlsx";
            //String  master = getClass().getResourceAsStream("reporteTASC.xlsx");
            System.out.println("r1: "+rutaArchivoExcel.toPath());
            System.out.println("r2: "+rutaArchivoExcel.toString());
            System.out.println(master);
          
           
            InputStream archivoEntrada = new FileInputStream(master);
//          System.out.printl`n(archivoEntrada.toString());
            XSSFWorkbook libro = new XSSFWorkbook(OPCPackage.open(archivoEntrada));
            XSSFSheet hoja = libro.getSheetAt(0);

            XSSFRow filaFecha = hoja.createRow(0);

            
            XSSFCell cellFechaCreacion2 = filaFecha.createCell((short) 5);
            cellFechaCreacion2.setCellValue("Fecha de emisión: "+ fechaActual.toString());

            Iterator<CausaInmediata> iCI = lstCI.iterator();
            CausaInmediata ci = null;
            boolean datos = false;


            XSSFRow encTipoContacto = hoja.createRow(1);

            XSSFCell cellcod = encTipoContacto.createCell((short) 0);
            cellcod.setCellValue("TIPO DE CONTACTO: ");

            XSSFRow valores1 = hoja.createRow(2);
            XSSFCell cellcodVal = valores1.createCell((short) 1);
            cellcodVal.setCellValue(casoActivo.getTipoContacto());

            XSSFRow encCausasInmediatas = hoja.createRow(4);

            XSSFCell cellcua = encCausasInmediatas.createCell((short) 0);
            cellcua.setCellValue("CAUSAS INMEDIATAS: ");
            int contador = 5;

            while (iCI.hasNext()) {
                datos = true;
                ci = iCI.next();

                XSSFRow filaDatos = hoja.createRow(contador++);
                XSSFCell cellCuenta = filaDatos.createCell((short) 1);
                cellCuenta.setCellValue((ci.getIndex() + " - " + ci.getCausaInmediata()));

            }
            contador++;
            XSSFRow encDesglBasic = hoja.createRow(contador++);
            XSSFCell cellBas = encDesglBasic.createCell((short) 0);
            cellBas.setCellValue("DESGLOSE DE CAUSAS BASICAS: ");


            Iterator<DesgloseCausaBasica> iCB = lstCB.iterator();
            DesgloseCausaBasica dc = null;

            List subDetalle;
            SubCausaBasica subCausa;

            while (iCB.hasNext()) {
                datos = true;
                dc = iCB.next();

                XSSFRow filaDatos = hoja.createRow(contador++);
                XSSFCell cellCuenta = filaDatos.createCell((short) 1);
                cellCuenta.setCellValue((dc.getIndex() + " - " + dc.getCausaBasica()));
                subDetalle = dc.getListaSubCausasBasicas();
                Iterator<SubCausaBasica> iDet = subDetalle.iterator();
                //imprimimos sub causas basicas
                while (iDet.hasNext()) {
                    subCausa = iDet.next();
                    if (subCausa.isEstado()) {
                        XSSFRow filaDatos2 = hoja.createRow(contador++);
                        XSSFCell cellCuenta2 = filaDatos2.createCell((short) 2);
                        cellCuenta2.setCellValue((subCausa.getIndex() + " - " + subCausa.getSubCausaBasica()));
                    }
                }
            }

            contador++;
            XSSFRow encMejoras = hoja.createRow(contador++);
            XSSFCell cellMejE = encMejoras.createCell((short) 0);
            cellMejE.setCellValue("ACCIONES DE MEJORA CONTINUA DEL SISTEMA: ");

            Iterator<Mejoras> iM = lstM.iterator();
            Mejoras d = null;
            while (iM.hasNext()) {
                datos = true;
                d = iM.next();

                XSSFRow filaDatos = hoja.createRow(contador++);
                XSSFCell cellCuenta = filaDatos.createCell((short) 1);
                cellCuenta.setCellValue((d.getIndex() + " - " + d.getMejora()));

            }
            if (!datos) {
                lblMensajeAlerta.setText("ALERTA: No hay datos!!");
                return;
            }

            try {

                String archivo;
                Stage stage = null;
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Guardar Reporte Como...");
                fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
                ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Excel files (*.xlsx)", "*.xlsx");
                fileChooser.getExtensionFilters().add(extFilter);  
                File file = fileChooser.showSaveDialog(stage);
                if(file !=null){
                    archivo = file.getAbsolutePath().concat(".xlsx");
                    OutputStream output = new FileOutputStream(archivo);
                    libro.write(output);
                    output.flush();
                    output.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
                 lblMensajeAlerta.setText(e.toString());

            }

        } catch (Exception e) {
            e.printStackTrace();
            lblMensajeAlerta.setText(e.toString());

        }
    }

    @FXML
    void generarReporte(ActionEvent event) throws InterruptedException {
        try {
            lblMensajeAlerta.setText("Generando reporte...");
            onClick$btnDummyGenerar();
            lblMensajeAlerta.setText("Reporte generado exitosamente!!");
        } catch (SQLException ex) {
            Logger.getLogger(ManagerController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ManagerController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ManagerController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (org.apache.poi.openxml4j.exceptions.InvalidFormatException ex) {
            Logger.getLogger(ManagerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void cambioATab2(Event event) {
        //  System.out.println("constructor tab 2");
    }

    @FXML
    void cambioATab3(Event event) {
    }

    @FXML
    void cambioATab4(Event event) {
    }

    @FXML
    void cambioATab5(Event event) {
    }

    public void mensajeReporte() {
        lblMensajeAlerta.setText("Reporte Generado exitosamente!");
    }

    class CloseDialogTask extends TimerTask {

        @Override
        public void run() {
            // lblMensajeAlerta.setStyle("font-color:green");
            mensajeReporte();
        }
    }
    
}
