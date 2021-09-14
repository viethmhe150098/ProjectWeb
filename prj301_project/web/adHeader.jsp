<%-- 
    Document   : adHeader
    Created on : Jul 18, 2021, 4:14:39 PM
    Author     : Viet
--%>

<%@page import="entity.Admin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Admin ad = (Admin) session.getAttribute("admin");

        %>
        <header style="padding-bottom: 50px">
            <div class="container">
                <div class="row">
                    <div class="col-sm-4" style="text-align: center"><h3>rollNumber:HE150098</h3></div>
                    <div class="col-sm-4" style="text-align: center"><h3>Welcome: <%=ad.getUser()%></h3></div>
                    <div class="col-sm-4" style="text-align: center"><h3><a href="ControlerAdmin?service=logout" style="color: black">Log Out</a></h3></div>
                </div>
            </div>
        </header>
    </body>
</html>
