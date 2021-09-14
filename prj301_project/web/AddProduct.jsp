<%-- 
    Document   : AddProduct
    Created on : Jul 1, 2021, 3:50:55 PM
    Author     : Viet
--%>

<%@page import="entity.Category"%>
<%@page import="entity.Customer"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entity.Admin"%>
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
            ArrayList<Category> listCate = (ArrayList<Category>) request.getAttribute("listCate");
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
                <div class="col-sm-6">
                    <form action="ControllerProduct" method="POST">
                        <table border="0">
                            <caption><h1>Add Product</h1></caption>
                            <tbody>
                                <tr>
                                    <td>Product ID</td>
                                    <td><input type="text" name="pid" value="" required /></td>
                                </tr>
                                <tr>
                                    <td>Product Name</td>
                                    <td><input type="text" name="pname" value="" required/></td>
                                </tr>
                                <tr>
                                    <td>Quantity</td>
                                    <td><input type="text" name="quantity" value="" required/></td>
                                </tr>
                                <tr>
                                    <td>Price</td>
                                    <td><input type="text" name="price" value="" required/></td>
                                </tr>
                                <tr>
                                    <td>Image</td>
                                    <td><input type="file" name="image" value="" /></td>
                                </tr>
                                <tr>
                                    <td>Description</td>
                                    <td><input type="text" name="description" value="" required/></td>
                                </tr>
                                <tr>
                                    <td>Status</td>
                                    <td><input type="radio" name="status" value="1" checked/>Enable
                                        <input type="radio" name="status" value="0"/>Disable</td>
                                </tr>
                                <tr>
                                    <td>Category</td>
                                    <td><select name="cate">
                                            <%for (Category cate : listCate) {%> 
                                            <option value="<%=cate.getCateid()%>"> <%=cate.getCateName()%> </option>
                                            <%}%>
                                        </select>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                        <p><input type="submit" value="Add" name="submit"/>  
                            <input type="reset" value="Reset"/></p>
                        <input type="hidden" value="add" name="service"/>
                        <%if (request.getAttribute("dupID") != null) {%>
                        <p><%=request.getAttribute("dupID")%></p>
                        <%}%>
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