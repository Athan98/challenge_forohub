package foroHub.api.domain.topico;

import foroHub.api.domain.autor.Autor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor  //Constructor sin atributos
@AllArgsConstructor //Constructor con todos los atributos
@EqualsAndHashCode(of = "id") //Utiliza el parametro idTopico para comparar entre topicos
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    @Temporal(TemporalType.DATE)
    private Date fecha_creacion;
    @Embedded
    private Autor autor;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    private boolean estado;

    public Topico(DatosRegistroTopico datosRegistroTopico) {
        this.titulo=datosRegistroTopico.titulo();
        this.mensaje=datosRegistroTopico.mensaje();
        this.fecha_creacion=datosRegistroTopico.fecha_creacion();
        this.autor=new Autor(datosRegistroTopico.autor());
        this.categoria=datosRegistroTopico.categoria();
        this.estado=datosRegistroTopico.estado();
    }

    public void actualizarDatos(DatosActualizarTopico datosActualizarTopico) {
        if(datosActualizarTopico.titulo() != null){
            this.titulo=datosActualizarTopico.titulo();
        }
        if(datosActualizarTopico.mensaje() != null){
            this.mensaje=datosActualizarTopico.mensaje();
        }
        if(datosActualizarTopico.fecha_creacion() != null){
            this.fecha_creacion=datosActualizarTopico.fecha_creacion();
        }
        if(datosActualizarTopico.autor() != null){
            this.autor=new Autor(datosActualizarTopico.autor());
        }
        if(datosActualizarTopico.categoria() != null){
            this.categoria=datosActualizarTopico.categoria();
        }
        this.estado=datosActualizarTopico.estado();
    }
}
