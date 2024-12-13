package foroHub.api.domain.autor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosAutor(
        @NotBlank
        String nombre,
        @NotBlank
        String apellido,
        @NotNull
        int edad,
        @NotBlank
        String pais) {
}
