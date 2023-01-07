<%@page import="service.GardeService"%>
<%@page import="entities.Garde"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PharmaLoc</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<link rel="stylesheet" href="/WEB-INF/template/style.css">
</head>
<body>

	<!-- Header -->
	<jsp:include page="/WEB-INF/template/header.jsp" />

	<!-- Contenu -->
	<div class="container mt-5">
		<h1>Garde</h1>
		<form action="GardeController" method="get">
			<input type="hidden" name="id"
				value="<%=request.getParameter("id") == null ? "" : request.getParameter("id")%>" />
			<div class="form-group">
				<label for="input-name">Type</label> <input type="text" name="nom"
					value="<%=request.getParameter("type") == null ? "" : request.getParameter("type")%>"
					class="form-control" id="type"
					placeholder="Entrez le type de la garde">
			</div>
			<button id="add" type="submit" class="btn btn-primary"><%=request.getParameter("id") == null ? "Ajouter" : "Modifier"%></button>
		</form>

		<br>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">TYPE</th>
					<th scope="col">ACTIONS</th>
				</tr>
			</thead>
			<tbody>
				<!-- Ajoutez ici les lignes du tableau pour chaque ville -->
				<%
				GardeService gs = new GardeService();
				for (Garde g : gs.findAll()) {
				%>
				<tr>
					<td><%=g.getId()%></td>
					<td><%=g.getType()%></td>
					<td><a href="GardeController?id=<%=g.getId()%>&op=update"
						class="btn btn-primary btn-sm mr-2"> <i class="fas fa-edit"></i>
							Modifier
					</a> <a href="GardeController?id=<%=g.getId()%>&op=delete"
						class="btn btn-danger btn-sm"> <i class="fas fa-trash-alt"></i>
							Supprimer
					</a></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>

	</div>

	<!-- Footer -->
	<jsp:include page="/WEB-INF/template/footer.jsp" />

	<!-- Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
		integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
		crossorigin="anonymous"></script>
</body>
</html>
