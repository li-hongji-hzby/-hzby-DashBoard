package cn.hzby.lhj.vo;

import java.util.Map;

import cn.hzby.lhj.po.Machine;

public class MachineWithAttributes extends Machine{

	private Map<String, Object> attributeList;

	public MachineWithAttributes() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public MachineWithAttributes(Map<String, Object> attributeList) {
		super();
		this.attributeList = attributeList;
	}

	public Map<String, Object> getAttributeList() {
		return attributeList;
	}

	public void setAttributeList(Map<String, Object> attributeList) {
		this.attributeList = attributeList;
	}

	@Override
	public String toString() {
		return "MachineWithAttributes [attributeList=" + attributeList + ", getAttributeList()=" + getAttributeList()
				+ ", getMachineNameCn()=" + getMachineNameCn() + ", getMachineType()=" + getMachineType()
				+ ", getMachineNameEn()=" + getMachineNameEn() + ", getProduct()=" + getProduct() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}
