package com.dailycodebuffer.security.service;

import com.dailycodebuffer.security.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    private String secretKey=null;

    public String generateToken(User user) {
        Map<String,Object> claims=new HashMap<>();
        return Jwts
                .builder()
                .claims()
                .add(claims)
                .subject(user.getUserName())
                .issuer("PRATHAM")
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 60*10*1000))
                .and()
                .signWith(generateKey())
                .compact();
    }

    public SecretKey generateKey(){
        byte[] decode=Decoders.BASE64.decode(getSecretKey());
        return Keys.hmacShaKeyFor(decode);
    }

    public String getSecretKey(){
        return secretKey="c613ff2b7869830aada4b23241289d5d0705a9d57e9509ea7a54bfa131123651415e4487b502946a11e40b3e385f3fbff42fd2a5d6971195e245604d8fb16390525ae2ae461261117dfca43c5a43ae27afefe1272dc5a427b659d656de1d1fa4f22ea74fadb394c8052948d39172b088b382cc1722640d20ca01b5e3d024e6a916997e1daa7e100f7055767763626c0104672fd0477e219299ee30b0e9d9ccfb7066b42386db0df869f0726e6e2a9eec85975203d2cfa6eda18d2d2ab1ebdc6f5a9b2908c02dcaf831757ed876def3da8f5fec04845210fe6c2af815499ba009e04aaabaac163a8bac3079ae3843d2ed0565ffdd38149b2b80017ef25d0055a8";
    }

    public String extractUserName(String token) {
        return extractClaims(token,Claims::getSubject);
    }

    private <T> T extractClaims(String token, Function<Claims,T> claimResolver) {
        Claims claims=extractClaims(token);
        return claimResolver.apply(claims);
    }

    private Claims extractClaims(String token){
        return Jwts
                .parser()
                .verifyWith(generateKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String userName=extractUserName(token);
        return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaims(token,Claims::getExpiration);
    }

}
