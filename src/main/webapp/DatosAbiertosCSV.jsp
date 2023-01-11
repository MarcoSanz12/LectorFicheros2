<%@page import="archivocsv.DatosCSV"%>
<%@page import="archivocsv.ArchivoCSV"%>
<%@page import="common.ServletAccesoDA"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
// Aquí puedes llamar al método de leer tu arcivho:
ArrayList<DatosCSV> objetos = new ArrayList<>();
try {
	objetos = ArchivoCSV.readCSV();
} catch (Exception e) {

}
%>
<!DOCTYPE html>
<html>
<head>
<title>Datos abiertos</title>
</head>
<body>
	<table border="1">
		<%
		for (DatosCSV obj : objetos) {
		%>
		<tr>
			<td><%=obj.getDato1()%></td>
			<td><%=obj.getDato2()%></td>
			<td><%=obj.getDato3()%></td>
			<td><%=obj.getDato4()%></td>
			<td><%=obj.getDato5()%></td>
			<td><%=obj.getDato6()%></td>
		</tr>
		<%
		}
		%>
	</table>

	<br>
	<a href="AccesoDA.jsp">Volver</a>
</body>
</html>
