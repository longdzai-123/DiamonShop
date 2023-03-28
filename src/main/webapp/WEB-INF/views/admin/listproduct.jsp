<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layouts/user/taglib.jsp" %>
<head>
<title>Danh sách chủng loại</title>
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
							
							<li class="active">Chủng loại</li>
							<li class="active">Danh sách sản phẩm</li>
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
													Danh mục chủng loại
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
																	<th class="center">Mã sản phẩm</th>
																	<th class="center">Mã chủng loại</th>
																	<th class="center">Tên sản phẩm</th>
																	<th class="center">Giá</th>
																	<th class="center">Hình ảnh sản phẩm</th>
																	<th class="center">Chỉnh sửa</th>
																	<th class="center">Xóa</th>
																</tr>
															</thead>

															<tbody>
															  <c:forEach var="item" items="${listProduct}">
																	<tr>
																		<td class="center">${item.id_product}</td>
																		<td class="center">${item.id_category }</td>
																		<td class="center">${item.name }</td>
																		<td class="center"><strong><fmt:formatNumber type="number" groupingUsed="true" value="${item.price }" /> ₫</strong></td>
																		<td class="center"><img alt="" src="<c:url value="/assets/user/img/${item.img}"/>" width="80px" height="80px"></td>
																		<td class="center"><a href="<c:url value=""/>" class="btn btn-mini btn-primary" type="button"><span class="ace-icon fa fa-pencil-square-o"></span></a></td>
																		<td class="center"><a href="<c:url value=""/>" class="btn btn-mini btn-danger"><span class="ace-icon fa fa-trash-o"></span></a></td>
																	</tr>
															  </c:forEach>
															</tbody>
														</table>
														
													</div>

													<div class="hr hr8 hr-double hr-dotted"></div>
													<div class="space-6"></div>
												</div>
											</div>
											
											<div style="text-align: end;margin-right: 25px;margin-top:-40px">
											   <a href="<c:url value="them"/>" class = "btn btn-success" type="button">Thêm sản phẩm</a>
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