package models;

public class StudentModel {
	
	public StudentModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	private int sid;
	private String fname;
	private String lname;
	private int age;
    private int cid;
	@Override
	public String toString() {
		return "StudentModel [sid=" + sid + ", fname=" + fname + ", lname=" + lname + ", age=" + age + ", cid="
				+ cid + "]";
	}
	//creating getters and setters
	public int getId() {
		return sid;
	}
	public StudentModel(int sid, String fname, String lname, int age, int cid) {
		super();
		this.sid = sid;
		this.fname = fname;
		this.lname = lname;
		this.age = age;
		this.cid = cid;
	}
	public void setId(int id) {
		this.sid = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	
	
	

	
	

	

}
