package beans;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.*;


public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    response.setContentType("text/html");  
		  
		    int account_no=Integer.parseInt(request.getParameter("account_no"));  
		    String password=request.getParameter("password");
		  
			CustomerBean customer = new CustomerBean();
			customer.setAccount_no(account_no);
			customer.setPassword(password);

		    if(LoginDao.validate(customer)){
				HttpSession session = request.getSession(true);
				session.setAttribute("account_no",account_no); 
		    	response.sendRedirect("../LoginSuccessHeader.jsp");
            }		    		
		    else{  
		    	
				
					System.out.println("____");
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Login failed.Username or Password incorrect.');");
				out.println("location='../Login.jsp';");
				out.println("</script>");
					
			
			
		    }  
		          
		   
	}

}
