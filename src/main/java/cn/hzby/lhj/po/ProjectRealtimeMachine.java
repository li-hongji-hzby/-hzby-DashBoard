package cn.hzby.lhj.po;

public class ProjectRealtimeMachine extends ProjectRealtimeMachineKey {
    private String machineNameZh;

    private Integer machineType;

    private String machineTypeName;

    private Integer isShow;

    private String machinePower;

    private String attributeList;

    public String getMachineNameZh() {
        return machineNameZh;
    }

    public void setMachineNameZh(String machineNameZh) {
        this.machineNameZh = machineNameZh == null ? null : machineNameZh.trim();
    }

    public Integer getMachineType() {
        return machineType;
    }

    public void setMachineType(Integer machineType) {
        this.machineType = machineType;
    }

    public String getMachineTypeName() {
        return machineTypeName;
    }

    public void setMachineTypeName(String machineTypeName) {
        this.machineTypeName = machineTypeName == null ? null : machineTypeName.trim();
    }

    public Integer getIsShow() {
        return isShow;
    }

    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }

    public String getMachinePower() {
        return machinePower;
    }

    public void setMachinePower(String machinePower) {
        this.machinePower = machinePower == null ? null : machinePower.trim();
    }

    public String getAttributeList() {
        return attributeList;
    }

    public void setAttributeList(String attributeList) {
        this.attributeList = attributeList == null ? null : attributeList.trim();
    }
}