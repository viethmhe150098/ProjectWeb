<%-- 
    Document   : Account.jsp
    Created on : Jun 25, 2021, 9:37:04 PM
    Author     : Viet
--%>

<%@page import="entity.Bill"%>
<%@page import="java.util.ArrayList"%>
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
            table td{
                width: 50%;
                padding: 10px;
            }
        </style>
    </head><!--/head-->

    <body>
        <%
            Customer add = (Customer) session.getAttribute("cus");
            Customer cus = (Customer) request.getAttribute("cus");
            ArrayList<Bill> listBill = (ArrayList<Bill>) request.getAttribute("listBill");
        %>
        <jsp:include page="header.jsp"></jsp:include>

            <div class="container">
                <div class="row" >
                    <div class="col-sm-6">
                        <h3 style="text-align: center">User information</h3>
                        <table style="margin: 0 auto; font-family: sans-serif; font-size: 16px">
                            <tr>
                                <td>Email</td>
                                <td><%=cus.getEmail()%></td>
                        </tr>
                        <tr>
                            <td>Name</td>
                            <td><%=cus.getCname()%></td>
                        </tr>
                        <tr>
                            <td>Username</td>
                            <td><%=cus.getUsername()%></td>
                        </tr>
                        <tr>
                            <td>
                                <button class="btn-default" style="padding: 5%; " >
                                    <a href="ControllerCustomer?service=update&id=<%=add.getCid()%>" style="text-decoration: none; color: black">Update Information</a>
                                </button>
                            </td>
                            <td>
                                <button class="btn-default" style="padding: 5%; " >
                                    <a href="ControllerCustomer?service=changePass&user=<%=add.getUsername() %>" style="text-decoration: none; color: black">Change Password</a>
                                </button>
                            </td>
                        </tr>
                    </table>
                </div>

                <div class="col-sm-6" >
                    <h3 style="text-align: center">Recent order</h3>
                    <table>
                        <thead>
                            <tr>
                                <th>Order ID</th>
                                <th>Date Create</th>
                                <th>Status</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for (Bill bill : listBill) {%>
                            <tr>
                                <td><%=bill.getOid()%></td>
                                <td><%=bill.getDateCreate()%></td>
                                <td style="padding-left: 0px">
                                    <%if (bill.getStatus() == 1) {%>

                                    <%= "Waiting"%>
                                    <a href="Checkout?service=cancel&oid=<%=bill.getOid()%>">cancel order </a>
                                    <%}
                                        if (bill.getStatus() == 2) {%>     
                                    <%= "Processing"%>
                                    <%}
                                        if (bill.getStatus() == 3) {%>
                                    <%= "Done"%>
                                    <%}
                                        if (bill.getStatus() == 4) {%>
                                    <%= "Canceled"%>
                                    <%}%>
                                </td>
                                <td><a href="ControllerBill?service=viewDetail&oid=<%= bill.getOid()%>">View Detail</a></td>
                            </tr>
                            <%}%>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div

    <jsp:include page="footer.jsp" ></jsp:include>
</html>
