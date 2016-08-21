<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="container">
    <div class="col-md-4 col-md-offset-4">
        <s:iterator value="listCategory">
            <div class="row text-center">
                <h3>
                    ${name }
                </h3>
            </div>
        </s:iterator>
    </div>
</div>