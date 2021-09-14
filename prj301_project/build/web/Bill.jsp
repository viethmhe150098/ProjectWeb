<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : Bill
    Created on : Jul 17, 2021, 8:01:14 PM
    Author     : Viet
--%>

<%@page import="entity.Admin"%>
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
    </head>
    <body>
        <%
            Admin ad = (Admin) session.getAttribute("admin");
        %>
        <jsp:include page="adHeader.jsp"></jsp:include>
        <section>
            <div class="container">
                <div class="col-sm-3">
                    <div class="left-sidebar">
                        <h2>Menu</h2>
                        <div class="panel-group category-products" id="accordian">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h4 class="panel-title">
                                        <a data-toggle="collapse" data-parent="#accordian" href="#sportswear">
                                            <span class="badge pull-right"><i class="fa fa-plus"></i></span>
                                            Product Management
                                        </a>
                                    </h4>
                                </div>
                                <div id="sportswear" class="panel-collapse collapse">
                                    <div class="panel-body">
                                        <ul>
                                            <li><a href="ControllerProduct?service=preAdd">Add New Prodcut </a></li>

                                            <li><a href="ControllerProduct?service=displayAll">Display All Product </a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h4 class="panel-title">
                                        <a data-toggle="collapse" data-parent="#accordian" href="#mens">
                                            <span class="badge pull-right"><i class="fa fa-plus"></i></span>
                                            Category Management
                                        </a>
                                    </h4>
                                </div>
                                <div id="mens" class="panel-collapse collapse">
                                    <div class="panel-body">
                                        <ul>
                                            <li><a href="ControllerCategory?service=preAdd">Add New Category</a></li>

                                            <li><a href="ControllerCategory?service=displayAll">Display All Category</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h4 class="panel-title"><a href="ControllerCustomer?service=displayAll">Customer Management</a></h4>
                                </div>
                            </div>
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h4 class="panel-title"><a href="ControllerBill?service=getAll">Bill Management</a></h4>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-sm-9">
                    <form method="post" action="ControllerBill?service=upSta">
                        <table border="1">
                            <thead>
                                <tr>
                                    <th>Customer ID</th>
                                    <th>Order ID</th>
                                    <th>Bill To</th>
                                    <th>Address</th>
                                    <th>Phone</th>
                                    <th>Date Create</th>
                                    <th>Total</th>
                                    <th>Status</th>
                                    <th>Update Status</th>
                                    <th>View Detail</th>
                                </tr>
                            </thead>
                            <tbody>
                                    <c:forEach var="o" items="${listb}">
                                        <tr>
                                        <td>${o.cid}</td>
                                        <td><input type="text" name="oid" value="${o.oid}" readonly="readonly" style="border: 0px"/></td>
                                        <td>${o.cname}</td>
                                        <td>${o.caddress}</td>
                                        <td>${o.cphone}</td>
                                        <td>${o.dateCreate}</td>
                                        <td>${o.total}</td>
                                        <td>
                                            <select name="status">
                                                <option value="1" ${o.status==1?"selected":""}>Processing</option>
                                                <option value="2" ${o.status==2?"selected":""}>Waiting</option>
                                                <option value="3" ${o.status==3?"selected":""}>Done</option>
                                                <option value="4" ${o.status==4?"selected":""}>Canceled</option>
                                            </select>
                                        </td>
                                        <td><input type="submit" value="Update"></td>
                                        <td><a href="ControllerBill?service=adViewDe&id=${o.oid}">View Detail</a></td>
                                        </tr>
                                    </c:forEach>
                            </tbody>
                        </table>
                    </form>
                </div>
            </div>
        </section>
        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.scrollUp.min.js"></script>
        <script src="js/price-range.js"></script>
        <script src="js/jquery.prettyPhoto.js"></script>
        <script src="js/main.js"></script>
    </body>
</html>