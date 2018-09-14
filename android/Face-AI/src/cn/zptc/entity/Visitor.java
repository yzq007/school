package cn.zptc.entity;

public class Visitor {
	String id;
	String name;
	String ownerid;
	String relation;
	String tell;
	String start;
	String stop;
	String picture;
	String remark;
	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getOwnerid() {
		return ownerid;
	}
	public String getRelation() {
		return relation;
	}
	public String getTell() {
		return tell;
	}
	public String getStart() {
		return start;
	}
	public String getStop() {
		return stop;
	}
	public String getPicture() {
		return picture;
	}
	public String getRemark() {
		return remark;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setOwnerid(String ownerid) {
		this.ownerid = ownerid;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	public void setTell(String tell) {
		this.tell = tell;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public void setStop(String stop) {
		this.stop = stop;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
