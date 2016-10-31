/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tascmanager.beans;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Freddy
 */
public class Caso {
    
    String tipoContacto;
    List<CausaInmediata> listaCausasInmediatas;
    List<DesgloseCausaBasica> listaCausasBasicas;
    List<Mejoras>  listaMejoras;

    public Caso() {
        
//            listaCausasInmediatas.clear();
        
        listaCausasInmediatas = new ArrayList();
        
            
            listaCausasInmediatas.add(new CausaInmediata(1, "Manejo de equipo sin autorizacion",false));
            listaCausasInmediatas.add(new CausaInmediata(2, "Falta de advertencias",false));
            listaCausasInmediatas.add(new CausaInmediata(3, "Falta de asegurar",false));
            listaCausasInmediatas.add(new CausaInmediata(4, "Manejo a velocidad inadecuada",false));
            listaCausasInmediatas.add(new CausaInmediata(5, "Hacer inoperables los instrumentos de seguridad",false));
            listaCausasInmediatas.add(new CausaInmediata(6, "Uso de equipo defectuoso",false));
            listaCausasInmediatas.add(new CausaInmediata(7, "Uso inapropiado de EPP",false));
            listaCausasInmediatas.add(new CausaInmediata(8, "Carga Inadecuada",false));
            listaCausasInmediatas.add(new CausaInmediata(9, "Almacenamiento inadecuado",false));
            listaCausasInmediatas.add(new CausaInmediata(10, "Levantamiento inadecuado",false));
            
            listaCausasInmediatas.add(new CausaInmediata(11, "Posicion de tarea inadecuada",false));
            listaCausasInmediatas.add(new CausaInmediata(12, "Manutención de equipo en operación",false));
            listaCausasInmediatas.add(new CausaInmediata(13, "Bromas",false));
            listaCausasInmediatas.add(new CausaInmediata(14, "Bajo influencia del alcohol u otras drogas",false));
            listaCausasInmediatas.add(new CausaInmediata(15, "Uso inapropiado del equipo",false));
            listaCausasInmediatas.add(new CausaInmediata(16, "No seguir procedimientos",false));
            listaCausasInmediatas.add(new CausaInmediata(17, "Protecciones y barreras inadecuadas",false));
            listaCausasInmediatas.add(new CausaInmediata(18, "EPP inadecuado o impropio",false));
            listaCausasInmediatas.add(new CausaInmediata(19, "Herramientas equipo o material defectuoso",false));
            listaCausasInmediatas.add(new CausaInmediata(20, "Congestión o acción restringida",false));
           
            listaCausasInmediatas.add(new CausaInmediata(21, "Sistema de advertencias inadecuado",false));
            listaCausasInmediatas.add(new CausaInmediata(22, "Peligro de explosión o incendio",false));
            listaCausasInmediatas.add(new CausaInmediata(23, "Desorden, aseo deficiente",false));
            listaCausasInmediatas.add(new CausaInmediata(24, "Exposisiones al ruido",false));
            listaCausasInmediatas.add(new CausaInmediata(25, "Exposiciones a la radiación",false));
            listaCausasInmediatas.add(new CausaInmediata(26, "Exposicion a temperaturas extremas",false));
            listaCausasInmediatas.add(new CausaInmediata(27, "Iluminación inadecuada",false));
            listaCausasInmediatas.add(new CausaInmediata(28, "Ventilación inadecuada",false));
            listaCausasInmediatas.add(new CausaInmediata(29, "Condiciones Ambientales Peligrosas",false));
            
            
            listaCausasBasicas = new ArrayList();
            
            listaCausasBasicas.add(new DesgloseCausaBasica(1, "Capacidad Fisica / Fisiológica Inadecuada", null,false));
            listaCausasBasicas.add(new DesgloseCausaBasica(2, "Capacidad mental /psicológica Inadecuada", null,false));
            listaCausasBasicas.add(new DesgloseCausaBasica(3, "Tension Física o Psicológica", null,false));
            listaCausasBasicas.add(new DesgloseCausaBasica(4, "Tension Mental o Psicológica", null,false));
            listaCausasBasicas.add(new DesgloseCausaBasica(5, "Falta de Conocimiento", null,false));
            
            listaCausasBasicas.add(new DesgloseCausaBasica(6, "Falta de Habilidad", null,false));
            listaCausasBasicas.add(new DesgloseCausaBasica(7, "Motivacion Inadecuada", null,false));
            listaCausasBasicas.add(new DesgloseCausaBasica(8, "Liderazgo y/o supervision inadecuado", null,false));
            listaCausasBasicas.add(new DesgloseCausaBasica(9, "Ingeniería Inadecuada", null,false));
            listaCausasBasicas.add(new DesgloseCausaBasica(10, "Adquisiciones inadecuadas", null,false));
            
            listaCausasBasicas.add(new DesgloseCausaBasica(11, "Mantenimiento inadecuado", null,false));
            listaCausasBasicas.add(new DesgloseCausaBasica(12, "Herramientas y equipos inadecuados", null,false));
            listaCausasBasicas.add(new DesgloseCausaBasica(13, "Estandares de trabajo inadecuados", null,false));
            listaCausasBasicas.add(new DesgloseCausaBasica(14, "Uso y desgaste excesivo", null,false));
            listaCausasBasicas.add(new DesgloseCausaBasica(15, "Abuso o mal uso", null,false));
            
           
            //mejoras
            listaMejoras  = new ArrayList();
            
            listaMejoras.add(new Mejoras(1, "POLITICA", false));
            listaMejoras.add(new Mejoras(2, "EVALUACION DE RIESGOS DE OH & S AAI", false));
            listaMejoras.add(new Mejoras(3, "OBJETIVOS Y METAS", false));
            listaMejoras.add(new Mejoras(4, "REQUERIMIENTOS LEGALES Y NORMAL UL", false));
            listaMejoras.add(new Mejoras(5, "PROGRAMAS DE GESTION", false));
            listaMejoras.add(new Mejoras(6, "ESTRUCTURA Y RESPONSABILIDADES", false));
            listaMejoras.add(new Mejoras(7, "ENTENAMIENTO, CONCIENCIA Y COMPETENCIA", false));
            listaMejoras.add(new Mejoras(8, "COMUNICACIÓN", false));
            listaMejoras.add(new Mejoras(9, "DOCUMENTACION", false));
            listaMejoras.add(new Mejoras(10, "CONTROL DE DATOS Y DOCUMENTOS", false));
            
            listaMejoras.add(new Mejoras(11, "CONTROL DE OPERACIONES", false));
            listaMejoras.add(new Mejoras(12, "PREPARACION ANTE EMERGENCIAS", false));
            listaMejoras.add(new Mejoras(13, "MEDICION Y MONITOREO DEL DESEMPEÑO", false));
            listaMejoras.add(new Mejoras(14, "ACCIDENTES / INCIDENTES / NO CONFORMIDADES", false));
            listaMejoras.add(new Mejoras(15, "REGISTROS Y SU ADMINISTRACION", false));
            listaMejoras.add(new Mejoras(16, "AUDITORIAS DEL SISTEMA DE GESTION", false));
            listaMejoras.add(new Mejoras(17, "REVISION POR LA GERENCIA", false));
            
           
                        

        
    }

