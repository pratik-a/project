package beans;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class deposite extends HttpServlet {
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	
    	int account_no=Integer.parseInt(request.getParameter("accountno"));
		System.out.println("--" + account_no);
    	double amount=Double.parseDouble(request.getParameter("amount"));
		System.out.println("--" + amount);
    	
    	CustomerBean customerbean=new CustomerBean();
    	customerbean.setAccount_no(account_no);
    	customerbean.setAmount(amount);
    
    	
    	try {
			if(RegisterDao.deposit(customerbean))
			{
				System.out.println("____");
			response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Amount deposited succesfully');");
            out.println("location='../LoginSuccessHeader.jsp';");
            out.println("</script>");
				
			}
			else {
				System.out.println("____");
			response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Amount deposit failed.Try again.');");
            out.println("location='../deposit.jsp';");
            out.println("</script>");
				
			}
    	}catch(ClassNotFoundException e) {
    		e.printStackTrace();
    	}
    }
}
    	
    	
    	