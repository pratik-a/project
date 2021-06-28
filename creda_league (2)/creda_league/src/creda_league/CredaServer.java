/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creda_league;

/**
 *
 * @author Pratik Awasthi
 */
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import static java.lang.Integer.parseInt;
import java.nio.charset.StandardCharsets;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
public class CredaServer extends UnicastRemoteObject implements creda_interface{

    public CredaServer() throws RemoteException
    {
        
    }
    @Override
    public String user_info(String username, String phoneno, String email, String password,  String filename) throws RemoteException {
        String server_message="";
        InputStream is ;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://usurewgqiwvaihmp:JwlLJn8zcQvfFtJe4zx0@b5oh6hy8kvwqgp0avkac-mysql.services.clever-cloud.com:3306/b5oh6hy8kvwqgp0avkac","usurewgqiwvaihmp","JwlLJn8zcQvfFtJe4zx0");
            //PreparedStatement ps = con.prepareStatement("insert into user_info(username,phone_no,email,password,profile_pic) values (?,?,?,?,?)");
            //is = new FileInputStream(new File(filename));
            String p_sql="select * from user_info where phone_no = '"+phoneno+"'";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(p_sql);//Execute
            if(rs.next())
            {
                server_message = "User Already Exists !!!";
                con.close();
                return server_message;
            }
            PreparedStatement ps = con.prepareStatement("insert into user_info(username,phone_no,email,password,balance,profile_pic) values (?,?,?,?,?,?)");
            is = new FileInputStream(new File(filename));
            
            ps.setString(1, username);
            ps.setString(2, phoneno);
            ps.setString(3, email);
            ps.setString(4,password);
            ps.setString(5,"100");
            ps.setBlob(6,is);
           
            ps.executeUpdate();
            con.close();
            transaction(phoneno);
            
            server_message = "Registered Successfully";
            //To change body of generated methods, choose Tools | Templates.
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CredaServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CredaServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CredaServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return server_message;
    }
    
    public void transaction(String phoneno)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con1 = DriverManager.getConnection("jdbc:mysql://usurewgqiwvaihmp:JwlLJn8zcQvfFtJe4zx0@b5oh6hy8kvwqgp0avkac-mysql.services.clever-cloud.com:3306/b5oh6hy8kvwqgp0avkac","usurewgqiwvaihmp","JwlLJn8zcQvfFtJe4zx0");
            
