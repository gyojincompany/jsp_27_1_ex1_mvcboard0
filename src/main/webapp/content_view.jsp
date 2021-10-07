<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>content_view.jsp</title>
</head>
<body>
	<h1>자유게시판 글보기</h1>
	<table width="800" cellpadding="0" cellspacing="0" border="1">
		<form action="modify.do" method="post">
			<tr>
				<td align="center" width="10%">번 호</td>
				<td width="20%"></td>
				<td align="center" width="10%">글제목</td>
				<td></td>
			</tr>
			<tr>
				<td align="center">글쓴이</td>
				<td></td>
				<td align="center">조회수</td>
				<td></td>
			</tr>
			<tr>
				<td align="center">내 용</td>
				<td colspan="3"></td>
			</tr>
			<tr>
				<td align="center"><input type="submit" value="수정"></td>
				<td colspan="3"><a href="list.do">글목록보기</a> &nbsp;&nbsp;&nbsp;&nbsp;삭 제&nbsp;&nbsp;&nbsp;&nbsp;답 변 </td>
			</tr>		
		</form>
	
	
	
	
	</table>
</body>
</html>