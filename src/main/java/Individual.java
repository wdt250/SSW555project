package main.java;

public class Individual{
	private String id;
	private String name;
	private String gend;
	private String birt;
	private int age;
	private Boolean alive;
	private String deat;
	private String child;
	private String spouse;
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGend() {
		return gend;
	}
	public void setGend(String gend) {
		this.gend = gend;
	}
	public String getBirt() {
		return birt;
	}
	public void setBirt(String birt) {
		this.birt = birt;
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
	public String getDeat() {
		return deat;
	}
	public void setDeat(String deat) {
		this.deat = deat;
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
		return "Individual [id=" + id + ", name=" + name + ", gend=" + gend + ", birt=" + birt + ", age=" + age
				+ ", alive=" + alive + ", deat=" + deat + ", child=" + child + ", spouse=" + spouse + "]";
	}
	
	
}