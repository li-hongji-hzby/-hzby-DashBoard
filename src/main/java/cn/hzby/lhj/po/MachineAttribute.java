package cn.hzby.lhj.po;

public class MachineAttribute {
    private Integer id;

    private String attributeNameEn;

    private String attributeNameCn;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAttributeNameEn() {
        return attributeNameEn;
    }

    public void setAttributeNameEn(String attributeNameEn) {
        this.attributeNameEn = attributeNameEn == null ? null : attributeNameEn.trim();
    }

    public String getAttributeNameCn() {
        return attributeNameCn;
    }

    public void setAttributeNameCn(String attributeNameCn) {
        this.attributeNameCn = attributeNameCn == null ? null : attributeNameCn.trim();
    }
}