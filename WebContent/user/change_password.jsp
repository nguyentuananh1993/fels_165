<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="container">
    <div class="card card-container">
      <h2 class="text-center">Change Password</h2>
      <p id="profile-name" class="profile-name-card"></p>
      <form class="form-signin" action="changePassword" method="post">
        <input type="password" id="inputPassword" name="password" class="form-control" 
        placeholder="Password" required>
        <input type="password" id="reinputPassword" name="passwordConfirm"
        class="form-control" placeholder="Re-input Password" required>
        <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit"> Change </button>
      </form>
    </div>
  </div>