<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div>
	<s:form action="signUp" method="post" enctype="multipart/form-data">
		<s:textfield name="user.email" label="Email"></s:textfield>
		<s:textfield name="user.username" label="Username"></s:textfield>
		<s:password name="user.password" label="Password"></s:password>
		<s:password name="passwordConfirm" label="Confirm Password"></s:password>
		<s:submit value="Sign Up" align="center" />
	</s:form>
</div>
