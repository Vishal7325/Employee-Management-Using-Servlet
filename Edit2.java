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
 * Servlet implementation class EditServlet2
 */
@WebServlet("/Edit2")
public class Edit2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Edit2() {
        super();
        //TODO Auto-generated constructor stub
    }

	
	//protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	//}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String sid=request.getParameter("id1");  
        int id=Integer.parseInt(sid); 
        
        String uname=request.getParameter("name1");  
        String umobile=request.getParameter("mobileNo1");  
        String uemail=request.getParameter("email1");  
        String ucountry=request.getParameter("country1");  
          
        ModelDemo1 e=new ModelDemo1();  
        e.setId(id);  
        e.setName(uname);  
        e.setContactNo(umobile);  
        e.setEmail(uemail);  
        e.setCountry(ucountry);  
          
        int status=DaoDemo1.update(e);  
        if(status>0){  
            response.sendRedirect("View");  
        }else{  
            out.println("Sorry! unable to update record");  
        }  
          
        out.close();
	}

}
