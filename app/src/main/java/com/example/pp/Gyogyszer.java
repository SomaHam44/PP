package com.example.pp;

import java.util.Date;

public class Gyogyszer {
    private int id;
    private String nev;
    private String hatoanyag;
    private String link;
    //private boolean rendszeres;
    private int napi;
    private int keszlet;
    //private String mod;

    public Gyogyszer(int id, String nev, String hatoanyag, String link, int napi, int keszlet) {
        this.id = id;
        this.nev = nev;
        this.hatoanyag = hatoanyag;
        this.link = link;
        this.napi = napi;
        this.keszlet = keszlet;
        //this.mod = mod;
    }

    public Gyogyszer() {
    }

    public int getId() {
        return id;
    }

    public String getStringId(){
        return String.valueOf(id);
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

    public String getHatoanyag() {
        return hatoanyag;
    }

    public void setHatoanyag(String hatoanyag) {
        this.hatoanyag = hatoanyag;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getNapi() {
        return napi;
    }
    public String getStringNapi(){
        return String.valueOf(napi);
    }

    public void setNapi(int napi) {
        this.napi = napi;
    }

    public int getKeszlet() {
        return keszlet;
    }
    public String getStringKeszlet(){
        return String.valueOf(keszlet);
    }

    public void setKeszlet(int keszlet) {
        this.keszlet = keszlet;
    }

    /*public String getMod() {
        return mod;
    }

    public void setMod(String mod) {
        this.mod = mod;
    }*/
}
