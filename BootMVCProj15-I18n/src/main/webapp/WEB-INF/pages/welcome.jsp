<%@page isELIgnored="false" contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="sp" %>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<br><br>
<h1 style="color:blue;text-align: center"><sp:message code="home.title"/></h1><br><br>
<a href="register"><h2 style="color:red;text-align: center"><sp:message code="home.link"/></h2></a><br><br>


<h2 style="color:red;text-align:center">Current Active Locale is::${pageContext.response.locale}</h2>
<fmt:setLocale value="${pageContext.response.locale}"/>

<jsp:useBean id="dt" class="java.util.Date"/>
<fmt:formatDate var="fdt" value="${dt}" type="date" dateStyle="SHORT"/>
<b>Formatted Date::${fdt}</b><br>
<fmt:formatDate var="ftime" value="${dt}" type="time" timeStyle="FULL"/>
<b>Formatted Date::${ftime}</b><br>

<fmt:formatNumber var="fnumber" value="1000000" type="number"/><br>
<b>Formatted Number::${fnumber}</b>

<fmt:formatNumber var="fcurrency" value="1000000" type="currency"/><br>
<b>Formatted Number::${fcurrency}</b>

<fmt:formatNumber var="fpercentage" value="1000000" type="PERCENT"/><br>
<b>Formatted Number::${fpercentage}</b><br><br>

<p align="center">
  <a href="?lang=fr_FR">French</a>&nbsp;&nbsp;&nbsp;&nbsp;
  <a href="?lang=de_DE">German</a>&nbsp;&nbsp;&nbsp;&nbsp;
  <a href="?lang=hi_IN">हिंदी</a>&nbsp;&nbsp;&nbsp;&nbsp;
  <a href="?lang=en_US">English</a>&nbsp;&nbsp;&nbsp;&nbsp;
  <a href="?lang=od_IN">ଓଡିଆ</a>&nbsp;&nbsp;&nbsp;&nbsp;
</p>