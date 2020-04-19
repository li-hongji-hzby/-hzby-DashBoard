package cn.hzby.lhj.po;

public class RealtimeDryer {
    private String deviceName;

    private Boolean status;

    private Integer pressure;

    private Integer power;

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

    public Integer getPressure() {
        return pressure;
    }

    public void setPressure(Integer pressure) {
        this.pressure = pressure;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public Integer getDewPoint() {
        return dewPoint;
    }

    public void setDewPoint(Integer dewPoint) {
        this.dewPoint = dewPoint;
    }
}