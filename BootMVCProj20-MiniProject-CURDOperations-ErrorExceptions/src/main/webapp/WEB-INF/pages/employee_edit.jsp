



<%@page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<style media="all">
body {
	background-color: pink;
}

span {
	color: red;
}
</style>

<script language="JavaScript" src="js/validations.js">
</script>

<h1 style="color:blue;text-align: center">Employee Update</h1>

<form:form modelAttribute="emp" onsubmit="return validation(this)">
  <table border="1" bgcolor="#FFFF33" align="center">
  <tr>
  <td>Employee No::</td>
  <td><form:input path="empno" readonly="true"/></td>
  </tr>
  
  <tr>
  <td>Employee Name::</td>
  <td><form:input path="ename"/><span id="enameErr"></span></td>
  </tr>
  
  
  <tr>
    <td>Employee Designation::</td>
    <td><form:input path="job"/><span id="jobErr"></span></td>
  </tr>
  
  <tr>
   <td>Employee Salary::</td>
   <td><form:input path="sal"/><span id="salErr"></span></td>
  </tr>
  
  <tr>
  <td colspan="2" align="center"><input type="submit" value="Update Employee"></td>
  </tr>
  </table>
  <form:hidden path="vflag"/>
</form:form>
