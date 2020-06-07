package cn.hzby.lhj.po;

public class ProjectMainSummaryKey {
    private String projectNameEn;

    private String dataName;

    public String getProjectNameEn() {
        return projectNameEn;
    }

    public void setProjectNameEn(String projectNameEn) {
        this.projectNameEn = projectNameEn == null ? null : projectNameEn.trim();
    }

    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName == null ? null : dataName.trim();
    }
}