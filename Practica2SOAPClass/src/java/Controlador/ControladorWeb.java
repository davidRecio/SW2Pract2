package Controlador;

import Recetarios.Receta;
import Recetarios.Recetario;
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
 * @author darth
 */
@WebService(serviceName = "ControladorWeb")
public class ControladorWeb {

    private ArrayList<Receta> recetaArrayList = new ArrayList();
    private Recetario recetario = new Recetario();
    CreadorObjetos co = new CreadorObjetos();
    Modelo modelo = new Modelo();
    private Receta receta = new Receta();
    Marsalling mrs = new Marsalling();
    ValidarXSD vXSD = new ValidarXSD();
    String sCarpAct = System.getProperty("user.dir");
    File carpeta = new File(sCarpAct);
    String ruta = carpeta.getPath();

    @WebMethod(operationName = "crearRecetario")
    public boolean crearRecetario(@WebParam(name = "nombreRecetario") String nombreRecetario,
            @WebParam(name = "precioRecetario") Double precioRecetario) {

        recetario = co.crearRecetarioWeb(nombreRecetario, recetaArrayList, precioRecetario);
        return !modelo.listarRecetarioWeb(recetario).equals("No existe el recetario");

    }

 //exportar e importar
    @WebMethod(operationName = "exportarRecetario")
    public void exportarRecetario(@WebParam(name = "nombreFichero") String nombreFichero) {
        mrs.crearXMLRecetario(nombreFichero, recetario, ruta);

    }

    @WebMethod(operationName = "importarRecetario")
    public void importarRecetario(@WebParam(name = "nombreFichero") String nombreFichero) {
        recetario = mrs.importarRecetario(nombreFichero, ruta);

    }

    @WebMethod(operationName = "exportarReceta")
    public void exportarReceta(@WebParam(name = "nombreFichero") String nombreFichero,
            @WebParam(name = "nombreReceta") String nombreReceta) {
        mrs.crearXMLReceta(nombreFichero, modelo.buscarReceta(nombreReceta, recetario), ruta);

    }

    @WebMethod(operationName = "importarReceta")
    public void importarReceta(@WebParam(name = "nombreFichero") String nombreFichero) {
        receta = mrs.importarReceta(nombreFichero, ruta);

    }
//validar fichero

    @WebMethod(operationName = "validarXSD")
    public String validarXSD(@WebParam(name = "nombreFichero") String nombrefichero) {
        return "¿Es valido el xml con su xsd? " + vXSD.validarXSD(ruta + "/files/xsd/recetario.xsd", ruta + "/files/xml/" + nombrefichero);
    }
    //obtener elementos

    @WebMethod(operationName = "obtenerRecetaRecetario")
    public Receta obtenerRecetaRecetario(@WebParam(name = "nombreReceta") String nombreReceta) {
        Receta resultado = new Receta();
        for (Receta ele : recetario.getRecetas()) {

            if (ele.getNombre().equals(nombreReceta)) {
                resultado = ele;
                return resultado;
            }
        }
        resultado = null;
        return resultado;
    }

//getters y setters
    @WebMethod(operationName = "obtenerRecetaArrayList")
    public ArrayList<Receta> obtenerRecetaArrayList() {
        return recetaArrayList;
    }

    @WebMethod(operationName = "crearRecetaArrayList")
    public void crearRecetaArrayList(@WebParam(name = "recetaArrayList") ArrayList<Receta> recetaArrayList) {
        this.recetaArrayList = recetaArrayList;
    }

    @WebMethod(operationName = "obtenerRecetario")
    public Recetario obtenerRecetario() {
        return recetario;
    }

    @WebMethod(operationName = "crearRecetaSimple")
    public void crearRecetaSimple(@WebParam(name = "receta") Receta receta) {
        this.receta = receta;
    }

    @WebMethod(operationName = "addReceta")
    public void addReceta() {
        recetaArrayList.add(receta);
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
                Logger.getLogger(ControladorWeb.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(ControladorWeb.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                bw.close();
            } catch (IOException ex) {
                Logger.getLogger(ControladorWeb.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(ControladorWeb.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(ControladorWeb.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                bw.close();
            } catch (IOException ex) {
                Logger.getLogger(ControladorWeb.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
