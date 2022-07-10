<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
function daumPost(){
    new daum.Postcode({
        oncomplete: function(data) {
			console.log(data.zonecode)
			console.log(data.userSelectedType)
			console.log(data.roadAddress)
			console.log(data.jibunAddress)
			
			let addr="";
			if(data.userSelectedType == 'R')
				addr = data.roadAddress
			else
				addr = data.jibunAddress
			$("#addr1").val(data.zonecode)
			$("#addr2").val( addr )
        }
    }).open();
}
</script>
</head>
<body>
	<%@include file="../default/header.jsp" %>
	<h1>회원가입</h1>
	<form id="fo" method="post" action="register">
		<table>
			<tr>
				<th>아이디</th>
				<td><input type="text" id="id" name="id"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" id="pw" name="pw"></td>
			</tr>
			<tr>
				<th>닉네임</th>
				<td><input type="text" id="nick" name="nick"></td>
			</tr>
			<tr>
				<th>주소</th>
				<td>
					<input type="text" id="addr1" placeholder="우편번호" readonly name="addr">
					<input type="button" value="우편번호 찾기" onclick="daumPost()">
					<br>
					<input type="text" name="addr" id="addr2" placeholder="주 소" readonly>
					<input type="text" name="addr" placeholder="상세주소">
				</td>
			</tr>
			<tr>
				<th>나이</th>
				<td><input type="number" id="age" name="age"></td>
				
			</tr>
			<tr>
				<th>성별</th>
				<td><select id="gender" name="gender">
						<option value="male">남성</option>
						<option value="female">여성</option>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="회원가입">
				</td>
			</tr>
		</table>
	</form>
	
</body>
</html>