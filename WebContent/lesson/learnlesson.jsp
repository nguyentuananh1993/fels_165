<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="col-md-6 text-center">
	<h1>${word.content }</h1>
</div>
<div class="col-md-6">
	<s:iterator value="listAnswer">
		<div class="row">
			<br>
			<form
				action="${pageContext.request.contextPath}/lesson/learnLesson${category_id }"
				method="post">
				<input type="hidden" name="answer.word_answer_id"
					value="${word_answer_id }" /> <input type="hidden"
					name="answer.word_id" value="${word_id }" /> <input type="hidden"
					name="answer.content" value="${content }" />

				<button type="submit" class="btn btn-default btn-block">${content }</button>
			</form>
		</div>
	</s:iterator>
	
</div>
