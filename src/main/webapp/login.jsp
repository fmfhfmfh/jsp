<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<script src="${pageContext.request.contextPath}/js/js.cookie-2.2.1.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	function getCookieValue(cookieName){
		result = "";
		var cookies = document.cookie.split("; ");
		for(i = 0; i < cookies.length; i++){
			cookieArr = cookies[i].split("=");
			if(cookieArr[0] == cookieName){
				 result = cookieArr[1];
			}
		}
		return result;
	}
	
	function setCookie(cookieName, cookieValue, expires){
		
// 		"USERID=brown; path=/; expires=Wed, 07 Oct 2020 00:38:35 GMT;"
		var today = new Date();
		// 현재 날짜에서 미래로 + expires 만큼 한 날짜 구하기
		today.setDate(today.getDate() + expires);
		document.cookie = cookieName + "=" + cookieValue + "; path=/; expires=" + today.toGMTString();
		console.log(document.cookie)
	}

	// 해당쿠기의 expires속성을 과거 날짜로 변경
	function deleteCookie(cookieName){
		setCookie(cookieName, "", -1);
	}


	$(function(){
// 		if(getCookieValue("REMEMBERME") == 'Y'){
// 			$('input[name="remember"]').prop('checked', true);
// 			$('#inputEmail').attr("value", getCookieValue("USERID"));
// 		}
		if(Cookies.get("REMEMBERME") == 'Y'){
			$('input[type=checkbox]').prop('checked', true);
			$('#inputEmail').val(Cookies.get("USERID"));
		}


		// sign in 버튼이 클릭 되었을 댸 이벤트 핸들러
		$('button').on('click', function(){
			email = $('#inputEmail').val();
			if($('input[type=checkbox]').prop('checked') == true){
				Cookies.set("REMEMBERME",'Y');
				Cookies.set("USERID", email);
			}else{
				Cookies.remove("REMEMBERME");
				Cookies.remove("USERID");
			}
			//submit
			$('form').submit();
		})
	
		
	})
		
	

</script>

  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
<!--     <link rel="icon" href="../../favicon.ico"> -->
	
    <title>Signin Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/css/signin.css" rel="stylesheet">

  </head>

  <body>
    <div class="container">

      <form class="form-signin" action="${pageContext.request.contextPath}/login" method="POST">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="email" id="inputEmail" name="userId" class="form-control" value="brown" placeholder="Email address" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" name="password" class="form-control" value="brownPass" placeholder="Password" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me" name="remember"> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="button">Sign in</button>
      </form>

    </div> <!-- /container -->
  </body>
</html>
    