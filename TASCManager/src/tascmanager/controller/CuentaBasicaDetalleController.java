/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tascmanager.controller;

import java.awt.Dialog;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.util.Callback;
import tascmanager.beans.CausaInmediata;
import tascmanager.beans.DesgloseCausaBasica;
import tascmanager.beans.SubCausaBasica;
import tascmanager.composer.Dialogs;
import static tascmanager.controller.ManagerController.desgloseCauBasicaGlobal;

/**
 * FXML Controller class
 *
 * @author turtle
 */
public class CuentaBasicaDetalleController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private ResourceBundle resources;
    @FXML //  fx:id="btnOK"
    private Button btnOK; // Value injected by FXMLLoader
    @FXML
    private URL location;
    @FXML
    private TableView<SubCausaBasica> tbWCausaBasicaDetalle;
    @FXML
    private HBox buttonBox;
    @FXML
    private Button continueButton;
    @FXML
    private TextArea errorMessage;
    @FXML
    private Button quitButton;

    @FXML
    void continueAction(ActionEvent event) {
        quitButton.getScene().getWindow().hide();
        //MensajeDeConsola = "";
    }

    @FXML
    void quitAction(ActionEvent event) {
        System.exit(1);
    }
    DesgloseCausaBasica currentCausa;
    List<SubCausaBasica> lst;
    public static List<SubCausaBasica> lstVerdadera;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        currentCausa = desgloseCauBasicaGlobal;

        System.out.println("causa seleccionada : " + currentCausa.getIndex());
        listarDetallesPorCausaBasica(currentCausa.getIndex());


    }

    public void listarDetallesPorCausaBasica(int indice) {
        if (currentCausa.getListaSubCausasBasicas() != null && currentCausa.getListaSubCausasBasicas().size() > 0) {
            lst = currentCausa.getListaSubCausasBasicas();
        } else {

            lst = new ArrayList();

            if (indice == 1) {
                lst.add(new SubCausaBasica(1, "Altura, peso, talla, fuerza, alcance etc. Inapropiados", false));
                lst.add(new SubCausaBasica(2, "Movimiento corporal limitado", false));
                lst.add(new SubCausaBasica(3, "Capacidad limitada para sostener posiciones cororales", false));
                lst.add(new SubCausaBasica(4, "Sensibilidad a substancias o alergias", false));
                lst.add(new SubCausaBasica(5, "Sensibilidad a extremos sensoriales ( temperatura, sonido, etc)", false));
                lst.add(new SubCausaBasica(6, "Deficiencia visual", false));
                lst.add(new SubCausaBasica(7, "Deficiencia auditiva", false));
                lst.add(new SubCausaBasica(8, "Otras deficiencias ( tacto, gusto, olfato, equilibrio)", false));
                lst.add(new SubCausaBasica(9, "Incapacidad respiratoria", false));
                lst.add(new SubCausaBasica(10, "Otras incapacidades fisicas permanentes", false));
                lst.add(new SubCausaBasica(11, "Incapacidades temporales", false));

            }
            if (indice == 2) {
                lst.add(new SubCausaBasica(1, "Temores y fobias", false));
                lst.add(new SubCausaBasica(2, "Disturbios emocionales", false));
                lst.add(new SubCausaBasica(3, "Enfermedad mental", false));
                lst.add(new SubCausaBasica(4, "Nivel de Inteligencia", false));
                lst.add(new SubCausaBasica(5, "Incapacidad para comprender", false));
                lst.add(new SubCausaBasica(6, "Mal juicio", false));
                lst.add(new SubCausaBasica(7, "Mala coordinación", false));
                lst.add(new SubCausaBasica(8, "Reacción lenta", false));
                lst.add(new SubCausaBasica(9, "Poca aptitud mecánica", false));
                lst.add(new SubCausaBasica(10, "Poca aptitud de aprendizaje", false));
                lst.add(new SubCausaBasica(11, "Falla de memoria", false));
            }
            if (indice == 3) {
                lst.add(new SubCausaBasica(1, "Lesión o enfermedad", false));
                lst.add(new SubCausaBasica(2, "Fatiga por carga o duración de la tarea", false));
                lst.add(new SubCausaBasica(3, "Fatiga por falta de descanso", false));
                lst.add(new SubCausaBasica(4, "Fatiga por sobrecarga sensitiva", false));
                lst.add(new SubCausaBasica(5, "Exposición a riesgos contra la salud", false));
                lst.add(new SubCausaBasica(6, "Exposición a temperatura extrema", false));
                lst.add(new SubCausaBasica(7, "Insuficiencia de oxígeno", false));
                lst.add(new SubCausaBasica(8, "variación de presión atmosférica", false));
                lst.add(new SubCausaBasica(9, "Movimiento restringido", false));
                lst.add(new SubCausaBasica(10, "Insuficiencia de azucar en la sangre", false));
                lst.add(new SubCausaBasica(11, "Drogas", false));
            }
            if (indice == 4) {
                lst.add(new SubCausaBasica(1, "Sobrecarga emocional", false));
                lst.add(new SubCausaBasica(2, "Fatiga por carga o velocidad de tarea mental", false));
                lst.add(new SubCausaBasica(3, "Demandas extremadas de opinión / desición", false));
                lst.add(new SubCausaBasica(4, "Rutina, monotonía de trabajos no importantes", false));
                lst.add(new SubCausaBasica(5, "Demandaes extremadas de concentración / percepción", false));
                lst.add(new SubCausaBasica(6, "Actividades \"sin sentido\" o \"degradantes\"", false));
                lst.add(new SubCausaBasica(7, "Direcciones y demandas confusas", false));
                lst.add(new SubCausaBasica(8, "Peticiones conflictivas", false));
                lst.add(new SubCausaBasica(9, "Preocupación por problemas", false));
                lst.add(new SubCausaBasica(10, "frustración", false));
                lst.add(new SubCausaBasica(11, "Enfermedad mental", false));

            }
            if (indice == 5) {
                lst.add(new SubCausaBasica(1, "Falta de experiencia", false));
                lst.add(new SubCausaBasica(2, "Orientación deficiente", false));
                lst.add(new SubCausaBasica(3, "Adiestramiento inicial inadecuado", false));
                lst.add(new SubCausaBasica(4, "Adiestramiento actualizado deficiente", false));
                lst.add(new SubCausaBasica(5, "Direcciones malentendidas", false));
            }
            if (indice == 6) {
                lst.add(new SubCausaBasica(1, "Instrucción inicial deficiente", false));
                lst.add(new SubCausaBasica(2, "Práctica insuficiente", false));
                lst.add(new SubCausaBasica(3, "Ejecución poco frecuente", false));
                lst.add(new SubCausaBasica(4, "Falta de preparación / asesoramiento", false));
                lst.add(new SubCausaBasica(5, "Revision Inadecuada de Instrucciones", false));
            }
            if (indice == 7) {

                lst.add(new SubCausaBasica(1, "Premiación (tolerancia) del desempeño inadcuado", false));
                lst.add(new SubCausaBasica(2, "Castigo del desempeño adecuado", false));
                lst.add(new SubCausaBasica(3, "Falta de incentivos", false));
                lst.add(new SubCausaBasica(4, "Frustración excesiva", false));
                lst.add(new SubCausaBasica(5, "Agresión inapropiada", false));
                lst.add(new SubCausaBasica(6, "Intento inapropiado de ahorrar tiempo o esfuerzo", false));
                lst.add(new SubCausaBasica(7, "Intento inapropiado de evitar incomodidad", false));
                lst.add(new SubCausaBasica(8, "Intento inapropiado de captar la atención", false));
                lst.add(new SubCausaBasica(9, "Disciplina Inadecuada", false));
                lst.add(new SubCausaBasica(10, "Presión inapropiada de los compañeros", false));
                lst.add(new SubCausaBasica(11, "Ejemplo inapropiado de supervisión", false));
                lst.add(new SubCausaBasica(12, "Retroalimentación deficiente del desempeño", false));
                lst.add(new SubCausaBasica(13, "Incentivos de producción inapropiados", false));
            }
            if (indice == 8) {
                lst.add(new SubCausaBasica(1, "Relaciones jeraráquicas poco claras o conflictivas", false));
                lst.add(new SubCausaBasica(2, "Asignación de responsabilidad poco clara o conflictiva", false));
                lst.add(new SubCausaBasica(3, "Delegación insuficiente o inadecuada", false));
                lst.add(new SubCausaBasica(4, "Dar políticas, procedimientos, prácticas, o pautas de acción inadecuadas", false));
                lst.add(new SubCausaBasica(5, "Dar objetivos, metas contradictorias", false));
                lst.add(new SubCausaBasica(6, "Programación o planificación inadecuada de trabajar", false));
                lst.add(new SubCausaBasica(7, "Instrucción/orientación/y/o preparación deficiente", false));
                lst.add(new SubCausaBasica(8, "Documentos de referencia, instrucciones y publicaciones de asesoramiento inadecuados a nuestra disposición", false));
                lst.add(new SubCausaBasica(9, "Identificación y evaluación deficiente de exposiciones a pérdidas", false));
                lst.add(new SubCausaBasica(10, "conocimiento inadecuado del trabajo de supervisión/administración", false));
                lst.add(new SubCausaBasica(11, "Asignación inadecuada del trabajador, a las exigencias de la tarea", false));
                lst.add(new SubCausaBasica(12, "Medición y evaluación deficiente del desempeño", false));
                lst.add(new SubCausaBasica(13, "Retroalimentación deficiente o incorrecta del desempeño", false));
            }
            if (indice == 9) {
                lst.add(new SubCausaBasica(1, "Evaluación inadecuada de las exposiciones a pérdidas", false));
                lst.add(new SubCausaBasica(2, "Consideración deficiente de factores ergonómicos / humanos", false));
                lst.add(new SubCausaBasica(3, "Estándares y/o especificaciones y/o criterios de diseño deficientes", false));
                lst.add(new SubCausaBasica(4, "Control inadecuado de la cosntrucción", false));
                lst.add(new SubCausaBasica(5, "Evaluación inadecuada de condiciones operacionales", false));
                lst.add(new SubCausaBasica(6, "Controles inadecuados", false));
                lst.add(new SubCausaBasica(7, "Monitoreo u operación inicial inadecuada", false));
                lst.add(new SubCausaBasica(8, "Evaluación inadecuada del cambio", false));
            }
            if (indice == 10) {
                lst.add(new SubCausaBasica(1, "Especificaciones deficientes de órdenes y pedidos", false));
                lst.add(new SubCausaBasica(2, "Invesigación inadecuada del material / equipo", false));
                lst.add(new SubCausaBasica(3, "Especificaciones inadecuadas a vendedores", false));
                lst.add(new SubCausaBasica(4, "Modalidad o ruta de reembarque inadecuada", false));
                lst.add(new SubCausaBasica(5, "Inspeción de recepción deficiente", false));
                lst.add(new SubCausaBasica(6, "Comunicación inadecuada de información de salud , seguridad y ambiente", false));
                lst.add(new SubCausaBasica(7, "Manejo inadecuado de materiales", false));
                lst.add(new SubCausaBasica(8, "Almacenamiento inadecuado de materiales", false));
                lst.add(new SubCausaBasica(9, "Transporte inadecuado de materiales", false));
                lst.add(new SubCausaBasica(10, "Identificación deficiente de materiales peligrosos", false));
                lst.add(new SubCausaBasica(11, "Disposición inadecuada de residuos / desperdicios", false));
                lst.add(new SubCausaBasica(12, "Selección inadecuada de contratistas", false));
            }
            if (indice == 11) {
                lst.add(new SubCausaBasica(1, "Prevención inadecuada - Evaluación de necesidades", false));
                lst.add(new SubCausaBasica(2, "Prevención inadecuada - Lubricación y servicio", false));
                lst.add(new SubCausaBasica(3, "Prevención inadecuada - Ajuste/ensamblaje", false));
                lst.add(new SubCausaBasica(4, "Prevención inadecuada - Limpieza o pulimiento", false));
                lst.add(new SubCausaBasica(5, "Reparación Inadecuada - Comunicación de necesidades", false));
                lst.add(new SubCausaBasica(6, "Reparación Inadecuada - Planeamiento del trabajo", false));
                lst.add(new SubCausaBasica(7, "Reparación Inadecuada - Examinación de unidades", false));
                lst.add(new SubCausaBasica(8, "Reparación Inadecuada - Substitución de partes", false));
            }
            if (indice == 12) {
                lst.add(new SubCausaBasica(1, "Evaluación deficiente de necesidades / riesgos", false));
                lst.add(new SubCausaBasica(2, "Consideración inadecuada de factores ergonómicos / humanos", false));
                lst.add(new SubCausaBasica(3, "Estándares o especificaciones inadecuadas", false));
                lst.add(new SubCausaBasica(4, "Disponibilidad inadecuada", false));
                lst.add(new SubCausaBasica(5, "Ajuste/reparación/mantenimiento deficiente", false));
                lst.add(new SubCausaBasica(6, "Salvamento y reclamación inadecuada", false));
                lst.add(new SubCausaBasica(7, "Inadecuada remoción o remplazo de articulos deficientes", false));
            }
            if (indice == 13) {
                lst.add(new SubCausaBasica(1, "Desarrollo inadecuado de estándares para: Inventario y evaluación de exposiciones y necesidades", false));
                lst.add(new SubCausaBasica(2, "Desarrollo inadecuado de estándares para: Coordinación en le diseño del proceso", false));
                lst.add(new SubCausaBasica(3, "Desarrollo inadecuado de estándares para: Involucración del empleado", false));
                lst.add(new SubCausaBasica(4, "Desarrollo inadecuado de estándares para: Estándares, procedimeintos, reglas", false));
                lst.add(new SubCausaBasica(5, "Comunicación inadecuada de estándares para: Publicaciones", false));
                lst.add(new SubCausaBasica(6, "Comunicación inadecuada de estándares para: Distribución", false));
                lst.add(new SubCausaBasica(7, "Comunicación inadecuada de estándares para: Traducción a idioma apropiado", false));
                lst.add(new SubCausaBasica(8, "Comunicación inadecuada de estándares para: Entrenamiento", false));
                lst.add(new SubCausaBasica(9, "Comunicación inadecuada de estándares para: Reforrzamiento con simbolos, códigos, simbolos de color y ayuda en el trabajo", false));
                lst.add(new SubCausaBasica(10, "Manutención inadecuada de estándares para: Seguimiento del flujo del trabajo", false));
                lst.add(new SubCausaBasica(11, "Manutención inadecuada de estándares para: Actualización", false));
                lst.add(new SubCausaBasica(12, "Manutención inadecuada de estándares para: Monitoreo del uso de estándares/ procedimeintos/ reglas", false));
                lst.add(new SubCausaBasica(13, "Monitoreo inadecuado del cumplimiento", false));
            }
            if (indice == 14) {

                lst.add(new SubCausaBasica(1, "Planificación inadecuada de uso", false));
                lst.add(new SubCausaBasica(2, "Extención inadecuada de la vida útil", false));
                lst.add(new SubCausaBasica(3, "Inspección y/o control deficiente", false));
                lst.add(new SubCausaBasica(4, "Carga o proporción de uso deficiente", false));
                lst.add(new SubCausaBasica(5, "Mantenimiento deficiente", false));
                lst.add(new SubCausaBasica(6, "Uso por personas no calificadas / adiestradas", false));
                lst.add(new SubCausaBasica(7, "Uso para propósitos indebidos", false));

            }
            if (indice == 15) {

                lst.add(new SubCausaBasica(1, "Conducta inapropiada censurada: Intencional", false));
                lst.add(new SubCausaBasica(2, "Conducta inapropiada censurada: No Intencional", false));
                lst.add(new SubCausaBasica(3, "Conducta inapropiada permitida: Intencional", false));
                lst.add(new SubCausaBasica(4, "Conducta inapropiada permitida: No Intencional", false));
            }
        }


        crearTablaCausasBasicas();

    }

    private void crearTablaCausasBasicas() {
        System.out.println("entro a crear la tabla");
        ObservableList<SubCausaBasica> listaDeCausasBasicas = FXCollections.observableArrayList(lst);
        tbWCausaBasicaDetalle.setItems(listaDeCausasBasicas);


        final TableColumn colIndex = new TableColumn("Número");
        colIndex.setCellValueFactory(
                new PropertyValueFactory<SubCausaBasica, String>("index"));

        final TableColumn colSubCausaBasica = new TableColumn("Descripciones de Causa Basica");
        colSubCausaBasica.setCellValueFactory(
                new PropertyValueFactory<SubCausaBasica, String>("subCausaBasica"));

        final TableColumn colEstado = new TableColumn("Estado");
        colEstado.setCellValueFactory(new PropertyValueFactory<SubCausaBasica, Boolean>("estado"));
        final Callback<TableColumn<SubCausaBasica, Boolean>, TableCell<SubCausaBasica, Boolean>> cellFactory = CheckBoxTableCell.forTableColumn(colEstado);
        colEstado.setCellFactory(new Callback<TableColumn<SubCausaBasica, Boolean>, TableCell<SubCausaBasica, Boolean>>() {
            @Override
            public TableCell<SubCausaBasica, Boolean> call(TableColumn<SubCausaBasica, Boolean> column) {
                TableCell<SubCausaBasica, Boolean> cell = cellFactory.call(column);
                cell.setAlignment(Pos.CENTER_LEFT);
                return cell;
            }
        });
        colEstado.setEditable(true);
        tbWCausaBasicaDetalle.setEditable(true);

        if (tbWCausaBasicaDetalle.getColumns().isEmpty()) {
            tbWCausaBasicaDetalle.getColumns().addAll(colIndex, colSubCausaBasica, colEstado);
        } else {
            tbWCausaBasicaDetalle.getColumns().clear();
            tbWCausaBasicaDetalle.getColumns().addAll(colIndex, colSubCausaBasica, colEstado);
        }


        tbWCausaBasicaDetalle.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                for (SubCausaBasica p : tbWCausaBasicaDetalle.getItems()) {
                    System.out.println(p);

                }
                System.out.println();

            }
        });
    }

    @FXML
    void clickOK(ActionEvent event) {
        if (validarCheckeos()) {
            lstVerdadera = tbWCausaBasicaDetalle.getItems();
            currentCausa.setListaSubCausasBasicas(lstVerdadera);
            currentCausa.setEstado(true);
            desgloseCauBasicaGlobal = currentCausa;
            
            btnOK.getScene().getWindow().hide();
        } else {
            Dialogs.showAlerta();
        }

    }

    public boolean validarCheckeos() {
        boolean estado = false;

        for (SubCausaBasica p : tbWCausaBasicaDetalle.getItems()) {

            if (p.isEstado()) {
                estado = true;
            }

        }
        return estado;
    }
}
