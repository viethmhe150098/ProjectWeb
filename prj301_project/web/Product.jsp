<%-- 
    Document   : Product.jsp
    Created on : Jun 30, 2021, 10:24:00 PM
    Author     : Viet
--%>

<%@page import="entity.Product"%>
<%@page import="entity.Category"%>

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
            ArrayList<Product> listPro = (ArrayList<Product>) request.getAttribute("listPro");
            int endPage = Integer.parseInt(request.getAttribute("endPage").toString());
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
                    <table border ="1">
                        <thead>
                            <tr>
                                <th>Product ID</th>
                                <th>Product Image</th>
                                <th>Product Name</th>
                                <th>Product Price</th>
                                <th>Product Quantity</th>
                                <th>Product Description</th>
                                <th>Category</th>
                                <th>Status</th>
                                <th>Update</th>
                                <th>Delete</th>
                                
                            </tr>
                        </thead>
                        <tbody>
                            <% for (Product pro : listPro) {%>
                            <tr>
                                <td><%=pro.getPid()%></td>
                                <td><img src="images/<%=pro.getImage()%>" height="50px" width="50px"></td>
                                <td><%=pro.getPname()%></td>
                                <td><%=pro.getPrice()%></td>
                                <td><%=pro.getQuantity()%></td>
                                <td><%=pro.getDes()%></td>
                                <%for (Category cate : listCate) {
                                        if (cate.getCateid() == pro.getCateID()) {
                                %>
                                <td><%=cate.getCateName()%></td>
                                <%      }
                                    }%>
                                <td><%=pro.getStatus() == 1 ? "Selling" : "Stop Selling"%></td>
                                <td><a href="ControllerProduct?service=update&pid=<%=pro.getPid()%>">Update</a></td>
                                <td><a href="ControllerProduct?service=delete&pid=<%=pro.getPid()%>">Delete</a></td>
                                <%if(request.getAttribute("id")!=null){
                                if(request.getAttribute("id").equals(pro.getPid()) ){%>
                                <td><%=request.getAttribute("mess")%></td>
                                <%}
                                }%>
                            </tr>
                            <%}%>
                        </tbody>
                    </table>
                    <div style="text-align: center">
                        <ul class="pagination">
                            <%for (int i = 1; i <= endPage; i++) {%>
                            <li><a href="ControllerProduct?service=displayAll&index=<%=i%>"><%=i%></a></li>
                                <%}%>
                        </ul>
                    </div>
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