    public Caso(String tipoContacto, List<CausaInmediata> listaCausasInmediatas, List<DesgloseCausaBasica> listaCausasBasicas, List<Mejoras> listaMejoras) {
        this.tipoContacto = tipoContacto;
        this.listaCausasInmediatas = listaCausasInmediatas;
        this.listaCausasBasicas = listaCausasBasicas;
        this.listaMejoras = listaMejoras;
    }

    public String getTipoContacto() {
        return tipoContacto;
    }

    public void setTipoContacto(String tipoContacto) {
        this.tipoContacto = tipoContacto;
    }

    public List<CausaInmediata> getListaCausasInmediatas() {
        return listaCausasInmediatas;
    }

    public void setListaCausasInmediatas(List<CausaInmediata> listaCausasInmediatas) {
        this.listaCausasInmediatas = listaCausasInmediatas;
    }

    public List<DesgloseCausaBasica> getListaCausasBasicas() {
        return listaCausasBasicas;
    }

    public void setListaCausasBasicas(List<DesgloseCausaBasica> listaCausasBasicas) {
        this.listaCausasBasicas = listaCausasBasicas;
    }

    public List<Mejoras> getListaMejoras() {
        return listaMejoras;
    }

    public void setListaMejoras(List<Mejoras> listaMejoras) {
        this.listaMejoras = listaMejoras;
    }

   
     
    
}
