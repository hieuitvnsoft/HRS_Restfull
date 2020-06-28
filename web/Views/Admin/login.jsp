<%-- 
    Document   : login
    Created on : Jul 22, 2019, 2:13:31 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Login Admin</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="/HRS/Views/Admin/images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/HRS/Views/Admin/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/HRS/Views/Admin/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/HRS/Views/Admin/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/HRS/Views/Admin/vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="/HRS/Views/Admin/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/HRS/Views/Admin/vendor/select2/select2.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="/HRS/Views/Admin/css/util.css">
	<link rel="stylesheet" type="text/css" href="/HRS/Views/Admin/css/main.css">
<!--===============================================================================================-->
</head>
<body>
	
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100 p-l-50 p-r-50 p-t-77 p-b-30">
                            <div style="color: #ee3148">${messs}</div>
                            <form method="POST"  class="login100-form validate-form" action="${pageContext.request.contextPath}/Admin/login.htm">
                                
					<span class="login100-form-title p-b-55">
						Login
					</span>
                                
					<div class="wrap-input100 validate-input m-b-16" data-validate = "Đăng nhập không được để trống!">
                                            <input class="input100" type="text" name="username" placeholder="Nhập tên đăng nhập" path="userName" value="hieuitvnsoft" id="username">
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<span class="lnr lnr-user"></span>
						</span>
					</div>

					<div class="wrap-input100 validate-input m-b-16" data-validate = "Mật khẩu không được để trống!">
                                            <input class="input100" type="password" name="password" placeholder="Nhập mật khẩu" value="Abc1234" path="password" id="password">
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<span class="lnr lnr-lock"></span>
						</span>
					</div>

					<div class="contact100-form-checkbox m-l-4">
						<input class="input-checkbox100" id="ckb1" type="checkbox" name="remember-me">
						<label class="label-checkbox100" for="ckb1">
							Remember me
						</label>
					</div>
					
					<div class="container-login100-form-btn p-t-25">
                                            <button type="submit" class="login100-form-btn">
							Login
						</button>
					</div>

					<div class="text-center w-full p-t-42 p-b-22">
						<span class="txt1">
							
						</span>
					</div>

					

					<div class="text-center w-full p-t-115">
						<span class="txt1">
							
						</span>

						<a class="txt1 bo1 hov1" href="#">
												
						</a>
					</div>
				</form>
			</div>
		</div>
	</div>
	
	

	
<!--===============================================================================================-->	
	<script src="/HRS/Views/Admin/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="/HRS/Views/Admin/vendor/bootstrap/js/popper.js"></script>
	<script src="/HRS/Views/Admin/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="/HRS/Views/Admin/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="/HRS/Views/Admin/js/main.js"></script>

</body>
</html>