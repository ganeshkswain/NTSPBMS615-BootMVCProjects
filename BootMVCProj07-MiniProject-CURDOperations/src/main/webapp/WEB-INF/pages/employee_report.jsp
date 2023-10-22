


<%@page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:choose>
	<c:when test="${!empty empData}">
		<table border="1" align="center" bgcolor="#C3FDB8">
			<tr>
				<th>EmpNo</th>
				<th>EmpName</th>
				<th>Job</th>
				<th>Salary</th>
				<th>Add and Delete</th>
			</tr>
			<c:forEach var="emp" items="${empData}">
				<tr>
					<td>${emp.empno}</td>
					<td>${emp.ename}</td>
					<td>${emp.job}</td>
					<td>${emp.sal}</td>
					<td>&nbsp;&nbsp;<a href="edit?no=${emp.empno}"><img alt="edit"
							src="images/edit.png" height="20" /></a>&nbsp;&nbsp;&nbsp;&nbsp; 
						<a onclick="return confirm('Do you want to delete')" href="delete?no=${emp.empno}"><img alt="delete" src="images/delete.png" height="20"></a>
				</tr>
			</c:forEach>
		</table>
	</c:when>
	<c:otherwise>
	   <h1 style="color:red;text-align: center">Record Not Found</h1>
	</c:otherwise>
</c:choose>
<br><br>
<hr>
<h2 style="text-align: center"><a href="add"><img alt="add" src="images/add.png" height="60">Add newEmployee</a></h2>
<c:if test="${!empty resultData}">
   <h3 style="color:green;text-align: center">${resultData}</h3>
</c:if>
<hr>
<h2 style="text-align: center"><a href="./"><img alt="home" src="images/home1.png" height="80">Home</a></h2>