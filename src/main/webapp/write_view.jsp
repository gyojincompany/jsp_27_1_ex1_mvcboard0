<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�Խ��� �۾���</title>
</head>
<body>
	<h1>�����Խ���</h1>
	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<form action="write.do" method="post">
			<tr>
				<td>�� ��</td>
				<td><input type="text" name="bname" size="50"></td>
			</tr>
			<tr>
				<td>�� ��</td>
				<td><input type="text" name="btitle" size="50"></td>
			</tr>
			<tr>
				<td>�� ��</td>
				<td><textarea name="bcontent" rows="10" cols="46"></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="�Է�">&nbsp;&nbsp;&nbsp;&nbsp;<a href="list.do">�� ����Ʈ ����</a></td>
			</tr>		
		</form>	
	</table>
</body>
</html>