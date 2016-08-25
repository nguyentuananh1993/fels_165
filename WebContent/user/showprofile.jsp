<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
	<div class="row">
		<div class="col-md-12 text-center">
			<h2>USER PROFILE</h2>
			<br> <br>
		</div>
	</div>
	<!-- USER PROFILE ROW STARTS-->
	<div class="row">
		<div class="col-md-3 col-sm-3">
			<div class="user-wrapper">
				<img src="..<s:property value='user.avatar'/>" />
				<div class="description">
					<h4>
						<s:property value="user.username" />
					</h4>
					<h5>
						<strong> <s:property value="user.email" />
						</strong>
					</h5>
					<hr>
					<a href="#" class="btn btn-danger btn-sm"> <i
						class="fa fa-font"></i> &nbsp;Words
					</a> <a href="#" class="btn btn-danger btn-sm"> <i
						class="fa fa-list"></i> &nbsp;Lession
					</a>
				</div>
			</div>
		</div>
		<div class="col-md-9 col-sm-9  user-wrapper">
			<c:forEach items="${listActivity}" varStatus="loop">
				Learn 20 words from category <c:out value="${listCategory[loop.index].name}" />	at <c:out value="${listActivity[loop.index].created_at}" /><br>
			</c:forEach>
		</div>
		<!-- USER PROFILE ROW END-->
	</div>
</div>