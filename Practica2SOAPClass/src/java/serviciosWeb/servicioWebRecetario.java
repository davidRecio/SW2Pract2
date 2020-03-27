/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviciosWeb;


import Funcionalidad.ValidarXSD;
import Funcionalidad.Marsalling;
import Recursos.Receta;
import Recursos.Recetario;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author david
 */
@WebService(serviceName = "servicioWebRecetario")
public class servicioWebRecetario {

   
    private Recetario recetario = new Recetario();
    private Marsalling mrs = new Marsalling();
    private ValidarXSD vXSD = new ValidarXSD();
    private String sCarpAct = System.getProperty("user.dir");
    private File carpeta = new File(sCarpAct);
    private String ruta = carpeta.getPath();
    private ArrayList<Receta> recetas = new ArrayList();
//Clases del modeo
    
    @WebMethod(operationName = "crearRecetario")
    public void crearRecetario(@WebParam(name = "recetario") Recetario recetario) {
        this.recetario=recetario;

    }
    @WebMethod(operationName = "addReceta")
    public void addReceta(@WebParam(name = "receta")Receta receta) {
      
       recetas.add(receta);
        recetario.setRecetas(recetas);

    }
    @WebMethod(operationName = "rmvReceta")
    public void rmvReceta(@WebParam(name = "nombreReceta")String nombreReceta) {
      recetario.getRecetas().remove(obtenerReceta(nombreReceta));

    }
    @WebMethod(operationName = "obtenerReceta")
    public Receta obtenerReceta(@WebParam(name = "nombreReceta")String nombreReceta) {
        Receta resultado = null;
        for (Receta ele : recetario.getRecetas()) {

            if (ele.getNombre().equals(nombreReceta)) {
                resultado = ele;
            }

        }
        return resultado;

    }
    @WebMethod(operationName = "obtenerRecetario")
    public Recetario obtenerRecetario() {
        return recetario;
    }

 //exportar e importar
    //el servicio te exporta el xmlen el servidor y luego lo muueve al cliente, port tanto la funcion tiene un return de fichero
    @WebMethod(operationName = "exportarRecetario")
    public void exportarRecetario(@WebParam(name = "nombreFichero") String nombreFichero) {
        mrs.crearXMLRecetario(nombreFichero, recetario, ruta);

    }
//parametro de entrada que sea unchero
    @WebMethod(operationName = "importarRecetario")
    public void importarRecetario(@WebParam(name = "nombreFichero") String nombreFichero) {
        recetario = mrs.importarRecetario(nombreFichero, ruta);

    }

    @WebMethod(operationName = "exportarReceta")
    public void exportarReceta(@WebParam(name = "nombreFichero") String nombreFichero,
            @WebParam(name = "nombreReceta") String nombreReceta) {
        mrs.crearXMLReceta(nombreFichero, obtenerReceta(nombreReceta), ruta);

    }

    @WebMethod(operationName = "importarReceta")
    public void importarReceta(@WebParam(name = "nombreFichero") String nombreFichero) {
        addReceta(mrs.importarReceta(nombreFichero, ruta));

    }
    
    
    
    
    
    //validar fichero

    @WebMethod(operationName = "validarXSD")
    public String validarXSD(@WebParam(name = "nombreFichero") String nombrefichero) {
        return "¿Es valido el xml con su xsd? " + vXSD.validarXSD(ruta + "/files/xsd/recetario.xsd", ruta + "/files/xml/" + nombrefichero);
    }


    //creacion de ficheros necesarios
    @WebMethod(operationName = "start")
    public void start() {
        crearEntorno();
    }
    //crea ficheros necesarios

    private void crearEntorno() {
        File directorio = new File(ruta + "/files/xml");
        if (!directorio.exists()) {
            if (directorio.mkdirs()) {
                System.out.println("Directorio creado");
            } else {
                System.out.println("Error al crear directorio");
            }
        }
        directorio = new File(ruta + "/files/xsd");
        if (!directorio.exists()) {
            if (directorio.mkdirs()) {
                System.out.println("Directorio creado");
            } else {
                System.out.println("Error al crear directorio");
            }
        }
        crearXSD();
        crearRecetario1();
    }

