package InmoGest.Piso;

import InmoGest.Usuario.Usuario;
import java.io.Serializable;
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

}

