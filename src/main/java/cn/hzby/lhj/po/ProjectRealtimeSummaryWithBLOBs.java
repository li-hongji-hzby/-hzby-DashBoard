package cn.hzby.lhj.po;

public class ProjectRealtimeSummaryWithBLOBs extends ProjectRealtimeSummary {
    private String machineList;

    private String attribute;

    public String getMachineList() {
        return machineList;
    }

    public void setMachineList(String machineList) {
        this.machineList = machineList == null ? null : machineList.trim();
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute == null ? null : attribute.trim();
    }
}