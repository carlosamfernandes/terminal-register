package br.com.carlos.terminalregister.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Terminal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer logic;
    private String model; // tem no item 2b, mas nao no 2c
    private String serial;
    private Integer sam;
    private String ptid;
    private Integer plat;
    private String version;
    private Integer mxr;
    private Integer mxf; // tem no item 2b, mas nao no 2c
    private String verfm;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Terminal other = (Terminal) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLogic() {
        return logic;
    }

    public void setLogic(Integer logic) {
        this.logic = logic;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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

    public Integer getMxr() {
        return mxr;
    }

    public void setMxr(Integer mxr) {
        this.mxr = mxr;
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

    //{
//        "title": "Terminal",
//        "type": "object",
//        "properties": {
//        "logic": {
//        "type": "integer"
//        },
//        "serial": {
//        "type": "string"
//        },
//        "sam": {
//        "type": "integer",
//        "minimum": 0
//        },
//        "ptid": {
//        "type": "string"
//        },
//        "plat": {
//        "type": "integer"
//        },
//        "version": {
//        "type": "string"
//        },
//        "mxr": {
//        "type": "integer"
//        },
//        "VERFM": {
//        "type": "string"
//        }
//        },
//        "required": ["logic", "serial", "model", "version"]
//        }

}

