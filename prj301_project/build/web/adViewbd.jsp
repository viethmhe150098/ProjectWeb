<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : adViewbd
    Created on : Jul 18, 2021, 4:27:48 PM
    Author     : Viet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

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
            tr th{
                width:  200px
            }
        </style>
    </head>
    <body>
        <jsp:include page="adHeader.jsp"></jsp:include>
            <section>

                <div class="container">
                    <h1>Order: ${oid}</h1>
                <p>Order Date: ${dateCreate}</p>
            </div>

            <div class="container">
                <div class="">
                    <h2>Shipping Information</h2>

                    <address>

                        Username: ${username}<br>
                        Receiver: ${receiver}<br>
                        Address: ${address}<br>
                        Phone: ${phone}

                    </address>

                </div>
            </div>
            <div class="container">
                <h2>Products purchased </h2>
                <table border="1px solid balck">

                    <thead>
                        <tr>
                            <th>Product ID</th>
                            <th>Product</th>
                            <th>Price</th>
                            <th>Amount</th>
                            <th>Total</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="o" items="${listO}">
                            <tr>
                                <td>${o.pid}</td>
                                <td>${o.pname}</td>
                                <td>${o.price}</td>
                                <td>${o.amount}</td>
                                <td>${o.price*o.amount}</td>
                            </tr>
                        </c:forEach>
                    </tbody>

                </table>
            </div>
        </div>


    </section>

</body>
</html>
