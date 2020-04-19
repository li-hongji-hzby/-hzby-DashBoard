package cn.hzby.lhj.po;

public class RealtimeAirCompressor {
    private String deviceName;

    private Boolean status;

    private Integer outputPressure;

    private Integer power;

    private Integer frequency;

    private Integer dewPoint;

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

    public Integer getOutputPressure() {
        return outputPressure;
    }

    public void setOutputPressure(Integer outputPressure) {
        this.outputPressure = outputPressure;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public Integer getDewPoint() {
        return dewPoint;
    }

    public void setDewPoint(Integer dewPoint) {
        this.dewPoint = dewPoint;
    }
}