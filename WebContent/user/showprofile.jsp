<%@ taglib prefix="s" uri="/struts-tags"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
	<div class="row">
		<div class="col-md-12 text-center">
			<h2>USER PROFILE</h2>
			<br> <br>
		</div>
	</div>
	<!-- USER PROFILE ROW STARTS-->
	<div class="row">
		<div class="col-md-4 col-sm-4">
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
					<%
						String username = (String) request.getSession().getAttribute("username");

						String user_viewed = (String) request.getSession().getAttribute("user_viewed");

						String isRelated = (String) request.getSession().getAttribute("isRelated");
						if (username != null) {
							if (username.equals(user_viewed)) { %>
								<a href="<s:url value="/user/editProfile"/>"
									class="btn btn-danger btn-sm"> <i class="fa fa-font"></i> &nbsp;
									Edit Profile
								</a>
								<a href="<s:url value="/user/changePassword"/>"
									class="btn btn-danger btn-sm"> <i class="fa fa-font"></i> &nbsp;
									Change PassWord
								</a>								
							<% } else {
								if (isRelated.equals("false")) { %>
									<a href="<s:url value="/user/createRelationship"/>"
										class="btn btn-danger btn-sm"> <i class="fa fa-font"></i> &nbsp;
										Follow
									</a>									
							<%	}
								if (isRelated.equals("true")) { %>
								<a href="<s:url value="/user/deleteRelationship"/>"
									class="btn btn-danger btn-sm"> <i class="fa fa-font"></i> &nbsp;
									Unfollow
								</a>
								
							<%	}
							 
								
							}
						} %>
				</div>
			</div>
		</div>
		<div class="col-md-9 col-sm-9  user-wrapper">
			<c:forEach items="${listActivity}" varStatus="loop">

				Learn 20 words from category <c:out
					value="${listCategory[loop.index].name}" />	at <c:out
					value="${listActivity[loop.index].created_at}" />
				<br>

			</c:forEach>
		</div>
		<!-- USER PROFILE ROW END-->
	</div>
</div>


