package com.sokrates.mobileTeacherAssistent.domain;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Schuele implements Parcelable{

    private Long su_KENNZAHL;
    private String su_NAMEKURZ;
    private List<Schuelstandort> schulstandort;

    public Schuele(Parcel in) {
    }

    public Long getSu_KENNZAHL() {
        return su_KENNZAHL;
    }

    public void setSu_KENNZAHL(Long su_KENNZAHL) {
        this.su_KENNZAHL = su_KENNZAHL;
    }

    public String getSu_NAMEKURZ() {
        return su_NAMEKURZ;
    }

    public void setSu_NAMEKURZ(String su_NAMEKURZ) {
        this.su_NAMEKURZ = su_NAMEKURZ;
    }

    public List<Schuelstandort> getSchulstandort() {
        return schulstandort;
    }

    public void setSchulstandort(List<Schuelstandort> schulstandort) {
        this.schulstandort = schulstandort;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Schuele)) return false;

        Schuele schuele = (Schuele) o;

        if (!getSu_KENNZAHL().equals(schuele.getSu_KENNZAHL())) return false;
        if (!getSu_NAMEKURZ().equals(schuele.getSu_NAMEKURZ())) return false;
        return getSchulstandort().equals(schuele.getSchulstandort());

    }

    @Override
    public int hashCode() {
        int result = getSu_KENNZAHL().hashCode();
        result = 31 * result + getSu_NAMEKURZ().hashCode();
        result = 31 * result + getSchulstandort().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Schuele{" +
                "su_KENNZAHL=" + su_KENNZAHL +
                ", su_NAMEKURZ='" + su_NAMEKURZ + '\'' +
                ", schulstandort=" + schulstandort +
                '}';
    }


    public static final Creator<Schuele> CREATOR
            = new Creator<Schuele>() {
        public Schuele createFromParcel(Parcel in) {
            return new Schuele(in);
        }

        public Schuele[] newArray(int size) {
            return new Schuele[size];
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
