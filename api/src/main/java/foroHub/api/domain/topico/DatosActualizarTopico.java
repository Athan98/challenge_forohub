package foroHub.api.domain.topico;

import foroHub.api.domain.autor.DatosAutor;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record DatosActualizarTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotNull
        Date fecha_creacion,
        @NotNull
        @Valid
        DatosAutor autor,
        @NotNull
        Categoria categoria,
        boolean estado) {
}
