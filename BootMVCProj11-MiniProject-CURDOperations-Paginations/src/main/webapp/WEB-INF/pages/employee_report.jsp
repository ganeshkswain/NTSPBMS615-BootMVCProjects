


<%@page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"/>

<div class="container">
<c:choose>
	<c:when test="${!empty empData.getContent()}">
<!-- 	<table border="1" align="center" bgcolor="#C3FDB8"> -->
<!-- 		<table border="1" class="table table-hover"> -->
      <table border="1" class="table">
			<tr class="table-danger">
				<th>EmpNo</th>
				<th>EmpName</th>
				<th>Job</th>
				<th>Salary</th>
				<th>Add and Delete</th>
			</tr>
			<c:forEach var="emp" items="${empData.getContent()}">
				<tr class="table-success">
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
		
	<p style="text-align: center">
<!--       For Previous Page  -->
   <c:if test="${empData.hasPrevious()}">
       <a href="report?page=${empData.getPageable().getPageNumber()-1}">Previous</a>
   </c:if>
<!--       For First Page  -->
	<c:if test="${!empData.isFirst()}">
	  <a href="report?page=0">First</a> &nbsp;&nbsp;
	</c:if>
<!--       For  Page Number -->
	<c:forEach var="i" begin="1" end="${empData.getTotalPages()}" step="1">
	   [<a href="report?page=${i-1}">${i}</a>] &nbsp;&nbsp;
	</c:forEach>

<!--       For Last Page  -->	
	<c:if test="${!empData.isLast()}">
	 <a href="report?page=${empData.getTotalPages()-1}">Last</a> &nbsp;&nbsp;
	</c:if>
	<!--       For  Next Page Number -->
   <c:if test="${empData.hasNext()}">
      <a href="report?page=${empData.getPageable().getPageNumber()+1}">Next</a>
   </c:if>	
   
	</p> 	
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
</div>