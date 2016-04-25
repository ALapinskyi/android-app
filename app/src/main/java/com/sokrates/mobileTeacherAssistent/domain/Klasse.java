package com.sokrates.mobileTeacherAssistent.domain;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Klasse implements Parcelable {

    public class Ids{
        private Integer suKennzahl;
        private Integer sjSchuljahr;
        private Integer klId;

        @Override
        public String toString() {
            return "Ids{" +
                    "suKennzahl=" + suKennzahl +
                    ", sjSchuljahr=" + sjSchuljahr +
                    ", klId=" + klId +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Ids)) return false;

            Ids ids = (Ids) o;

            if (!getSuKennzahl().equals(ids.getSuKennzahl())) return false;
            if (!getSjSchuljahr().equals(ids.getSjSchuljahr())) return false;
            return getKlId().equals(ids.getKlId());

        }

        @Override
        public int hashCode() {
            int result = getSuKennzahl().hashCode();
            result = 31 * result + getSjSchuljahr().hashCode();
            result = 31 * result + getKlId().hashCode();
            return result;
        }

        public Ids(Integer suKennzahl, Integer sjSchuljahr, Integer klId) {
            this.suKennzahl = suKennzahl;
            this.sjSchuljahr = sjSchuljahr;
            this.klId = klId;
        }

        public Integer getSuKennzahl() {
            return suKennzahl;
        }

        public void setSuKennzahl(Integer suKennzahl) {
            this.suKennzahl = suKennzahl;
        }

        public Integer getSjSchuljahr() {
            return sjSchuljahr;
        }

        public void setSjSchuljahr(Integer sjSchuljahr) {
            this.sjSchuljahr = sjSchuljahr;
        }

        public Integer getKlId() {
            return klId;
        }

        public void setKlId(Integer klId) {
            this.klId = klId;
        }
    }

    private Ids id;
    private String klName;
    private String klAliasname;
    private String klSchulstufe;
    private Date klVon;
    private Date klBis;
    private Date klStichtaggmv;
    private Date klStichtagbidok;
    private String klFachrichtung;
    private String klProvkz;
    private String klSchulform;
    private String klSemester;
    private String klOrganisation;
    private String klUpdatedat;
    private String klAnmerkung;
    private Integer klMaxschueler;
    private String klMehrstufenkz;
    private Date klDatumsn;
    private Date klDatumjz;
    private Date klDatumwh1;
    private Date klDatumwh2;
    private String klNameuntis;
    private String klKvbezeichnung;
    private String klNamenext;
    private String klArt1;
    private String klArt2;
    private String klArt3;
    private String klArt4;
    private String klArt5;



    /*public static final Parcelable.Creator<Klasse> CREATOR
            = new Parcelable.Creator<Klasse>() {
        public Klasse createFromParcel(Parcel in) {
            return new Klasse(in);
        }

        public Klasse[] newArray(int size) {
            return new Klasse[size];
        }
    };*/

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }

    public Ids getId() {
        return id;
    }

    public void setId(Ids id) {
        this.id = id;
    }

    public String getKlName() {
        return klName;
    }

    public void setKlName(String klName) {
        this.klName = klName;
    }

    public String getKlAliasname() {
        return klAliasname;
    }

    public void setKlAliasname(String klAliasname) {
        this.klAliasname = klAliasname;
    }

    public String getKlSchulstufe() {
        return klSchulstufe;
    }

    public void setKlSchulstufe(String klSchulstufe) {
        this.klSchulstufe = klSchulstufe;
    }

    public Date getKlVon() {
        return klVon;
    }

    public void setKlVon(Date klVon) {
        this.klVon = klVon;
    }

    public Date getKlBis() {
        return klBis;
    }

    public void setKlBis(Date klBis) {
        this.klBis = klBis;
    }

    public Date getKlStichtaggmv() {
        return klStichtaggmv;
    }

    public void setKlStichtaggmv(Date klStichtaggmv) {
        this.klStichtaggmv = klStichtaggmv;
    }

    public Date getKlStichtagbidok() {
        return klStichtagbidok;
    }

    public void setKlStichtagbidok(Date klStichtagbidok) {
        this.klStichtagbidok = klStichtagbidok;
    }

    public String getKlFachrichtung() {
        return klFachrichtung;
    }

    public void setKlFachrichtung(String klFachrichtung) {
        this.klFachrichtung = klFachrichtung;
    }

    public String getKlProvkz() {
        return klProvkz;
    }

    public void setKlProvkz(String klProvkz) {
        this.klProvkz = klProvkz;
    }

    public String getKlSchulform() {
        return klSchulform;
    }

    public void setKlSchulform(String klSchulform) {
        this.klSchulform = klSchulform;
    }

    public String getKlSemester() {
        return klSemester;
    }

    public void setKlSemester(String klSemester) {
        this.klSemester = klSemester;
    }

    public String getKlOrganisation() {
        return klOrganisation;
    }

    public void setKlOrganisation(String klOrganisation) {
        this.klOrganisation = klOrganisation;
    }

    public String getKlUpdatedat() {
        return klUpdatedat;
    }

    public void setKlUpdatedat(String klUpdatedat) {
        this.klUpdatedat = klUpdatedat;
    }

    public String getKlAnmerkung() {
        return klAnmerkung;
    }

    public void setKlAnmerkung(String klAnmerkung) {
        this.klAnmerkung = klAnmerkung;
    }

    public Integer getKlMaxschueler() {
        return klMaxschueler;
    }

    public void setKlMaxschueler(Integer klMaxschueler) {
        this.klMaxschueler = klMaxschueler;
    }

    public String getKlMehrstufenkz() {
        return klMehrstufenkz;
    }

    public void setKlMehrstufenkz(String klMehrstufenkz) {
        this.klMehrstufenkz = klMehrstufenkz;
    }

    public Date getKlDatumsn() {
        return klDatumsn;
    }

    public void setKlDatumsn(Date klDatumsn) {
        this.klDatumsn = klDatumsn;
    }

    public Date getKlDatumjz() {
        return klDatumjz;
    }

    public void setKlDatumjz(Date klDatumjz) {
        this.klDatumjz = klDatumjz;
    }

    public Date getKlDatumwh1() {
        return klDatumwh1;
    }

    public void setKlDatumwh1(Date klDatumwh1) {
        this.klDatumwh1 = klDatumwh1;
    }

    public Date getKlDatumwh2() {
        return klDatumwh2;
    }

    public void setKlDatumwh2(Date klDatumwh2) {
        this.klDatumwh2 = klDatumwh2;
    }

    public String getKlNameuntis() {
        return klNameuntis;
    }

    public void setKlNameuntis(String klNameuntis) {
        this.klNameuntis = klNameuntis;
    }

    public String getKlKvbezeichnung() {
        return klKvbezeichnung;
    }

    public void setKlKvbezeichnung(String klKvbezeichnung) {
        this.klKvbezeichnung = klKvbezeichnung;
    }

    public String getKlNamenext() {
        return klNamenext;
    }

    public void setKlNamenext(String klNamenext) {
        this.klNamenext = klNamenext;
    }

    public String getKlArt1() {
        return klArt1;
    }

    public void setKlArt1(String klArt1) {
        this.klArt1 = klArt1;
    }

    public String getKlArt2() {
        return klArt2;
    }

    public void setKlArt2(String klArt2) {
        this.klArt2 = klArt2;
    }

    public String getKlArt3() {
        return klArt3;
    }

    public void setKlArt3(String klArt3) {
        this.klArt3 = klArt3;
    }

    public String getKlArt4() {
        return klArt4;
    }

    public void setKlArt4(String klArt4) {
        this.klArt4 = klArt4;
    }

    public String getKlArt5() {
        return klArt5;
    }

    public void setKlArt5(String klArt5) {
        this.klArt5 = klArt5;
    }

    @Override
    public String toString() {
        return "Klasse{" +
                "id=" + id +
                ", klName='" + klName + '\'' +
                ", klAliasname='" + klAliasname + '\'' +
                ", klSchulstufe='" + klSchulstufe + '\'' +
                ", klVon=" + klVon +
                ", klBis=" + klBis +
                ", klStichtaggmv=" + klStichtaggmv +
                ", klStichtagbidok=" + klStichtagbidok +
                ", klFachrichtung='" + klFachrichtung + '\'' +
                ", klProvkz='" + klProvkz + '\'' +
                ", klSchulform='" + klSchulform + '\'' +
                ", klSemester='" + klSemester + '\'' +
                ", klOrganisation='" + klOrganisation + '\'' +
                ", klUpdatedat='" + klUpdatedat + '\'' +
                ", klAnmerkung='" + klAnmerkung + '\'' +
                ", klMaxschueler=" + klMaxschueler +
                ", klMehrstufenkz='" + klMehrstufenkz + '\'' +
                ", klDatumsn=" + klDatumsn +
                ", klDatumjz=" + klDatumjz +
                ", klDatumwh1=" + klDatumwh1 +
                ", klDatumwh2=" + klDatumwh2 +
                ", klNameuntis='" + klNameuntis + '\'' +
                ", klKvbezeichnung='" + klKvbezeichnung + '\'' +
                ", klNamenext='" + klNamenext + '\'' +
                ", klArt1='" + klArt1 + '\'' +
                ", klArt2='" + klArt2 + '\'' +
                ", klArt3='" + klArt3 + '\'' +
                ", klArt4='" + klArt4 + '\'' +
                ", klArt5='" + klArt5 + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Klasse)) return false;

        Klasse klasse = (Klasse) o;

        if (!getId().equals(klasse.getId())) return false;
        if (!getKlName().equals(klasse.getKlName())) return false;
        if (!getKlAliasname().equals(klasse.getKlAliasname())) return false;
        if (!getKlSchulstufe().equals(klasse.getKlSchulstufe())) return false;
        if (!getKlVon().equals(klasse.getKlVon())) return false;
        if (!getKlBis().equals(klasse.getKlBis())) return false;
        if (!getKlStichtaggmv().equals(klasse.getKlStichtaggmv())) return false;
        if (!getKlStichtagbidok().equals(klasse.getKlStichtagbidok())) return false;
        if (!getKlFachrichtung().equals(klasse.getKlFachrichtung())) return false;
        if (!getKlProvkz().equals(klasse.getKlProvkz())) return false;
        if (!getKlSchulform().equals(klasse.getKlSchulform())) return false;
        if (!getKlSemester().equals(klasse.getKlSemester())) return false;
        if (!getKlOrganisation().equals(klasse.getKlOrganisation())) return false;
        if (!getKlUpdatedat().equals(klasse.getKlUpdatedat())) return false;
        if (!getKlAnmerkung().equals(klasse.getKlAnmerkung())) return false;
        if (!getKlMaxschueler().equals(klasse.getKlMaxschueler())) return false;
        if (!getKlMehrstufenkz().equals(klasse.getKlMehrstufenkz())) return false;
        if (!getKlDatumsn().equals(klasse.getKlDatumsn())) return false;
        if (!getKlDatumjz().equals(klasse.getKlDatumjz())) return false;
        if (!getKlDatumwh1().equals(klasse.getKlDatumwh1())) return false;
        if (!getKlDatumwh2().equals(klasse.getKlDatumwh2())) return false;
        if (!getKlNameuntis().equals(klasse.getKlNameuntis())) return false;
        if (!getKlKvbezeichnung().equals(klasse.getKlKvbezeichnung())) return false;
        if (!getKlNamenext().equals(klasse.getKlNamenext())) return false;
        if (!getKlArt1().equals(klasse.getKlArt1())) return false;
        if (!getKlArt2().equals(klasse.getKlArt2())) return false;
        if (!getKlArt3().equals(klasse.getKlArt3())) return false;
        if (!getKlArt4().equals(klasse.getKlArt4())) return false;
        return getKlArt5().equals(klasse.getKlArt5());

    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getKlName().hashCode();
        result = 31 * result + getKlAliasname().hashCode();
        result = 31 * result + getKlSchulstufe().hashCode();
        result = 31 * result + getKlVon().hashCode();
        result = 31 * result + getKlBis().hashCode();
        result = 31 * result + getKlStichtaggmv().hashCode();
        result = 31 * result + getKlStichtagbidok().hashCode();
        result = 31 * result + getKlFachrichtung().hashCode();
        result = 31 * result + getKlProvkz().hashCode();
        result = 31 * result + getKlSchulform().hashCode();
        result = 31 * result + getKlSemester().hashCode();
        result = 31 * result + getKlOrganisation().hashCode();
        result = 31 * result + getKlUpdatedat().hashCode();
        result = 31 * result + getKlAnmerkung().hashCode();
        result = 31 * result + getKlMaxschueler().hashCode();
        result = 31 * result + getKlMehrstufenkz().hashCode();
        result = 31 * result + getKlDatumsn().hashCode();
        result = 31 * result + getKlDatumjz().hashCode();
        result = 31 * result + getKlDatumwh1().hashCode();
        result = 31 * result + getKlDatumwh2().hashCode();
        result = 31 * result + getKlNameuntis().hashCode();
        result = 31 * result + getKlKvbezeichnung().hashCode();
        result = 31 * result + getKlNamenext().hashCode();
        result = 31 * result + getKlArt1().hashCode();
        result = 31 * result + getKlArt2().hashCode();
        result = 31 * result + getKlArt3().hashCode();
        result = 31 * result + getKlArt4().hashCode();
        result = 31 * result + getKlArt5().hashCode();
        return result;
    }
}
