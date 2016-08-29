<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
	<!-- Form -->
	<form action="wordFilter" method="POST" class="filter">
		<!-- Option -->
		<div class="row">
			<div class="col-md-8 col-md-offset-2">
				<div class="col-md-6">
					<label for="category">Category</label> 
					<select class="form-control" name="category">
						<s:iterator value="listCategory">
							<s:if test="compare(category,name)">
								<option value="${name }" selected>${name }</option>
							</s:if>
							<s:else>
								<option value="${name }">${name }</option>
							</s:else>
						</s:iterator>
					</select>
				</div>
				<div class="col-md-6">
					<br><br>
					<s:if test="compare(typeCurrent,'1')">
					<s:radio name="typeCurrent" list="#{'1':'Leaned','2':'Not Leaned','3':'All'}" value="1"/>
					</s:if>
					<s:else>
					<s:if test="compare(typeCurrrent,'2')">
					<s:radio name="typeCurrent" list="#{'1':'Leaned','2':'Not Leaned','3':'All'}" value="2"/>
					</s:if>
					<s:else>
					<s:radio name="typeCurrent" list="#{'1':'Leaned','2':'Not Leaned','3':'All'}" value="3"/>
					</s:else>
					</s:else>
					<s:property value='typeCurrent'/>
				</div>
			</div>
		</div>
		<div class="row">
			<input class="btn btn-default col-md-offset-9" type="submit"
				value="Filter">
		</div>
	</form>
	<hr>
	<!-- List Word -->
	<div class="row terms col-md-8 col-md-offset-2">
		<div class="col-md-12 col-sm-12">
			<c:forEach items="${mapWord }" var="entry">
				<div class="row term">
					<div class="col-md-6 col-sm-6">${entry.key.content }</div>
					<div class="col-md-6 col-sm-6">${entry.value.content }</div>
				</div>
			</c:forEach>
		</div>
	</div>
</div>