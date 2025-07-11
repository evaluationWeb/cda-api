package com.adrar.api.service;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.stereotype.Service;


@Service
public class JWTService {

    //import des dépendances
    private final JwtEncoder jwtEncoder;
    private final JwtDecoder jwtDecoder;
    public JWTService(JwtEncoder jwtEncoder, JwtDecoder jwtDecoder) {
        this.jwtEncoder = jwtEncoder;
        this.jwtDecoder = jwtDecoder;
    }

    //Méthode pour générer un JWT avec les informations d'authentification
    public String generateToken(Authentication authentication) {
        Instant now = Instant.now();
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(now)
                .expiresAt(now.plus(1, ChronoUnit.DAYS))
                .subject(authentication.getName())
                .build();
        JwtEncoderParameters jwtEncoderParameters = JwtEncoderParameters.from(JwsHeader.with(MacAlgorithm.HS256).build(), claims);
        return this.jwtEncoder.encode(jwtEncoderParameters).getTokenValue();
    }

    // Méthode pour extraire le username à partir du token JWT
    public String getUsernameFromToken(String token) {
        Jwt decodedJwt = jwtDecoder.decode(token);
        return decodedJwt.getSubject();
    }
}
