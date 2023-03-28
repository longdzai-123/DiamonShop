<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layouts/user/taglib.jsp" %>

			<div id="sidebar" class="sidebar esponsive ace-save-state" >
				<ul class="nav nav-list"  >
					<li class="active">
						<a href="<c:url value="/admin/home"/>" >
							<i class="menu-icon fa fa-tachometer"></i>
							<span class="menu-text"> Đơn hàng </span>
						</a>

						<b class="arrow"></b>
					</li>
					<li class="">
						<a href="<c:url value="/admin/danh-muc" />">
							<i class="menu-icon fa fa-list"></i>
							<span class="menu-text"> Danh mục chủng loại </span>
						</a>

						<b class="arrow"></b>
					</li>	
					<li class="">
						<a href="<c:url value="/admin/listAdminProduct" />" >
							<i class="menu-icon fa fa-desktop"></i>
							<span class="menu-text">Tất cả sản phẩm </span>
						</a>
					</li>
					<li class="">
						<a href="widgets.html">
							<i class="menu-icon fa fa-list-alt"></i>
							<span class="menu-text"> Danh sách tài khoản </span>
						</a>

						<b class="arrow"></b>
					</li>			
				</ul>		
			</div>
    

