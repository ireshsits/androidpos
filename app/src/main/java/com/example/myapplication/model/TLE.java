package com.example.myapplication.model;

public class TLE {

    private int id;
    private int issuerID;
    private String aid;
    private String vsn;
    private String eAlgo;
    private String ukid;
    private String mAlgo;
    private String dmtr;
    private String kSize;
    private String scsLength;

    public int getTLEId() {
        return id;
    }

    public void setTLEId(int id) {
        this.id = id;
    }

    public int getIssuerID() {
        return issuerID;
    }

    public void setIssuerID(int issuerID) {
        this.issuerID = issuerID;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getVsn() {
        return vsn;
    }

    public void setVsn(String vsn) {
        this.vsn = vsn;
    }

    public String geteAlgo() {
        return eAlgo;
    }

    public void seteAlgo(String eAlgo) {
        this.eAlgo = eAlgo;
    }

    public String getUkid() {
        return ukid;
    }

    public void setUkid(String ukid) {
        this.ukid = ukid;
    }

    public String getmAlgo() {
        return mAlgo;
    }

    public void setmAlgo(String mAlgo) {
        this.mAlgo = mAlgo;
    }

    public String getDmtr() {
        return dmtr;
    }

    public void setDmtr(String dmtr) {
        this.dmtr = dmtr;
    }

    public String getkSize() {
        return kSize;
    }

    public void setkSize(String kSize) {
        this.kSize = kSize;
    }

    public String getScsLength() {
        return scsLength;
    }

    public void setScsLength(String scsLength) {
        this.scsLength = scsLength;
    }

    public TLE(int id, int issuerID, String aid, String vsn, String eAlgo, String ukid, String mAlgo, String dmtr, String kSize, String scsLength) {
        this.id = id;
        this.issuerID = issuerID;
        this.aid = aid;
        this.vsn = vsn;
        this.eAlgo = eAlgo;
        this.ukid = ukid;
        this.mAlgo = mAlgo;
        this.dmtr = dmtr;
        this.kSize = kSize;
        this.scsLength = scsLength;
    }
}
