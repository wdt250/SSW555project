package main.java;

public class Family{
	private String id;
	private String marrieddate;
	private String divorcedate;
	private String husbandid;
	private String husbandname;
	private String wifeid;
	private String wifename;
	private String child;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMarrieddate() {
		return marrieddate;
	}
	public void setMarrieddate(String marrieddate) {
		this.marrieddate = marrieddate;
	}
	public String getDivorcedate() {
		return divorcedate;
	}
	public void setDivorcedate(String divorcedate) {
		this.divorcedate = divorcedate;
	}
	public String getHusbandid() {
		return husbandid;
	}
	public void setHusbandid(String husbandid) {
		this.husbandid = husbandid;
	}
	public String getHusbandname() {
		return husbandname;
	}
	public void setHusbandname(String husbandname) {
		this.husbandname = husbandname;
	}
	public String getWifeid() {
		return wifeid;
	}
	public void setWifeid(String wifeid) {
		this.wifeid = wifeid;
	}
	public String getWifename() {
		return wifename;
	}
	public void setWifename(String wifename) {
		this.wifename = wifename;
	}
	public String getChild() {
		return child;
	}
	public void setChild(String child) {
		this.child = child;
	}
	
	@Override
	public String toString() {
		return "Family [id=" + id + ", marrieddate=" + marrieddate + ", divorcedate=" + divorcedate + ", husbandid="
				+ husbandid + ", husbandname=" + husbandname + ", wifeid=" + wifeid + ", wifename=" + wifename
				+ ", child=" + child + "]";
	}
	
	
}