            DateFormat formatter = new SimpleDateFormat("dd/MM/yy");
            Calendar obj = Calendar.getInstance();
            String str = formatter.format(obj.getTime());
            //System.out.println("Current Date: "+str );
            PreparedStatement ps1 = con1.prepareStatement("insert into transaction(phoneno, credit, date) values (?,?,?)");
            ps1.setString(1,phoneno);
            ps1.setString(2,"100");
            ps1.setString(3,str);
            ps1.executeUpdate();
            con1.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CredaServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CredaServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public String user_login(String phone, String password) throws RemoteException {
        String server_message="";
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://usurewgqiwvaihmp:JwlLJn8zcQvfFtJe4zx0@b5oh6hy8kvwqgp0avkac-mysql.services.clever-cloud.com:3306/b5oh6hy8kvwqgp0avkac","usurewgqiwvaihmp","JwlLJn8zcQvfFtJe4zx0");
            String p_sql="select * from user_info where phone_no = '"+phone+"' and password = '"+password+"'";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(p_sql);//Execute
            if(rs.next())
            {
                server_message = "User Found";
                con.close();
                return server_message;
            }
            else
            {
                server_message = "User Not Found";
                con.close();
                return server_message;
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CredaServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CredaServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return server_message;
    }
    @Override
    public String admin_add_team(String teamname, String filename_image) throws RemoteException {
        String server_message="";
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://usurewgqiwvaihmp:JwlLJn8zcQvfFtJe4zx0@b5oh6hy8kvwqgp0avkac-mysql.services.clever-cloud.com:3306/b5oh6hy8kvwqgp0avkac","usurewgqiwvaihmp","JwlLJn8zcQvfFtJe4zx0");
            String t_sql ="select * from teams where team_name ='"+teamname+"'";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(t_sql);
            if(rs.next())
            {
                System.out.println("Server");
                server_message = "Team Already Exists !!!";
                con.close();
                return server_message;
            }
            PreparedStatement ps = con.prepareStatement("insert into teams(team_name,team_image) values(?,?)");
            InputStream is = new FileInputStream(new File(filename_image));
            ps.setString(1, teamname);
            ps.setBlob(2, is);
            ps.executeUpdate();
            con.close();
            server_message = "Successful Added";
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CredaServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CredaServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CredaServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return server_message;
        
    }
    
    public static void main(String args[]) throws RemoteException
    {
        try
        {
            //Server Networking with RMI
            Registry reg = LocateRegistry.createRegistry(1991);
            reg.rebind("Creda Server",new CredaServer());//Skeleton
            System.out.println("Server is Ready !!!");
        }
        catch(RemoteException e)
        {
            System.out.println("exception"+e);
        }
    }

    @Override
    public String admin_add_player(String playername, String playerteam, String player_type, String filename_image) throws RemoteException {
        String server_message="";
        InputStream is ;
        try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://usurewgqiwvaihmp:JwlLJn8zcQvfFtJe4zx0@b5oh6hy8kvwqgp0avkac-mysql.services.clever-cloud.com:3306/b5oh6hy8kvwqgp0avkac","usurewgqiwvaihmp","JwlLJn8zcQvfFtJe4zx0");
                String p_sql="select * from player_info where player_name = '"+playername+"'";
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(p_sql);//Execute
                if(rs.next())
                {
                    server_message = "Player Already Exists !!!";
                    con.close();
                    return server_message;
                }
                PreparedStatement ps = con.prepareStatement("insert into player_info(player_name,player_team,player_type,player_image) values (?,?,?,?)");
                is = new FileInputStream(new File(filename_image));
                ps.setString(1, playername);
                ps.setString(2, playerteam);
                ps.setString(3, player_type);
                ps.setBlob(4,is);
                ps.executeUpdate();
                
            con.close();
            server_message = "Successful Added";

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CredaServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CredaServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CredaServer.class.getName()).log(Level.SEVERE, null, ex);
        }
          return server_message;  
    }

    @Override
    public String[] team_details() throws RemoteException {
          List<String> values = new ArrayList<String>();
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://usurewgqiwvaihmp:JwlLJn8zcQvfFtJe4zx0@b5oh6hy8kvwqgp0avkac-mysql.services.clever-cloud.com:3306/b5oh6hy8kvwqgp0avkac","usurewgqiwvaihmp","JwlLJn8zcQvfFtJe4zx0");
            String sql ="select team_name from teams";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);//Execute
            int count=0;
            //String[] team_name;
            String[] team = new String[10];
            while(rs.next())
            {
              team[count] = rs.getString("team_name");
              count++;
            }
            
            for(String data: team) {
                if(data != null) { 
                    values.add(data);
                }
            }
            String[] target = values.toArray(new String[values.size()]);
            
            
            
            
            //String[] team = new String[count];
            
            con.close();
            return target;
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CredaServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CredaServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] teams =values.toArray(new String[values.size()]);
        
            return null;
    }

    
    @Override
    public Object getUserDetails(String phoneno) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String transaction_entry(String phoneno, String amount,String totalamt) {
        String server_message="";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://usurewgqiwvaihmp:JwlLJn8zcQvfFtJe4zx0@b5oh6hy8kvwqgp0avkac-mysql.services.clever-cloud.com:3306/b5oh6hy8kvwqgp0avkac","usurewgqiwvaihmp","JwlLJn8zcQvfFtJe4zx0");
            DateFormat formatter = new SimpleDateFormat("dd/MM/yy");
            Calendar obj = Calendar.getInstance();
            String str = formatter.format(obj.getTime());
            PreparedStatement ps = con.prepareStatement("insert into transaction(phoneno,credit,date) values (?,?,?)");
            ps.setString(1, phoneno);
            ps.setString(2, amount);
            ps.setString(3, str);
                ps.executeUpdate();
             
            
            con.close();
            user_info_balance(phoneno,amount,totalamt);
            server_message = "Added Successfully";
                
        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CredaServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CredaServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return server_message;
            
    }

    
public void user_info_balance(String phoneno, String amount,String totalamt)
{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con1 = DriverManager.getConnection("jdbc:mysql://usurewgqiwvaihmp:JwlLJn8zcQvfFtJe4zx0@b5oh6hy8kvwqgp0avkac-mysql.services.clever-cloud.com:3306/b5oh6hy8kvwqgp0avkac","usurewgqiwvaihmp","JwlLJn8zcQvfFtJe4zx0");
            int amt = parseInt(totalamt)+ parseInt(amount);
           
            String str = Integer.toString(amt);
            //System.out.print(str);
            PreparedStatement ps1 = con1.prepareStatement("update user_info set balance = ? where phone_no = ?");
            ps1.setString(1, str);
            ps1.setString(2,phoneno);
            ps1.executeUpdate();
            con1.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CredaServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CredaServer.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    

    /*String server_message="";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://usurewgqiwvaihmp:JwlLJn8zcQvfFtJe4zx0@b5oh6hy8kvwqgp0avkac-mysql.services.clever-cloud.com:3306/b5oh6hy8kvwqgp0avkac","usurewgqiwvaihmp","JwlLJn8zcQvfFtJe4zx0");
            PreparedStatement ps = con.prepareStatement("insert into transaction(phoneno,credit) values (?,?)");
            ps.setString(1, phoneno);
            ps.setString(2, amount);
                ps.executeUpdate();
                
            con.close();
            server_message = "Added Successfully";
                
        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CredaServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CredaServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return server_message;*/
    
}
