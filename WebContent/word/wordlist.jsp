<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
    <!-- Form -->
    <form action="wordFilterByCategory" method="POST">
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
            </div>
        </div>
        <div class="row">
            <input class="btn btn-default col-md-offset-8" type="submit" value="Filter">
        </div>
    </form>
    <hr>
    <!-- List Word -->
    <div class="row">
        <div class="col-md-12">
            <c:forEach items="${mapWord }" var="entry">
                <div class="col-md-3">${entry.key.content }</div>
                <div class="col-md-3">${entry.value.content }</div>
            </c:forEach>
        </div>
    </div>
</div>