<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>list.jsp</title>
</head>
<body>
	<h1>�����Խ��� ����Ʈ</h1>
	<table width="1000" cellpadding="0" cellspacing="0" border="1">
		<tr>
			<td>��ȣ</td>
			<td>����</td>
			<td>�۾���</td>
			<td>�Խ���</td>
			<td>��ȸ��</td>
		</tr>
		
		<c:forEach items="${list }" var="dto">
			<tr>
				<td>${dto.bid }</td>
				<td width="50%">
					<c:forEach begin="1" end="${dto.bindent}">&nbsp;&nbsp;&nbsp;</c:forEach>
					<a href="content_view.do?bid=${dto.bid }">${dto.btitle }</a>
				</td>
				<td>${dto.bname }</td>
				<td>${dto.bdate }</td>
				<td>${dto.bhit }</td>
			</tr>
		</c:forEach>
		
		<tr>
			<td colspan="5"><a href="write_view.do">�Խñ� �ۼ�</a></td>
		</tr>
	</table>
</body>
</html>