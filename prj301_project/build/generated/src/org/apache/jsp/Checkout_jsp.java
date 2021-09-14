package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import entity.Order;
import entity.Customer;

public final class Checkout_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            List<Order> list = (List<Order>) request.getAttribute("list");
            Customer cus = (Customer) session.getAttribute("cus");
        
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\n");
      out.write("            <section id=\"cart_items\">\n");
      out.write("                <div class=\"container\">\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <div class=\"shopper-informations\">\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-sm-3\">\n");
      out.write("                                <div class=\"shopper-info\">\n");
      out.write("                                    <p>Shopper Information</p>\n");
      out.write("                                    <form>\n");
      out.write("                                        <input type=\"text\" placeholder=\"Display Name\" value=\"\" readonly>\n");
      out.write("                                        <input type=\"text\" placeholder=\"User Name\" value=\"\" readonly>\n");
      out.write("                                    </form>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-sm-6\">\n");
      out.write("                                <div class=\"bill-to\">\n");
      out.write("                                    <p>Bill To</p>\n");
      out.write("                                    <div class=\"form-one\">\n");
      out.write("                                        <form>\n");
      out.write("                                            <input type=\"text\" placeholder=\"Name\" name=\"name\">\n");
      out.write("                                            <input type=\"text\" placeholder=\"Address\" name=\"address\">\n");
      out.write("                                            <input type=\"text\" placeholder=\"Phone\" name=\"phone\">\n");
      out.write("\n");
      out.write("                                        </form>\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <div class=\"table-responsive cart_info\">\n");
      out.write("                        <table class=\"table table-condensed\">\n");
      out.write("                            <thead>\n");
      out.write("                                <tr class=\"cart_menu\">\n");
      out.write("                                    <td class=\"image\">Item</td>\n");
      out.write("                                    <td class=\"description\"></td>\n");
      out.write("                                    <td class=\"price\">Price</td>\n");
      out.write("                                    <td class=\"quantity\">Quantity</td>\n");
      out.write("                                    <td class=\"total\">Total</td>\n");
      out.write("                                    <td></td>\n");
      out.write("                                </tr>\n");
      out.write("                            </thead>\n");
      out.write("                            <tbody>\n");
      out.write("                            ");
 for (Order pro : list) {
      out.write("\n");
      out.write("                            <tr>\n");
      out.write("                                <td class=\"cart_product\">\n");
      out.write("                                    <a href=\"\"><img src=\"images/");
      out.print(pro.getImage());
      out.write("\" alt=\"\" style=\"height: 110px; width: 110px\"></a>\n");
      out.write("                                </td>\n");
      out.write("                                <td class=\"cart_description\" style=\"width: 243.85px\">\n");
      out.write("                                    <h4><a href=\"\">");
      out.print(pro.getPname());
      out.write("</a></h4>\n");
      out.write("                                    <p>");
      out.print(pro.getPid());
      out.write("</p>\n");
      out.write("                                </td>\n");
      out.write("                                <td class=\"cart_price\">\n");
      out.write("                                    <p>");
      out.print(pro.getPrice());
      out.write("</p>\n");
      out.write("                                </td>\n");
      out.write("                                <td class=\"cart_quantity\">\n");
      out.write("                                    <div class=\"cart_quantity_button\">\n");
      out.write("                                        <a class=\"cart_quantity_down\" href=\"sub?id=");
      out.print(pro.getPid());
      out.write("\"> - </a>\n");
      out.write("\n");
      out.write("                                        <input class=\"cart_quantity_input\" type=\"text\" name=\"quantity\" value=\"");
      out.print(pro.getAmount());
      out.write("\" autocomplete=\"off\" size=\"2\">\n");
      out.write("                                        <a class=\"cart_quantity_up\" href=\"cart?id=");
      out.print(pro.getPid());
      out.write("\"> + </a>\n");
      out.write("                                    </div>\n");
      out.write("                                </td>\n");
      out.write("                                <td class=\"cart_total\">\n");
      out.write("                                    <div style=\"height: 33.6px; width: 200px\"><p class=\"cart_total_price\">");
      out.print(pro.getPrice() * pro.getAmount());
      out.write("$</p></div>\n");
      out.write("                                </td>\n");
      out.write("                                <td class=\"cart_delete\">\n");
      out.write("                                    <a class=\"cart_quantity_delete\" href=\"remove?id=");
      out.print(pro.getPid());
      out.write("\"><i class=\"fa fa-times\"></i></a>\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                            ");
}
      out.write("\n");
      out.write("                            <tr>\n");
      out.write("                                <td colspan=\"4\">&nbsp;</td>\n");
      out.write("                                <td colspan=\"2\">\n");
      out.write("                                    <table class=\"table table-condensed total-result\">\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td>Cart Sub Total</td>\n");
      out.write("                                            <td>$59</td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td>Exo Tax</td>\n");
      out.write("                                            <td>$2</td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr class=\"shipping-cost\">\n");
      out.write("                                            <td>Shipping Cost</td>\n");
      out.write("                                            <td>Free</td>\t\t\t\t\t\t\t\t\t\t\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td>Total</td>\n");
      out.write("                                            <td><span>$61</span></td>\n");
      out.write("                                        </tr>\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td>Check out</td>\n");
      out.write("                                        </tr>\n");
      out.write("                                    </table>\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                        </tbody>\n");
      out.write("                    </table>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </section> \n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\n");
      out.write("    </body>\n");
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
