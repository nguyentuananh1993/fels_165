<%@ taglib prefix="s" uri="/struts-tags"%>
<s:property value="user.user_id" />
<s:property value="user.username" />
<a href="<s:url value="/user/profile.jsp"/>">Edit Profile</a>
<a href="<s:url value="/user/showProfile"/>">Show Profile</a>
<a href="<s:url value="/word/wordFilterByCategory.action"/>">Word List</a>
<a href="<s:url value="/category/listAllCategory.action"/>">Categories</a>