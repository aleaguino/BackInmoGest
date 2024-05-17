package InmoGest.Piso;

import InmoGest.Usuario.Usuario;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "piso")
public class Piso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name= "ciudad")
    private String ciudad;
    @Column (name = "ubicacion")
    private String ubicacion;
    @Column (name = "año")
    private Integer anno;
    @Column (name = "precio")
    private String precio;
    @Column (name = "estado")
    private String estado;
    
    //DATOS INQUILINO
    @Column (name = "inquilinoNombre")
    private String inquilinoNombre;
    @Column (name = "inquilinoDNI")
    private String inquilinoDNI;
    @Column (name = "inquilinoIBAN")
    private String inquilinoIBAN;
    
    //INGRESOS
    @Column (name = "ingresoMensual")
    private int ingresoMensual;
    
    private double ingresosAnuales;
    
    //GASTOS
    @Column (name = "comunidad")
    private String comunidad;
    @Column (name = "ibi")
    private String ibi;
    @Column (name = "seguro")
    private String seguro;
    @Column (name = "reforma")
    private String reforma;
    @Column (name = "averias")
    private String averias;
    @Column (name = "agua")
    private String agua;
    @Column (name = "luz")
    private String luz;
    @Column (name = "gas")
    private String gas;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    // Getters y setters, constructores, etc.
    
    public String getCiudad() {
    return ciudad;
}
    public String getUbicacion() {
    return ubicacion;
}
    public String getPrecio() {
    return precio;
}
    public String getInquilinoNombre() {
    return inquilinoNombre;
}
    public String getInquilinoDNI() {
    return inquilinoDNI;
}
    public String getInquilinoIBAN() {
    return inquilinoIBAN;
}
    public String getEstado(){
    return estado;
}
    public int getIngresoMensual(){
    return ingresoMensual; 
}
    public String getComunidad(){
    return comunidad;
}
    public String getIbi(){
    return ibi;
}
    public String getSeguro(){
    return seguro;
}
    public String getReforma(){
    return reforma;
}
    public String getAverias(){
    return averias;
}
    public String getAgua(){
    return agua;
}
    public String getLuz(){
    return luz;  
}
    public String getGas(){
    return gas;
}
    
    
    public void setIngresosAnuales(double ingresosAnuales) {
        this.ingresosAnuales = ingresosAnuales;
    }

}
