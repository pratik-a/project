<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="java.sql.*,java.util.*,java.lang.*,java.io.*" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>

 
<% int accountNo = (Integer)session.getAttribute("account_no"); %>
 
<!DOCTYPE html>
    <html lang="en">
        <head>
          <title>Global Banking...</title>
          <meta charset="utf-8">
          <meta name="viewport" content="width=device-width, initial-scale=1">
          <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
          <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
          <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
          <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
          <link href="style.css" rel="stylesheet" type="text/css">

          <script type="text/javascript">
                            
            function validate() {
                if (!document.adduser.phone.value.match(/^\d{10}$/)) {
                    alert("Phone Number Should be 10 digits only");
                    return false;
                }
                else {
                    return true;
                }
            }

          </script>
        </head>
        <body>
       
            <sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
            url="jdbc:mysql://localhost/bankdb" user="root" password="" />

             <sql:query dataSource="${snapshot}" var="result">
                SELECT * from customer WHERE account_no =<%= session.getAttribute("account_no") %>;
              
            </sql:query>
            <c:forEach var="row" items="${result.rows}">
    <section class="py-5">
        <div class="container d-flex justify-content-center">
           <div class="card col-md-6 p-0">
               <div class="card-header">
                   <div class="card-title text-center w-100"><b>Update Details</b></div>
               </div>
               <div class="card-body">
                   <form action="beans/UpdateServlet" name="adduser" method="post" id="login-client">
                      
                    <input type="hidden" class="form-control" name="accountno" value='<%= accountNo %>'/>
                    
                        <div class="form-group">
                            <label for="address" class='control-label'>Address</label>
                            <input type="text" class="form-control" name="address"value="${row.address}" required>
                        </div>
                        <div class="form-group">
                            <label for="phone" class='control-label'>Phone No</label>
                            <input type="number" class="form-control" name="phone"value="${row.phone}" required >
                        </div>
                        <div class="form-group d-flex justify-content-end">
                            <button><a href="LoginSuccessHeader.jsp"> Back</a></button>
                            <input type="submit" name="register" onclick="return validate()">
                        </div>
                   </form>
               </div>
           </div>
        </div>
    </section>
</c:forEach>