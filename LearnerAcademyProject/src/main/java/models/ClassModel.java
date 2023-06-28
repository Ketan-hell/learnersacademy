package models;

public class ClassModel {
	private int cid;
	private int section;
	private int subject;
	private int teacher;
	private String time;
	private String subname;
	private String fname;
	private String lname;

	//creating getters and setters
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
	public ClassModel(int cid, int section, int subject, int teacher, String time) {
		super();
		this.cid = cid;
		this.section = section;
		this.subject = subject;
		this.teacher = teacher;
		this.time = time;
	}
	public ClassModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ClassModel [cid=" + cid + ", section=" + section + ", subject=" + subject + ", teacher=" + teacher
				+ ", time=" + time + "]";
	}
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getSection() {
		return section;
	}
	public void setSection(int section) {
		this.section = section;
	}
	public int getSubject() {
		return subject;
	}
	public void setSubject(int subject) {
		this.subject = subject;
	}
	public int getTeacher() {
		return teacher;
	}
	public void setTeacher(int teacher) {
		this.teacher = teacher;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getSubname() {
		return subname;
	}
	public void setSubname(String subname) {
		this.subname = subname;
	}


}
