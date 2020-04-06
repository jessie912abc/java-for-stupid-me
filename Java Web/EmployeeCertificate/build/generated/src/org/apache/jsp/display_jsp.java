package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Certificate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;;
import java.util.Calendar;
import java.time.LocalDate;
import model.Employee;
import java.util.ArrayList;

public final class display_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Display Employee Certificate</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        ");

            ArrayList<Employee> listEmp = (ArrayList<Employee>) request.getAttribute("listEmp");
            LocalDate date = LocalDate.now();
            int dayOfWeek = date.getDayOfWeek().getValue();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        
      out.write("\n");
      out.write("        <h2>Current Date: ");
      out.print(formatter.format(date).toString());
      out.write("</h2>\n");
      out.write("        \n");
      out.write("        <style>\n");
      out.write("            table,th,td{\n");
      out.write("                border: 1px solid black;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("        <table>\n");
      out.write("            <tr>\n");
      out.write("                ");

                    
                    DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM");
                    LocalDate monday = date.minusDays(dayOfWeek - 1);
                
      out.write("\n");
      out.write("                <th>Employee</th>\n");
      out.write("                <th>");
      out.print( formatter1.format(monday) );
      out.write("</th>\n");
      out.write("                <th>");
      out.print( formatter1.format(monday.plusDays(1)) );
      out.write("</th>\n");
      out.write("                <th>");
      out.print( formatter1.format(monday.plusDays(2)) );
      out.write("</th>\n");
      out.write("                <th>");
      out.print( formatter1.format(monday.plusDays(3)) );
      out.write("</th>\n");
      out.write("                <th>");
      out.print( formatter1.format(monday.plusDays(4)) );
      out.write("</th>\n");
      out.write("                <th>");
      out.print( formatter1.format(monday.plusDays(5)) );
      out.write("</th>\n");
      out.write("                <th>");
      out.print( formatter1.format(monday.plusDays(6)) );
      out.write("</th>\n");
      out.write("            </tr>\n");
      out.write("            ");

                for (Employee e : listEmp) {
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td>");
      out.print( e.getName() );
      out.write("</td>   \n");
      out.write("                ");

                    ArrayList<Certificate> listCert = e.getCert();                            
                
      out.write("\n");
      out.write("                <td>\n");
      out.write("                    ");
 
                        for (Certificate c : listCert) {
                            LocalDate expiredDate = c.getExpiredDate().toLocalDate();
                            long minus = ChronoUnit.DAYS.between(expiredDate, monday);
      out.write("\n");
      out.write("                        ");
      out.print(minus);
      out.write("\n");
      out.write("                    ");
}
      out.write("\n");
      out.write("                </td> \n");
      out.write("                <td>\n");
      out.write("                    ");
 
                        for (Certificate c : listCert) {
                            LocalDate expiredDate = c.getExpiredDate().toLocalDate();
                            long minus = ChronoUnit.DAYS.between(expiredDate, monday.plusDays(1));
      out.write("\n");
      out.write("                        ");
      out.print(minus);
      out.write("\n");
      out.write("                    ");
}
      out.write("\n");
      out.write("                </td> \n");
      out.write("                <td>\n");
      out.write("                    ");
 
                        for (Certificate c : listCert) {
                            LocalDate expiredDate = c.getExpiredDate().toLocalDate();
                            long minus = ChronoUnit.DAYS.between(expiredDate, monday.plusDays(2));
      out.write("\n");
      out.write("                        ");
      out.print(minus);
      out.write("\n");
      out.write("                    ");
}
      out.write("\n");
      out.write("                </td> \n");
      out.write("                <td>\n");
      out.write("                    ");
 
                        for (Certificate c : listCert) {
                            LocalDate expiredDate = c.getExpiredDate().toLocalDate();
                            long minus = ChronoUnit.DAYS.between(expiredDate, monday.plusDays(3));
      out.write("\n");
      out.write("                        ");
      out.print(minus);
      out.write("\n");
      out.write("                    ");
}
      out.write("\n");
      out.write("                </td> \n");
      out.write("                <td>\n");
      out.write("                    ");
 
                        for (Certificate c : listCert) {
                            LocalDate expiredDate = c.getExpiredDate().toLocalDate();
                            long minus = ChronoUnit.DAYS.between(expiredDate, monday.plusDays(4));
      out.write("\n");
      out.write("                        ");
      out.print(minus);
      out.write("\n");
      out.write("                    ");
}
      out.write("\n");
      out.write("                </td> \n");
      out.write("                <td>\n");
      out.write("                    ");
 
                        for (Certificate c : listCert) {
                            LocalDate expiredDate = c.getExpiredDate().toLocalDate();
                            long minus = ChronoUnit.DAYS.between(expiredDate, monday.plusDays(5));
      out.write("\n");
      out.write("                        ");
      out.print(minus);
      out.write("\n");
      out.write("                    ");
}
      out.write("\n");
      out.write("                </td> \n");
      out.write("                <td>\n");
      out.write("                    ");
 
                        for (Certificate c : listCert) {
                            LocalDate expiredDate = c.getExpiredDate().toLocalDate();
                            long minus = ChronoUnit.DAYS.between(expiredDate, monday.plusDays(6));
      out.write("\n");
      out.write("                        ");
      out.print(minus);
      out.write("\n");
      out.write("                    ");
}
      out.write("\n");
      out.write("                </td>\n");
      out.write("                \n");
      out.write("                \n");
      out.write("                \n");
      out.write("            </tr>\n");
      out.write("            ");
}
      out.write("\n");
      out.write("        </table>\n");
      out.write("        \n");
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
