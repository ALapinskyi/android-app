package com.sokrates.mobileTeacherAssistent.domain;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Schueler implements Parcelable{

    private Long sg_kennzahl;
    private String sg_FAMNAME;
    ///private String klasse;
    private String sg_VORNAME1;
    private Date sg_GEBURTDAT;

    public Schueler(Parcel in) {
    }

    public Long getSg_kennzahl() {
        return sg_kennzahl;
    }

    public void setSg_kennzahl(Long sg_kennzahl) {
        this.sg_kennzahl = sg_kennzahl;
    }

    public String getSg_FAMNAME() {
        return sg_FAMNAME;
    }

    public void setSg_FAMNAME(String sg_FAMNAME) {
        this.sg_FAMNAME = sg_FAMNAME;
    }

    /*public String getKlasse() {
        return klasse;
    }

    public void setKlasse(String klasse) {
        this.klasse = klasse;
    }*/

    public String getSg_VORNAME1() {
        return sg_VORNAME1;
    }

    public void setSg_VORNAME1(String sg_VORNAME1) {
        this.sg_VORNAME1 = sg_VORNAME1;
    }

    public Date getSg_GEBURTDAT() {
        return sg_GEBURTDAT;
    }

    public void setSg_GEBURTDAT(Date sg_GEBURTDAT) {
        this.sg_GEBURTDAT = sg_GEBURTDAT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Schueler)) return false;

        Schueler schueler = (Schueler) o;

        if (!getSg_kennzahl().equals(schueler.getSg_kennzahl())) return false;
        if (!getSg_FAMNAME().equals(schueler.getSg_FAMNAME())) return false;
        //if (!getKlasse().equals(schueler.getKlasse())) return false;
        if (!getSg_VORNAME1().equals(schueler.getSg_VORNAME1())) return false;
        return getSg_GEBURTDAT().equals(schueler.getSg_GEBURTDAT());

    }

    @Override
    public int hashCode() {
        int result = getSg_kennzahl().hashCode();
        result = 31 * result + getSg_FAMNAME().hashCode();
        //result = 31 * result + getKlasse().hashCode();
        result = 31 * result + getSg_VORNAME1().hashCode();
        result = 31 * result + getSg_GEBURTDAT().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Schueler{" +
                "sg_kennzahl=" + sg_kennzahl +
                ", sg_FAMNAME='" + sg_FAMNAME + '\'' +
               // ", klasse='" + klasse + '\'' +
                ", sg_VORNAME1='" + sg_VORNAME1 + '\'' +
                ", sg_GEBURTDAT=" + sg_GEBURTDAT +
                '}';
    }


    public static final Parcelable.Creator<Schueler> CREATOR
            = new Parcelable.Creator<Schueler>() {
        public Schueler createFromParcel(Parcel in) {
            return new Schueler(in);
        }

        public Schueler[] newArray(int size) {
            return new Schueler[size];
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
