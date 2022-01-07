package beans;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class transfer extends HttpServlet {
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("--" + request.getParameter("accountno"));
    	
    	int account_no=Integer.parseInt(request.getParameter("accountno"));
		System.out.println("--" + account_no);
    	int account_no2=Integer.parseInt(request.getParameter("accountno2"));
		System.out.println("--" + account_no2);

    	double amount=Double.parseDouble(request.getParameter("amount"));
		System.out.println("--" + amount);

			
    	
    	CustomerBean customerbean=new CustomerBean();
    	customerbean.setAccount_no(account_no);
    	customerbean.setAccount_no2(account_no2);
    	customerbean.setAmount(amount);
    
    	
    	try {
			int i = RegisterDao.transfer(customerbean);
			if(i==1)
			{
			response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Amount transfered succesfully');");
            out.println("location='../LoginSuccessHeader.jsp';");
            out.println("</script>");
				
			}
			else if(i==0) {
					System.out.println("____");
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Amount transfer failed. Try Again.');");
				out.println("location='../transfer.jsp';");
				out.println("</script>");
					
			}else if(i==4){
				System.out.println("____");
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Invalid Account Number.');");
				out.println("location='../transfer.jsp';");
				out.println("</script>");
			}
			else{
				System.out.println("____");
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('InSufficient Balance.');");
				out.println("location='../transfer.jsp';");
				out.println("</script>");
			}
    	}catch(ClassNotFoundException e) {
    		e.printStackTrace();
    	}
    }
}
    	
    	
    	