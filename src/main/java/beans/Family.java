package main.java.beans;

import java.util.ArrayList;

/**
 * 
 * @author Linlei Liu 
 *         E-mail:lliu33@stevens.edu
 * 
 * @editor Daotong Wang
 */

public class Family{
	private String familyId;
	private String marriedDate;
	private String divorceDate;
	private String husbandId;
	private String husbandName;
	private String wifeId;
	private String wifeName;
	private ArrayList<String> children;
	
	public String getFamilyId() {
		return familyId;
	}
	public void setFamilyId(String id) {
		this.familyId = id;
	}
	public String getMarriedDate() {
		return marriedDate;
	}
	public void setMarriedDate(String marrieddate) {
		this.marriedDate = marrieddate;
	}
	public String getDivorceDate() {
		return divorceDate;
	}
	public void setDivorceDate(String divorcedate) {
		this.divorceDate = divorcedate;
	}
	public String getHusbandId() {
		return husbandId;
	}
	public void setHusbandId(String husbandid) {
		this.husbandId = husbandid;
	}
	public String getHusbandName() {
		return husbandName;
	}
	public void setHusbandName(String husbandname) {
		this.husbandName = husbandname;
	}
	public String getWifeId() {
		return wifeId;
	}
	public void setWifeId(String wifeid) {
		this.wifeId = wifeid;
	}
	public String getWifeName() {
		return wifeName;
	}
	public void setWifeName(String wifename) {
		this.wifeName = wifename;
	}
	public ArrayList<String> getChildren() {
		return children;
	}
	public void setChilden(ArrayList<String> Children) {
		this.children = Children;
	}
	
	@Override
	public String toString() {
		return "Family [id=" + familyId + ", marrieddate=" + marriedDate + ", divorcedate=" + divorceDate + ", husbandid="
				+ husbandId + ", husbandname=" + husbandName + ", wifeid=" + wifeId + ", wifename=" + wifeName
				+ ", child=" + children + "]";
	}
	
	
}
