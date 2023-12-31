package com.dto;


import lombok.Data;

@Data
public class AgenDto {

    private String id;

    private String nama;
    private String alamat;
    private String email;

    private String tglPendaftaran;
    private int status;
    
}
