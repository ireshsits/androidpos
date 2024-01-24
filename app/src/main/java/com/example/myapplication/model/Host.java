package com.example.myapplication.model;

public class Host {
    private int id;
    private String ip;
    private int port;
    private int nii;
    private int secureNII;

    public int getHostId() {
        return id;
    }

    public void setHostId(int id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getNii() {
        return nii;
    }

    public void setNii(int nii) {
        this.nii = nii;
    }

    public int getSecureNII() {
        return secureNII;
    }

    public void setSecureNII(int secureNII) {
        this.secureNII = secureNII;
    }

    public int getTpdu() {
        return tpdu;
    }

    public void setTpdu(int tpdu) {
        this.tpdu = tpdu;
    }

    public int getTieEnabled() {
        return tieEnabled;
    }

    public void setTieEnabled(int tieEnabled) {
        this.tieEnabled = tieEnabled;
    }

    public Host(int id, String ip, int port, int nii, int secureNII, int tpdu, int tieEnabled) {
        this.id = id;
        this.ip = ip;
        this.port = port;
        this.nii = nii;
        this.secureNII = secureNII;
        this.tpdu = tpdu;
        this.tieEnabled = tieEnabled;
    }

    private int tpdu;
    private int tieEnabled;
}
