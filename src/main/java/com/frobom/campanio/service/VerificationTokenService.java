package com.frobom.campanio.service;

public interface VerificationTokenService {

    boolean isValidToken(String token);
}
