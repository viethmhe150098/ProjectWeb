<%-- 
    Document   : home
    Created on : Jun 13, 2021, 2:26:39 PM
    Author     : Viet
--%>

<%@page import="entity.Banner"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="entity.Product"%>
<%@page import="entity.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entity.Customer"%>
<%@page import="entity.Admin"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
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
    </head><!--/head-->

    <body>
        <%
            Customer cus = (Customer) session.getAttribute("cus");
            ArrayList<Product> listPro = (ArrayList<Product>) request.getAttribute("listPro");
            ArrayList<Category> list = (ArrayList<Category>) request.getAttribute("listCate");
            ArrayList<Banner> listBan = (ArrayList<Banner>) request.getAttribute("listBan");
        %>
        <
        <jsp:include page="header.jsp"></jsp:include>
            <section id="slider"><!--slider-->
                <div class="container">
                    <div class="row">
                        <div class="col-sm-12">
                            <div id="slider-carousel" class="carousel slide" data-ride="carousel">
                                <ol class="carousel-indicators">
                                    <li data-target="#slider-carousel" data-slide-to="0" class="active"></li>
                                    <li data-target="#slider-carousel" data-slide-to="1"></li>
                                    <li data-target="#slider-carousel" data-slide-to="2"></li>
                                </ol>

                                <div class="carousel-inner">

                                    <div class="item active">                                      
                                        <img src="images/Banner/the-body-shop-4.jpg" style="height: 378.75px;width: 925px; text-align: center" class="girl img-responsive" alt="" />                        
                                    </div>

                                    <div class="item">
                                        <img src="images/Banner/the-body-shop-homepage.jpg" style="height: 378.75px;width: 925px" class="girl img-responsive" alt="" />
                                    </div>
                                    <div class="item">
                                        <img src="images/Banner/teatree.jpg" style="height: 378.75px;width: 925px" class="girl img-responsive" alt="" />
                                    </div>


                                </div>

                                <a href="#slider-carousel" class="left control-carousel hidden-xs" data-slide="prev">
                                    <i class="fa fa-angle-left"></i>
                                </a>
                                <a href="#slider-carousel" class="right control-carousel hidden-xs" data-slide="next">
                                    <i class="fa fa-angle-right"></i>
                                </a>
                            </div>

                        </div>
                    </div>
                </div>
            </section><!--/slider-->

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
                            </div><!--/category-products-->

                            <!--/brands_products-->
                            <div class="shipping text-center"><!--shipping-->
                                <img src="images/home/shipping.jpg" alt="" />
                            </div><!--/shipping-->

                        </div>
                    </div>

                    <div class="col-sm-9 padding-right">
                        <div class="features_items"><!--features_items-->
                            <h2 class="title text-center">Features Items</h2>
                            <% for (Product pro : listPro) {%>
                            <div class="col-sm-4" style="width: 273.15px; height: 417.95px">
                                <div class="product-image-wrapper">
                                    <div class="single-products">
                                        <div class="productinfo text-center" style="height: 387.35px">
                                            <img src="images/<%=pro.getImage()%>" alt="" />

                                            <h2><%= pro.getPrice()%>$</h2>
                                            <div style="height: 40px"><p><%=pro.getPname()%></p></div>
                                            <a href="cart?id=<%=pro.getPid()%>" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
                                        </div>
                                        <div class="product-overlay">
                                            <div class="overlay-content">
                                                <h2><%= pro.getPrice()%>$</h2>
                                                <p><%=pro.getPname()%></p>
                                                <a href="cart?id=<%=pro.getPid()%>" class="btn btn-default add-to-cart"><i class="fa fa-shopping-cart"></i>Add to cart</a>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </div>
                            <%}%>





                        </div><!--features_items-->





                    </div>
                </div>
            </div>
        </section>

        <jsp:include page="footer.jsp"></jsp:include>



        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.scrollUp.min.js"></script>
        <script src="js/price-range.js"></script>
        <script src="js/jquery.prettyPhoto.js"></script>
        <script src="js/main.js"></script>
    </body>
</html>