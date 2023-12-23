package com.model;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "agen")
@Data
public class Agen {

    @Id
    private String id;

    private String nama;
    private String alamat;
    private String email;

    @Column(name = "tgl_pendaftaran")
    private String tglPendaftaran;
    private int status;
    
}
