<%@page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div><h1 style="color: red; text-align: center; background-color: yellow">Job
	Seeker Registration Form</h1></div>

<form:form modelAttribute="js" enctype="multipart/form-data">
	<table align="center" bgcolor="cyan" border="1">
		<tr>
			<td>Name::</td>
			<td><form:input path="jsName" /></td>
		</tr>

		<tr>
			<td>Address::</td>
			<td><form:input path="jsAddrs" /></td>
		</tr>

		<tr>
			<td>Select Photo</td>
			<td><form:input type="file" path="photo" /></td>
		</tr>

		<tr>
			<td>Select Resume</td>
			<td><form:input type="file" path="resume" /></td>
		</tr>

		<tr>
			<td colspan="2"><input type="submit" value="Register"></td>

		</tr>

	</table>
</form:form>

<h4 style="color:blue;text-align: center"><a href="./">Home</a></h4>