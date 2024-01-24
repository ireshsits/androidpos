package com.example.myapplication.model;

public class TerminalInfo {
    private int isActive;
    private int fallbackEnable;
    private String maskReceipt;
    private int cupNII;
    private int cupSecureNII;
    private String merchantPassword;
    private String adminPassword;
    private String sAdminPassword;
    private int multiMerchant;
    private int ecr;
    private int autoReversal;
    private int preAuthEnable;

    public TerminalInfo(int isActive, int fallbackEnable, String maskReceipt, int cupNII, int cupSecureNII, String merchantPassword, String adminPassword, String sAdminPassword, int multiMerchant, int ecr, int autoReversal, int preAuthEnable, int isoClear, int isoTle, int speechEnable, int manualKeyin) {
        this.isActive = isActive;
        this.fallbackEnable = fallbackEnable;
        this.maskReceipt = maskReceipt;
        this.cupNII = cupNII;
        this.cupSecureNII = cupSecureNII;
        this.merchantPassword = merchantPassword;
        this.adminPassword = adminPassword;
        this.sAdminPassword = sAdminPassword;
        this.multiMerchant = multiMerchant;
        this.ecr = ecr;
        this.autoReversal = autoReversal;
        this.preAuthEnable = preAuthEnable;
        this.isoClear = isoClear;
        this.isoTle = isoTle;
        this.speechEnable = speechEnable;
        this.manualKeyin = manualKeyin;
    }

    private int isoClear;
    private int isoTle;
    private int speechEnable;
    private int manualKeyin;


    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public int getFallbackEnable() {
        return fallbackEnable;
    }

    public void setFallbackEnable(int fallbackEnable) {
        this.fallbackEnable = fallbackEnable;
    }

    public String getMaskReceipt() {
        return maskReceipt;
    }

    public void setMaskReceipt(String maskReceipt) {
        this.maskReceipt = maskReceipt;
    }

    public int getCupNII() {
        return cupNII;
    }

    public void setCupNII(int cupNII) {
        this.cupNII = cupNII;
    }

    public int getCupSecureNII() {
        return cupSecureNII;
    }

    public void setCupSecureNII(int cupSecureNII) {
        this.cupSecureNII = cupSecureNII;
    }

    public String getMerchantPassword() {
        return merchantPassword;
    }

    public void setMerchantPassword(String merchantPassword) {
        this.merchantPassword = merchantPassword;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getsAdminPassword() {
        return sAdminPassword;
    }

    public void setsAdminPassword(String sAdminPassword) {
        this.sAdminPassword = sAdminPassword;
    }

    public int getMultiMerchant() {
        return multiMerchant;
    }

    public void setMultiMerchant(int multiMerchant) {
        this.multiMerchant = multiMerchant;
    }

    public int getEcr() {
        return ecr;
    }

    public void setEcr(int ecr) {
        this.ecr = ecr;
    }

    public int getAutoReversal() {
        return autoReversal;
    }

    public void setAutoReversal(int autoReversal) {
        this.autoReversal = autoReversal;
    }

    public int getPreAuthEnable() {
        return preAuthEnable;
    }

    public void setPreAuthEnable(int preAuthEnable) {
        this.preAuthEnable = preAuthEnable;
    }

    public int getIsoClear() {
        return isoClear;
    }

    public void setIsoClear(int isoClear) {
        this.isoClear = isoClear;
    }

    public int getIsoTle() {
        return isoTle;
    }

    public void setIsoTle(int isoTle) {
        this.isoTle = isoTle;
    }

    public int getSpeechEnable() {
        return speechEnable;
    }

    public void setSpeechEnable(int speechEnable) {
        this.speechEnable = speechEnable;
    }

    public int getManualKeyin() {
        return manualKeyin;
    }

    public void setManualKeyin(int manualKeyin) {
        this.manualKeyin = manualKeyin;
    }


}
