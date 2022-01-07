package beans;
import java.sql.*;

// import javax.swing.plaf.synth.SynthLookAndFeel;  
public class LoginDao {
	public static boolean validate(CustomerBean customer){    
		int count =0;

		int account_no = customer.getAccount_no();
		String password = customer.getPassword();
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/bankdb","root",""  );   
			String sql="select COUNT(*) as count from customer where account_no=? and password=?";
			System.out.println(sql);
			
			
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1,account_no);  
			ps.setString(2,password);  
			ResultSet rs=ps.executeQuery();  
			rs.next(); 
			count = rs.getInt("count");
		
		}catch(Exception e) {
			System.out.println(e);
		}
		return count > 0;
	}  
}
