package de.han.ekl;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.security.KeyPair;

public class Main {
    public static void main(String[] args) {
        SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        System.out.println(String.format("Signature algorithm %s, secret key[%s]",SignatureAlgorithm.HS256.name(), Encoders.BASE64.encode(key.getEncoded())));

        KeyPair keyPair = Keys.keyPairFor(SignatureAlgorithm.RS256);
        System.out.println(String.format("Signature algorithm %s, private key \n %s",SignatureAlgorithm.RS256.name(),Encoders.BASE64.encode(keyPair.getPrivate().getEncoded())));
        System.out.println(String.format("Signature algorithm %s, public key \n %s", SignatureAlgorithm.RS256.name(), keyPair.getPublic().toString()));

        keyPair = Keys.keyPairFor(SignatureAlgorithm.ES256);
        System.out.println(String.format("Signature algorithm %s private key \n %s", SignatureAlgorithm.ES256.name(), Encoders.BASE64.encode(keyPair.getPrivate().getEncoded())));
        System.out.println(String.format("Signature algorithm %s public key \n %s", SignatureAlgorithm.ES256.name(), keyPair.getPublic().toString()));
    }
}
