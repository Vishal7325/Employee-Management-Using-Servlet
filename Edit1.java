package Service1;

import java.io.IOException;
import java.io.PrintWriter;
import Dao1.DaoDemo1;
import Model1.ModelDemo1;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/Edit1")
public class Edit1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Edit1() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        
        out.println("<h1>Update Employee</h1>");  
        String sid=request.getParameter("id1");  
        int id=Integer.parseInt(sid);  
          
        ModelDemo1 e=DaoDemo1.getEmployeeById(id);  
          
        out.print("<form action='Edit2' method='post'>");  
        out.print("<table>");  
        out.print("<tr><td></td><td><input type='hidden' name='id1' value='"+e.getId()+"'/></td></tr>");  
        out.print("<tr><td>Name:</td><td><input type='text' name='name1' value='"+e.getName()+"'/></td></tr>");  
        out.print("<tr><td>Contact no:</td><td><input type='text' name='mobileNo1' value='"+e.getContactNo()+"'/></td></tr>");  
        out.print("<tr><td>Email:</td><td><input type='email' name='email1' value='"+e.getEmail()+"'/></td></tr>");  
        out.print("<tr><td>Country:</td><td>");  
        out.print("<select name='country1' style='width:150px'>");  
        out.print("<option>India</option>");  
        out.print("<option>USA</option>");  
        out.print("<option>UK</option>");  
        out.print("<option>Other</option>");  
        out.print("</select>");  
        out.print("</td></tr>");  
        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
          
        out.close();  
	
	}

	
	//protected void doPost(HttpRequest request, HttpResponse response) throws DigestException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}


