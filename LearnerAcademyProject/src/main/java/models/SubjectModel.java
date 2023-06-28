package models;

public class SubjectModel {
	private int subid;
	private String subname;
	private String shortcut;
	
	public SubjectModel(int subid, String subname, String shortcut ) {
		super();
		this.subid = subid;
		this.subname = subname;
		this.shortcut = shortcut;
	}
	//creating getters and setters
	public int getId() {
		return subid;
	}

	public void setId(int id) {
		this.subid = id;
	}
	
	public SubjectModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getShortcut() {
		return shortcut;
	}

	public void setShortcut(String shortcut) {
		this.shortcut = shortcut;
	}

	public String getSubname() {
		return subname;
	}

	public void setSubname(String subname) {
		this.subname = subname;
	}
}
