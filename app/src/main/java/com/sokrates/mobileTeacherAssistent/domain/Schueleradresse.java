package com.sokrates.mobileTeacherAssistent.domain;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;


public class Schueleradresse implements Parcelable{

    public class Ids {
        private Long sg_KENNZAHL;
        private Integer sa_ID;

        public Integer getSa_ID() {
            return sa_ID;
        }

        public void setSa_ID(Integer sa_ID) {
            this.sa_ID = sa_ID;
        }

        public Long getSg_KENNZAHL() {
            return sg_KENNZAHL;
        }

        public void setSg_KENNZAHL(Long sg_KENNZAHL) {
            this.sg_KENNZAHL = sg_KENNZAHL;
        }

        @Override
        public String toString() {
            return "Ids{" +
                    "sa_ID=" + sa_ID +
                    ", sg_KENNZAHL=" + sg_KENNZAHL +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Ids)) return false;

            Ids ids = (Ids) o;

            if (getSg_KENNZAHL() != null ? !getSg_KENNZAHL().equals(ids.getSg_KENNZAHL()) : ids.getSg_KENNZAHL() != null)
                return false;
            return !(getSa_ID() != null ? !getSa_ID().equals(ids.getSa_ID()) : ids.getSa_ID() != null);

        }

        @Override
        public int hashCode() {
            int result = getSg_KENNZAHL() != null ? getSg_KENNZAHL().hashCode() : 0;
            result = 31 * result + (getSa_ID() != null ? getSa_ID().hashCode() : 0);
            return result;
        }
    }

    private Ids id;
    private Integer GM_ID;
    private String sa_ART;
    private String sa_ANREDE;
    private String sa_TITEL;
    private String sa_AKADGRAD;
    private String sa_FAMNAME;
    private String sa_VORNAME;
    private String sa_LANDKZ;
    private String sa_PLZ;
    private String sa_ORT;
    private String sa_STRASSE;
    private String sa_HAUSNR;
    private Integer sa_STRASSENNR;
    private String sa_HOFNAME;
    private String sa_TEL1;
    private String sa_TEL2;
    private String sa_FAX;
    private String sa_MAIL;
    private String sa_HOMEPAGE;
    private String sa_BERUF;
    private Date sa_VON;
    private Date sa_BIS;
    private String sa_WOHNTHIERKZ;
    private String sa_ERZBERECHTKZ;
    private String sa_ANMERKUNG;
    private String sa_ZAHLPFLICHTKZ;
    private String sa_BILDUNGSORT;
    private String sa_HEIMATADRESSE;
    private String sa_UPDATEDAT;
    private String sa_POSTAN;
    private String sa_HWS;
    private String sa_AKADGRAD_NACH;
    private String sa_ANREDE1;
    private String sa_ANREDE2;
    private Integer spr_ID;
    private Integer gm_ID;
    private String sa_VERHEIRATETKZ;

    protected Schueleradresse(Parcel in) {
        sa_ART = in.readString();
        sa_ANREDE = in.readString();
        sa_TITEL = in.readString();
        sa_AKADGRAD = in.readString();
        sa_FAMNAME = in.readString();
        sa_VORNAME = in.readString();
        sa_LANDKZ = in.readString();
        sa_PLZ = in.readString();
        sa_ORT = in.readString();
        sa_STRASSE = in.readString();
        sa_HAUSNR = in.readString();
        sa_HOFNAME = in.readString();
        sa_TEL1 = in.readString();
        sa_TEL2 = in.readString();
        sa_FAX = in.readString();
        sa_MAIL = in.readString();
        sa_HOMEPAGE = in.readString();
        sa_BERUF = in.readString();
        sa_WOHNTHIERKZ = in.readString();
        sa_ERZBERECHTKZ = in.readString();
        sa_ANMERKUNG = in.readString();
        sa_ZAHLPFLICHTKZ = in.readString();
        sa_BILDUNGSORT = in.readString();
        sa_HEIMATADRESSE = in.readString();
        sa_UPDATEDAT = in.readString();
        sa_POSTAN = in.readString();
        sa_HWS = in.readString();
        sa_AKADGRAD_NACH = in.readString();
        sa_ANREDE1 = in.readString();
        sa_ANREDE2 = in.readString();
        sa_VERHEIRATETKZ = in.readString();
    }

    public static final Creator<Schueleradresse> CREATOR = new Creator<Schueleradresse>() {
        @Override
        public Schueleradresse createFromParcel(Parcel in) {
            return new Schueleradresse(in);
        }

        @Override
        public Schueleradresse[] newArray(int size) {
            return new Schueleradresse[size];
        }
    };

    public Ids getId() {
        return id;
    }

    public void setId(Ids id) {
        this.id = id;
    }

    public Integer getGM_ID() {
        return GM_ID;
    }

    public void setGM_ID(Integer GM_ID) {
        this.GM_ID = GM_ID;
    }

    public Integer getGm_ID() {
        return gm_ID;
    }

    public void setGm_ID(Integer gm_ID) {
        this.gm_ID = gm_ID;
    }

    public String getSa_AKADGRAD() {
        return sa_AKADGRAD;
    }

    public void setSa_AKADGRAD(String sa_AKADGRAD) {
        this.sa_AKADGRAD = sa_AKADGRAD;
    }

    public String getSa_AKADGRAD_NACH() {
        return sa_AKADGRAD_NACH;
    }

    public void setSa_AKADGRAD_NACH(String sa_AKADGRAD_NACH) {
        this.sa_AKADGRAD_NACH = sa_AKADGRAD_NACH;
    }

    public String getSa_ANMERKUNG() {
        return sa_ANMERKUNG;
    }

    public void setSa_ANMERKUNG(String sa_ANMERKUNG) {
        this.sa_ANMERKUNG = sa_ANMERKUNG;
    }

    public String getSa_ANREDE1() {
        return sa_ANREDE1;
    }

    public void setSa_ANREDE1(String sa_ANREDE1) {
        this.sa_ANREDE1 = sa_ANREDE1;
    }

    public String getSa_ANREDE2() {
        return sa_ANREDE2;
    }

    public void setSa_ANREDE2(String sa_ANREDE2) {
        this.sa_ANREDE2 = sa_ANREDE2;
    }

    public String getSa_ANREDE() {
        return sa_ANREDE;
    }

    public void setSa_ANREDE(String sa_ANREDE) {
        this.sa_ANREDE = sa_ANREDE;
    }

    public String getSa_ART() {
        return sa_ART;
    }

    public void setSa_ART(String sa_ART) {
        this.sa_ART = sa_ART;
    }

    public String getSa_BERUF() {
        return sa_BERUF;
    }

    public void setSa_BERUF(String sa_BERUF) {
        this.sa_BERUF = sa_BERUF;
    }

    public String getSa_BILDUNGSORT() {
        return sa_BILDUNGSORT;
    }

    public void setSa_BILDUNGSORT(String sa_BILDUNGSORT) {
        this.sa_BILDUNGSORT = sa_BILDUNGSORT;
    }

    public Date getSa_BIS() {
        return sa_BIS;
    }

    public void setSa_BIS(Date sa_BIS) {
        this.sa_BIS = sa_BIS;
    }

    public String getSa_ERZBERECHTKZ() {
        return sa_ERZBERECHTKZ;
    }

    public void setSa_ERZBERECHTKZ(String sa_ERZBERECHTKZ) {
        this.sa_ERZBERECHTKZ = sa_ERZBERECHTKZ;
    }

    public String getSa_FAMNAME() {
        return sa_FAMNAME;
    }

    public void setSa_FAMNAME(String sa_FAMNAME) {
        this.sa_FAMNAME = sa_FAMNAME;
    }

    public String getSa_FAX() {
        return sa_FAX;
    }

    public void setSa_FAX(String sa_FAX) {
        this.sa_FAX = sa_FAX;
    }

    public String getSa_HAUSNR() {
        return sa_HAUSNR;
    }

    public void setSa_HAUSNR(String sa_HAUSNR) {
        this.sa_HAUSNR = sa_HAUSNR;
    }

    public String getSa_HEIMATADRESSE() {
        return sa_HEIMATADRESSE;
    }

    public void setSa_HEIMATADRESSE(String sa_HEIMATADRESSE) {
        this.sa_HEIMATADRESSE = sa_HEIMATADRESSE;
    }

    public String getSa_HOFNAME() {
        return sa_HOFNAME;
    }

    public void setSa_HOFNAME(String sa_HOFNAME) {
        this.sa_HOFNAME = sa_HOFNAME;
    }

    public String getSa_HOMEPAGE() {
        return sa_HOMEPAGE;
    }

    public void setSa_HOMEPAGE(String sa_HOMEPAGE) {
        this.sa_HOMEPAGE = sa_HOMEPAGE;
    }

    public String getSa_HWS() {
        return sa_HWS;
    }

    public void setSa_HWS(String sa_HWS) {
        this.sa_HWS = sa_HWS;
    }

    public String getSa_LANDKZ() {
        return sa_LANDKZ;
    }

    public void setSa_LANDKZ(String sa_LANDKZ) {
        this.sa_LANDKZ = sa_LANDKZ;
    }

    public String getSa_MAIL() {
        return sa_MAIL;
    }

    public void setSa_MAIL(String sa_MAIL) {
        this.sa_MAIL = sa_MAIL;
    }

    public String getSa_ORT() {
        return sa_ORT;
    }

    public void setSa_ORT(String sa_ORT) {
        this.sa_ORT = sa_ORT;
    }

    public String getSa_PLZ() {
        return sa_PLZ;
    }

    public void setSa_PLZ(String sa_PLZ) {
        this.sa_PLZ = sa_PLZ;
    }

    public String getSa_POSTAN() {
        return sa_POSTAN;
    }

    public void setSa_POSTAN(String sa_POSTAN) {
        this.sa_POSTAN = sa_POSTAN;
    }

    public String getSa_STRASSE() {
        return sa_STRASSE;
    }

    public void setSa_STRASSE(String sa_STRASSE) {
        this.sa_STRASSE = sa_STRASSE;
    }

    public Integer getSa_STRASSENNR() {
        return sa_STRASSENNR;
    }

    public void setSa_STRASSENNR(Integer sa_STRASSENNR) {
        this.sa_STRASSENNR = sa_STRASSENNR;
    }

    public String getSa_TEL1() {
        return sa_TEL1;
    }

    public void setSa_TEL1(String sa_TEL1) {
        this.sa_TEL1 = sa_TEL1;
    }

    public String getSa_TEL2() {
        return sa_TEL2;
    }

    public void setSa_TEL2(String sa_TEL2) {
        this.sa_TEL2 = sa_TEL2;
    }

    public String getSa_TITEL() {
        return sa_TITEL;
    }

    public void setSa_TITEL(String sa_TITEL) {
        this.sa_TITEL = sa_TITEL;
    }

    public String getSa_UPDATEDAT() {
        return sa_UPDATEDAT;
    }

    public void setSa_UPDATEDAT(String sa_UPDATEDAT) {
        this.sa_UPDATEDAT = sa_UPDATEDAT;
    }

    public String getSa_VERHEIRATETKZ() {
        return sa_VERHEIRATETKZ;
    }

    public void setSa_VERHEIRATETKZ(String sa_VERHEIRATETKZ) {
        this.sa_VERHEIRATETKZ = sa_VERHEIRATETKZ;
    }

    public Date getSa_VON() {
        return sa_VON;
    }

    public void setSa_VON(Date sa_VON) {
        this.sa_VON = sa_VON;
    }

    public String getSa_VORNAME() {
        return sa_VORNAME;
    }

    public void setSa_VORNAME(String sa_VORNAME) {
        this.sa_VORNAME = sa_VORNAME;
    }

    public String getSa_WOHNTHIERKZ() {
        return sa_WOHNTHIERKZ;
    }

    public void setSa_WOHNTHIERKZ(String sa_WOHNTHIERKZ) {
        this.sa_WOHNTHIERKZ = sa_WOHNTHIERKZ;
    }

    public String getSa_ZAHLPFLICHTKZ() {
        return sa_ZAHLPFLICHTKZ;
    }

    public void setSa_ZAHLPFLICHTKZ(String sa_ZAHLPFLICHTKZ) {
        this.sa_ZAHLPFLICHTKZ = sa_ZAHLPFLICHTKZ;
    }

    public Integer getSpr_ID() {
        return spr_ID;
    }

    public void setSpr_ID(Integer spr_ID) {
        this.spr_ID = spr_ID;
    }

    @Override
    public String toString() {
        return "Schueleradresse{" +
                "GM_ID=" + GM_ID +
                ", id=" + id +
                ", sa_ART='" + sa_ART + '\'' +
                ", sa_ANREDE='" + sa_ANREDE + '\'' +
                ", sa_TITEL='" + sa_TITEL + '\'' +
                ", sa_AKADGRAD='" + sa_AKADGRAD + '\'' +
                ", sa_FAMNAME='" + sa_FAMNAME + '\'' +
                ", sa_VORNAME='" + sa_VORNAME + '\'' +
                ", sa_LANDKZ='" + sa_LANDKZ + '\'' +
                ", sa_PLZ='" + sa_PLZ + '\'' +
                ", sa_ORT='" + sa_ORT + '\'' +
                ", sa_STRASSE='" + sa_STRASSE + '\'' +
                ", sa_HAUSNR='" + sa_HAUSNR + '\'' +
                ", sa_STRASSENNR=" + sa_STRASSENNR +
                ", sa_HOFNAME='" + sa_HOFNAME + '\'' +
                ", sa_TEL1='" + sa_TEL1 + '\'' +
                ", sa_TEL2='" + sa_TEL2 + '\'' +
                ", sa_FAX='" + sa_FAX + '\'' +
                ", sa_MAIL='" + sa_MAIL + '\'' +
                ", sa_HOMEPAGE='" + sa_HOMEPAGE + '\'' +
                ", sa_BERUF='" + sa_BERUF + '\'' +
                ", sa_VON=" + sa_VON +
                ", sa_BIS=" + sa_BIS +
                ", sa_WOHNTHIERKZ='" + sa_WOHNTHIERKZ + '\'' +
                ", sa_ERZBERECHTKZ='" + sa_ERZBERECHTKZ + '\'' +
                ", sa_ANMERKUNG='" + sa_ANMERKUNG + '\'' +
                ", sa_ZAHLPFLICHTKZ='" + sa_ZAHLPFLICHTKZ + '\'' +
                ", sa_BILDUNGSORT='" + sa_BILDUNGSORT + '\'' +
                ", sa_HEIMATADRESSE='" + sa_HEIMATADRESSE + '\'' +
                ", sa_UPDATEDAT='" + sa_UPDATEDAT + '\'' +
                ", sa_POSTAN='" + sa_POSTAN + '\'' +
                ", sa_HWS='" + sa_HWS + '\'' +
                ", sa_AKADGRAD_NACH='" + sa_AKADGRAD_NACH + '\'' +
                ", sa_ANREDE1='" + sa_ANREDE1 + '\'' +
                ", sa_ANREDE2='" + sa_ANREDE2 + '\'' +
                ", spr_ID=" + spr_ID +
                ", gm_ID=" + gm_ID +
                ", sa_VERHEIRATETKZ='" + sa_VERHEIRATETKZ + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Schueleradresse)) return false;

        Schueleradresse that = (Schueleradresse) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getGM_ID() != null ? !getGM_ID().equals(that.getGM_ID()) : that.getGM_ID() != null)
            return false;
        if (getSa_ART() != null ? !getSa_ART().equals(that.getSa_ART()) : that.getSa_ART() != null)
            return false;
        if (getSa_ANREDE() != null ? !getSa_ANREDE().equals(that.getSa_ANREDE()) : that.getSa_ANREDE() != null)
            return false;
        if (getSa_TITEL() != null ? !getSa_TITEL().equals(that.getSa_TITEL()) : that.getSa_TITEL() != null)
            return false;
        if (getSa_AKADGRAD() != null ? !getSa_AKADGRAD().equals(that.getSa_AKADGRAD()) : that.getSa_AKADGRAD() != null)
            return false;
        if (getSa_FAMNAME() != null ? !getSa_FAMNAME().equals(that.getSa_FAMNAME()) : that.getSa_FAMNAME() != null)
            return false;
        if (getSa_VORNAME() != null ? !getSa_VORNAME().equals(that.getSa_VORNAME()) : that.getSa_VORNAME() != null)
            return false;
        if (getSa_LANDKZ() != null ? !getSa_LANDKZ().equals(that.getSa_LANDKZ()) : that.getSa_LANDKZ() != null)
            return false;
        if (getSa_PLZ() != null ? !getSa_PLZ().equals(that.getSa_PLZ()) : that.getSa_PLZ() != null)
            return false;
        if (getSa_ORT() != null ? !getSa_ORT().equals(that.getSa_ORT()) : that.getSa_ORT() != null)
            return false;
        if (getSa_STRASSE() != null ? !getSa_STRASSE().equals(that.getSa_STRASSE()) : that.getSa_STRASSE() != null)
            return false;
        if (getSa_HAUSNR() != null ? !getSa_HAUSNR().equals(that.getSa_HAUSNR()) : that.getSa_HAUSNR() != null)
            return false;
        if (getSa_STRASSENNR() != null ? !getSa_STRASSENNR().equals(that.getSa_STRASSENNR()) : that.getSa_STRASSENNR() != null)
            return false;
        if (getSa_HOFNAME() != null ? !getSa_HOFNAME().equals(that.getSa_HOFNAME()) : that.getSa_HOFNAME() != null)
            return false;
        if (getSa_TEL1() != null ? !getSa_TEL1().equals(that.getSa_TEL1()) : that.getSa_TEL1() != null)
            return false;
        if (getSa_TEL2() != null ? !getSa_TEL2().equals(that.getSa_TEL2()) : that.getSa_TEL2() != null)
            return false;
        if (getSa_FAX() != null ? !getSa_FAX().equals(that.getSa_FAX()) : that.getSa_FAX() != null)
            return false;
        if (getSa_MAIL() != null ? !getSa_MAIL().equals(that.getSa_MAIL()) : that.getSa_MAIL() != null)
            return false;
        if (getSa_HOMEPAGE() != null ? !getSa_HOMEPAGE().equals(that.getSa_HOMEPAGE()) : that.getSa_HOMEPAGE() != null)
            return false;
        if (getSa_BERUF() != null ? !getSa_BERUF().equals(that.getSa_BERUF()) : that.getSa_BERUF() != null)
            return false;
        if (getSa_VON() != null ? !getSa_VON().equals(that.getSa_VON()) : that.getSa_VON() != null)
            return false;
        if (getSa_BIS() != null ? !getSa_BIS().equals(that.getSa_BIS()) : that.getSa_BIS() != null)
            return false;
        if (getSa_WOHNTHIERKZ() != null ? !getSa_WOHNTHIERKZ().equals(that.getSa_WOHNTHIERKZ()) : that.getSa_WOHNTHIERKZ() != null)
            return false;
        if (getSa_ERZBERECHTKZ() != null ? !getSa_ERZBERECHTKZ().equals(that.getSa_ERZBERECHTKZ()) : that.getSa_ERZBERECHTKZ() != null)
            return false;
        if (getSa_ANMERKUNG() != null ? !getSa_ANMERKUNG().equals(that.getSa_ANMERKUNG()) : that.getSa_ANMERKUNG() != null)
            return false;
        if (getSa_ZAHLPFLICHTKZ() != null ? !getSa_ZAHLPFLICHTKZ().equals(that.getSa_ZAHLPFLICHTKZ()) : that.getSa_ZAHLPFLICHTKZ() != null)
            return false;
        if (getSa_BILDUNGSORT() != null ? !getSa_BILDUNGSORT().equals(that.getSa_BILDUNGSORT()) : that.getSa_BILDUNGSORT() != null)
            return false;
        if (getSa_HEIMATADRESSE() != null ? !getSa_HEIMATADRESSE().equals(that.getSa_HEIMATADRESSE()) : that.getSa_HEIMATADRESSE() != null)
            return false;
        if (getSa_UPDATEDAT() != null ? !getSa_UPDATEDAT().equals(that.getSa_UPDATEDAT()) : that.getSa_UPDATEDAT() != null)
            return false;
        if (getSa_POSTAN() != null ? !getSa_POSTAN().equals(that.getSa_POSTAN()) : that.getSa_POSTAN() != null)
            return false;
        if (getSa_HWS() != null ? !getSa_HWS().equals(that.getSa_HWS()) : that.getSa_HWS() != null)
            return false;
        if (getSa_AKADGRAD_NACH() != null ? !getSa_AKADGRAD_NACH().equals(that.getSa_AKADGRAD_NACH()) : that.getSa_AKADGRAD_NACH() != null)
            return false;
        if (getSa_ANREDE1() != null ? !getSa_ANREDE1().equals(that.getSa_ANREDE1()) : that.getSa_ANREDE1() != null)
            return false;
        if (getSa_ANREDE2() != null ? !getSa_ANREDE2().equals(that.getSa_ANREDE2()) : that.getSa_ANREDE2() != null)
            return false;
        if (getSpr_ID() != null ? !getSpr_ID().equals(that.getSpr_ID()) : that.getSpr_ID() != null)
            return false;
        if (getGm_ID() != null ? !getGm_ID().equals(that.getGm_ID()) : that.getGm_ID() != null)
            return false;
        return !(getSa_VERHEIRATETKZ() != null ? !getSa_VERHEIRATETKZ().equals(that.getSa_VERHEIRATETKZ()) : that.getSa_VERHEIRATETKZ() != null);

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getGM_ID() != null ? getGM_ID().hashCode() : 0);
        result = 31 * result + (getSa_ART() != null ? getSa_ART().hashCode() : 0);
        result = 31 * result + (getSa_ANREDE() != null ? getSa_ANREDE().hashCode() : 0);
        result = 31 * result + (getSa_TITEL() != null ? getSa_TITEL().hashCode() : 0);
        result = 31 * result + (getSa_AKADGRAD() != null ? getSa_AKADGRAD().hashCode() : 0);
        result = 31 * result + (getSa_FAMNAME() != null ? getSa_FAMNAME().hashCode() : 0);
        result = 31 * result + (getSa_VORNAME() != null ? getSa_VORNAME().hashCode() : 0);
        result = 31 * result + (getSa_LANDKZ() != null ? getSa_LANDKZ().hashCode() : 0);
        result = 31 * result + (getSa_PLZ() != null ? getSa_PLZ().hashCode() : 0);
        result = 31 * result + (getSa_ORT() != null ? getSa_ORT().hashCode() : 0);
        result = 31 * result + (getSa_STRASSE() != null ? getSa_STRASSE().hashCode() : 0);
        result = 31 * result + (getSa_HAUSNR() != null ? getSa_HAUSNR().hashCode() : 0);
        result = 31 * result + (getSa_STRASSENNR() != null ? getSa_STRASSENNR().hashCode() : 0);
        result = 31 * result + (getSa_HOFNAME() != null ? getSa_HOFNAME().hashCode() : 0);
        result = 31 * result + (getSa_TEL1() != null ? getSa_TEL1().hashCode() : 0);
        result = 31 * result + (getSa_TEL2() != null ? getSa_TEL2().hashCode() : 0);
        result = 31 * result + (getSa_FAX() != null ? getSa_FAX().hashCode() : 0);
        result = 31 * result + (getSa_MAIL() != null ? getSa_MAIL().hashCode() : 0);
        result = 31 * result + (getSa_HOMEPAGE() != null ? getSa_HOMEPAGE().hashCode() : 0);
        result = 31 * result + (getSa_BERUF() != null ? getSa_BERUF().hashCode() : 0);
        result = 31 * result + (getSa_VON() != null ? getSa_VON().hashCode() : 0);
        result = 31 * result + (getSa_BIS() != null ? getSa_BIS().hashCode() : 0);
        result = 31 * result + (getSa_WOHNTHIERKZ() != null ? getSa_WOHNTHIERKZ().hashCode() : 0);
        result = 31 * result + (getSa_ERZBERECHTKZ() != null ? getSa_ERZBERECHTKZ().hashCode() : 0);
        result = 31 * result + (getSa_ANMERKUNG() != null ? getSa_ANMERKUNG().hashCode() : 0);
        result = 31 * result + (getSa_ZAHLPFLICHTKZ() != null ? getSa_ZAHLPFLICHTKZ().hashCode() : 0);
        result = 31 * result + (getSa_BILDUNGSORT() != null ? getSa_BILDUNGSORT().hashCode() : 0);
        result = 31 * result + (getSa_HEIMATADRESSE() != null ? getSa_HEIMATADRESSE().hashCode() : 0);
        result = 31 * result + (getSa_UPDATEDAT() != null ? getSa_UPDATEDAT().hashCode() : 0);
        result = 31 * result + (getSa_POSTAN() != null ? getSa_POSTAN().hashCode() : 0);
        result = 31 * result + (getSa_HWS() != null ? getSa_HWS().hashCode() : 0);
        result = 31 * result + (getSa_AKADGRAD_NACH() != null ? getSa_AKADGRAD_NACH().hashCode() : 0);
        result = 31 * result + (getSa_ANREDE1() != null ? getSa_ANREDE1().hashCode() : 0);
        result = 31 * result + (getSa_ANREDE2() != null ? getSa_ANREDE2().hashCode() : 0);
        result = 31 * result + (getSpr_ID() != null ? getSpr_ID().hashCode() : 0);
        result = 31 * result + (getGm_ID() != null ? getGm_ID().hashCode() : 0);
        result = 31 * result + (getSa_VERHEIRATETKZ() != null ? getSa_VERHEIRATETKZ().hashCode() : 0);
        return result;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(sa_ART);
        dest.writeString(sa_ANREDE);
        dest.writeString(sa_TITEL);
        dest.writeString(sa_AKADGRAD);
        dest.writeString(sa_FAMNAME);
        dest.writeString(sa_VORNAME);
        dest.writeString(sa_LANDKZ);
        dest.writeString(sa_PLZ);
        dest.writeString(sa_ORT);
        dest.writeString(sa_STRASSE);
        dest.writeString(sa_HAUSNR);
        dest.writeString(sa_HOFNAME);
        dest.writeString(sa_TEL1);
        dest.writeString(sa_TEL2);
        dest.writeString(sa_FAX);
        dest.writeString(sa_MAIL);
        dest.writeString(sa_HOMEPAGE);
        dest.writeString(sa_BERUF);
        dest.writeString(sa_WOHNTHIERKZ);
        dest.writeString(sa_ERZBERECHTKZ);
        dest.writeString(sa_ANMERKUNG);
        dest.writeString(sa_ZAHLPFLICHTKZ);
        dest.writeString(sa_BILDUNGSORT);
        dest.writeString(sa_HEIMATADRESSE);
        dest.writeString(sa_UPDATEDAT);
        dest.writeString(sa_POSTAN);
        dest.writeString(sa_HWS);
        dest.writeString(sa_AKADGRAD_NACH);
        dest.writeString(sa_ANREDE1);
        dest.writeString(sa_ANREDE2);
        dest.writeString(sa_VERHEIRATETKZ);
    }
}
