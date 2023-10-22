<%@page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<br><br>
<h1 style="color:blue;text-align: center">JobSeekers List</h1>
	<c:choose>
		<c:when test="${!empty jsList}">
			<table border="1" bgcolor="cyan" align="center">
				<tr>
					<th>JsId</th>
					<th>JsName</th>
					<th>JsAddrs</th>
					<th>Resume</th>
					<th>Photo</th>
				</tr>
					<c:forEach var="info" items="${jsList}">
						<tr>
							<td>${info.jsId}</td>
							<td>${info.jsName}</td>
							<td>${info.jsAddrs}</td>
							<td><a href="download?jsId=${info.jsId}&type=resume">Download
									Resume</a></td>
							<td><a href="download?jsId=${info.jsId}&type=photo">Download
									Photo</a></td>
						</tr>
					</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<h1 style="color: red; text-align: center">Record Not Found</h1>
		</c:otherwise>
	</c:choose>
	
	<br><br>
	<h4 style="color:blue;text-align: center"><a href="./">Home</a></h4>
