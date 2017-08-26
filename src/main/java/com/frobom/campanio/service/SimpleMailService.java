package com.frobom.campanio.service;

public interface SimpleMailService {

    void send(String recipient, String subject, String content);
}
