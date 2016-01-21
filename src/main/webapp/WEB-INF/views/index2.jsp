<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<meta charset=UTF-8">
<title>Flamenco</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/master.css" type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/login.css" type="text/css">

<script src="${pageContext.request.contextPath}/js/jquery-1.7.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.spinner.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/forms/jquery.validate.min.js"></script>

<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600'
	rel='stylesheet' type='text/css'>
<!--[if lt IE 9]>
  <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
  <![endif]-->

<script>
	$(document).ready(function() {
		$('div.wrapper').hide();
		$('div.wrapper').fadeIn(1200);
		$('#lg-form').validate();
		$('.submit').click(function() {
			var $this = $(this);
			$this.spinner();
			setTimeout(function() {
				$this.spinner('remove');
			}, 1000);
		});
	});
</script>


</head>
<body>
	<div class="wrapper">
		<div class="logo">
			<h1>LOGIN PAGE</h1>
		</div>
		<div class="lg-body">
			<div class="inner">
				<div id="lg-head">
					<p>
						<span class="font-bold">Adminity</span>: Please login to access
						the control panel.
					</p>
					<div class="separator"></div>
				</div>
				<div class="login">
					<form id="lg-form" method="post" action="${pageContext.request.contextPath}/login">
						<fieldset>
							<ul>
								<li id="usr-field"><input class="input required"
									name="admin" type="text" size="26" minlength="1"
									placeholder="Username..." /></li>
								<li id="psw-field"><input class="input required"
									name="passWord" type="password" size="26" minlength="1"
									placeholder="Password..." /></li>
								<li class="checkbox"><input class="checkbox"
									type="checkbox" id="remember-me" value="remember" /> <label
									for="remember-me" class="checkbox-text">Remeber Me</label></li>
								<li><input class="submit" type="submit" value="" /></li>
							</ul>
						</fieldset>
					</form>
					<span id="lost-psw"> <a href="#">I forgot my password</a>
					</span>
				</div>
			</div>
		</div>
	</div>
	<div style="display: none">
		<script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540'
			language='JavaScript' charset='gb2312'></script>
	</div>
</body>
</html>