package foroHub.api.domain.autor;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor  //Constructor sin atributos
@AllArgsConstructor //Constructor con todos los atributos
public class Autor {

    private String nombre;
    private String apellido;
    private int edad;
    private String pais;

    public Autor(DatosAutor autor) {
        this.nombre=autor.nombre();
        this.apellido=autor.apellido();
        this.edad= autor.edad();
        this.pais= autor.pais();
    }
}
