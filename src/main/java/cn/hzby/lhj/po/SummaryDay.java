package cn.hzby.lhj.po;

public class SummaryDay {
    private Integer timestamp;

    private Integer electricity;

    private Integer air;

    private Float unitCost;

    public Integer getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getElectricity() {
        return electricity;
    }

    public void setElectricity(Integer electricity) {
        this.electricity = electricity;
    }

    public Integer getAir() {
        return air;
    }

    public void setAir(Integer air) {
        this.air = air;
    }

    public Float getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(Float unitCost) {
        this.unitCost = unitCost;
    }
}