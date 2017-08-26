package com.frobom.campanio.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frobom.campanio.entity.VerificationToken;
import com.frobom.campanio.repository.VerificationTokenRepository;
import com.frobom.campanio.service.VerificationTokenService;

@Service("verificationTokenService")
public class VerificationTokenServiceImpl implements VerificationTokenService {

    @Autowired
    private VerificationTokenRepository tokenRepository;

    @Override
    public boolean isValidToken(String token) {
        VerificationToken verificationToken = tokenRepository.findByToken(token);
        return verificationToken != null? true : false;
    }
}
