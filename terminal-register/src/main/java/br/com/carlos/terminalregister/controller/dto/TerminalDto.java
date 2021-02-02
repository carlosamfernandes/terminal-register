package br.com.carlos.terminalregister.controller.dto;

import br.com.carlos.terminalregister.models.Terminal;

import java.util.List;
import java.util.stream.Collectors;

public class TerminalDto {

    private Integer logic;
    private String serial;
    private String model; // é o mesmo dado do vermf
    private Integer sam;
    private String ptid;
    private Integer plat;
    private String version;
    private Integer mxr; // é o mesmo dado do sam
    private Integer mxf;
    private String verfm;

    public TerminalDto(Terminal terminal) {
        this.logic = terminal.getLogic();
        this.model = terminal.getVerfm();
        this.serial = terminal.getSerial();
        this.sam = terminal.getSam();
        this.ptid = terminal.getPtid();
        this.plat = terminal.getPlat();
        this.version = terminal.getVersion();
        this.mxr = terminal.getSam();
        this.mxf = terminal.getMxf();
        this.verfm = terminal.getVerfm();
    }

    public Integer getLogic() {
        return logic;
    }

    public String getModel() {
        return model;
    }

    public String getSerial() {
        return serial;
    }

    public Integer getSam() {
        return sam;
    }

    public String getPtid() {
        return ptid;
    }

    public Integer getPlat() {
        return plat;
    }

    public String getVersion() {
        return version;
    }

    public Integer getMxr() {
        return mxr;
    }

    public Integer getMxf() {
        return mxf;
    }

    public String getVerfm() {
        return verfm;
    }

    public static List<TerminalDto> convert(List<Terminal> terminals) {
        return terminals.stream().map(TerminalDto::new).collect(Collectors.toList());
    }

}
