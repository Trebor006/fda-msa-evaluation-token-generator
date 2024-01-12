package com.pichincha.evaluation.fdamsaevaluationtokengenerator.helper;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.jwk.OctetSequenceKey;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import com.pichincha.evaluation.fdamsaevaluationtokengenerator.configuration.TokenConfiguration;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Date;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TokenGenerator {

  private final TokenConfiguration tokenConfiguration;

  public String generateJWT(String user) throws JOSEException {
    OctetSequenceKey secretKey =
        new OctetSequenceKey.Builder(
                tokenConfiguration.getSecretKey().getBytes(StandardCharsets.UTF_8))
            .build();

    JWSSigner signer = new MACSigner(secretKey);

    JWTClaimsSet claimsSet =
        new JWTClaimsSet.Builder()
            .subject(user)
            .issueTime(Date.from(Instant.now()))
            .expirationTime(
                Date.from(Instant.now().plusMillis(tokenConfiguration.getExpirationMilis())))
            .build();

    SignedJWT signedJWT = new SignedJWT(new JWSHeader(JWSAlgorithm.HS256), claimsSet);
    signedJWT.sign(signer);

    return signedJWT.serialize();
  }
}
