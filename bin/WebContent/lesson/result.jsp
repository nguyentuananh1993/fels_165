<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="col-md-6">
	<s:iterator value="question">
		<div class="row">
			<br>
			${content }
		</div>
	</s:iterator>
	<s:iterator value="choice">
		<div class="row">
			<br>
			${content }
		</div>
	</s:iterator>
	<s:iterator value="result">
		<div class="row">
			<br>
			
		</div>
	</s:iterator>
	
	<div class="container">
    <div class="col-md-4 col-md-offset-4">
            <div class="row text-center">
                <h3>
                    <a href="${pageContext.request.contextPath}/lesson/learnLesson${category_id }">Continue</a>
                </h3>
            </div>
    </div>
    	<div class="container">
    <div class="col-md-4 col-md-offset-4">
            <div class="row text-center">
                <h3>
                    <a href="${pageContext.request.contextPath}/category/listAllCategory">Back</a>
                </h3>
            </div>
    </div>
    
</div>
</div>