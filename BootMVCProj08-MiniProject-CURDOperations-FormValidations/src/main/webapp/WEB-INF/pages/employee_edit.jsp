



<%@page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<h1 style="color:blue;text-align: center">Employee Update</h1>
<form:form modelAttribute="emp">
  <table border="1" bgcolor="#FFFF33" align="center">
  <tr>
  <td>Employee No::</td>
  <td><form:input path="empno" readonly="true"/></td>
  </tr>
  
  <tr>
  <td>Employee Name::</td>
  <td><form:input path="ename"/></td>
  </tr>
  
  
  <tr>
    <td>Employee Designation::</td>
    <td><form:input path="job"/></td>
  </tr>
  
  <tr>
   <td>Employee Salary::</td>
   <td><form:input path="sal"/></td>
  </tr>
  
  <tr>
  <td colspan="2" align="center"><input type="submit" value="Update Employee"></td>
  </tr>
  </table>
</form:form>