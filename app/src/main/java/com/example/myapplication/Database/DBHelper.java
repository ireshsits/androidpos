package com.example.myapplication.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {


    private static final int VERSION = 1;
    private static final String DB_NAME = "DBPOS.dp";


    // Table creation SQL statements
    private static final String CREATE_TABLE_TERMINAL_INFO = "CREATE TABLE Terminal_Info (" + "    IsActive INTEGER," + "    FallbackEnable INTEGER," + "    MaskReceipt TEXT," + "    CupNII INTEGER," + "    CupSecureNII INTEGER," + "    MerchantPassword TEXT," + "    AdminPassword TEXT," + "    SAdminPassword TEXT," + "    MultiMerchant INTEGER," + "    ECR INTEGER," + "    AutoReversal INTEGER," + "    PreAuthEnable INTEGER," + "    ISO_Clear INTEGER," + "    ISO_TLE INTEGER," + "    SpeechEnable INTEGER," + "    ManualKeyin INTEGER" + ");";
    private static final String CREATE_TABLE_ISSUER = "CREATE TABLE Issuer (" + "    ID INTEGER PRIMARY KEY," + "    IssuerName TEXT," + "    IssuerLable TEXT," + "    IssuerAbbrev TEXT," + "    T_DF11 TEXT," + "    T_DF12 TEXT," + "    T_DF13 TEXT," + "    T_DF14 TEXT," + "    T_DF15 TEXT," + "    T_DF16 TEXT," + "    T_DF17 TEXT," + "    T_DF18 TEXT," + "    T_DF19 TEXT," + "    T_DF20 TEXT," + "    T_DF21 TEXT," + "    T_9F06 TEXT," + "    T_9F08 TEXT," + "    T_9F09 TEXT," + "    T_9F1A TEXT," + "    T_9F1B TEXT," + "    T_9F33 TEXT," + "    T_9F35 TEXT," + "    T_9F40 TEXT," + "    T_9F66 TEXT," + "    T_9F7B TEXT" + ");";
    private static final String CREATE_TABLE_ACQUIRE = "CREATE TABLE Acquire (" + "    ID INTEGER PRIMARY KEY," + "    AcqName TEXT," + "    HostID INTEGER," + "    TerminalID NUMERIC," + "    MerchantID NUMERIC," + "    Currency TEXT," + "    CurrencyCode INTEGER," + "    CountryCode INTEGER," + "    RctHdr1 TEXT," + "    RctHdr2 TEXT," + "    RctHdr3 TEXT," + "    InvoiceNumber INTEGER," + "    STAN INTEGER," + "    MerchantName TEXT," + "    BatchNumber INTEGER" + ");";
    private static final String CREATE_TABLE_ISSUER_ACQUIRE = "CREATE TABLE Issuer_Acquire (" + "    ID BLOB PRIMARY KEY," + "    AcquireID INTEGER," + "    IssuerID INTEGER," + "    FOREIGN KEY(AcquireID) REFERENCES Acquire(ID)," + "    FOREIGN KEY(IssuerID) REFERENCES Issuer(ID)" + ");";

    private static final String CREATE_TABLE_CDT = "CREATE TABLE CDT (" + "    ID INTEGER PRIMARY KEY," + "    IssuerID INTEGER," + "    PANLOW INTEGER," + "    PANHigh INTEGER," + "    CardAbbrev TEXT," + "    CardLable TEXT," + "    Track1Required INTEGER," + "    Track2Required INTEGER," + "    CheckLuhn INTEGER," + "    ExpDateRequired INTEGER," + "    ManualEntry INTEGER," + "    ChkSvcCode INTEGER," + "    FOREIGN KEY(IssuerID) REFERENCES Issuer(ID)" + ");";
    private static final String CREATE_TABLE_HOST = "CREATE TABLE Host (" + "    ID INTEGER PRIMARY KEY," + "    IP TEXT," + "    PORT INTEGER," + "    NII INTEGER," + "    SecureNII INTEGER," + "    TPDU INTEGER," + "    TieEnabled INTEGER" + ");";
    private static final String CREATE_TABLE_TLE = "CREATE TABLE TLE (" + "    ID INTEGER PRIMARY KEY," + "    IssuerID INTEGER," + "    AID TEXT," + "    VSN TEXT," + "    EAlgo TEXT," + "    UKID TEXT," + "    MAlgo TEXT," + "    DMTR TEXT," + "    KSize TEXT," + "    SCSLength TEXT," + "    FOREIGN KEY(IssuerID) REFERENCES Issuer(ID)" + ");";
    private static final String CREATE_TABLE_TFI = "CREATE TABLE TFI (" + "    ID INTEGER PRIMARY KEY," + "    IssuerID INTEGER," + "    Field2 INTEGER," + "    Field3 INTEGER," + "    Field4 INTEGER," + "    Field11 INTEGER," + "    Field12 INTEGER," + "    Field13 INTEGER," + "    Field14 INTEGER," + "    Field22 INTEGER," + "    Field23 INTEGER," + "    Field24 INTEGER," + "    Field25 INTEGER," + "    Field35 INTEGER," + "    Field37 INTEGER," + "    Field38 INTEGER," + "    Field39 INTEGER," + "    Field41 INTEGER," + "    Field42 INTEGER," + "    Field45 INTEGER," + "    Field48 INTEGER," + "    Field52 INTEGER," + "    Field54 INTEGER," + "    Field55 INTEGER," + "    Field60 INTEGER," + "    Field61 INTEGER," + "    Field62 INTEGER," + "    Field63 INTEGER," + "    FOREIGN KEY(IssuerID) REFERENCES Issuer(ID)" + ");";


    public DBHelper(@Nullable Context context) {

        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_TERMINAL_INFO);
        db.execSQL(CREATE_TABLE_ISSUER);
        db.execSQL(CREATE_TABLE_ACQUIRE);
        db.execSQL(CREATE_TABLE_ISSUER_ACQUIRE);
        db.execSQL(CREATE_TABLE_CDT);
        db.execSQL(CREATE_TABLE_HOST);
        db.execSQL(CREATE_TABLE_TLE);
        db.execSQL(CREATE_TABLE_TFI);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//         Drop older tables if existed
        db.execSQL("DROP TABLE IF EXISTS Terminal_Info");
        db.execSQL("DROP TABLE IF EXISTS Issuer");
        db.execSQL("DROP TABLE IF EXISTS Acquire");
        db.execSQL("DROP TABLE IF EXISTS Issuer_Acquire");
        db.execSQL("DROP TABLE IF EXISTS CDT");
        db.execSQL("DROP TABLE IF EXISTS Host");
        db.execSQL("DROP TABLE IF EXISTS TLE");
        db.execSQL("DROP TABLE IF EXISTS TFI");
        // Create new tables
        onCreate(db);
    }
}
