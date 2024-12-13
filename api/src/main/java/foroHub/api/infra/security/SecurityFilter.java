package foroHub.api.infra.security;

import foroHub.api.domain.usuario.UsuarioRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //Obtener token del header
        var token= request.getHeader("Authorization");

        //Verificar si el token no esta nulo

        if(token !=null){
            //Si llego, validar el token:
            token=token.replace("Bearer ","");

            //Verificamos si el subject esta logeado realmente en el sistema. Lo extraemos de la BD
            var usuario=tokenService.getSubject(token);
            System.out.println(usuario);

            if(usuario != null){
                //Si el usuario NO ES NULO, EL TOKEN ES VALIDO. Entonces:
                //Encontramos el usuario
                var usuarioSesion=usuarioRepository.findByUser(usuario);
                //El usuario existe, entonces forzamos autenticacion para iniciar sesion
                var authentication= new UsernamePasswordAuthenticationToken(usuarioSesion, null,
                        usuarioSesion.getAuthorities());
                //Seteamos manualmente autenticacion
                SecurityContextHolder.getContext().setAuthentication(authentication);

            }


        }

        //El filtro atrapa la request y la envia al siguiente filtro
        filterChain.doFilter(request,response);


    }
}
