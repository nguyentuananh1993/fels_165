<%@ page import="com.opensymphony.xwork2.*"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="authz"
	uri="http://www.springframework.org/security/tags"%>
<div class="navbar navbar-default">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="<s:url value="/"/>"> FRAMGIA English Leaning</a>
		</div>
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="<s:url value="/"/>">HOME</a></li>
				<li><a href="<s:url value="/about"/>">ABOUT</a></li>
				<%
					Object obj = request.getSession().getAttribute("user");
					if (obj == null) {
				%>
				<li><a href="<s:url value="/user/logIn"/>"> SIGN IN </a></li>
				<li><a href="<s:url value="/user/signUp"/>"> SIGN UP </a></li>
				<%
					} else {
				%>
				<li><a href="<s:url value="/category/listAllCategory"/>">
						CATEGORY </a></li>
				<li><a href="<s:url value="/word/"/>"> WORDS </a></li>
				<li><a href="<s:url value="/user/showProfile"/>"> PROFILE </a></li>
				<li><a href="<s:url value="/user/signOut"/>"> SIGN OUT</a></li>
				<%
					}
				%>
			</ul>
		</div>
	</div>
</div>
