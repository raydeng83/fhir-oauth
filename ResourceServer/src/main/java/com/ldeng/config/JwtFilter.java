package com.ldeng.config;

import com.ldeng.KeycloakUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;
import org.apache.commons.codec.binary.Base64;
import org.springframework.web.filter.GenericFilterBean;
import twitter4j.JSONException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

/**
 * Created by lede on 4/26/16.
 */
public class JwtFilter extends GenericFilterBean {


    @Override
    public void doFilter(final ServletRequest req,
                         final ServletResponse res,
                         final FilterChain chain) throws IOException, ServletException {

        final HttpServletRequest request = (HttpServletRequest) req;
        final HttpServletResponse response = (HttpServletResponse) res;
        final String authHeader = request.getHeader("Authorization");

        final String publicKeyString;
        PublicKey publicKey = null;

        try {
            publicKeyString = KeycloakUtil.getRealm().get("publicKey").textValue();
            System.out.println("Public Key is: "+publicKeyString);
            publicKey = getKey(publicKeyString);

        } catch (JSONException e) {
            e.printStackTrace();
        }


        if ("OPTIONS".equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);

            chain.doFilter(req, res);
        } else {

            if (authHeader == null || !authHeader.startsWith("bearer ")) {
                throw new ServletException("Missing or invalid Authorization header");
            }

            final String token = authHeader.substring(7);

            try {
                final Claims claims = Jwts.parser().setSigningKey(publicKey).parseClaimsJws(token).getBody();
                request.setAttribute("claims", claims);
            } catch (final SignatureException e) {
                throw new ServletException("Invalid token.");
            }

            chain.doFilter(req, res);
        }

    }

    public PublicKey getKey(String key){
        try{
            byte[] byteKey = Base64.decodeBase64(key.getBytes());
            X509EncodedKeySpec X509publicKey = new X509EncodedKeySpec(byteKey);
            KeyFactory kf = KeyFactory.getInstance("RSA");

            return kf.generatePublic(X509publicKey);
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }

}
