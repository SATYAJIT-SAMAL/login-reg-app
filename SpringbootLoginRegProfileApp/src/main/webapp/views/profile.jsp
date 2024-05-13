<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile</title>
		<link rel="stylesheet" type="text/css" href="/css/style.css" />
	</head>
	<body>
		<div class="body_div">
			<br/> <span class="body_text_title" style="color: green"> Welcome : ${session_name} </span> <br/> <br/> <br/>
			<b> Email : </b> ${session_email} <br/> <br/>
			<b> Gender : </b> ${session_gender} <br/> <br/>
			<b> City : </b> ${session_city} <br/> <br/>
		</div>
	</body>
</html>