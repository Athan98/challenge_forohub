package foroHub.api.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import foroHub.api.domain.usuario.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.secret}")
    private String apiSecret;

    public String generarToken(Usuario usuario){
        try{
            Algorithm algorithm=Algorithm.HMAC256(apiSecret);
            return JWT.create()
                    .withIssuer("forohub")
                    .withSubject(usuario.getUser())
                    .withClaim("id",usuario.getId())
                    .withExpiresAt(generarFechaExpiracion())
                    .sign(algorithm);
        }catch (JWTCreationException jwtCreationException){
            throw new RuntimeException();
        }
    }

    //Metodo para verificar el JWT de un usuario
    public String getSubject(String token){
        //Verificar si el token llega
        if(token==null){
            throw new RuntimeException();
        }

        DecodedJWT verifier = null;

        try{
            Algorithm algorithm=Algorithm.HMAC256(apiSecret); //Validar firma TOKEN
            verifier=JWT.require(algorithm)
                    .withIssuer("forohub")
                    .build()
                    .verify(token);
            verifier.getSubject();
        }catch (JWTVerificationException exception){
            System.out.println(exception.toString());
        }

        if(verifier.getSubject() == null){
            throw new RuntimeException("Verifier invalido");
        }

        return verifier.getSubject();
    }

    private Instant generarFechaExpiracion(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-05:00"));
    }
}