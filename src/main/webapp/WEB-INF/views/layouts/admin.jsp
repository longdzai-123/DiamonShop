<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ include file="/WEB-INF/views/layouts/user/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title><decorator:title default="Master-layouts"/></title>
		<decorator:head/>

		<meta name="description" content="overview &amp; stats" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
		<link rel="stylesheet" href="<c:url value="/assets/admin/css/bootstrap.min.css"/>"/>
		<link rel="stylesheet" href="<c:url value="/assets/admin/font-awesome/4.5.0/css/font-awesome.min.css"/>" />
		<link rel="stylesheet" href="<c:url value="/assets/admin/css/font-awesome.css"/> " />
		<link rel="stylesheet" href="<c:url value="/assets/admin/css/ace.min.css"/>" class="ace-main-stylesheet" id="main-ace-style" />
		<link rel="stylesheet" href="<c:url value="/assets/admin/css/ace-skins.min.css"/>" />
		<link rel="stylesheet" href="<c:url value="/assets/admin/css/ace-rtl.min.css"/>" />
		<script src="<c:url value="/assets/admin/js/ace-extra.min.js"/>"></script>

		
	</head>

	<body class="no-skin">
		<div id="navbar" class="navbar navbar-default          ace-save-state">
			<div class="navbar-container ace-save-state" id="navbar-container">

				<div class="navbar-header pull-left">
					<a href="index.html" class="navbar-brand">
						<small>
							<i class="fa fa-leaf"></i>
							Trang Admin
						</small>
					</a>
				</div>

				<div class="navbar-buttons navbar-header pull-right" role="navigation">
					<ul class="nav ace-nav">
						<li class="light-blue dropdown-modal">
							<a data-toggle="dropdown" href="#" class="dropdown-toggle">
								<span class="user-info">
									<small>${loginAdminInfo.display_name}</small>
								</span>

								<i class="ace-icon fa fa-caret-down"></i>
							</a>

							<ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
								<li>
									<a href="<c:url value="/trang-chu"/>" >
										<i class="ace-icon fa fa-power-off"></i>
										Thoát 
									</a>
								</li>
							</ul>
						</li>
					</ul>
				</div>
			</div>
		</div>
		
        <div class="main-container ace-save-state" id="main-container"> 
        
            <%@include file="/WEB-INF/views/layouts/admin/header.jsp" %>
		    <decorator:body/>
		    
        </div>
        
        
        
		<script src="<c:url value="/assets/admin/js/jquery-2.1.4.min.js"/>"></script>
		<script src='<c:url value="/assets/admin/js/bootstrap.min.js"/>'></script>
		<script src="<c:url value="/assets/admin/js/jquery-ui.custom.min.js"/>"></script>
		<script src="<c:url value="/assets/admin/js/jquery.ui.touch-punch.min.js"/>"></script>
		<script src="<c:url value="/assets/admin/js/jquery.easypiechart.min.js"/>"></script>
		<script src="<c:url value="/assets/admin/js/jquery.sparkline.index.min.js"/>"></script>
		<script src="<c:url value="/assets/admin/js/jquery.flot.min.js"/>"></script>
		<script src="<c:url value="/assets/admin/js/jquery.flot.pie.min.js"/>"></script>
		<script src="<c:url value="/assets/admin/js/jquery.flot.resize.min.js"/>"></script>
		<script src="<c:url value="/assets/admin/js/ace-elements.min.js"/>"></script>
		<script src="<c:url value="/assets/admin/js/ace.min.js"/>"></script>
	</body>
</html>