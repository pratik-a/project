
<!DOCTYPE html>
<html lang="en">
    
<html>
<head>
	<meta charset="utf-8">
	  <meta name="viewport" content="width=device-width, initial-scale=1">
	  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<SCRIPT LANGUAGE="JavaScript">
function dil(form)
{
   if(isNaN(document.F1.amount.value))
   {
       alert("Amount  must  be  number & can't be null")
	   document.F1.amount.value=""
	   document.F1.amount.focus()
	   return false
   }

   return true   
}
</SCRIPT>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Global Banking ..</title>
<link href="style.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
function ctck()
{
var sds = document.getElementById("dum");

}
</script>

</head>

<body>
	<section class="py-5">
        <div class="container d-flex justify-content-center">
           <div class="card col-md-6 p-0">
               <div class="card-header">
                   <div class="card-title text-center w-100"><b>Withdraw Form</b></div>
               </div>
               <div class="card-body">
                   <form action="beans/withdraw" method="post" id="login-client">
                        <div class="form-group">
                            <label for="email" class='control-label'>Account no</label>
	          <%out.println(session.getAttribute("account_no") );	%>	
              <input type="hidden" class="form-control" name="accountno" value='<%= session.getAttribute("account_no") %>'/>				
                           
                        </div>
                        <div class="form-group">
                            <label for="text" class='control-label'>Withdraw Amount</label>
							<input type="text" class="form-control" name="amount" required>
                            
                        </div>
                        <div class="form-group d-flex justify-content-end">
                            <button><a href="LoginSuccessHeader.jsp"> Back</a></button>
                            <button class="btn btn-sm btn-primary btn-flat">Withdraw</button>
                        </div>
                   </form>
               </div>
           </div>
        </div>
    </section>

</body>
</html> 
