<%-- 
    Document   : update
    Created on : Jun 26, 2021, 12:30:07 AM
    Author     : Viet
--%>

<%@page import="entity.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Home | E-Shopper</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/prettyPhoto.css" rel="stylesheet">
        <link href="css/price-range.css" rel="stylesheet">
        <link href="css/animate.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
        <link href="css/responsive.css" rel="stylesheet">
        <!--[if lt IE 9]>
        <script src="js/html5shiv.js"></script>
        <script src="js/respond.min.js"></script>
        <![endif]-->       
        <link rel="shortcut icon" href="images/ico/favicon.ico">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
        <style>
            form{
                margin-left: 40%
            }
        </style>
    </head>
    <body>
        <%
            Customer cus = (Customer) request.getAttribute("cus");
            Customer add = (Customer) session.getAttribute("cus");
        %>
        <!--/header--> 
        <jsp:include page="header.jsp"></jsp:include>
            <section>
                <div  class="container" style="background-color: #d7ded9; margin-bottom: 5%; height: 300px">

                    <form method="post" style="font-size: 20px" action="ControllerCustomer">
                        <input type="hidden" name="id" value="<%=cus.getCid()%>"><br>
                    <label for="Name" >Name</label><br>
                    <input type="text" name="name" value="<%=cus.getCname()%>"><br>
                    <label for="user">Username</label><br>
                    <input type="text" name="user" value="<%=cus.getUsername()%>"><br>
                    <label for="user">Email</label><br>
                    <input type="text" name="email" value="<%=cus.getEmail()%>" readonly><br>
                    <p style="margin-top: 5px; margin-left: 10%"><input type="submit" value="Save" name="submit"/> </p>
                    <input type="hidden" value="updated" name="service"/>
                </form>
            </div>
            <div class="alert alert-danger container" role="alert" style="text-align: center; ">
                After the Information is changed, the account will automatically log out
            </div>
        </section>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
