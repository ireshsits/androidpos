package com.example.myapplication.model;

public class IssuerAcquire {
    private byte[] id; // Assuming ID is a binary large object (BLOB)
    private int acquireID;
    private int issuerID;

    // Constructor
    public IssuerAcquire(byte[] id, int acquireID, int issuerID) {
        this.id = id;
        this.acquireID = acquireID;
        this.issuerID = issuerID;
    }

    // Getters and setters
    public byte[] getIssuerAcquireId() {

        return id;
    }
    public void setIssuerAcquireId(byte[] id)
    {
        this.id = id;
    }
    public int getAcquireID()
    {
        return acquireID;
    }
    public void setAcquireID(int acquireID) {

        this.acquireID = acquireID;
    }
    public int getIssuerID() {

        return issuerID;
    }
    public void setIssuerID(int issuerID) {

        this.issuerID = issuerID;
    }
}
