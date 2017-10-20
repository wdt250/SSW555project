package main.java.beans;

/**
 * 
 * @author Linlei Liu 
 *         E-mail:lliu33@stevens.edu
 * @editor Daotong Wang
 */

public class Individual{
	private String individualId;
	private String name;
	private String gender;
	private String birthDate;
	private int age;
	private Boolean alive;
	private String deathDate;
	private String asChildOfFamily;
	private String asSpouseOfFamily;
	
	
	
	public String getIndividualId() {
		return individualId;
	}
	public void setIndividualId(String id) {
		this.individualId = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gend) {
		this.gender = gend;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birt) {
		this.birthDate = birt;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Boolean getAlive() {
		return alive;
	}
	public void setAlive(Boolean alive) {
		this.alive = alive;
	}
	public String getDeathDate() {
		return deathDate;
	}
	public void setDeathDate(String deat) {
		this.deathDate = deat;
	}
	public String getAsChildOfFamily() {
		return asChildOfFamily;
	}
	public void setAsChildOfFamily(String asChildOfFamily) {
		this.asChildOfFamily = asChildOfFamily;
	}
	public String getAsSpouseOfFamily() {
		return asSpouseOfFamily;
	}
	public void setAsSpouseOfFamily(String asSpouseOfFamily) {
		this.asSpouseOfFamily = asSpouseOfFamily;
	}
	@Override
	public String toString() {
		return "Individual [individualId=" + individualId + ", name=" + name + ", gender=" + gender + ", birthDate="
				+ birthDate + ", age=" + age + ", alive=" + alive + ", deathDate=" + deathDate + ", asChildOfFamily="
				+ asChildOfFamily + ", asSpouseOfFamily=" + asSpouseOfFamily + "]";
	}
}
