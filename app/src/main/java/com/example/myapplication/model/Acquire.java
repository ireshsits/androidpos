package com.example.myapplication.model;

public class Acquire {
    private int id;
    private String acqName;
    private int hostID;
    private long terminalID;
    private long merchantID;
    private String currency;
    private int currencyCode;
    private int countryCode;
    private String rctHdr1;
    private String rctHdr2;
    private String rctHdr3;
    private int invoiceNumber;
    private int stan;
    private String merchantName;
    private int batchNumber;


    public String getAcqName() {
        return acqName;
    }

    public void setAcqName(String acqName) {
        this.acqName = acqName;
    }

    public int getHostID() {
        return hostID;
    }

    public void setHostID(int hostID) {
        this.hostID = hostID;
    }

    public long getTerminalID() {
        return terminalID;
    }

    public void setTerminalID(long terminalID) {
        this.terminalID = terminalID;
    }

    public long getMerchantID() {
        return merchantID;
    }

    public void setMerchantID(long merchantID) {
        this.merchantID = merchantID;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(int currencyCode) {
        this.currencyCode = currencyCode;
    }

    public int getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(int countryCode) {
        this.countryCode = countryCode;
    }

    public String getRctHdr1() {
        return rctHdr1;
    }

    public void setRctHdr1(String rctHdr1) {
        this.rctHdr1 = rctHdr1;
    }

    public String getRctHdr2() {
        return rctHdr2;
    }

    public void setRctHdr2(String rctHdr2) {
        this.rctHdr2 = rctHdr2;
    }

    public String getRctHdr3() {
        return rctHdr3;
    }

    public void setRctHdr3(String rctHdr3) {
        this.rctHdr3 = rctHdr3;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public int getStan() {
        return stan;
    }

    public void setStan(int stan) {
        this.stan = stan;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public int getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(int batchNumber) {
        this.batchNumber = batchNumber;
    }

    public Acquire(int id, String acqName, int hostID, long terminalID, long merchantID, String currency, int currencyCode, int countryCode, String rctHdr1, String rctHdr2, String rctHdr3, int invoiceNumber, int stan, String merchantName, int batchNumber) {
        this.id = id;
        this.acqName = acqName;
        this.hostID = hostID;
        this.terminalID = terminalID;
        this.merchantID = merchantID;
        this.currency = currency;
        this.currencyCode = currencyCode;
        this.countryCode = countryCode;
        this.rctHdr1 = rctHdr1;
        this.rctHdr2 = rctHdr2;
        this.rctHdr3 = rctHdr3;
        this.invoiceNumber = invoiceNumber;
        this.stan = stan;
        this.merchantName = merchantName;
        this.batchNumber = batchNumber;
    }

    public int getAcquireId() {
        return id;
    }

    public void setAcquireId(int id) {
        this.id = id;
    }
}
