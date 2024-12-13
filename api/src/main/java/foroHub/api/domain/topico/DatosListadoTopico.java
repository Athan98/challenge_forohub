package foroHub.api.domain.topico;

import foroHub.api.domain.autor.Autor;

import java.util.Date;

public record DatosListadoTopico(
        String titulo,
        String mensaje,
        Date fecha_creacion,
        Autor autor,
        Categoria categoria,
        boolean estado) {

    public DatosListadoTopico(Topico topico){
        this(topico.getTitulo(),topico.getMensaje(),topico.getFecha_creacion(),topico.getAutor(),topico.getCategoria(), topico.isEstado());
    }

}
