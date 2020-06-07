package cn.hzby.lhj.po;

public class MachineStatus {
    private Integer id;

    private String machineName;

    private String attrribute;

    private Double min;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName == null ? null : machineName.trim();
    }

    public String getAttrribute() {
        return attrribute;
    }

    public void setAttrribute(String attrribute) {
        this.attrribute = attrribute == null ? null : attrribute.trim();
    }

    public Double getMin() {
        return min;
    }

    public void setMin(Double min) {
        this.min = min;
    }
}