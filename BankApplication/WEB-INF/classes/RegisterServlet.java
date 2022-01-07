package beans;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	int accountno=Integer.parseInt(request.getParameter("account_no"));
    	String username=request.getParameter("username");
    	String password=request.getParameter("password");
	String email=request.getParameter("email");
	String address=request.getParameter("address");
    	String phone=String.valueOf(request.getParameter("phone"));
    	
    	CustomerBean customerbean=new CustomerBean();
	customerbean.setAccount_no(accountno);
    	customerbean.setUsername(username);
    	customerbean.setPassword(password);
    	customerbean.setEmail(email);
    	customerbean.setAddress(address);
    	customerbean.setPhone(phone);
    	
    	try {
		if(RegisterDao.registerCustomer(customerbean))
		{
			response.setContentType("text/html");
                                                    PrintWriter out = response.getWriter();
                                                    out.println("<script type=\"text/javascript\">");
                                                    out.println("alert('Registered succesfully');");
                                                    out.println("location='../Login.jsp';");
                                                    out.println("</script>");
		}
	                 else {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Registration failed');");
			out.println("location='../Register.jsp';");
			out.println("</script>");
		}
    	}catch(ClassNotFoundException e) {
    		e.printStackTrace();
    	}
    }
}
    	
    	
    	