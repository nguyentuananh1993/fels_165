<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="container">
    <div class="card card-container">
      <h2 class="text-center">SIGN UP</h2>
      <p id="profile-name" class="profile-name-card"></p>
      <form class="form-signin" action="signUp" method="post">
        <span id="reauth-email" class="reauth-email"></span>
        <input type="email" id="inputEmail" name="user.email" class="form-control" 
        placeholder="Email address" required autofocus>
        <input type="text" id="inputUsername" name="user.username" class="form-control" 
        placeholder="Username" required autofocus>
        <input type="password" id="inputPassword" name="user.password" class="form-control" 
        placeholder="Password" required>
        <input type="password" id="reinputPassword" name="passwordConfirm"
        class="form-control" placeholder="Re-input Password" required>
        <div id="remember" class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> I agree with the <a href="#">Terms and Conditions</a>.
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Sign up</button>
      </form>   
    </div>
  </div>