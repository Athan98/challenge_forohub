package foroHub.api.controller;

import foroHub.api.domain.autor.DatosAutor;
import foroHub.api.domain.topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @PostMapping
    public ResponseEntity<DatosRespuestaTopico> registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico,
                                          UriComponentsBuilder uriComponentsBuilder){
        Topico topico=repository.save(new Topico(datosRegistroTopico));
        DatosRespuestaTopico datosRespuestaTopico= new DatosRespuestaTopico(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFecha_creacion(),
                topico.getAutor(),
                topico.getCategoria(),
                topico.isEstado()
        );
        // URL donde encontrar al medico:
        // GET http://localhost:8080/topicos/xx
        URI url=uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaTopico);

    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoTopico>> listarTopicos(@PageableDefault(size = 10) Pageable paginacion){
        return ResponseEntity.ok(repository.findAll(paginacion).map(DatosListadoTopico::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<DatosRespuestaTopico>> obtenerTopico(@PathVariable Long id){
        Optional<DatosRespuestaTopico> datosRespuestaTopico = repository.findById(id).map(DatosRespuestaTopico::new);

        if(datosRespuestaTopico.isPresent()){
            return ResponseEntity.ok(datosRespuestaTopico);
        }else{
            return ResponseEntity.notFound().build();
        }

    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DatosRespuestaTopico> actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico, @PathVariable Long id){
        Optional<Topico> topico = repository.findById(id);

        if(topico.isPresent()){
            topico.get().actualizarDatos(datosActualizarTopico);
            return ResponseEntity.ok(
                    new DatosRespuestaTopico(
                            topico.get().getId(),
                            topico.get().getTitulo(),
                            topico.get().getMensaje(),
                            topico.get().getFecha_creacion(),
                            topico.get().getAutor(),
                            topico.get().getCategoria(),
                            topico.get().isEstado()
                    ));
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id){
        Optional<Topico> topico = repository.findById(id);

        if(topico.isPresent()){
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
