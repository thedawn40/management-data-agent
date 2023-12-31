package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "product")
@Data
public class Product {

    @Id
    private int id;

    @Column(name = "nama_produk")
    private String namaProduk;
    @Column(name = "jenis_produk")
    private String jenisProduk;
    private String deskripsi;
    private Long premi;

    @Column(name = "periode_pembayaran")
    private String periodPembayaran;

    @Column(name = "manfaat_utama")
    private String manfaatUtama;

    @Column(name = "batasan_manfaat")
    private String batasanManfaat;

    @Column(name = "tanggal_peluncuran")
    private String tanggalPeluncuran;

    
}
