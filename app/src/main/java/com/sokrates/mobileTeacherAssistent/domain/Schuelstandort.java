package com.sokrates.mobileTeacherAssistent.domain;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Schuelstandort implements Parcelable{

    private Long su_KENNZAHL;
    private String so_STRASSENNR;
    private String so_STRASSE;
    private String so_NAME;
    private Long so_KENNZAHL;
    private String so_LANDKZ;
    private String so_ORT;
    private Integer so_PLZ;
    private String so_HAUSNR;
    private String so_UPDATEDAT;
    private String so_BLZ;
    private String so_IBAN;
    private String so_UID;
    private String so_BIC;
    private String so_BANK;
    private String so_KONTONR;

    public Schuelstandort(Parcel in) {
    }

    public Long getSu_KENNZAHL() {
        return su_KENNZAHL;
    }

    public void setSu_KENNZAHL(Long su_KENNZAHL) {
        this.su_KENNZAHL = su_KENNZAHL;
    }

    public String getSo_STRASSENNR() {
        return so_STRASSENNR;
    }

    public void setSo_STRASSENNR(String so_STRASSENNR) {
        this.so_STRASSENNR = so_STRASSENNR;
    }

    public String getSo_STRASSE() {
        return so_STRASSE;
    }

    public void setSo_STRASSE(String so_STRASSE) {
        this.so_STRASSE = so_STRASSE;
    }

    public String getSo_NAME() {
        return so_NAME;
    }

    public void setSo_NAME(String so_NAME) {
        this.so_NAME = so_NAME;
    }

    public Long getSo_KENNZAHL() {
        return so_KENNZAHL;
    }

    public void setSo_KENNZAHL(Long so_KENNZAHL) {
        this.so_KENNZAHL = so_KENNZAHL;
    }

    public String getSo_LANDKZ() {
        return so_LANDKZ;
    }

    public void setSo_LANDKZ(String so_LANDKZ) {
        this.so_LANDKZ = so_LANDKZ;
    }

    public String getSo_ORT() {
        return so_ORT;
    }

    public void setSo_ORT(String so_ORT) {
        this.so_ORT = so_ORT;
    }

    public Integer getSo_PLZ() {
        return so_PLZ;
    }

    public void setSo_PLZ(Integer so_PLZ) {
        this.so_PLZ = so_PLZ;
    }

    public String getSo_HAUSNR() {
        return so_HAUSNR;
    }

    public void setSo_HAUSNR(String so_HAUSNR) {
        this.so_HAUSNR = so_HAUSNR;
    }

    public String getSo_UPDATEDAT() {
        return so_UPDATEDAT;
    }

    public void setSo_UPDATEDAT(String so_UPDATEDAT) {
        this.so_UPDATEDAT = so_UPDATEDAT;
    }

    public String getSo_BLZ() {
        return so_BLZ;
    }

    public void setSo_BLZ(String so_BLZ) {
        this.so_BLZ = so_BLZ;
    }

    public String getSo_IBAN() {
        return so_IBAN;
    }

    public void setSo_IBAN(String so_IBAN) {
        this.so_IBAN = so_IBAN;
    }

    public String getSo_UID() {
        return so_UID;
    }

    public void setSo_UID(String so_UID) {
        this.so_UID = so_UID;
    }

    public String getSo_BIC() {
        return so_BIC;
    }

    public void setSo_BIC(String so_BIC) {
        this.so_BIC = so_BIC;
    }

    public String getSo_BANK() {
        return so_BANK;
    }

    public void setSo_BANK(String so_BANK) {
        this.so_BANK = so_BANK;
    }

    public String getSo_KONTONR() {
        return so_KONTONR;
    }

    public void setSo_KONTONR(String so_KONTONR) {
        this.so_KONTONR = so_KONTONR;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Schuelstandort that = (Schuelstandort) o;

        if (su_KENNZAHL != null ? !su_KENNZAHL.equals(that.su_KENNZAHL) : that.su_KENNZAHL != null)
            return false;
        if (so_STRASSENNR != null ? !so_STRASSENNR.equals(that.so_STRASSENNR) : that.so_STRASSENNR != null)
            return false;
        if (so_STRASSE != null ? !so_STRASSE.equals(that.so_STRASSE) : that.so_STRASSE != null)
            return false;
        if (so_NAME != null ? !so_NAME.equals(that.so_NAME) : that.so_NAME != null) return false;
        if (so_KENNZAHL != null ? !so_KENNZAHL.equals(that.so_KENNZAHL) : that.so_KENNZAHL != null)
            return false;
        if (so_LANDKZ != null ? !so_LANDKZ.equals(that.so_LANDKZ) : that.so_LANDKZ != null)
            return false;
        if (so_ORT != null ? !so_ORT.equals(that.so_ORT) : that.so_ORT != null) return false;
        if (so_PLZ != null ? !so_PLZ.equals(that.so_PLZ) : that.so_PLZ != null) return false;
        if (so_HAUSNR != null ? !so_HAUSNR.equals(that.so_HAUSNR) : that.so_HAUSNR != null)
            return false;
        if (so_UPDATEDAT != null ? !so_UPDATEDAT.equals(that.so_UPDATEDAT) : that.so_UPDATEDAT != null)
            return false;
        if (so_BLZ != null ? !so_BLZ.equals(that.so_BLZ) : that.so_BLZ != null) return false;
        if (so_IBAN != null ? !so_IBAN.equals(that.so_IBAN) : that.so_IBAN != null) return false;
        if (so_UID != null ? !so_UID.equals(that.so_UID) : that.so_UID != null) return false;
        if (so_BIC != null ? !so_BIC.equals(that.so_BIC) : that.so_BIC != null) return false;
        if (so_BANK != null ? !so_BANK.equals(that.so_BANK) : that.so_BANK != null) return false;
        return !(so_KONTONR != null ? !so_KONTONR.equals(that.so_KONTONR) : that.so_KONTONR != null);

    }

    @Override
    public int hashCode() {
        int result = su_KENNZAHL != null ? su_KENNZAHL.hashCode() : 0;
        result = 31 * result + (so_STRASSENNR != null ? so_STRASSENNR.hashCode() : 0);
        result = 31 * result + (so_STRASSE != null ? so_STRASSE.hashCode() : 0);
        result = 31 * result + (so_NAME != null ? so_NAME.hashCode() : 0);
        result = 31 * result + (so_KENNZAHL != null ? so_KENNZAHL.hashCode() : 0);
        result = 31 * result + (so_LANDKZ != null ? so_LANDKZ.hashCode() : 0);
        result = 31 * result + (so_ORT != null ? so_ORT.hashCode() : 0);
        result = 31 * result + (so_PLZ != null ? so_PLZ.hashCode() : 0);
        result = 31 * result + (so_HAUSNR != null ? so_HAUSNR.hashCode() : 0);
        result = 31 * result + (so_UPDATEDAT != null ? so_UPDATEDAT.hashCode() : 0);
        result = 31 * result + (so_BLZ != null ? so_BLZ.hashCode() : 0);
        result = 31 * result + (so_IBAN != null ? so_IBAN.hashCode() : 0);
        result = 31 * result + (so_UID != null ? so_UID.hashCode() : 0);
        result = 31 * result + (so_BIC != null ? so_BIC.hashCode() : 0);
        result = 31 * result + (so_BANK != null ? so_BANK.hashCode() : 0);
        result = 31 * result + (so_KONTONR != null ? so_KONTONR.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Schuelstandort{" +
                "su_KENNZAHL=" + su_KENNZAHL +
                ", so_STRASSENNR='" + so_STRASSENNR + '\'' +
                ", so_STRASSE='" + so_STRASSE + '\'' +
                ", so_NAME='" + so_NAME + '\'' +
                ", so_KENNZAHL=" + so_KENNZAHL +
                ", so_LANDKZ='" + so_LANDKZ + '\'' +
                ", so_ORT='" + so_ORT + '\'' +
                ", so_PLZ=" + so_PLZ +
                ", so_HAUSNR='" + so_HAUSNR + '\'' +
                ", so_UPDATEDAT='" + so_UPDATEDAT + '\'' +
                ", so_BLZ='" + so_BLZ + '\'' +
                ", so_IBAN='" + so_IBAN + '\'' +
                ", so_UID='" + so_UID + '\'' +
                ", so_BIC='" + so_BIC + '\'' +
                ", so_BANK='" + so_BANK + '\'' +
                ", so_KONTONR='" + so_KONTONR + '\'' +
                '}';
    }

    public static final Creator<Schuelstandort> CREATOR
            = new Creator<Schuelstandort>() {
        public Schuelstandort createFromParcel(Parcel in) {
            return new Schuelstandort(in);
        }

        public Schuelstandort[] newArray(int size) {
            return new Schuelstandort[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
