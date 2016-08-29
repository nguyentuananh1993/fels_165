<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
USER LIST
<s:iterator value="userList">
	<div class="row">
		<a href="${pageContext.request.contextPath}/user/findByUserId${user_id }">${username }</a>
	</div>
</s:iterator>
