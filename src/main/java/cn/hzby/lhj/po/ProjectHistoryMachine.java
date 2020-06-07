package cn.hzby.lhj.po;

public class ProjectHistoryMachine extends ProjectHistoryMachineKey {
    private String machineNameZh;

    private Integer machineType;

    private String machineTypeName;

    private Integer isShow;

    private Integer machinePower;

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

    public Integer getMachinePower() {
        return machinePower;
    }

    public void setMachinePower(Integer machinePower) {
        this.machinePower = machinePower;
    }

    public String getAttributeList() {
        return attributeList;
    }

    public void setAttributeList(String attributeList) {
        this.attributeList = attributeList == null ? null : attributeList.trim();
    }
}