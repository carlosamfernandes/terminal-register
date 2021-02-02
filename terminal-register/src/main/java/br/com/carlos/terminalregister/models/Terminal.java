package br.com.carlos.terminalregister.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Terminal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer logic;
    private String model; // tem no item 2b, mas nao no 2c
    private String serial;
    private Integer sam;
    private String ptid;
    private Integer plat;
    private String version;
    private Integer mxr;
    private Integer mxf; // tem no item 2b, mas nao no 2c
    private String verfm;



}

