package beans;

import java.util.ArrayList;

/**
 * 
 * @author Linlei Liu 
 *         E-mail:lliu33@stevens.edu
 * modify Daotong's code
 */

public class Family{
	
	private String familiesId;
	
	private String marriedDate;
	
	private String divorceDate;
	
	private String husbandId;
	
	private String husbandName;
	
	private String wifeId;
	
	private String wifeName;
	
	private ArrayList<String> children;

	public String getFamiliesId() {
		return familiesId;
	}

	public void setFamiliesId(String familiesId) {
		this.familiesId = familiesId;
	}

	public String getMarriedDate() {
		return marriedDate;
	}

	public void setMarriedDate(String marriedDate) {
		this.marriedDate = marriedDate;
	}

	public String getDivorceDate() {
		return divorceDate;
	}

	public void setDivorceDate(String divorceDate) {
		this.divorceDate = divorceDate;
	}

	public String getHusbandId() {
		return husbandId;
	}

	public void setHusbandId(String husbandId) {
		this.husbandId = husbandId;
	}

	public String getHusbandName() {
		return husbandName;
	}

	public void setHusbandName(String husbandName) {
		this.husbandName = husbandName;
	}

	public String getWifeId() {
		return wifeId;
	}

	public void setWifeId(String wifeId) {
		this.wifeId = wifeId;
	}

	public String getWifeName() {
		return wifeName;
	}

	public void setWifeName(String wifeName) {
		this.wifeName = wifeName;
	}

	public ArrayList<String> getChildren() {
		return children;
	}

	public void setChildren(ArrayList<String> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "Family [familiesId=" + familiesId + ", marriedDate=" + marriedDate + ", divorceDate=" + divorceDate
				+ ", husbandId=" + husbandId + ", husbandName=" + husbandName + ", wifeId=" + wifeId + ", wifeName="
				+ wifeName + ", children=" + children + "]";
	}
	
}