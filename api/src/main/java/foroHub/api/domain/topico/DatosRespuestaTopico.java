package foroHub.api.domain.topico;

import foroHub.api.domain.autor.Autor;
import foroHub.api.domain.autor.DatosAutor;

import java.util.Date;

public record DatosRespuestaTopico(
        Long id,
        String titulo,
        String mensaje,
        Date fecha_creacion,
        Autor autor,
        Categoria categoria,
        boolean estado
) {
    public DatosRespuestaTopico(Topico topico){
        this(topico.getId(),topico.getTitulo(),topico.getMensaje(),topico.getFecha_creacion(),topico.getAutor(),topico.getCategoria(),topico.isEstado());
    }
}
