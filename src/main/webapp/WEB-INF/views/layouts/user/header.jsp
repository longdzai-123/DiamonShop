<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layouts/user/taglib.jsp" %>
<header id="header">
	<div class="row">
		<div class="span4">
			<h1>
				<img src="<c:url value="/assets/user/img/logo.jpg"/>"/>		
			</h1>
		</div>
		<div class="span8 alignR">
		</div>
	</div>
</header>

<!--
Navigation Bar Section 
-->
<div class="navbar">
	<div class="navbar-inner">
		<div class="container">
			<a data-target=".nav-collapse" data-toggle="collapse"
				class="btn btn-navbar"> <span class="icon-bar"></span> <span
				class="icon-bar"></span> <span class="icon-bar"></span>
			</a>
			<div class="nav-collapse">
				<ul class="nav">
				   <c:forEach var="item" items="${menus}" varStatus="index">
				       <c:if test="${index.first}">
				       		<li class="active">
				       </c:if>
				       <c:if test="${not index.first}">
				       		<li class="">
				       </c:if> 
				       <a href='<c:url value="/trang-chu"/>'>${item.name}</a></li>
				   </c:forEach>
				</ul>
				<form action="<c:url value="/tim-kiem"/>" class="navbar-search pull-left" method="get">		
					<input name ="name" type="text" placeholder="Tìm kiếm" class="search-query span2">
					<button type="submit" class="btn btn-outline-primary">Tìm kiếm</button>
				</form>
				<ul class="nav pull-right">
				  <c:if test="${ empty loginInfo }">
					<li class="dropdown">
					    <a data-toggle="dropdown" class="dropdown-toggle" href="#"><span class="icon-lock"></span> Đăng nhập </a>
					</li>
					</c:if>
					
					<c:if test="${not empty loginInfo }">
					   <li><a href="">${loginInfo.display_name}</a><b class="caret"></b></li>
					</c:if>
				</ul>
			</div>
		</div>
	</div>
</div>
