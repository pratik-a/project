<%@ page language="java" contentType= "text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>

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
        </head>
        <body>
        

         
    <section class="py-5">
        <div class="container d-flex justify-content-center">
           <div class="card col-md-6 p-0">
               <div class="card-header">
                 
                    <center><b>Account  Balance</b></center>
               </div>
               <div class="card-body">
                <div class="form-group">
                    
            <sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
            url="jdbc:mysql://localhost/bankdb" user="root" password="" />

             <sql:query dataSource="${snapshot}" var="result">
                SELECT account_no,username,amount from customer WHERE account_no =<%= session.getAttribute("account_no") %>;
              
            </sql:query>
            <table id="example" class="display responsive-table ">
            <c:forEach var="row" items="${result.rows}">
                <tr>                       
                    <th>Account No</th>
                    <td><c:out value="${row.account_no}" />                                   
                </tr>
                 <tr>                       
                    <th>Username</th>
                    <td><c:out value="${row.username}"/>                                       
                </tr>
                <tr>                       
                    <th>Balance</th>
                    <td><c:out value="${row.amount}"/>                                       
                </tr>
            </c:forEach>
            </table>
                </div>
                <div class="form-group d-flex justify-content-end">
                    <button ><a href="LoginSuccessHeader.jsp"> Back</a></button>
                  
               </div>
               </div>
           </div>
            
        </div>
       
    </section>
                                  