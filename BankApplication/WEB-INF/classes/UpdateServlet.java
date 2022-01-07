package beans;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.*;


public class UpdateServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    response.setContentType("text/html");  
		  
			int account_no=Integer.parseInt(request.getParameter("accountno"));
            String address=request.getParameter("address");  
		    String phone=request.getParameter("phone");

			CustomerBean customer = new CustomerBean();
			customer.setAddress(address);
			customer.setPhone(phone);
			customer.setAccount_no(account_no);

		    if(RegisterDao.validate(customer)){
				System.out.println("____");
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Updated Successfully.');");
				out.println("location='../LoginSuccessHeader.jsp';");
				out.println("</script>");
				
		    	
            }		    		
		    else{  
		    	
				
					System.out.println("____");
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Update failed. Try Again.');");
				out.println("location='../change_account_details.jsp';");
				out.println("</script>");
					
			
			
		    }  
		          
		   
	}

}
