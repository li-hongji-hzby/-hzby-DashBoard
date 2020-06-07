package cn.hzby.lhj.po;

public class ProjectHistoryMachineKey {
    private String projectNameEn;

    private String machineNameEn;

    public String getProjectNameEn() {
        return projectNameEn;
    }

    public void setProjectNameEn(String projectNameEn) {
        this.projectNameEn = projectNameEn == null ? null : projectNameEn.trim();
    }

    public String getMachineNameEn() {
        return machineNameEn;
    }

    public void setMachineNameEn(String machineNameEn) {
        this.machineNameEn = machineNameEn == null ? null : machineNameEn.trim();
    }
}