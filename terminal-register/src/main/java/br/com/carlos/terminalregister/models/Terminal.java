package br.com.carlos.terminalregister.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Terminal {

    @Id
    private Integer logic;
    private String serial;
    private Integer sam;
    private String ptid;
    private Integer plat;
    private String version;
    private Integer mxf;
    private String verfm;

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Terminal other = (Terminal) obj;
        if (logic == null) {
            if (other.logic != null)
                return false;
        } else if (!logic.equals(other.logic))
            return false;
        return true;
    }

    public Integer getLogic() {
        return logic;
    }

    public void setLogic(Integer logic) {
        this.logic = logic;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public Integer getSam() {
        return sam;
    }

    public void setSam(Integer sam) {
        this.sam = sam;
    }

    public String getPtid() {
        return ptid;
    }

    public void setPtid(String ptid) {
        this.ptid = ptid;
    }

    public Integer getPlat() {
        return plat;
    }

    public void setPlat(Integer plat) {
        this.plat = plat;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Integer getMxf() {
        return mxf;
    }

    public void setMxf(Integer mxf) {
        this.mxf = mxf;
    }

    public String getVerfm() {
        return verfm;
    }

    public void setVerfm(String verfm) {
        this.verfm = verfm;
    }


}

