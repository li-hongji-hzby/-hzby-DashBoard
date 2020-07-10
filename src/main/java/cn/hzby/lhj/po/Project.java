package cn.hzby.lhj.po;

public class Project {
    private String projectNameEn;

    private String projectNameZh;

    private String username;

    private Integer isDefault;

    public String getProjectNameEn() {
        return projectNameEn;
    }

    public void setProjectNameEn(String projectNameEn) {
        this.projectNameEn = projectNameEn == null ? null : projectNameEn.trim();
    }

    public String getProjectNameZh() {
        return projectNameZh;
    }

    public void setProjectNameZh(String projectNameZh) {
        this.projectNameZh = projectNameZh == null ? null : projectNameZh.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }
}