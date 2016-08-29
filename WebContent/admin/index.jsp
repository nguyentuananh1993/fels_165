<%@ taglib uri="/struts-tags" prefix="s"%>
<!-- CONTAINER START -->
  <div class="container">
    <div class="row">
      <div class="col-md-12 text-center">
        <h2>HOME</h2>
        <br>
        <br>
      </div>
    </div>
    <div class="row">
      <div class="col-md-3 col-sm-3">
        <div class="menu-bar">
          <ul>
            <li class="menu-title">MENU</li>
            <li class="menu-item menu-selected"><a href="<s:url value="/admin/"/>">Home</a></li>
            <li class="menu-item"><a href="<s:url value="/admin/word"/>">Words</a></li>
            <li class="menu-item"><a href="<s:url value="/admin/category"/>">Category</a></li>
            <li class="menu-item"><a href="<s:url value="/admin/user"/>">Users</a></li>
          </ul>
        </div>
      </div>
      <div class="col-md-9 col-sm-9 user-wrapper">
         <div class="row">
           <div class="col-md-12 col-sm-12 text-center">
           <h2>UNDER DESTRUCTION</h2>
           <img alt="" src="../images/admin-background.jpg">
           </div>
         </div>
      </div>
    </div>
    <!-- USER PROFILE ROW END-->
  </div>
<!-- CONATINER END -->