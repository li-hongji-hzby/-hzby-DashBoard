package cn.hzby.lhj.po;

public class MachineKey {
    private String machineNameEn;

    private String product;

    public String getMachineNameEn() {
        return machineNameEn;
    }

    public void setMachineNameEn(String machineNameEn) {
        this.machineNameEn = machineNameEn == null ? null : machineNameEn.trim();
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product == null ? null : product.trim();
    }
}