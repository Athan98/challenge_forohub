package foroHub.api.controller;

import foroHub.api.domain.usuario.DatosAutenticacionUsuario;
import foroHub.api.domain.usuario.Usuario;
import foroHub.api.infra.security.DatosJWTToken;
import foroHub.api.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    //DISPARAR EL PROCESO DE AUTENTICACION
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid DatosAutenticacionUsuario datosAutenticacionUsuario){
        Authentication authToken= new UsernamePasswordAuthenticationToken(datosAutenticacionUsuario.user(),
                datosAutenticacionUsuario.pass());
        //Devuelve el usuario autenticado
        var usuarioAutenticado=authenticationManager.authenticate(authToken);
        //Genera el token con el usuario autenticado previamente
        var jwtToken=tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
        //Se devuelve el token para ese usuario
        return ResponseEntity.ok(new DatosJWTToken(jwtToken));
    }
}
