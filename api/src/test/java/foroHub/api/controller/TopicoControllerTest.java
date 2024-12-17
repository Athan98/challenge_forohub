package foroHub.api.controller;

import foroHub.api.domain.autor.Autor;
import foroHub.api.domain.autor.DatosAutor;
import foroHub.api.domain.topico.Categoria;
import foroHub.api.domain.topico.DatosRegistroTopico;
import foroHub.api.domain.topico.DatosRespuestaTopico;
import foroHub.api.domain.topico.TopicoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class TopicoControllerTest {

    @Autowired
    private MockMvc mvc;


    @Test
    @DisplayName("Deberia devolver http 400 cuando la request no tenga datos")
    @WithMockUser // Del paquete Spring-Security-Test. Para saltar la parte del login con JWT, simulando que estamos logueados
    void registrarTopico_escenario1() throws Exception {
        var response=mvc.perform(post("/topicos"))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }


    @Test
    void actualizarTopico() {
    }
}