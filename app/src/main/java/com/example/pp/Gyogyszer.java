package com.example.pp;

import java.util.Date;

public class Gyogyszer {
    private int id;
    private String nev;
    private Date lejarat;
    private int napi;
    private int keszlet;
    private Date mod;

    public Gyogyszer(int id, String nev, Date lejarat, int napi, int keszlet, Date mod) {
        this.id = id;
        this.nev = nev;
        this.lejarat = lejarat;
        this.napi = napi;
        this.keszlet = keszlet;
        this.mod = mod;
    }

    public Gyogyszer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public Date getLejarat() {
        return lejarat;
    }

    public void setLejarat(Date lejarat) {
        this.lejarat = lejarat;
    }

    public int getNapi() {
        return napi;
    }

    public void setNapi(int napi) {
        this.napi = napi;
    }

    public int getKeszlet() {
        return keszlet;
    }

    public void setKeszlet(int keszlet) {
        this.keszlet = keszlet;
    }

    public Date getMod() {
        return mod;
    }

    public void setMod(Date mod) {
        this.mod = mod;
    }
}
