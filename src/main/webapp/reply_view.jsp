<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>reply_view.jsp</title>
</head>
<body>
	<h1>�����Խ��� �亯</h1>
	<table width="800" cellpadding="0" cellspacing="0" border="1">
		<form action="reply.do" method="post">
			<input type="hidden" name="bid" value="${reply_view.bid }">
			<input type="hidden" name="bgroup" value="${reply_view.bgroup }">
			<input type="hidden" name="bstep" value="${reply_view.bstep }">
			<input type="hidden" name="bindent" value="${reply_view.bindent }">
			
			<tr>
				<td align="center" width="10%">�� ȣ</td>
				<td width="20%">${reply_view.bid }</td>
				<td align="center" width="10%">������</td>
				<td><input type="text" name="btitle" size="60" value="${reply_view.btitle }"></td>
			</tr>
			<tr>
				<td align="center">�۾���</td>
				<td><input type="text" name="bname" value="${reply_view.bname }"></td>
				<td align="center">��ȸ��</td>
				<td>${reply_view.bhit }</td>
			</tr>
			<tr>
				<td align="center">�� ��</td>
				<td colspan="3"><textarea cols="90" name="bcontent" rows="10">${reply_view.bcontent }</textarea></td>
			</tr>
			<tr>
				<td align="center"><input type="submit" value="�亯"></td>
				<td colspan="3"><a href="list.do">�۸�Ϻ���</a></td>
			</tr>		
		</form>
	
	
	
	
	</table>
</body>
</html>