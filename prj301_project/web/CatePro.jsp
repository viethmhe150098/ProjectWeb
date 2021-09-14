<%-- 
    Document   : CatePro
    Created on : Jul 7, 2021, 12:15:46 AM
    Author     : Viet
--%>

<%@page import="entity.Product"%>
<%@page import="entity.Category"%>
<%@page import="java.util.ArrayList"%>
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
        <title>Shop | E-Shopper</title>
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
        <%
            ArrayList<Category> list = (ArrayList<Category>) request.getAttribute("listCate");
            ArrayList<Product> listPro = (ArrayList<Product>) request.getAttribute("listPro");
        %>
        <section id="advertisement">
            <div class="container">
                <img src="images/shop/advertisement.jpg" alt="" />
            </div>
        </section>

        <section>
            <div class="container">
                <div class="row">
                    <div class="col-sm-3">
                        <div class="left-sidebar">
                            <h2>Category</h2>
                            <div class="panel-group category-products" id="accordian"><!--category-productsr-->
                                <% for (Category cate : list) {%>
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h4 class="panel-title">
                                            <a  href="ControllerProduct?service=searchbyCate&cateid=<%=cate.getCateid()%>">

                                                <%=cate.getCateName()%>
                                            </a>
                                        </h4>
                                    </div>
                                </div>
                                <%}%>
                            </div>

                            <!--/brands_products-->

                            <!--/shipping-->

                        </div>
                    </div>

                    <div class="col-sm-9 padding-right">
                        <div class="features_items"><!--features_items-->
                            <h2 class="title text-center">Our Products</h2>
                            <% for (Product pro : listPro) {%>
                            <div class="col-sm-4" style="width: 273.15px; height: 417.95px">
                                <div class="product-image-wrapper">
                                    <div class="single-products">
                                        <div class="productinfo text-center" style="height: 387.35px">
                                            <img src="images/<%=pro.getImage()%>" alt="" />
                                            <h2><%=pro.getPrice()%>$</h2>
                                            <div style="height: 40px"><p><%=pro.getPname()%></p></div>
                                            <a href="cart?id=<%=pro.getPid()%>" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
                                        </div>
                                        <div class="product-overlay">
                                            <div class="overlay-content">
                                                <h2><%=pro.getPrice()%>$</h2>
                                                <p><%=pro.getDes()%></p>
                                                <a href="cart?id=<%=pro.getPid()%>" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <%}%>

                        </div>
                        <!--features_items-->
                    </div>
                </div>
            </div>
        </section>

                            <jsp:include page="footer.jsp"></jsp:include>

        </footer>
        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.scrollUp.min.js"></script>
        <script src="js/price-range.js"></script>
        <script src="js/jquery.prettyPhoto.js"></script>
        <script src="js/main.js"></script>
    </body>
</html>
