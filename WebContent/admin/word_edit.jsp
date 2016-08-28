<%@ taglib uri="/struts-tags" prefix="s"%>
<div class="container">
	<div class="row">
		<div class="col-md-12 text-center">
			<h2>WORD</h2>
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
				<div class="row">
					<h2>Edit word:</h2>
					<hr>
					<form class="form-signin" action="actionWordEdit" method="post">
						<input type="hidden" name="word.word_id"
							value="<s:property value="word.word_id"/>"/>
						<input type="hidden" name="word.created_at"
							value="<s:property value="word.created_at"/>"/> 
						<input type="hidden" name="word.updated_at"
							value="<s:property value="word.updated_at"/>"/>
						<table class="col-md-12 col-sm-12">
							<tbody>
								<tr>
									<td>Word</td>
									<td><input id="inputEmail" name="word.content"
										class="form-control" type="text" autofocus="" required=""
										placeholder="Email Address"
										value="<s:property value="word.content"/>"></td>
								</tr>
								<tr>
									<td>Category</td>
									<td><input id="inputUsername" name="word.category_id"
										class="form-control" type="text" autofocus="" required=""
										placeholder="Username"
										value="<s:property value="word.category_id"/>"></td>
								</tr>
							</tbody>
						</table>
						<div class="col-sm-12 col-md-12">
							<div class="col-sm-9 col-md-9"></div>
							<div class="col-sm-3 col-md-3">
								<button
									class="col-sm-3 col-md-3 btn btn-lg btn-primary btn-block btn-signin"
									type="submit">Edit</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- USER PROFILE ROW END-->
</div>