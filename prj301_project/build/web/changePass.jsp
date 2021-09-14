<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : changePass
    Created on : Jul 18, 2021, 11:28:02 AM
    Author     : Viet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Login | E-Shopper</title>
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

    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
            <section>
                <div class="container">
                    <form action="ControllerCustomer?service=changedPass" method="POST" class="login-form">
                        <input class="form-control form-control-lg" style="background-color: #F0F0E9; margin-bottom: 10px; padding-bottom: 10px" type="text" name="user" value="${user}" readonly />

                    <input class="form-control form-control-lg" style="background-color: #F0F0E9; margin-bottom: 10px; padding-bottom: 10px" type="password" name="opass" value="" placeholder="Old Password"/>
                    <c:if test="${mess1!=null}">
                        <p>${mess1}</p>
                    </c:if>
                    <input class="form-control form-control-lg" style="background-color: #F0F0E9; margin-bottom: 10px; padding-bottom: 10px" type="password" name="npass" value="" placeholder="New Password"/>
                    <c:if test="${mess2!=null}">
                        <p>${mess2}</p>
                    </c:if>
                    <input class="form-control form-control-lg" style="background-color: #F0F0E9; margin-bottom: 10px; padding-bottom: 10px" type="password" name="cpass" value="" placeholder="Confirm Password"/>
                    <c:if test="${mess3!=null}">
                        <p>${mess3}</p>
                    </c:if>
                    <input class="form-control form-control-lg" style="background-color: #fc9803; margin-bottom: 10px; padding-bottom: 10px; font-weight: bolder "type="submit" value="Save Change">
                </form>
            </div>
            <div class="container">
                <div class="alert alert-danger" role="alert" style="text-align: center; ">
                    After the password is changed, the account will automatically log out
                </div>
            </div>
        </section>
        <jsp:include page="footer.jsp"></jsp:include>
        <script src="js/jquery.js"></script>
        <script src="js/price-range.js"></script>
        <script src="js/jquery.scrollUp.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.prettyPhoto.js"></script>
        <script src="js/main.js"></script>

    </body>

</html>
