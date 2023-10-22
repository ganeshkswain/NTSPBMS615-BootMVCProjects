

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

<h1 style="color:blue;text-align: center">Register Employee</h1>
<form:form modelAttribute="emp" onsubmit="return validation(this)" name="frm">
 <%--  <p style="color: red;text-align: center"> 
<form:errors path="*"/>
   </p> --%>
  <table border="1" bgcolor="cyan" align="center">
  <tr>
  <td>Employee Name::</td>
  <td><form:input path="ename"/> <form:errors cssStyle="color:red" path="ename"/><span id="enameErr"></span></td>
  </tr>
  
 
  
  <tr>
    <td>Employee Designation::</td>
    <td><form:input path="job"/> <form:errors cssStyle="color:red" path="job"/> <span id="jobErr"></span></td>
  </tr>
  
  <tr>
   <td>Employee Salary::</td>
   <td><form:input path="sal"/> <form:errors cssStyle="color:red" path="sal"/><span id="salErr"></span></td>
  </tr>
   
   <script language="JavaScript">
     function sendReqForStates(frm){
    	 frm.action="statesurl" //request path of handler method
    	 frm.submit(); //submits the request
     }
   </script>
  
  <tr>
    <td>Select Country::</td>
    <td><form:select path="country" onchange="sendReqForStates()">
      <form:options items="${countriesInfo}"/>
    </form:select>
  </tr>
  
  <tr>
    <td>Select State::</td>
    <td><form:select path="state">
           <form:options items="${statesInfo}"/>
    </form:select>
    </td>
  </tr>
  
  
  <tr>
  <td colspan="2" align="center"><input type="submit" value="Register Employee"></td>
  </tr>
  </table>
  <form:hidden path="vflag"/>
</form:form>



<%-- <h1 style="color:blue;text-align: center">Register Employee</h1>
<form:form modelAttribute="emp">
  <p style="color: red;text-align: center"> 
<form:errors path="*"/>
   </p>
  <table border="1" bgcolor="cyan" align="center">
  <tr>
  <td>Employee Name::</td>
  <td><form:input path="ename"/> <form:errors cssStyle="color:red" path="ename"/></td>
  </tr>
  
 
  
  <tr>
    <td>Employee Designation::</td>
    <td><form:input path="job"/> <form:errors cssStyle="color:red" path="job"/></td>
  </tr>
  
  <tr>
   <td>Employee Salary::</td>
   <td><form:input path="sal"/> <form:errors cssStyle="color:red" path="sal"/></td>
  </tr>
  
  <tr>
  <td colspan="2" align="center"><input type="submit" value="Register Employee"></td>
  </tr>
  </table>
</form:form> --%>