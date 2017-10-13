package beans;

/**
 * 
 * @author Linlei Liu 
 *         E-mail:lliu33@stevens.edu
 * modify Daotong's code
 */

public class Individual{
	
	private String individualId;
	
	private String name;
	
	private String gender;
	
	private String birthDate;
	
	private int age;
	
	private Boolean alive;
	
	private String deathDate;
	
	private String child;
	
	private String spouse;

	public String getIndividualId() {
		return individualId;
	}

	public void setIndividualId(String individualId) {
		this.individualId = individualId;
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

	public void setGender(String gender) {
		this.gender = gender;
	}

	
	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
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

	public void setDeathDate(String deathDate) {
		this.deathDate = deathDate;
	}

	public String getChild() {
		return child;
	}

	public void setChild(String child) {
		this.child = child;
	}

	public String getSpouse() {
		return spouse;
	}

	public void setSpouse(String spouse) {
		this.spouse = spouse;
	}

	@Override
	public String toString() {
		return "Individual [individualId=" + individualId + ", name=" + name + ", gender=" + gender + ", birthDate="
				+ birthDate + ", age=" + age + ", alive=" + alive + ", deathDate=" + deathDate + ", child=" + child
				+ ", spouse=" + spouse + "]";
	}

}