package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class footer_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    \n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <meta name=\"description\" content=\"\">\n");
      out.write("        <meta name=\"author\" content=\"\">\n");
      out.write("        <title>Cart | E-Shopper</title>\n");
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
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <footer id=\"footer\"><!--Footer-->\n");
      out.write("        <div class=\"footer-top\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-sm-2\">\n");
      out.write("                        <div class=\"companyinfo\">\n");
      out.write("                            <h2><span>e</span>-shopper</h2>\n");
      out.write("                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,sed do eiusmod tempor</p>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-7\">\n");
      out.write("                        <div class=\"col-sm-3\">\n");
      out.write("                            <div class=\"video-gallery text-center\">\n");
      out.write("                                <a href=\"#\">\n");
      out.write("                                    <div class=\"iframe-img\">\n");
      out.write("                                        <img src=\"images/home/iframe1.png\" alt=\"\" />\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"overlay-icon\">\n");
      out.write("                                        <i class=\"fa fa-play-circle-o\"></i>\n");
      out.write("                                    </div>\n");
      out.write("                                </a>\n");
      out.write("                                <p>Circle of Hands</p>\n");
      out.write("                                <h2>24 DEC 2014</h2>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"col-sm-3\">\n");
      out.write("                            <div class=\"video-gallery text-center\">\n");
      out.write("                                <a href=\"#\">\n");
      out.write("                                    <div class=\"iframe-img\">\n");
      out.write("                                        <img src=\"images/home/iframe2.png\" alt=\"\" />\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"overlay-icon\">\n");
      out.write("                                        <i class=\"fa fa-play-circle-o\"></i>\n");
      out.write("                                    </div>\n");
      out.write("                                </a>\n");
      out.write("                                <p>Circle of Hands</p>\n");
      out.write("                                <h2>24 DEC 2014</h2>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"col-sm-3\">\n");
      out.write("                            <div class=\"video-gallery text-center\">\n");
      out.write("                                <a href=\"#\">\n");
      out.write("                                    <div class=\"iframe-img\">\n");
      out.write("                                        <img src=\"images/home/iframe3.png\" alt=\"\" />\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"overlay-icon\">\n");
      out.write("                                        <i class=\"fa fa-play-circle-o\"></i>\n");
      out.write("                                    </div>\n");
      out.write("                                </a>\n");
      out.write("                                <p>Circle of Hands</p>\n");
      out.write("                                <h2>24 DEC 2014</h2>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"col-sm-3\">\n");
      out.write("                            <div class=\"video-gallery text-center\">\n");
      out.write("                                <a href=\"#\">\n");
      out.write("                                    <div class=\"iframe-img\">\n");
      out.write("                                        <img src=\"images/home/iframe4.png\" alt=\"\" />\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"overlay-icon\">\n");
      out.write("                                        <i class=\"fa fa-play-circle-o\"></i>\n");
      out.write("                                    </div>\n");
      out.write("                                </a>\n");
      out.write("                                <p>Circle of Hands</p>\n");
      out.write("                                <h2>24 DEC 2014</h2>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-3\">\n");
      out.write("                        <div class=\"address\">\n");
      out.write("                            <img src=\"images/home/map.png\" alt=\"\" />\n");
      out.write("                            <p>505 S Atlantic Ave Virginia Beach, VA(Virginia)</p>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"footer-widget\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-sm-2\">\n");
      out.write("                        <div class=\"single-widget\">\n");
      out.write("                            <h2>Service</h2>\n");
      out.write("                            <ul class=\"nav nav-pills nav-stacked\">\n");
      out.write("                                <li><a href=\"\">Online Help</a></li>\n");
      out.write("                                <li><a href=\"\">Contact Us</a></li>\n");
      out.write("                                <li><a href=\"\">Order Status</a></li>\n");
      out.write("                                <li><a href=\"\">Change Location</a></li>\n");
      out.write("                                <li><a href=\"\">FAQ’s</a></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-2\">\n");
      out.write("                        <div class=\"single-widget\">\n");
      out.write("                            <h2>Quock Shop</h2>\n");
      out.write("                            <ul class=\"nav nav-pills nav-stacked\">\n");
      out.write("                                <li><a href=\"\">T-Shirt</a></li>\n");
      out.write("                                <li><a href=\"\">Mens</a></li>\n");
      out.write("                                <li><a href=\"\">Womens</a></li>\n");
      out.write("                                <li><a href=\"\">Gift Cards</a></li>\n");
      out.write("                                <li><a href=\"\">Shoes</a></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-2\">\n");
      out.write("                        <div class=\"single-widget\">\n");
      out.write("                            <h2>Policies</h2>\n");
      out.write("                            <ul class=\"nav nav-pills nav-stacked\">\n");
      out.write("                                <li><a href=\"\">Terms of Use</a></li>\n");
      out.write("                                <li><a href=\"\">Privecy Policy</a></li>\n");
      out.write("                                <li><a href=\"\">Refund Policy</a></li>\n");
      out.write("                                <li><a href=\"\">Billing System</a></li>\n");
      out.write("                                <li><a href=\"\">Ticket System</a></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-2\">\n");
      out.write("                        <div class=\"single-widget\">\n");
      out.write("                            <h2>About Shopper</h2>\n");
      out.write("                            <ul class=\"nav nav-pills nav-stacked\">\n");
      out.write("                                <li><a href=\"\">Company Information</a></li>\n");
      out.write("                                <li><a href=\"\">Careers</a></li>\n");
      out.write("                                <li><a href=\"\">Store Location</a></li>\n");
      out.write("                                <li><a href=\"\">Affillate Program</a></li>\n");
      out.write("                                <li><a href=\"\">Copyright</a></li>\n");
      out.write("                            </ul>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-3 col-sm-offset-1\">\n");
      out.write("                        <div class=\"single-widget\">\n");
      out.write("                            <h2>About Shopper</h2>\n");
      out.write("                            <form action=\"#\" class=\"searchform\">\n");
      out.write("                                <input type=\"text\" placeholder=\"Your email address\" />\n");
      out.write("                                <button type=\"submit\" class=\"btn btn-default\"><i class=\"fa fa-arrow-circle-o-right\"></i></button>\n");
      out.write("                                <p>Get the most recent updates from <br />our site and be updated your self...</p>\n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"footer-bottom\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <p class=\"pull-left\">Copyright © 2013 E-SHOPPER Inc. All rights reserved.</p>\n");
      out.write("                    <p class=\"pull-right\">Designed by <span><a target=\"_blank\" href=\"http://www.themeum.com\">Themeum</a></span></p>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </footer><!--/Footer-->\n");
      out.write("    <script src=\"js/jquery.js\"></script>\n");
      out.write("    <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("    <script src=\"js/jquery.scrollUp.min.js\"></script>\n");
      out.write("    <script src=\"js/jquery.prettyPhoto.js\"></script>\n");
      out.write("    <script src=\"js/main.js\"></script>\n");
      out.write("</body>\n");
      out.write("</html>\n");
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
