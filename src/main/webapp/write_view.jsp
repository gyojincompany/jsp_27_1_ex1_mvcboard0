<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>게시판 글쓰기</title>
</head>
<body>
	<h1>자유게시판</h1>
	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<form action="write.do" method="post">
			<tr>
				<td>이 름</td>
				<td><input type="text" name="bname" size="50"></td>
			</tr>
			<tr>
				<td>제 목</td>
				<td><input type="text" name="btitle" size="50"></td>
			</tr>
			<tr>
				<td>내 용</td>
				<td><textarea name="bcontent" rows="10" cols="46"></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="입력">&nbsp;&nbsp;&nbsp;&nbsp;<a href="list.do">글 리스트 보기</a></td>
			</tr>		
		</form>	
	</table>
</body>
</html>