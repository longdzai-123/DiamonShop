<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<head>
<title>Chi tiết sản phẩm</title>
<style>
.product-content {
	overflow-x: hidden;
}
</style>
</head>
<body>
	<div class="row product-content">
		<div id="sidebar" class="span3">
			<div class="well well-small">
				<ul class="nav nav-list">
					<c:forEach var="item" items="${categorys}">
						<li style="font-size: 17px"><a href='<c:url value="/san-pham/${item.id}"/>'> <i
								class="icon-chevron-right" ></i>${item.name}</a></li>
					</c:forEach>


					<li><a class="totalInCart" href="cart.html"><strong>Đã
								mua<span class="badge badge-warning pull-right"
								style="line-height: 18px;"><fmt:formatNumber
										type="number" groupingUsed="true" value="${TotalPriceCart}" />
									₫ </span>
						</strong></a></li>
				</ul>
			</div>

		</div>
		<div class="span9">
			<ul class="breadcrumb">
				<li><a href="index.html">Trang chủ</a> <span class="divider">/</span></li>
				<li><a href="products.html">Sản Phẩm</a> <span class="divider">/</span></li>
				<li class="active">Chi tiết sản phẩm</li>
			</ul>
			<div class="well well-small">
				<div class="row-fluid">
					<div class="span5">
						<div id="myCarousel" class="carousel slide cntr">
							<div class="carousel-inner">
								<div class="item active">
									<a href="#"> <img
										src="<c:url value="/assets/user/img/${ product.img }"/>"
										alt="" style="width: 100%"></a>
								</div>
							</div>
							<a class="left carousel-control" href="#myCarousel"
								data-slide="prev">‹</a> <a class="right carousel-control"
								href="#myCarousel" data-slide="next">›</a>
						</div>
					</div>
					<div class="span7">
						<h3>${product.name }</h3>
						<hr class="soft" />

						<form class="form-horizontal qtyFrm" method="get"
							action="<c:url value="/AddCart/${ product.id_product }"/>">
							<div class="control-group">
								<label class="control-label"><span><fmt:formatNumber
											type="number" groupingUsed="true" value="${ product.price  }" />
										₫ </span></label>
								<div class="controls">
									<input type="number" min="0" value="0" class="span6">
								</div>
							</div>

							<div class="control-group">
								<label class="control-label"><span>Color</span></label>
								<div class="controls">
									<select class="span11">
										<option>Red</option>
										<option>Purple</option>
										<option>Pink</option>
										<option>Red</option>6
									</select>
								</div>
							</div>

							<p>${product.title }
							<p>
								<button type="submit" class="shopBtn">
									<span class=" icon-shopping-cart"></span> Thêm vào giỏ hàng
								</button>
						</form>
					</div>
				</div>
				<hr class="softn clr" />


				<ul id="productDetail" class="nav nav-tabs">

					<li class="active"><a href="#cmt" data-toggle="tab">Nhận
							xét về sản phẩm</a></li>
					<li class=""><a href="#home" data-toggle="tab">Chi tiết
							sản phẩm</a></li>
					<li class=""><a href="#profile" data-toggle="tab">Sản phẩm
							liên quan</a></li>
				</ul>
				<div id="myTabContent" class="tab-content tabWrapper">
					<div class="tab-pane fade active in" id="cmt">
					    <div>
					        <c:forEach var="item" items="${listcmt}">
					        		<h5>${item.name_user}:</h5>
					        		<h5>${item.content}</h5>
					        		<br>
					        </c:forEach>
					    
					    </div>
					
						<div class="row">
							<div class="well">
								<form:form action="/DiamonShop/comment" class="form-horizontal"
									modelAttribute="comment">
									<h4>Nhận xét về sản phẩm</h4>
									<div class="control-group">
										<div class="controls">
											<form:textarea type="text" class="span3" rows="5" cols="30"
												path="content" />
										</div>
									</div>
									<div class="controls">
										<button type="submit" class="defaultBtn">Bình luận</button>
									</div>
								</form:form>
							</div>
						</div>
					</div>

					<div class="tab-pane fade" id="home">${product.details}</div>




					<div class="tab-pane fade" id="profile">

						<c:set var="countList" value="${ productByIDCategory.size() }" />

						<c:if test="${ productByIDCategory.size() > 10 }">
							<c:set var="countList" value="10" />
						</c:if>

						<c:forEach var="item" items="${ productByIDCategory }" begin="1"
							end="${countList}">

							<div class="row-fluid">
								<div class="span2">
									<img src="<c:url value="/assets/user/img/${ item.img }"/>"
										alt="">
								</div>
								<div class="span6">
									<h5>${item.name }</h5>
									<p>${item.title }</p>
								</div>
								<div class="span4 alignR">
									<form class="form-horizontal qtyFrm">
										<h3>
											<fmt:formatNumber type="number" groupingUsed="true"
												value="${ item.price  }" />
											₫
										</h3>

										<div class="btn-group">
											<a href="<c:url value="/AddCart/${ item.id_product }"/>"
												class="defaultBtn"><span class=" icon-shopping-cart"></span>
												Thêm vào giỏ hàng</a> <a href="product_details.html"
												class="shopBtn">Xem Sản Phẩm</a>
										</div>
									</form>
								</div>
							</div>
							<hr class="soft" />
						</c:forEach>


					</div>

				</div>

			</div>
		</div>
	</div>
	<!-- Body wrapper -->
</body>
