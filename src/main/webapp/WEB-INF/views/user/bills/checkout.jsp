<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<head>
<title>Thanh toán</title>
</head>
<body>
	<div class="row">
		<div id="sidebar" class="span3">
			<div class="well well-small">
				<ul class="nav nav-list">
					<c:forEach var="item" items="${categorys}">
				   		<li><a href='<c:url value="/san-pham/${item.id}"/>'>
						     <i class="icon-circle-blank"></i>${item.name}</a>
					    </li>
				   </c:forEach>
					

					<li><a class="totalInCart" href="cart.html"><strong>Đã mua<span class="badge badge-warning pull-right" style="line-height: 18px;"><fmt:formatNumber type="number" groupingUsed="true" value="${TotalPriceCart}" /> ₫   </span>
						</strong></a></li>
				</ul>
			</div>

			
			

		</div>
		<div class="span9">
			<ul class="breadcrumb">
				<li><a href="index.html">Trang chủ</a> <span class="divider">/</span></li>
				<li class="active">Người dùng</li>
			</ul>
			<h3>Người dùng</h3>
			<hr class="soft" />

			<div class="row">
					<div class="well" >
						<form:form action="checkout" class="form-horizontal" method="POST" modelAttribute="bills">
							<h3>Thanh toán đơn hàng</h3>
							<div class="control-group">
								<label class="control-label">Họ tên<sup>*</sup></label>
								<div class="controls">
									<form:input type="text" class="span3" placeholder="Mời nhập họ tên" path="display_name"/>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Email<sup>*</sup></label>
								<div class="controls">
									<form:input type="email" class="span3" placeholder="Mời nhập Email" path="user"/>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Liên hệ<sup>*</sup></label>
								<div class="controls">
									<form:input type="text" class="span3" placeholder="Mời nhập số điện thoại" path="phone"/>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Địa chỉ<sup>*</sup></label>
								<div class="controls">								
									<form:textarea type="address" class="span3" rows="5" cols="30"  path="address"/>
								</div>
								
							</div>
							<div class="control-group">
								<label class="control-label">Ghi chú<sup>*</sup></label>
								<div class="controls">
								    <form:textarea type="text" class="span3" rows="5" cols="30"  path="note"/>
								</div>
								
							</div>
							
							<div class="control-group">
								<div class="controls">
									<input type="submit" name="submitAccount" value="Thanh toán" class="shopBtn exclusive">
								</div>
							</div>
						</form:form>
					</div>
			</div>

		</div>
	</div>


</body>
