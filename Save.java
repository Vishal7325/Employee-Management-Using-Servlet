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
  
@WebServlet("/Save")  
public class Save extends HttpServlet {  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response)   
         throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String name=request.getParameter("username");  
        String ContactNo=request.getParameter("mobileNo");  
        String email=request.getParameter("email");  
        String country=request.getParameter("country");  
          
        ModelDemo1 e=new ModelDemo1();  
        e.setName(name);  
        e.setContactNo(ContactNo);  
        e.setEmail(email);  
        e.setCountry(country);  
          
        int status=DaoDemo1.save(e);  
        if(status>0){  
            out.print("<p>Record saved successfully!</p>");  
            request.getRequestDispatcher("index.html").include(request, response);  
        }else{  
            out.println("Sorry! unable to save record");  
        }  
          
        out.close();  
    }  
  
}  