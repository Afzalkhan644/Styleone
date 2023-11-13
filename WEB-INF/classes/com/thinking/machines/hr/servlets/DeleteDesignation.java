package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;
public class DeleteDesignation extends HttpServlet
{
public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
{
PrintWriter pw=null;
String title="";
int code=0;
try
{
pw=response.getWriter();
try
{
code=Integer.parseInt(request.getParameter("code"));
}catch(NumberFormatException numberFormatException)
{
sendBackView(response);
return;
}

DesignationDAO designationDAO;
designationDAO=new DesignationDAO();
designationDAO.deleteByCode(code);
pw.println("<!DOCTYPE HTML>"); 
pw.println("<html lang='en'>");
pw.println("<head>");
pw.println("<title>HR Application</title>");
pw.println("</head>");
pw.println("<body>");
pw.println("<!-- Main container starts here -->");
pw.println("<div style='width:90hw;height:auto;border:1px solid black'>");
pw.println("<!-- Header starts here -->");
pw.println("<div style='margin:5px;width:90hw;height:auto;border:1px solid black'>");
pw.println("<img src='/styleone/images/logo.png' style='float:left'><div style='margin-top:9px;margin-bottom:9px;font-size:20pt'>Thinking Machines</div>");
pw.println("</div><!-- Header ends here -->");
pw.println("<!-- content-section starts here -->");
pw.println("<div style='width:90hw;height:70vh;margin:5px;border:1px solid white'>");
pw.println("<!-- left panel starts here -->");
pw.println("<div style='height:65vh;margin:5px;border:1px solid black;float:left;padding:5px'>");
pw.println("<a href='/styleone/designationsView'>Designations</a><br>");
pw.println("<a href='/styleone/employeesView'>Employees</a>");
pw.println("</div>");
pw.println("<!-- left panel ends here -->");
pw.println("<!-- right panel starts here -->");
pw.println("<div style='height:65vh;margin-top:5px;margin-bottom:5px;margin-right:5px;margin-left:105px;padding:5px;border:1px solid black'>");
pw.println("<h3>Notification</h3>");
pw.println("Designation deleted<br>");

pw.println("<form action='/styleone/designationsView'>");
pw.println("<button type='submit'>Ok</button>");
pw.println("</form>");

pw.println("</div>");
pw.println("<!-- right panel ends here -->");
pw.println("</div><!-- content-section ends here -->");
pw.println("<!-- footer starts here -->");
pw.println("<div style='width:90hw;height:auto;margin:5px;border:1px solid white;text-align:center'>");
pw.println("&copy;Thinking Machines 2023");
pw.println("</div><!-- footer ends here -->");
pw.println("</div><!-- Main container ends here -->");
pw.println("</form>");
pw.println("</body>");
pw.println("</html>");
}catch(DAOException daoException)
{
//send back the form to update with error message
sendBackView(response);
}
catch(Exception exception)
{
System.out.println(exception);
}
}
public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
{
doGet(request,response);
}
private void sendBackView(HttpServletResponse response)
{
try
{
DesignationDAO designationDAO;
designationDAO = new DesignationDAO();
List<DesignationDTO> designations;
designations=designationDAO.getAll();

//for(int i=0;i<designations.size();i++) System.out.println(designations.get(i).getTitle());

PrintWriter pw = response.getWriter();
response.setContentType("text/html");

pw.println("<!DOCTYPE HTML>");
pw.println("<html lang='en'>");
pw.println("<head>");
pw.println("<title>HR Application</title>");
pw.println("</head>");
pw.println("<body>");
pw.println("<!-- Main container starts here -->");
pw.println("<div style='width:90hw;height:auto;border:1px solid black'>");
pw.println("<!-- Header starts here -->");
pw.println("<div style='margin:5px;width:90hw;height:auto;border:1px solid black'>");
pw.println("<img src='/styleone/images/logo.png' style='float:left'><div style='margin-top:9px;margin-bottom:9px;font-size:20pt'>Thinking Machines</div>");
pw.println("</div><!-- Header ends here -->");
pw.println("<!-- content-section starts here -->");
pw.println("<div style='width:90hw;height:70vh;margin:5px;border:1px solid white'>");
pw.println("<!-- left panel starts here -->");
pw.println("<div style='height:65vh;margin:5px;border:1px solid black;float:left;padding:5px'>");
pw.println("<b>Designations</b><br>");
pw.println("<a href='/styleone/employeesView'>Employees</a>");
pw.println("</div>");
pw.println("<!-- left panel ends here -->");
pw.println("<!-- right panel starts here -->");
pw.println("<div style='height:65vh;margin-top:5px;margin-bottom:5px;margin-right:5px;margin-left:105px;padding:5px;overflow:scroll;border:1px solid black'>");
pw.println("<h3>Notification</h3>");
pw.println("Designation updated<br>");
pw.println("<form action='/styleone/designationsView'>");
pw.println("<button type='submit'>Ok</button>");
pw.println("</form>");
pw.println("</div>");
pw.println("<!-- right panel ends here -->");
pw.println("</div><!-- content-section ends here -->");
pw.println("<!-- footer starts here -->");
pw.println("<div style='width:90hw;height:auto;margin:5px;border:1px solid white;text-align:center'>");
pw.println("&copy;Thinking Machines 2023");
pw.println("</div><!-- footer ends here -->");
pw.println("</div><!-- Main container ends here -->");
pw.println("</body>");
pw.println("</html>");

}catch(DAOException exception)
{

}
catch(Exception e)
{
System.out.println(e.getMessage());
}
}
}