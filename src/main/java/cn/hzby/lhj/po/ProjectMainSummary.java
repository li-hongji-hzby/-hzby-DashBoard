package cn.hzby.lhj.po;

public class ProjectMainSummary extends ProjectMainSummaryKey {
    private Integer isShow;

    private String attribute;

    public Integer getIsShow() {
        return isShow;
    }

    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute == null ? null : attribute.trim();
    }
}