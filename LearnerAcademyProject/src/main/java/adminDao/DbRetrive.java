package adminDao;
import models.StudentModel;
import models.ClassModel;
import models.SubjectModel;
import models.TeacherModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class DbRetrive{	
	public static void main(String[] args) throws ClassNotFoundException {
		
	}
	
	public List<StudentModel> getStudent() throws ClassNotFoundException{
		List<StudentModel> student = new ArrayList<>();
		//loading driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		ResultSet myRS = null;
		Connection conn =null;
		Statement myStmt = null;
		
		try {
			
			String url = "jdbc:mysql://127.0.0.1:3306/learnerprogram";
			String name = "root";
			String password = "ketan";
			//get connection
			conn = DriverManager.getConnection(url, name, password);
			System.out.println("connection created");
			//create sql Statement
			String query = "Select * from studentdata";
			myStmt = conn.createStatement();
			System.out.println("statement created ok");
			//execute query
			myRS = myStmt.executeQuery(query);
			//process Result
			
			while(myRS.next()) {
				StudentModel temp = new StudentModel();
				temp.setId(myRS.getInt("sid"));
				temp.setFname(myRS.getString("fName"));
				temp.setLname(myRS.getString("lName"));
				temp.setAge(myRS.getInt("age"));
				//add it to list of student
				student.add(temp);
			}
		}catch (Exception e) {
			System.out.println("Inside catch block");
				// TODO: handle exception
			System.out.println("bye");
			}
		finally {
			// close JDBC objects
			close(conn,myStmt, myRS);
		}
			return student;

	}
	
	public List<TeacherModel> getTeachers() throws ClassNotFoundException {

		List<TeacherModel> teachers = new ArrayList<TeacherModel>();
		//loading driver
		Class.forName("com.mysql.cj.jdbc.Driver");
	     Connection conn = null;
		Statement myStmt = null;
		ResultSet myRS = null;
		
		try {
			
			System.out.println("Inside try blocksssssssss");
			String url = "jdbc:mysql://127.0.0.1:3306/learnerprogram";
			String name = "root";
			String password = "ketan";
			// get a connection
			conn = DriverManager.getConnection(url, name, password);;
			// create sql stmt
			String sql = "SELECT * FROM teacherdata";
			 myStmt = conn.prepareStatement(sql);
			// execute query
			myRS = myStmt.executeQuery(sql);
			// process result
			while (myRS.next()) {
			
				TeacherModel temp = new TeacherModel();
			     temp.setId(myRS.getInt("tid"));
					temp.setFname(myRS.getString("fname"));
					temp.setLname(myRS.getString("lname"));
					  temp.setAge(myRS.getInt("age"));

				// add it to the list of students
				teachers.add(temp);

			}
			

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			// close JDBC objects
		//	close(conn, myStmt, myRS);
		}
		return teachers;
	}
	
	public List<ClassModel> getClasses() {

		List<ClassModel> classes = new ArrayList<>();

		Connection conn = null;
		Statement myStmt = null;
		ResultSet myRS = null;

		try {
			String url = "jdbc:mysql://127.0.0.1:3306/learnerprogram";
			String name = "root";
			String password = "ketan";
			// get a connection
			conn = DriverManager.getConnection(url, name, password);

			// create sql stmt
			String sql = "Select * from classdata inner join subjectdata on classdata.subject = subjectdata.subid inner join teacherdata on classdata.teacher = teacherdata.tid";
			myStmt = conn.createStatement();
			

			// execute query
			myRS = myStmt.executeQuery(sql);

			// process result
			while (myRS.next()) {

				// create new class object
				ClassModel temp = new ClassModel();
				temp.setCid(myRS.getInt("cid"));
				temp.setSection(myRS.getInt("section"));
				temp.setSubname(myRS.getString("subname"));
				temp.setFname(myRS.getString("fname"));
				temp.setLname(myRS.getString("lname"));
				temp.setTime(myRS.getString("time"));
				// retrieve data from result set row
				
				
				
				

				// add it to the list of students
				classes.add(temp);

			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			// close JDBC objects
			close(conn, myStmt, myRS);
		}
		return classes;

	}

	
	public List<SubjectModel> getSubject() {

		List<SubjectModel> subject = new ArrayList<>();

		Connection conn = null;
		Statement myStmt = null;
		ResultSet myRS = null;

		try {

			System.out.println("Inside try block");
			String url = "jdbc:mysql://127.0.0.1:3306/learnerprogram";
			String name = "root";
			String password = "ketan";
			// get a connection
			conn = DriverManager.getConnection(url, name, password);

			// create sql stmt
			String sql = "SELECT * FROM subjectdata";
			myStmt = conn.createStatement();

			// execute query
			myRS = myStmt.executeQuery(sql);

			// process result
			while (myRS.next()) {

				// create new class object
				SubjectModel temp = new SubjectModel();
				// retrieve data from result set row
				temp.setId(myRS.getInt("subid"));
				temp.setSubname(myRS.getString("subname"));
				temp.setShortcut(myRS.getString("shortcut"));

				// add it to the list of students
				subject.add(temp);

			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			// close JDBC objects
			close(conn, myStmt, myRS);
		}
		return subject;

	}
	public List<StudentModel> viewStudentList() throws ClassNotFoundException{
		List<StudentModel> viewstudent = new ArrayList<>();
		Class.forName("com.mysql.cj.jdbc.Driver");
		ResultSet myRS = null;
		Connection conn =null;
		Statement myStmt = null;
		
		try {
			
			String url = "jdbc:mysql://127.0.0.1:3306/learnerprogram";
			String name = "root";
			String password = "ketan";
			//get connection
			conn = DriverManager.getConnection(url, name, password);
			//create sql Statement
			String query = "Select fname, lname, age from studentdata where subject = ?";
			myStmt = conn.createStatement();
			System.out.println("statement created ok");
			//execute query
			myRS = myStmt.executeQuery(query);
			//process Result
			
			while(myRS.next()) {
				StudentModel temp = new StudentModel();
				temp.setFname(myRS.getString("fName"));
				temp.setLname(myRS.getString("lName"));
				temp.setAge(myRS.getInt("age"));
				//add it to list of student
				viewstudent.add(temp);
			}
		}catch (Exception e) {
			System.out.println("Inside catch block");
				// TODO: handle exception
			System.out.println("bye");
			}
		finally {
			// close JDBC objects
			close(conn,myStmt, myRS);
		}
			return viewstudent;

	}
	

	
	private void close(Connection conn, Statement myStmt, ResultSet myRS) {
		// TODO Auto-generated method stub
		try {
			if (myRS != null) {
				myRS.close();
			}
			if (myStmt != null) {
				myStmt.close();
			}
			if (conn != null) {
				conn.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
		

}