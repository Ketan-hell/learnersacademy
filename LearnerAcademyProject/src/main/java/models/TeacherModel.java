package models;

public class TeacherModel {
	public TeacherModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	private int tid;
	private String fname;
	private String lname;
	private int age;
	
	
	@Override
	public String toString() {
		return "TeacherModel [tid=" + tid + ", fname=" + fname + ", lname=" + lname + ", age=" + age + "]";
	}

	public TeacherModel(int tid, String fname, String lname, int age) {
		super();
		this.tid = tid;
		this.fname = fname;
		this.lname = lname;
		this.age = age;
	}
	//creating getters and setters

	public int getId() {
		return tid;
	}

	public void setId(int tid) {
		this.tid = tid;
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
	

}
