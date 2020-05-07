package cn.hzby.lhj.po;

public class Machine extends MachineKey {
    private String machineNameCn;

    private Integer machineType;

    public String getMachineNameCn() {
        return machineNameCn;
    }

    public void setMachineNameCn(String machineNameCn) {
        this.machineNameCn = machineNameCn == null ? null : machineNameCn.trim();
    }

    public Integer getMachineType() {
        return machineType;
    }

    public void setMachineType(Integer machineType) {
        this.machineType = machineType;
    }
}