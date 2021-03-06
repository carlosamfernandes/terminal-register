package br.com.carlos.terminalregister.controller.form;

import br.com.carlos.terminalregister.models.Terminal;
import br.com.carlos.terminalregister.repository.TerminalRepository;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class TerminalForm {

    // TODO: arrumar o form para se adequar ao post

    @NotNull @NotEmpty
    private Integer logic;
    @NotNull @NotEmpty
    private String serial;
    @NotNull @NotEmpty
    private String model; // é o mesmo dado do vermf
    @Min(value = 0)
    private Integer sam;
    private String ptid;
    private Integer plat;
    @NotNull @NotEmpty
    private String version;
    private Integer mxr; // é o mesmo dado do sam
    private Integer mxf;
    private String verfm;

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

    public Terminal update(Integer logic, TerminalRepository terminalRepository) {
        Terminal terminal = terminalRepository.getOne(logic);
        terminal.setLogic(this.logic);
        terminal.setMxf(this.mxf);
        terminal.setPlat(this.plat);
        terminal.setPtid(this.ptid);
        terminal.setSam(this.sam);
        terminal.setVerfm(this.model);
        terminal.setSerial(this.serial);
        terminal.setVersion(this.version);
        return terminal;
    }

    public Terminal convert (String terminalInput){
        String [] splitted = terminalInput.split(";");
        Terminal terminal = new Terminal();
        terminal.setLogic(Integer.parseInt(splitted[0]));
        terminal.setSerial(splitted[1]);
        terminal.setSam(Integer.parseInt(splitted[3]));
        terminal.setPtid(splitted[4]);
        terminal.setPlat(Integer.parseInt(splitted[5]));
        terminal.setVersion(splitted[6]);
        terminal.setMxf(Integer.parseInt(splitted[8]));
        terminal.setVerfm(splitted[9]);

        return terminal;
    }

}
