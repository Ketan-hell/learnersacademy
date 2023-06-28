package registration.adminLogin;
import adminDao.DbRetrive;
import models.StudentModel;
import models.TeacherModel;
import models.ClassModel;
import models.SubjectModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.sql.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("unused")
@WebServlet("/portal")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DbRetrive db;
	
       
  
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init() throws ServletException {

		super.init();

		// create instance of db util, to pass in conn pool object
		try {
			db = new DbRetrive();

		} catch (Exception e) {
			throw new ServletException(e);
		}

	}
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//RequestDispatcher rd = request.getRequestDispatcher("/view.jsp");
		//rd.include(request, response);
		PrintWriter out = response.getWriter();
		
		String action = request.getQueryString();
		System.out.println(action);
		switch(action) {
		case "/Classes":
			System.out.println("heyy i m in Classes block");
			showClassesData(request,response);
			break;
		case "/Subject":
			System.out.println("heyy i m in subject block");
			showSubjectData(request,response);
			break;
		case "/Teacher":
			System.out.println("heyy i m in teacher block");
			try {
				showTeachersData(request,response);
				System.out.println("show teacher data");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/Student":
			System.out.println("heyy i m in student block");
			try{
				showStudentData(request, response);
			}catch (ServletException | IOException | ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
			break;
			
		case "/Logout":
			System.out.println("heyy i m in logout block");
			exit(request, response);
			break;
		default:
			try {
				showTeachersData(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
			break;
		}
	}

	private void showStudentData(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException{
		
		// add students to the request
		response.setContentType("text/html");
		HttpSession session=request.getSession(false);
		PrintWriter out=response.getWriter();
		StudentModel temp = new StudentModel();
		List<StudentModel> student = db.getStudent();
		request.setAttribute("student", student);
		RequestDispatcher rd = request.getRequestDispatcher("/StudentList.jsp");
		rd.forward(request, response);
		
	}
	
	private void showTeachersData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// get students 
		response.setContentType("text/html");
		HttpSession session=request.getSession(false);
		PrintWriter out=response.getWriter();
		TeacherModel temp = new TeacherModel();
		List<TeacherModel> teachers = db.getTeachers();
		// add teachers to the request
		request.setAttribute("teachers", teachers);
		// send it to the jSP view page
		RequestDispatcher rd = request.getRequestDispatcher("TeacherList.jsp");
		rd.forward(request, response);
	}
	
	private void showClassesData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	List<ClassModel> classes = db.getClasses();
	ClassModel temp = new ClassModel();
	request.setAttribute("classes", classes);
	RequestDispatcher rd = request.getRequestDispatcher("/ClassList.jsp");
	rd.forward(request, response);
	}
	
	private void showSubjectData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<SubjectModel> subject = db.getSubject();
		SubjectModel temp = new SubjectModel();
		request.setAttribute("subject", subject);
		RequestDispatcher rd = request.getRequestDispatcher("/SubjectList.jsp");
		rd.forward(request, response);
		}
	
	private void exit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/index.html");
		rd.forward(request, response);
		}


}
