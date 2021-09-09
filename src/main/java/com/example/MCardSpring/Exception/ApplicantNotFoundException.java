package com.example.MCardSpring.Exception;

 public class ApplicantNotFoundException extends RuntimeException {
     public ApplicantNotFoundException(Long id) {
        super(id + "' sine sahip kullanıcı bulunamamıştır!");
    }
}
