<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
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
                
                
                var pass = document.getElementById("password").value
                var confPass = document.getElementById("cpassword").value
             
                if (!document.adduser.username.value.match(/^[a-zA-Z- ']+$/) || document.adduser.username.value.length > 50) {
                    alert("Please Enter Valid Username");
                    return false;
                }
                else if (!document.adduser.email.value.match(/^\w+([\.-]?\w+)@\w+([\.-]?\w+)(\.\w{2,3})+$/)) {
                    alert("Please Enter Valid Email Address");
                    return false;
                }
                else if (!document.adduser.password.value.match(/^((?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[\W]).{6,20})/)) {
                    alert("Password Must contain at least one number,one uppercase and one lowercase letter, and at least 8 or more characters");
                    return false;
                }
                else  if(pass != confPass) {
                    alert("Password and Confirm Password does not match");
                    return false;
                }
                else if (!document.adduser.phone.value.match(/^\d{10}$/)) {
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
           <section class="py-5">
               <div class="container d-flex justify-content-center">
               <div class="card col-md-6 p-0">
               <div class="card-header">
               <div class="card-title text-center w-100"><b>Registration</b></div>
               </div>
               <div class="card-body">
                   <form action="beans/RegisterServlet" name="adduser"  method="post" >
                    <div class="form-group">
                        <label for="account_no" class='control-label'>Account No<font color="red">*</font></label>
                        <input type="number" class="form-control" name="account_no" required>
                    </div>    
                    <div class="form-group">
                            <label for="username" class='control-label'>Username<font color="red">*</font></label>              
                            <input type="text" class="form-control" name="username" required>
                        </div>
                        <div class="form-group">
                            <label for="email" class='control-label'>Email<font color="red">*</font></label>
                            <input type="text" class="form-control" name="email" required>
                        </div>
                        <div class="form-group">
                            <label for="password" class='control-label'>Password<font color="red">*</font></label>
                            <input type="password" id="password" class="form-control" name="password" required>
                        </div>
                        <div class="form-group">
                            <label for="cpassword" class='control-label'>Confirm Password<font color="red">*</font></label>
                            <input type="password" id="cpassword" class="form-control" name="cpassword" required>
                        </div>
                       
                        <div class="form-group">
                            <label for="address" class='control-label'>Address<font color="red">*</font></label>
                            <input type="text" class="form-control" name="address" required>
                        </div>

                        <div class="form-group">
                            <label for="phone" class='control-label'>Phone<font color="red">*</font></label>
                            <input type="number" class="form-control" name="phone" required>
                        </div>                        
                        <div class="form-group d-flex justify-content-end">
                            <input type="submit" name="register" value="Register" onclick="return validate()">
                        </div>
                        
                   </form>
                   
                    
                
               </div>
           </div>
        </div>
    </section>
    </body>
</html>