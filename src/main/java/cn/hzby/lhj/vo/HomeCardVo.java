package cn.hzby.lhj.vo;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONType;


@JSONType(orders={"timestamp","electricity","air","unitCost"})
public class HomeCardVo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long timestamp;
	private double electricity;
	private double air;
	private double unitCost;
	
	
	
	public HomeCardVo() {
		super();
	}
	
	public HomeCardVo(long timestamp, double electricity, double air, double unitCost) {
		super();
		this.timestamp = timestamp;
		this.electricity = electricity;
		this.air = air;
		this.unitCost = unitCost;
	}

	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	public double getElectricity() {
		return electricity;
	}
	public void setElectricity(double electricity) {
		this.electricity = electricity;
	}
	public double getAir() {
		return air;
	}
	public void setAir(double air) {
		this.air = air;
	}

	public double getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(double unitCost) {
		this.unitCost = unitCost;
	}

	@Override
	public String toString() {
		return "HomeCardVo [timestamp=" + timestamp + ", electricity=" + electricity + ", air=" + air + ", unitCost="
				+ unitCost + "]";
	}

	
	
	
}
