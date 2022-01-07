<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <!DOCTYPE html>
    <html lang="en">
        <head>
          <title>Global Banking</title>
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
                   <div class="card-title text-center w-100"><b>Login</b></div>
               </div>
               <div class="card-body">
                   <form action="beans/LoginServlet"  method="post" id="login-client">
                        <div class="form-group">
                            <label for="account_no" class='control-label'>Account no</label>
                            <input type="number" class="form-control" name="account_no" required>
                        </div>
                        <div class="form-group">
                            <label for="password" class='control-label'>Password</label>
                            <input type="password" class="form-control" name="password" required>
                        </div>
                        <div class="form-group d-flex justify-content-end">
                            <button class="btn btn-sm btn-primary btn-flat">Login</button>
                        </div>
                   </form>
               </div>
           </div>
        </div>
    </section>