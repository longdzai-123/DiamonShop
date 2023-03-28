<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<head>
<title>Danh sách chủng loại</title>
</head>
<body>

	<div class="main-content">
		<div class="main-content-inner">
			<div class="breadcrumbs ace-save-state" id="breadcrumbs">
				<ul class="breadcrumb">
					<li><i class="ace-icon fa fa-home home-icon"></i> <a
						href="<c:url value="/admin/home"/>">Home</a></li>

					<li class="active">Danh mục chủng loại</li>
					<li class="active">Thêm danh mục</li>
				</ul>

				<div class="nav-search" id="nav-search">
					<form class="form-search">
						<span class="input-icon"> <input type="text"
							placeholder="Search ..." class="nav-search-input"
							id="nav-search-input" autocomplete="off" /> <i
							class="ace-icon fa fa-search nav-search-icon"></i>
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
											<i class="ace-icon fa fa-leaf green"></i> Thêm danh mục
										</h3>
									</div>
                                <div class="well">
									<form:form action="savedanhmuc" modelAttribute="categorys">
									    
									    <div>
									      <div class="control-group">
									        <label class="control-label" >Nhập mã danh mục :  </label>
									        <form:input class="span3" type="number"  placeholder="Nhập mã danh mục" path="id"/>
									      </div>
									      <br>
									      <div class="control-group">
									        <label class="control-label" >Nhập tên danh mục :  </label>
									         <form:input class="span3" type="text" placeholder="Nhập tên danh mục" path="name"/> 
									      </div>
									      <br>
									     <div class="control-group">
									        <label class="control-label" >Nhập mô tả :  </label>
									         <form:input class="span3" type="text" placeholder="Nhập mô tả" path="description"/> 
									      </div>
									       <br>
		
									    </div>									
										<div class="controls">
											<button class="btn btn-success" type="submit">Thêm danh mục</button>
										</div>
									</form:form>
							 </div>

								</div>
							</div>
						</div>


					</div>

				</div>

			</div>

		</div>
	</div>



</body>