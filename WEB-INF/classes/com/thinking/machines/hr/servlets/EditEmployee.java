package com.thinking.machines.hr.servlets;
import com.thinking.machines.hr.dl.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
public class EditEmployee extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
String employeeId= request.getParameter("employeeId");
DesignationDAO designationDAO = new DesignationDAO();
EmployeeDAO employeeDAO = new EmployeeDAO();
EmployeeDTO employee=null;
try
{
employee = employeeDAO.getEmployeeById(employeeId);
}catch(DAOException daoException){
sendBackView(response);
}
try
{
response.setContentType("text/html");
PrintWriter pw=response.getWriter();
pw.println("<!DOCTYPE HTML> ");
pw.println("<html lang='en'>");
pw.println("<head>");
pw.println("<title>HR Application</title>");
pw.println("<script>");
pw.println("function validateForm(frm)");
pw.println("{");
pw.println("var firstInvalidComponent=null;");
pw.println("var valid=true;");
pw.println("");
pw.println("var name = frm.name.value.trim();");
pw.println("var nameErrorSection=document.getElementById('nameErrorSection');");
pw.println("nameErrorSection.innerHTML='';");
pw.println("if(name.length==0)");
pw.println("{");
pw.println("nameErrorSection.innerHTML='Name required';");
pw.println("frm.name.focus();");
pw.println("firstInvalidComponent=frm.name;");
pw.println("valid=false;");
pw.println("}");
pw.println("");
pw.println("var designationCode = frm.designationCode.value.trim();");
pw.println("var designationCodeErrorSection=document.getElementById('designationCodeErrorSection');");
pw.println("designationCodeErrorSection.innerHTML='';");
pw.println("if(designationCode==-1)");
pw.println("{");
pw.println("designationCodeErrorSection.innerHTML='Designation required';");
pw.println("if(firstInvalidComponent==null) firstInvalidComponent=frm.designationCode;");
pw.println("valid=false;");
pw.println("}");
pw.println("");
pw.println("var dateOfBirth=frm.dateOfBirth.value;");
pw.println("var dateOfBirthErrorSection=document.getElementById('dateOfBirthErrorSection');");
pw.println("dateOfBirthErrorSection.innerHTML='';");
pw.println("if(dateOfBirth.length==0)");
pw.println("{");
pw.println("dateOfBirthErrorSection.innerHTML='Date of birth required';");
pw.println("if(firstInvalidComponent==null) firstInvalidComponent=frm.dateOfBirth;");
pw.println("valid=false;");
pw.println("}");
pw.println("");
pw.println("");
pw.println("var genderErrorSection=document.getElementById('genderErrorSection');");
pw.println("genderErrorSection.innerHTML='';");
pw.println("if(frm.gender[0].checked==false && frm.gender[1].checked==false)");
pw.println("{");
pw.println("genderErrorSection.innerHTML='Select gender required';");
pw.println("valid=false;");
pw.println("}");
pw.println("");
pw.println("var basicSalary = frm.basicSalary.value.trim();");
pw.println("var basicSalaryErrorSection=document.getElementById('basicSalaryErrorSection');");
pw.println("basicSalaryErrorSection.innerHTML='';");
pw.println("if(basicSalary.length==0)");
pw.println("{");
pw.println("basicSalaryErrorSection.innerHTML='Basic salary required';");
pw.println("if(firstInvalidComponent==null) firstInvalidComponent=frm.basicSalary;");
pw.println("valid=false;");
pw.println("}");
pw.println("else");
pw.println("{");
pw.println("var v='0123456789.'");
pw.println("var e=0;");
pw.println("var isBasicSalaryValid=true;");
pw.println("while(e<basicSalary.length)");
pw.println("{");
pw.println("if(v.indexOf(basicSalary.charAt(e))==-1)");
pw.println("{");
pw.println("basicSalaryErrorSection.innerHTML='Invalid basic salary';");
pw.println("if(firstInvalidComponent==null) firstInvalidComponent=frm.basicSalary;");
pw.println("valid=false;");
pw.println("isBasicSalaryValid=false;");
pw.println("break;");
pw.println("}");
pw.println("e++;");
pw.println("}");
pw.println("if(isBasicSalaryValid)");
pw.println("{");
pw.println("var dot=basicSalary.indexOf('.');");
pw.println("if(dot!=-1)");
pw.println("{");
pw.println("var numberOfFractions=basicSalary.length-(dot+1);");
pw.println("if(numberOfFractions>2)");
pw.println("{");
pw.println("basicSalaryErrorSection.innerHTML='Invalid basic salary';");
pw.println("if(firstInvalidComponent==null) firstInvalidComponent=frm.basicSalary;");
pw.println("valid=false;");
pw.println("}");
pw.println("}");
pw.println("}");
pw.println("}");
pw.println("");
pw.println("");
pw.println("var panNumber = frm.panNumber.value.trim();");
pw.println("var panNumberErrorSection=document.getElementById('panNumberErrorSection');");
pw.println("panNumberErrorSection.innerHTML='';");
pw.println("if(panNumber.length==0)");
pw.println("{");
pw.println("panNumberErrorSection.innerHTML='PAN number required';");
pw.println("if(firstInvalidComponent==null) firstInvalidComponent=frm.panNumber;");
pw.println("valid=false;");
pw.println("}");
pw.println("");
pw.println("var aadharCardNumber = frm.aadharCardNumber.value.trim();");
pw.println("var aadharCardNumberErrorSection=document.getElementById('aadharCardNumberErrorSection');");
pw.println("aadharCardNumberErrorSection.innerHTML='';");
pw.println("if(aadharCardNumber.length==0)");
pw.println("{");
pw.println("aadharCardNumberErrorSection.innerHTML='Aadhar card number required';");
pw.println("if(firstInvalidComponent==null) firstInvalidComponent=frm.aadharCardNumber;");
pw.println("valid=false;");
pw.println("}");
pw.println("");
pw.println("");
pw.println("");
pw.println("if(!valid) firstInvalidComponent.focus();");
pw.println("return valid;");
pw.println("}");
pw.println("function cancelAddition()");
pw.println("{");
pw.println("document.getElementById('cancelAdditionForm').submit();");
pw.println("}");
pw.println("</script>");
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
pw.println("<b>Employees</b><br>");
pw.println("<a href='/styleone/index.html'>Home</a>");
pw.println("</div>");
pw.println("<!-- left panel ends here -->");
pw.println("<!-- right panel starts here -->");
pw.println("<div style='height:65vh;margin-top:5px;margin-bottom:5px;margin-right:5px;margin-left:105px;padding:5px;border:1px solid black'>");
pw.println("<h2>Employee(Edit module)</h2>");
pw.println("");
pw.println("<form method='post' action='/styleone/addEmployee' onsubmit='return validateForm(this)'>");
pw.println("<input type='hidden' name='employeeId' id='employeeId' value'"+employeeId+"'> ");
pw.println("<table>");
pw.println("<tr>");
pw.println("<td>Name</td>");
String name= employee.getName();
pw.println("<td><input type='text' id='name' name='name' maxlength='50' size='51'  value='"+name+"'>");
pw.println("<span id='nameErrorSection' style='color:red'></span></td>");
pw.println("</tr>");
pw.println("");
pw.println("<tr>");
pw.println("<td>Designation</td>");
pw.println("<td><select id='designationCode' name='designationCode'>");
pw.println("<option value='-1'>&lt;Select Designation&gt;</option>");
List<DesignationDTO> designations=designationDAO.getAll();
int designationCode = employee.getDesignationCode();
int code;
String title;
for(DesignationDTO designation:designations)
{
code=designation.getCode();
title=designation.getTitle();
if(code!=designationCode){
pw.println("<option value='"+code+"'>"+title+"</option>");
}
else
{
pw.println("<option selected value='"+code+"'>"+title+"</option>");

}
}
pw.println("</select>");
pw.println("<span id='designationCodeErrorSection' style='color:red'></span>");
pw.println("</td>");
pw.println("</tr>");
pw.println("");
pw.println("<tr>");
pw.println("<td>Date of birth</td>");
SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
java.util.Date dateOfBirth=employee.getDateOfBirth();
pw.println("<td><input type='date' id='dateOfBirth' name='dateOfBirth' value='"+simpleDateFormat.format(dateOfBirth)+"'>");
pw.println("<span id='dateOfBirthErrorSection' style='color:red'></span>");
pw.println("</td>");
pw.println("</tr>");
pw.println("");
pw.println("<tr>");
pw.println("<td>Gender</td>");
String gender=employee.getGender();
pw.println("<td>");
if(gender.equals("M")==true){
pw.println("<input checked type='radio' id='male' name='gender' value='M'>Male");
}
else
{
pw.println("<input type='radio' id='male' name='gender' value='M'>Male");

}
pw.println("&nbsp;&nbsp;&nbsp;&nbsp;");
if(gender.equals("F")==false){
pw.println("<input type='radio' id='female' name='gender' value='F'>Female");
}
else{
pw.println("<input checked type='radio' id='female' name='gender' value='F'>Female");
}
pw.println("<span id='genderErrorSection' style='color:red'></span>");
pw.println("</td>");
pw.println("</tr>");
pw.println("");
boolean isIndian=employee.getIsIndian();
pw.println("<tr>");
pw.println("<td>Indian?</td>");
pw.println("<td>");
if(isIndian){
pw.println("<input checked type='checkbox' id='isIndian' name='isIndian' value='Y'>");
}
else{
pw.println("<input type='checkbox' id='isIndian' name='isIndian' value='Y'>");
}
pw.println("</td>");
pw.println("</tr>");
pw.println("");
pw.println("<tr>");
pw.println("<td>Basic Salary</td>");
pw.println("<td>");
BigDecimal basicSalary=employee.getBasicSalary();
pw.println("<input type='text' style='text-align:right' name='basicSalary' id='basicSalary' maxlength='12' size='13' value='"+basicSalary.toPlainString()+"'>");
pw.println("");
pw.println("<span id='basicSalaryErrorSection' style='color:red'></span>");
pw.println("</td>");
pw.println("</tr>");
pw.println("");
pw.println("<tr>");
pw.println("<td>PAN Number</td>");
pw.println("<td>");
String panNumber=employee.getPanNumber();
pw.println("<input type='text' id='panNumber' name='panNumber' maxlength='15' size='16' value='"+panNumber+"'>");
pw.println("<span id='panNumberErrorSection' style='color:red'></span>");
pw.println("</td>");
pw.println("</tr>");
pw.println("");
pw.println("<tr>");
pw.println("<td>Aadhar Card Number</td>");
pw.println("<td>");
String aadharCardNumber= employee.getAadharCardNumber();
pw.println("<input type='text' id='aadharCardNumber' name='aadharCardNumber' maxlength='15' size='16' value='"+aadharCardNumber+"'>");
pw.println("<span id='aadharCardNumberErrorSection' style='color:red'></span>");
pw.println("</td>");
pw.println("</tr>");
pw.println("");
pw.println("");
pw.println("<tr>");
pw.println("<td colspan='2'><button type='submit' style='float:left'>Update</button>");
pw.println("&nbsp;&nbsp;<button type='Button' onclick='cancelUpdate()'>Cancel</button></td>");
pw.println("</tr>");
pw.println("</table>");
pw.println("");
pw.println("</form>");
pw.println("");
pw.println("</div>");
pw.println("<!-- right panel ends here -->");
pw.println("</div><!-- content-section ends here -->");
pw.println("<!-- footer starts here -->");
pw.println("<div style='width:90hw;height:auto;margin:5px;border:1px solid white;text-align:center'>");
pw.println("&copy;Thinking Machines 2023");
pw.println("</div><!-- footer ends here -->");
pw.println("</div><!-- Main container ends here -->");
pw.println("<form id='cancelUpdate' action='/styleone/employeesView'>");
pw.println("</form>");
pw.println("</body>");
pw.println("</html>");
return;
}catch(Exception e)
{
System.out.println(e);
}
}
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
doGet(request,response);
}

