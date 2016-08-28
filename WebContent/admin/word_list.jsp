<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- CONTAINER START-->
<div class="container">
	<div class="row">
		<div class="col-md-12 text-center">
			<h2>WORD LISTS</h2>
			<br> <br>
		</div>
	</div>
	<div class="row">
		<div class="col-md-3 col-sm-3">
			<div class="menu-bar">
				<ul>
					<li class="menu-title">MENU</li>
					<li class="menu-item"><a href="<s:url value="/admin/"/>">Home</a></li>
					<li class="menu-item menu-selected"><a
						href="<s:url value="/admin/word"/>">Words</a></li>
					<li class="menu-item"><a
						href="<s:url value="/admin/category"/>">Category</a></li>
					<li class="menu-item"><a href="<s:url value="/admin/user"/>">Users</a></li>
				</ul>
			</div>
		</div>
		<div class="col-md-9 col-sm-9 user-wrapper">
			<div class="description">
				<div class="row text-right">
					<a href="#"
						class="btn btn-warning" onclick="return notImplementDialog();"> <i class="fa fa-upload"></i>&nbsp;
						Import
					</a> <a href="#"
						class="btn btn-success" onclick="return notImplementDialog();"> <i class="fa fa-download"></i>&nbsp;
						Export
					</a> <a href="<s:url value="/admin/wordAdd"/>"
						class="btn btn-social btn-linkedin"> <i class="fa fa-plus"></i>&nbsp;
						Add
					</a> <a href="<s:url value="/admin/wordDeleteAll"/>"
						class="btn btn-danger" onclick="return confirmDeleteAll();"> <i
						class="fa fa-remove"></i>&nbsp; Delete All
					</a>
				</div>
				<div class="row">
					<div class="col-md-12 col-sm-12">
						<table class="table">
							<thead>
								<tr style="">
									<th>ID</th>
									<th style="width: 200px;">Word</th>
									<th>Category ID</th>
									<th class="text-center" style="width: 300px;">Action</th>
								</tr>
							</thead>
							<tbody>
								<s:iterator value="listWord">
									<tr>
										<td>${word_id }</td>
										<td>${content }</td>
										<td>${category_id }</td>
										<td class="text-right"><a href="<s:url value="/admin/wordEdit"/>${word_id}"
											class="btn btn-warning"> <i class="fa fa-edit"></i>&nbsp;
												Edit
										</a> <a href="<s:url value="/admin/wordDelete"/>${word_id}"
											class="btn btn-danger" onclick="return confirmDelete();">
												<i class="fa fa-remove"></i>&nbsp; Delete
										</a></td>
									</tr>
								</s:iterator>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- USER PROFILE ROW END-->
</div>
<!-- CONTAINER END-->