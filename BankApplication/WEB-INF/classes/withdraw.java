package beans;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class withdraw extends HttpServlet {
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	
    	int account_no=Integer.parseInt(request.getParameter("accountno"));
    	double amount=Double.parseDouble(request.getParameter("amount"));
    	
    	CustomerBean customerbean=new CustomerBean();
    	customerbean.setAccount_no(account_no);
    	customerbean.setAmount(amount);
    
    	
    	try {
			int i = RegisterDao.withdraw(customerbean);
			if(i==1)
			{
				System.out.println("____");
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Amount withdrawn succesfully');");
				out.println("location='../LoginSuccessHeader.jsp';");
				out.println("</script>");
			}
			else if(i==0) {
				System.out.println("____");
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Amount withdrawl failed.Try again.');");
				out.println("location='../withdraw.jsp';");
				out.println("</script>");
			}else{
				System.out.println("____");
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('InSufficient Balance.');");
				out.println("location='../withdraw.jsp';");
				out.println("</script>");
			}
    	}catch(ClassNotFoundException e) {
    		e.printStackTrace();
    	}
    }
}
    	
    	
    	