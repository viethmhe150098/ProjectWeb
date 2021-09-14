<%-- 
    Document   : Cart
    Created on : Jul 9, 2021, 5:24:06 PM
    Author     : Viet
--%>

<%@page import="entity.Customer"%>
<%@page import="entity.Order"%>
<%@page import="entity.Product"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Cart | E-Shopper</title>
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
        <jsp:include page="header.jsp"></jsp:include><!--/header-->
        <%
            List<Order> list = (List<Order>) request.getAttribute("list");
            Customer cus = (Customer) session.getAttribute("cus");
            double totalBill = 0;
            for (Order order : list) {
                totalBill += order.getPrice() * order.getAmount();
            }
        %>
        <section id="cart_items">
            <div class="container">

                <div class="table-responsive cart_info">
                    <table class="table table-condensed">
                        <thead>
                            <tr class="cart_menu">
                                <td class="image">Item</td>
                                <td class="description"></td>
                                <td class="price">Price</td>
                                <td class="quantity">Quantity</td>
                                <td class="total">Total</td>
                                <td></td>
                            </tr>
                        </thead>
                        <tbody>
                            <% for (Order pro : list) {%>
                            <tr>
                                <td class="cart_product">
                                    <a href=""><img src="images/<%=pro.getImage()%>" alt="" style="height: 110px; width: 110px"></a>
                                </td>
                                <td class="cart_description" style="width: 243.85px">
                                    <h4><a href=""><%=pro.getPname()%></a></h4>
                                    <p><%=pro.getPid()%></p>
                                </td>
                                <td class="cart_price">
                                    <p><%=pro.getPrice()%></p>
                                </td>
                                <td class="cart_quantity">
                                    <div class="cart_quantity_button">
                                        <a class="cart_quantity_down" href="sub?id=<%=pro.getPid()%>"> - </a>

                                        <input class="cart_quantity_input" type="text" name="quantity" value="<%=pro.getAmount()%>" autocomplete="off" size="2">
                                        <a class="cart_quantity_up" href="cart?id=<%=pro.getPid()%>"> + </a>
                                    </div>
                                </td>
                                <td class="cart_total">
                                    <div style="height: 33.6px; width: 200px"><p class="cart_total_price"><%=String.format("%.2f", pro.getPrice() * pro.getAmount())%>$</p></div>
                                </td>
                                <td class="cart_delete">
                                    <a class="cart_quantity_delete" href="remove?id=<%=pro.getPid()%>"><i class="fa fa-times"></i></a>
                                </td>
                            </tr>
                            <%}%>
                            <tr>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td><h2>Total Bill: <%=String.format("%.2f", totalBill)%>$</h2></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </section> <!--/#cart_items-->

        <section id="do_action">
            <div class="container">

                <div class="row">
                    <div class="col-sm-4">
                        <div class="total_area">

                            <ul >

                                <h1 style="text-align: center"><a href="ControllerProduct?service=shop" style="color: black">Keep Shopping</a></h1>

                            </ul>

                        </div>
                    </div>
                    <div class="col-sm-8">
                        <div class="total_area">
                            <ul>
                                <div class="shopper-info">
                                    <% if (cus != null) {%>

                                    <form method="post" action="Checkout?service=checkout">

                                        <h2>Shopper Information</h2>
                                        <input type="hidden" value="<%=cus.getCid()%>" name="cid">
                                        <input type="text" placeholder="Display Name" value="<%=cus.getCname()%>" readonly>
                                        <input type="text" placeholder="User Name" value="<%=cus.getUsername()%>" readonly>
                                        <h2>Bill To</h2>
                                        <input type="text" placeholder="Name" name="name" >
                                        <input type="text" placeholder="Address" name="address">
                                        <input type="text" placeholder="Phone" name="phone">
                                        <div style="text-align: center"><button class="btn-warning btn-lg">
                                                <input type="submit" value="Check Out">
                                            </button></div>                      
                                            <%} else {%>
                                        <h1 style="text-align: center"><a href="login.jsp" style="color: black">Login To Check out</a></h1>
                                        <% }%>
                                    </form>
                                </div>
                        </div>
                    </div>
                </div>

                </ul>

            </div>
        </div>
    </div>
</div>
</section><!--/#do_action-->

<jsp:include page="footer.jsp"></jsp:include>!--/Footer-->



<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.scrollUp.min.js"></script>
<script src="js/jquery.prettyPhoto.js"></script>
<script src="js/main.js"></script>
</body>
</html>
