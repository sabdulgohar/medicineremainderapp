package com.sagnf.medicinereminder;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.util.Base64;

public class KeyGenerator {

    public static void main(String[] args) {

        var key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        String base64Key = Base64.getEncoder().encodeToString(key.getEncoded());

        System.out.println("Generated Base64 Key:");
        System.out.println(base64Key);
    }
}