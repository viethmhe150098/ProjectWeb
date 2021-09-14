package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import entity.Admin;

public final class AddBanner_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <meta name=\"description\" content=\"\">\n");
      out.write("        <meta name=\"author\" content=\"\">\n");
      out.write("        <title>Home | E-Shopper</title>\n");
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"css/font-awesome.min.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"css/prettyPhoto.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"css/price-range.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"css/animate.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"css/main.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"css/responsive.css\" rel=\"stylesheet\">\n");
      out.write("        <!--[if lt IE 9]>\n");
      out.write("        <script src=\"js/html5shiv.js\"></script>\n");
      out.write("        <script src=\"js/respond.min.js\"></script>\n");
      out.write("        <![endif]-->       \n");
      out.write("        <link rel=\"shortcut icon\" href=\"images/ico/favicon.ico\">\n");
      out.write("        <link rel=\"apple-touch-icon-precomposed\" sizes=\"144x144\" href=\"images/ico/apple-touch-icon-144-precomposed.png\">\n");
      out.write("        <link rel=\"apple-touch-icon-precomposed\" sizes=\"114x114\" href=\"images/ico/apple-touch-icon-114-precomposed.png\">\n");
      out.write("        <link rel=\"apple-touch-icon-precomposed\" sizes=\"72x72\" href=\"images/ico/apple-touch-icon-72-precomposed.png\">\n");
      out.write("        <link rel=\"apple-touch-icon-precomposed\" href=\"images/ico/apple-touch-icon-57-precomposed.png\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            Admin ad = (Admin) session.getAttribute("admin");

        
      out.write("\n");
      out.write("        <div class=\"header\">\n");
      out.write("            <div style=\"width: 50%; float: left;padding-bottom: 50px\"><h3>rollNumber:HE150098</h3></div>\n");
      out.write("            <div style=\"width: 50%; float: right;padding-bottom:  50px\"><h3>Welcome: ");
      out.print(ad.getUser());
      out.write("</h3></div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <section>\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"col-sm-3\">\n");
      out.write("                    <div class=\"left-sidebar\">\n");
      out.write("                        <h2>Menu</h2>\n");
      out.write("                        <div class=\"panel-group category-products\" id=\"accordian\">\n");
      out.write("                            <div class=\"panel panel-default\">\n");
      out.write("                                <div class=\"panel-heading\">\n");
      out.write("                                    <h4 class=\"panel-title\">\n");
      out.write("                                        <a data-toggle=\"collapse\" data-parent=\"#accordian\" href=\"#sportswear\">\n");
      out.write("                                            <span class=\"badge pull-right\"><i class=\"fa fa-plus\"></i></span>\n");
      out.write("                                            Product Management\n");
      out.write("                                        </a>\n");
      out.write("                                    </h4>\n");
      out.write("                                </div>\n");
      out.write("                                <div id=\"sportswear\" class=\"panel-collapse collapse\">\n");
      out.write("                                    <div class=\"panel-body\">\n");
      out.write("                                        <ul>\n");
      out.write("                                            <li><a href=\"ControllerProduct?service=preAdd\">Add New Prodcut </a></li>\n");
      out.write("\n");
      out.write("                                            <li><a href=\"ControllerProduct?service=displayAll\">Display All Product </a></li>\n");
      out.write("                                        </ul>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"panel panel-default\">\n");
      out.write("                                <div class=\"panel-heading\">\n");
      out.write("                                    <h4 class=\"panel-title\">\n");
      out.write("                                        <a data-toggle=\"collapse\" data-parent=\"#accordian\" href=\"#mens\">\n");
      out.write("                                            <span class=\"badge pull-right\"><i class=\"fa fa-plus\"></i></span>\n");
      out.write("                                            Category Management\n");
      out.write("                                        </a>\n");
      out.write("                                    </h4>\n");
      out.write("                                </div>\n");
      out.write("                                <div id=\"mens\" class=\"panel-collapse collapse\">\n");
      out.write("                                    <div class=\"panel-body\">\n");
      out.write("                                        <ul>\n");
      out.write("                                            <li><a href=\"ControllerCategory?service=preAdd\">Add New Category</a></li>\n");
      out.write("\n");
      out.write("                                            <li><a href=\"ControllerCategory?service=displayAll\">Display All Category</a></li>\n");
      out.write("                                        </ul>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"panel panel-default\">\n");
      out.write("                                <div class=\"panel-heading\">\n");
      out.write("                                    <h4 class=\"panel-title\"><a href=\"ControllerCustomer?service=displayAll\">Customer Management</a></h4>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"panel panel-default\">\n");
      out.write("                                <div class=\"panel-heading\">\n");
      out.write("                                    <h4 class=\"panel-title\"><a href=\"#\">Bill Management</a></h4>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"panel panel-default\">\n");
      out.write("                            <div class=\"panel-heading\">\n");
      out.write("                                <h4 class=\"panel-title\">\n");
      out.write("                                    <a data-toggle=\"collapse\" data-parent=\"#accordian\" href=\"#mens\">\n");
      out.write("                                        <span class=\"badge pull-right\"><i class=\"fa fa-plus\"></i></span>\n");
      out.write("                                        Banner Management\n");
      out.write("                                    </a>\n");
      out.write("                                </h4>\n");
      out.write("                            </div>\n");
      out.write("                            <div id=\"mens\" class=\"panel-collapse collapse\">\n");
      out.write("                                <div class=\"panel-body\">\n");
      out.write("                                    <ul>\n");
      out.write("                                        <li><a href=\"ControllerBanner?service=preAdd\">Add New Banner</a></li>\n");
      out.write("\n");
      out.write("                                        <li><a href=\"ControllerBanner?service=displayAll\">Display All Banner</a></li>\n");
      out.write("                                    </ul>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-sm-6\">\n");
      out.write("                    <form action=\"ControllerCategory\" method=\"POST\">\n");
      out.write("                        <table border=\"0\">\n");
      out.write("                            <caption><h1>Add Banner</h1></caption>\n");
      out.write("                            <tbody>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>Banner Name</td>\n");
      out.write("                                    <td><input type=\"text\" name=\"bname\" value=\"\" required/></td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>Banner Image</td>\n");
      out.write("                                    <td><input type=\"file\" name=\"bimages\" value=\"\" required/></td>\n");
      out.write("                                </tr>\n");
      out.write("                            </tbody>\n");
      out.write("                        </table>\n");
      out.write("                        <p><input type=\"submit\" value=\"Add\" name=\"submit\"/>  \n");
      out.write("                            <input type=\"reset\" value=\"Reset\"/></p>\n");
      out.write("                        <input type=\"hidden\" value=\"add\" name=\"service\"/>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </section>\n");
      out.write("        <script src=\"js/jquery.js\"></script>\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"js/jquery.scrollUp.min.js\"></script>\n");
      out.write("        <script src=\"js/price-range.js\"></script>\n");
      out.write("        <script src=\"js/jquery.prettyPhoto.js\"></script>\n");
      out.write("        <script src=\"js/main.js\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
