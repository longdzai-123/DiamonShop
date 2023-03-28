<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layouts/user/taglib.jsp" %>
<head>
 <title>Trang chủ</title>
</head>
<body>
			
	
	<div class="main-content">
				<div class="main-content-inner">
					<div class="breadcrumbs ace-save-state" id="breadcrumbs">
						<ul class="breadcrumb">
							<li>
								<i class="ace-icon fa fa-home home-icon"></i>
								<a href="<c:url value="/admin/home"/>">Home</a>
							</li>
							<li class="active">Đơn hàng</li>
						</ul>

						<div class="nav-search" id="nav-search">
							<form class="form-search">
								<span class="input-icon">
									<input type="text" placeholder="Search ..." class="nav-search-input" id="nav-search-input" autocomplete="off" />
									<i class="ace-icon fa fa-search nav-search-icon"></i>
								</span>
							</form>
						</div>
					</div>

					<div class="page-content" style="font-size: 15px">
						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
								<div class="space-6"></div>

								<div class="row">
									<div class="col-sm-10 col-sm-offset-1">
										<div class="widget-box transparent">
											<div class="widget-header widget-header-large">
												<h3 class="widget-title grey lighter">
													<i class="ace-icon fa fa-leaf green"></i>
													Đơn hàng 
												</h3>
											</div>

											<div class="widget-body">
												<div class="widget-main padding-24">
													<div class="row">
														<div class="col-sm-6">
														</div><!-- /.col -->
													</div><!-- /.row -->

													<div class="space"></div>

													<div>
														<table class="table table-striped table-bordered">
															<thead>
																<tr>
																	<th class="center">Mã đơn hàng</th>
																	<th class="center"> Địa chỉ Email</th>
																	<th class="center">Họ tên khách hàng</th>
																	<th class="center">Số điện thoại</th>
																	<th class="center">Địa chỉ</th>
																	<th class="center">Số lượng sản phẩm</th>											
																	<th class="center">Tổng tiền đơn hàng</th>
																	<th class="center">Ghi chú đơn hàng</th>
																	<th></th>
																</tr>
															</thead>

															<tbody>
															  <c:forEach var="item" items="${listBills}">
																	<tr>
																		<td class="center">${item.id}</td>
																		<td class="center">${item.user}</td>
																		<td class="center">${ item.display_name}</td>
																		<td class="center">${item.phone}</td>																		
																		<td class="center">${ item.address}</td>																		
																		<td class="center">${ item.quanty}</td>
																		<td class="center"><strong><fmt:formatNumber type="number" groupingUsed="true" value="${ item.total  }" /> ₫</strong></td>
																		<td class="center">${item.note}</td>
																		<td class="center"><a href='<c:url value="chi-tiet-don-hang/${item.id}" />' >Xem chi tiết đơn hàng</a></td>
																		
																	</tr>
															  </c:forEach>
															</tbody>
														</table>
													</div>

													<div class="hr hr8 hr-double hr-dotted"></div>
													<div class="space-6"></div>
												</div>
											</div>
										</div>
									</div>
								</div>

								<!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->
					</div><!-- /.page-content -->
				</div>
			</div><!-- /.main-content -->


		
</body>
-