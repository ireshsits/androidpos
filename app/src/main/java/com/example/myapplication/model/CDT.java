package com.example.myapplication.model;

public class CDT {
    public int getCDTId() {
        return id;
    }

    public void setCDTId(int id) {
        this.id = id;
    }

    public int getIssuerID() {
        return issuerID;
    }

    public void setIssuerID(int issuerID) {
        this.issuerID = issuerID;
    }

    public long getPanLow() {
        return panLow;
    }

    public void setPanLow(long panLow) {
        this.panLow = panLow;
    }

    public long getPanHigh() {
        return panHigh;
    }

    public void setPanHigh(long panHigh) {
        this.panHigh = panHigh;
    }

    public String getCardAbbrev() {
        return cardAbbrev;
    }

    public void setCardAbbrev(String cardAbbrev) {
        this.cardAbbrev = cardAbbrev;
    }

    public String getCardLabel() {
        return cardLabel;
    }

    public void setCardLabel(String cardLabel) {
        this.cardLabel = cardLabel;
    }

    public int getTrack1Required() {
        return track1Required;
    }

    public void setTrack1Required(int track1Required) {
        this.track1Required = track1Required;
    }

    public int getTrack2Required() {
        return track2Required;
    }

    public void setTrack2Required(int track2Required) {
        this.track2Required = track2Required;
    }

    public int getCheckLuhn() {
        return checkLuhn;
    }

    public void setCheckLuhn(int checkLuhn) {
        this.checkLuhn = checkLuhn;
    }

    public int getExpDateRequired() {
        return expDateRequired;
    }

    public void setExpDateRequired(int expDateRequired) {
        this.expDateRequired = expDateRequired;
    }

    public int getManualEntry() {
        return manualEntry;
    }

    public void setManualEntry(int manualEntry) {
        this.manualEntry = manualEntry;
    }

    public int getChkSvcCode() {
        return chkSvcCode;
    }

    public void setChkSvcCode(int chkSvcCode) {
        this.chkSvcCode = chkSvcCode;
    }

    private int id;
    private int issuerID;
    private long panLow;
    private long panHigh;
    private String cardAbbrev;
    private String cardLabel;
    private int track1Required;
    private int track2Required;
    private int checkLuhn;
    private int expDateRequired;
    private int manualEntry;
    private int chkSvcCode;

    public CDT(int id, int issuerID, long panLow, long panHigh, String cardAbbrev, String cardLabel, int track1Required, int track2Required, int checkLuhn, int expDateRequired, int manualEntry, int chkSvcCode) {
        this.id = id;
        this.issuerID = issuerID;
        this.panLow = panLow;
        this.panHigh = panHigh;
        this.cardAbbrev = cardAbbrev;
        this.cardLabel = cardLabel;
        this.track1Required = track1Required;
        this.track2Required = track2Required;
        this.checkLuhn = checkLuhn;
        this.expDateRequired = expDateRequired;
        this.manualEntry = manualEntry;
        this.chkSvcCode = chkSvcCode;
    }
}
