package beans;

import java.sql.Connection;
import java.sql.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import beans.CustomerBean;
import beans.withdraw;

public class RegisterDao {
	public static int withdrawAmount ;

	public static boolean registerCustomer(CustomerBean customer) throws ClassNotFoundException {

		int accountno=customer.getAccount_no();
		String username = customer.getUsername();
		String password = customer.getPassword();
		String emailid = customer.getEmail();
		String address = customer.getAddress();
		double amount = customer.getAmount();
		String phone = customer.getPhone();
                                 

		int count = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bankdb", "root", "");
			Statement st = con.createStatement();
			String sql = "insert into customer(account_no,username,password,email,address,phone)VALUES('" + accountno + "','" + username + "','" + password + "','" + emailid + "','" + address + "','" + phone + "')";
			int res = st.executeUpdate(sql);
                                                    if (res > 0) {
				return true;
			}

		} catch (Exception e) {
			System.out.println(e);
		}
                                  return false;
	}

	public static boolean validate(CustomerBean customer){    
		int count =0;
                                   int account_no=customer.getAccount_no();	
		String address = customer.getAddress();
		String phone = customer.getPhone();
		
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/bankdb","root",""  );   
			String sql="Update customer set address=? , phone=? where account_no=?";
			System.out.println(sql);
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,address);  
			ps.setString(2,phone); 
			ps.setInt(3, account_no); 
			count=ps.executeUpdate();  
		}catch(Exception e) {
			e.printStackTrace();
		}
		return count > 0;
	}  

	public static boolean deposit(CustomerBean customer) throws ClassNotFoundException {

		int account_no = customer.getAccount_no();	
		double amount = customer.getAmount();
		double amt =amount;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                                   Date dateobj = new Date(); 
                                   String date=df.format(dateobj);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bankdb", "root", "");
			String sql="select amount from customer where account_no=?";
			System.out.println(sql);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,account_no);  
		                 ResultSet rs=ps.executeQuery();  
			rs.next(); 
			int amountDB = rs.getInt("amount");
		                 if(amountDB>0){
				amount = amount+amountDB;
				sql="Update customer set amount = "+ amount +" where account_no = " +account_no  ;
                                                                      ps = con.prepareStatement(sql);
                                                                      int rs2 = ps.executeUpdate(sql);
			                  if (rs2 > 0) {
			                                   sql = "insert into transaction(account_no,transaction_type,amount,date)VALUES('" + account_no
				                  + "','" + "Deposit" + "','" + amt + "','" + date + "')";
				                  ps = con.prepareStatement(sql);
				                  int rs3 = ps.executeUpdate(sql);
				                  return true;
			                  }
		                 }

		} catch (Exception e) {
			System.out.println(e);
		
		}

		return false;
	}

	// if balance not exist = -1
	// if sucess = 1
	// if fail = 0
	public static int withdraw(CustomerBean customer) throws ClassNotFoundException {

		int account_no = customer.getAccount_no();
		double amount = customer.getAmount();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                                   Date dateobj = new Date(); 
                                   String date=df.format(dateobj);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bankdb", "root", "");
			String sql="select amount from customer where account_no=?";
			System.out.println(sql);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,account_no);  
		                 ResultSet rs=ps.executeQuery();  
			rs.next(); 
			int amountDB = rs.getInt("amount");
			if(amount>amountDB){
				return -1;
			}
                                                    withdrawAmount = amountDB;
                                                    if(amountDB>0){
				amountDB -=amount;
				sql="Update customer set amount = " + amountDB +" where account_no =" +account_no  ;
				ps = con.prepareStatement(sql);
                                                                     int rs2 = ps.executeUpdate(sql);
			                 if (rs2 > 0) {
				                  sql = "insert into transaction(account_no,transaction_type,amount,date)VALUES('" + account_no
				                   + "','" + "Withdraw" + "','" + amount + "','" + date + "')";
				                   ps = con.prepareStatement(sql);
				                   int rs3 = ps.executeUpdate(sql);
				                   return 1;
			                  }
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return 0;
	}

	
	public static int transfer(CustomerBean customer) throws ClassNotFoundException {

		int account_no2 = customer.getAccount_no2();
		int account_no = customer.getAccount_no();
		double amount = customer.getAmount(); 
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                                  Date dateobj = new Date(); 
                                  String date=df.format(dateobj);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bankdb", "root", "");
			String sql="select Count(*) as count from customer where account_no=?"; 
			System.out.println(sql);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,account_no2);  
		                 ResultSet rs=ps.executeQuery();  
			rs.next(); 
		                 int acno= rs.getInt("count");
			System.out.println("Count after " + acno);
			if(acno==0){
				return 4;
			}
                                                    sql="select amount from customer where account_no=?"; 
			System.out.println(sql);
			ps = con.prepareStatement(sql);
			ps.setInt(1,account_no);  
		                  rs=ps.executeQuery();  
			rs.next(); 
			int amountDB = rs.getInt("amount");
			if(amount>amountDB){
				return -1;
			}
		                 if(amountDB>0){
				amountDB -=amount; 
				sql="Update customer set amount = " + amountDB +" where account_no =" +account_no  ;
				ps = con.prepareStatement(sql);
                                                                     int rs2 = ps.executeUpdate(sql);
			                 if (rs2 > 0) {
				                  sql="select amount from customer where account_no=?";
				                  System.out.println(sql);
			                                    ps = con.prepareStatement(sql);
				                   ps.setInt(1,account_no2);
                                                                                        rs=ps.executeQuery();  
				                   rs.next(); 
				                   int amountDB2 = rs.getInt("amount");
                                                                                        if(amountDB2>0){
					 amountDB2 +=amount;
					 sql="Update customer set amount = " + amountDB2 +" where account_no = " +account_no2  ;
					 ps = con.prepareStatement(sql);
	                                                                       rs2 = ps.executeUpdate(sql);
				if (rs2 > 0) {
                                                                                      sql = "insert into transaction(account_no,transaction_type,amount,date)VALUES('" + account_no
					+ "','" + "Withdraw" + "','" + amount + "','" + date + "')";
					ps = con.prepareStatement(sql);
					int rs4 = ps.executeUpdate(sql);
                                                                                       sql = "insert into transaction(account_no,transaction_type,amount,date)VALUES('" + account_no2
				                  + "','" + "Deposit" + "','" + amount + "','" + date + "')";
				                  ps = con.prepareStatement(sql);
				                  int rs3 = ps.executeUpdate(sql);
                                                                                       return 1;
				}
			}}}

		} catch (Exception e) {
			System.out.println(e);
		}

		return 0;
	}
}