private void sendBackView(HttpServletResponse response)
{
try
{
List<EmployeeDTO> employees = new EmployeeDAO().getAll();

response.setContentType("text/html");
PrintWriter pw = response.getWriter();
pw.println("<!DOCTYPE HTML>");
pw.println("<html lang='en'>");
pw.println("<head>");
pw.println("<title>HR Application</title>");
pw.println("<script>");
pw.println("function Employee()");
pw.println("{");
pw.println("this.employeeId=\"\";");
pw.println("this.name=\"\";");
pw.println("this.designationCode=0;");
pw.println("this.dateOfBirth=\"\";");
pw.println("this.gender=\"\";");
pw.println("this.isIndian=true;");
pw.println("this.panNumber=\"\";");
pw.println("this.aadharCardNumber=\"\";");
pw.println("this.basicSalary=0;");
pw.println("}");
pw.println("var selectedRow=null;");
pw.println("var employees=[];");

SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
int i=0;
for(EmployeeDTO employee:employees)
{
pw.println("var employee=new Employee();");
pw.println("employee.employeeId=\""+employee.getEmployeeId()+"\";");
pw.println("employee.name=\""+employee.getName()+"\";");
pw.println("employee.designationCode="+employee.getDesignationCode()+";");
pw.println("employee.designation=\""+employee.getDesignation()+"\";");
pw.println("employee.dateOfBirth=\""+simpleDateFormat.format(employee.getDateOfBirth())+"\";");
pw.println("employee.gender=\""+employee.getGender()+"\";");
pw.println("employee.isIndian="+employee.getIsIndian()+";");
pw.println("employee.basicSalary="+employee.getBasicSalary().toPlainString()+";");
pw.println("employee.panNumber=\""+employee.getPanNumber()+"\";");
pw.println("employee.aadharCardNumber=\""+employee.getAadharCardNumber()+"\";");

pw.println("employees["+i+"]=employee;");
i++;
}
pw.println("function selectEmployee(row,employeeId)");
pw.println("{");
pw.println("if(row==selectedRow) return;");
pw.println("if(selectedRow!=null)");
pw.println("{");
pw.println("selectedRow.style.background=\"white\";");
pw.println("selectedRow.style.color=\"black\";");
pw.println("}");
pw.println("row.style.background=\"#7C7B7B\";");
pw.println("row.style.color=\"white\";");
pw.println("selectedRow=row;");
pw.println("var i;");
pw.println("for(i=0;i<employees.length;i++)");
pw.println("{");
pw.println("if(employees[i].employeeId===employeeId)");
pw.println("{");
pw.println("break;");
pw.println("}");
pw.println("}");
pw.println("var emp=employees[i];");
pw.println("document.getElementById(\"detailPanel_employeeId\").innerHTML=emp.employeeId;");
pw.println("document.getElementById(\"detailPanel_name\").innerHTML=emp.name;");
pw.println("document.getElementById(\"detailPanel_designation\").innerHTML=emp.designation;");
pw.println("document.getElementById(\"detailPanel_dateOfBirth\").innerHTML=emp.dateOfBirth;");
pw.println("document.getElementById(\"detailPanel_gender\").innerHTML=emp.gender;");
pw.println("if(emp.isIndian)");
pw.println("{");
pw.println("document.getElementById(\"detailPanel_isIndian\").innerHTML=\"Yes\";");
pw.println("}");
pw.println("else");
pw.println("{");
pw.println("document.getElementById(\"detailPanel_isIndian\").innerHTML=\"No\";");
pw.println("}");
pw.println("document.getElementById(\"detailPanel_basicSalary\").innerHTML=emp.basicSalary;");
pw.println("document.getElementById(\"detailPanel_panNumber\").innerHTML=emp.panNumber;");
pw.println("document.getElementById(\"detailPanel_aadharCardNumber\").innerHTML=emp.aadharCardNumber;");
pw.println("}");
pw.println("</script>");
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
pw.println("<b>Employees</b><br>");
pw.println("<a href='/styleone/index.html'>Home</a>");
pw.println("</div>");
pw.println("<!-- left panel ends here -->");
pw.println("<!-- right panel starts here -->");
pw.println("<div style='height:65vh;margin-top:5px;margin-bottom:5px;margin-right:5px;margin-left:105px;padding:5px;border:1px solid black'>");
pw.println("<h2>Employees</h2>");
pw.println("<div style='height:30vh;margin-top:5px;margin-bottom:5px;margin-right:5px;margin-left:5px;padding:5px;border:1px solid black;overflow:scroll'>");
pw.println("<table border='1'>");
pw.println("<thead>");
pw.println("<tr>");
pw.println("<th colspan='6' style='text-align:right;padding:5px'>");
pw.println("<a href='/styleone/getEmployeeAddForm'>Add Employee</a>");
pw.println("</th>");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<th style='width:60px;text-align:center'>S.No.</th>");
pw.println("<th style='width:200px;text-align:center'>Id.</th>");
pw.println("<th style='width:200px;text-align:center'>Name</th>");
pw.println("<th style='width:200px;text-align:center'>Designation</th>");
pw.println("<th style='width:100px;text-align:center'>Edit</th>");
pw.println("<th style='width:100px;text-align:center'>Delete</th>");
pw.println("</tr>");
pw.println("</thead>");
pw.println("<tbody>");
int sno=0;
for(EmployeeDTO employee:employees)
{
sno++;
pw.println("<tr style='cursor:pointer' onclick='selectEmployee(this,\""+employee.getEmployeeId()+"\")'>");
pw.println("<td style='text-align:right'>"+sno+".</td>");
pw.println("<td>"+employee.getEmployeeId()+"</td>");
pw.println("<td>"+employee.getName()+"</td>");
pw.println("<td>"+employee.getDesignation()+"</td>");
System.out.println("Designation in EmployeesView: "+employee.getDesignation());
pw.println("<td style='text-align:center'><a href='/styleone/editEmployee?employeeId="+employee.getEmployeeId()+"'>Edit</a></td>");
pw.println("<td style='text-align:center'><a href='/styleone/confirmDeleteEmployee?employeeId="+employee.getEmployeeId()+"'>Delete</a></td>");
pw.println("</tr>");
}
pw.println("</tbody>");
pw.println("</table>");
pw.println("</div>");
pw.println("");
pw.println("<div style='height:19vh;margin-top:5px;margin-bottom:5px;margin-right:5px;margin-left:5px;padding:5px;border:1px solid black'>");
pw.println("<label style='background:grey;color:white;padding-left:5px;padding-right:5px'>Details</label>");
pw.println("<table border='0' width=100%>");
pw.println("<tr>");
pw.println("<td>Employee Id : <span id='detailPanel_employeeId' style='margin-right:30px'></span></td>");
pw.println("<td>Name : <span id='detailPanel_name' style='margin-right:30px'></span></td>");
pw.println("<td>Designation : <span id='detailPanel_designation' style='margin-right:30px'></span></td>");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<td>Date of birth : <span id='detailPanel_dateOfBirth' style='margin-right:30px'></span></td>");
pw.println("<td>Gender : <span id='detailPanel_gender' style='margin-right:30px'></span></td>");
pw.println("<td>Is Indian : <span id='detailPanel_isIndian' style='margin-right:30px'></span></td>");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<td>Basic Salary : <span id='detailPanel_basicSalary' style='margin-right:30px'></span></td>");
pw.println("<td>PAN Number : <span id='detailPanel_panNumber' style='margin-right:30px'></span></td>");
pw.println("<td>AadharCardNumber : <span id='detailPanel_aadharCardNumber' style='margin-right:30px'></span></td>");
pw.println("</tr>");
pw.println("</table>");
pw.println("</div>");
pw.println("");
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
}
catch(Exception e)
{
System.out.println(e.getMessage());
}


}
}
