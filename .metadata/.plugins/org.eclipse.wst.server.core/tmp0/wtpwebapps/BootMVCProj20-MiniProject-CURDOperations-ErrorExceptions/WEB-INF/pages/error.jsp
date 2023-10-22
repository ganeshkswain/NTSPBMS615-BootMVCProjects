<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>
	<h1 style="color: red; text-align: center">Some Internal Problem--
		Inconvinience is regretted</h1>
	<hr />
	<table border="1" align="center" bgcolor="cyan">
		<tr>
			<td>Status</td>
			<td>${status}</td>
		</tr>

		<tr>
			<td>Time Stamp</td>
			<td>${timestamp}</td>
		</tr>

		<tr>
			<td>message</td>
			<td>${message}</td>
		</tr>

		<tr>
			<td>type</td>
			<td>${type}</td>
		</tr>

		<tr>
			<td>path</td>
			<td>${path}</td>
		</tr>

		<tr>
			<td>trace</td>
			<td>${trace}</td>
		</tr>

	</table>
</body>
</html>