    private void crearXSD() {

        File archivo = new File(ruta + "/files/xsd/recetario.xsd");
        BufferedWriter bw = null;
        if (archivo.exists() != true) {

            try {
                bw = new BufferedWriter(new FileWriter(archivo));
            } catch (IOException ex) {
                Logger.getLogger(servicioWebRecetario.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                bw.write("<xs:schema attributeFormDefault=\"unqualified\" elementFormDefault=\"qualified\" xmlns:xs=\"http://www.w3.org/2001/XMLSchema\">\n"
                        + "  <xs:element name=\"Recetario\">\n"
                        + "    <xs:complexType>\n"
                        + "      <xs:sequence>\n"
                        + "        <xs:element type=\"xs:string\" name=\"nombre\"/>\n"
                        + "        <xs:element name=\"recetas\">\n"
                        + "          <xs:complexType>\n"
                        + "            <xs:sequence>\n"
                        + "              <xs:element name=\"recetas\" maxOccurs=\"unbounded\" minOccurs=\"0\">\n"
                        + "                <xs:complexType>\n"
                        + "                  <xs:sequence>\n"
                        + "                    <xs:element type=\"xs:string\" name=\"nombre\"/>\n"
                        + "                    <xs:element name=\"ingrediente\">\n"
                        + "                      <xs:complexType>\n"
                        + "                        <xs:sequence>\n"
                        + "                          <xs:element type=\"xs:string\" name=\"ingrediente\" maxOccurs=\"unbounded\" minOccurs=\"0\"/>\n"
                        + "                        </xs:sequence>\n"
                        + "                      </xs:complexType>\n"
                        + "                    </xs:element>\n"
                        + "                    <xs:element type=\"xs:float\" name=\"precio\"/>\n"
                        + "                  </xs:sequence>\n"
                        + "                  <xs:attribute type=\"xs:string\" name=\"dificultad\" use=\"optional\"/>\n"
                        + "                </xs:complexType>\n"
                        + "              </xs:element>\n"
                        + "            </xs:sequence>\n"
                        + "          </xs:complexType>\n"
                        + "        </xs:element>\n"
                        + "        <xs:element type=\"xs:float\" name=\"precio\"/>\n"
                        + "      </xs:sequence>\n"
                        + "    </xs:complexType>\n"
                        + "  </xs:element>\n"
                        + "</xs:schema>\n"
                        + "");
            } catch (IOException ex) {
                Logger.getLogger(servicioWebRecetario.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                bw.close();
            } catch (IOException ex) {
                Logger.getLogger(servicioWebRecetario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void crearRecetario1() {

        File archivo = new File(ruta + "/files/xml/recetario1.xml");
        BufferedWriter bw = null;
        if (archivo.exists() != true) {

            try {
                bw = new BufferedWriter(new FileWriter(archivo));
            } catch (IOException ex) {
                Logger.getLogger(servicioWebRecetario.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                bw.write("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
                        + "<Recetario>\n"
                        + "    <nombre>Recetario1</nombre>\n"
                        + "    <recetas>\n"
                        + "        <recetas dificultad=\"Dificil\">\n"
                        + "            <nombre>Lasanna</nombre>\n"
                        + "            <ingrediente>\n"
                        + "                <ingrediente>Tomate</ingrediente>\n"
                        + "                <ingrediente>Carne</ingrediente>\n"
                        + "                <ingrediente>Pasta</ingrediente>\n"
                        + "                <ingrediente>Queso</ingrediente>\n"
                        + "                <ingrediente>Aceite</ingrediente>\n"
                        + "                <ingrediente>Sal</ingrediente>\n"
                        + "                <ingrediente>Bechamel</ingrediente>\n"
                        + "            </ingrediente>\n"
                        + "            <precio>12.0</precio>\n"
                        + "        </recetas>\n"
                        + "        <recetas dificultad=\"Facil\">\n"
                        + "            <nombre>Sandwich de pavo</nombre>\n"
                        + "            <ingrediente>\n"
                        + "                <ingrediente>Pavo</ingrediente>\n"
                        + "                <ingrediente>Pan</ingrediente>\n"
                        + "            </ingrediente>\n"
                        + "            <precio>1.5</precio>\n"
                        + "        </recetas>\n"
                        + "        <recetas dificultad=\"Facil\">\n"
                        + "            <nombre>Filete de ternera</nombre>\n"
                        + "            <ingrediente>\n"
                        + "                <ingrediente>Carne de ternera</ingrediente>\n"
                        + "                <ingrediente>Aceite</ingrediente>\n"
                        + "                <ingrediente>Sal</ingrediente>\n"
                        + "            </ingrediente>\n"
                        + "            <precio>1.0</precio>\n"
                        + "        </recetas>\n"
                        + "    </recetas>\n"
                        + "    <precio>20.0</precio>\n"
                        + "</Recetario>");
            } catch (IOException ex) {
                Logger.getLogger(servicioWebRecetario.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                bw.close();
            } catch (IOException ex) {
                Logger.getLogger(servicioWebRecetario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
