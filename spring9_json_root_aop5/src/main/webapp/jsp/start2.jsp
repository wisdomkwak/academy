<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>DB Basic</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="./resources/js/getdata2.js"></script>
<style>
table {
	boarder-collapse: collapse;
}

th, td {
	width: 100px;
	text-align: center
}
</style>
</head>
<body>
	<div>
		<form id="insert_form" action="jsontest2">
			<fieldset>
				<legend>데이터 추가</legend>
				<table>
					<tr>
						<td><label>상품명</label></td>
						<td><input type="text" name="name" id="name"></td>
					</tr>
					<tr>
						<td><label>모델 번호</label></td>
						<td><input type="text" name="modelnumber" id="modelnumber"></td>
					</tr>
					<tr>
						<td><label>시리즈</label></td>
						<td><input type="text" name="series" id="series"></td>
					</tr>
				</table>
				<input type="submit" value="추가">
			</fieldset>
		</form>
	</div>
	<table border="1">
		<thead>
			<tr>
				<th>아이디</th>
				<th>상품명</th>
				<th>모델번호</th>
				<th>시리즈</th>
			</tr>
		</thead>
		<tbody id="output">
		</tbody>
	</table>
</html>