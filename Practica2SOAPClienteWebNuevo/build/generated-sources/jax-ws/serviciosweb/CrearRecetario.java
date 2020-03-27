
package serviciosweb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para crearRecetario complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="crearRecetario"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="recetario" type="{http://serviciosWeb/}recetario" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "crearRecetario", propOrder = {
    "recetario"
})
public class CrearRecetario {

    protected Recetario recetario;

    /**
     * Obtiene el valor de la propiedad recetario.
     * 
     * @return
     *     possible object is
     *     {@link Recetario }
     *     
     */
    public Recetario getRecetario() {
        return recetario;
    }

    /**
     * Define el valor de la propiedad recetario.
     * 
     * @param value
     *     allowed object is
     *     {@link Recetario }
     *     
     */
    public void setRecetario(Recetario value) {
        this.recetario = value;
    }

}
