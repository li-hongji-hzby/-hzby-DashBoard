package cn.hzby.lhj.po;

public class RealtimeFlowMeter {
    private String deviceName;

    private Boolean status;

    private Integer flowRate;

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName == null ? null : deviceName.trim();
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getFlowRate() {
        return flowRate;
    }

    public void setFlowRate(Integer flowRate) {
        this.flowRate = flowRate;
    }
}