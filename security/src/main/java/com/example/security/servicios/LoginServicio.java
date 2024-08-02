package com.example.security.servicios;

import com.example.security.dao.UsuarioDAO;
import com.example.security.modelo.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Path("/auth")
@Service
public class LoginServicio {
    @Value("${app.jwtSecret}")
    private String jwtSecret;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response validar(Usuario usuario) {
        boolean status = UsuarioDAO.validar(usuario.getUsername(), usuario.getPassword());
        if (status) {
            long tiempo = System.currentTimeMillis();
            String jwt = Jwts.builder()
                    .signWith(SignatureAlgorithm.HS256, jwtSecret)
                    .setSubject("Angel Rondon")
                    .setIssuedAt(new Date(tiempo))
                    .setExpiration(new Date(tiempo + 900000))
                    .claim("email", "angel123@gmail.com")
                    .compact();

            JsonObject json = Json.createObjectBuilder()
                    .add("JWT", jwt).build();
            return Response.status(Response.Status.CREATED).entity(json).build();
        }
        return Response.status(Response.Status.UNAUTHORIZED).build();
    }
}
