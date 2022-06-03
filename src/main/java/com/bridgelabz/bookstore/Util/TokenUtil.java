package com.bridgelabz.bookstore.Util;

import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;

@Component
public class TokenUtil {
	
	private static final String TOKEN_SECRET="nvn";
	
    public String createToken(int userID) {

        Algorithm algo = Algorithm.HMAC256(TOKEN_SECRET);
        String token = JWT.create().withClaim("id_key", userID).sign(algo);

        return token;
        
    }

    public int decodeToken(String token) throws SignatureVerificationException {

        Verification verification = JWT.require(Algorithm.HMAC256(TOKEN_SECRET));
        JWTVerifier jwtVerifier = verification.build();

        DecodedJWT decodedJWT = jwtVerifier.verify(token);

        Claim idClaim = decodedJWT.getClaim("id_key");
        int id = idClaim.asInt();

        return id;
        
    }
}
