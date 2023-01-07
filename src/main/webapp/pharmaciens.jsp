<%@page import="service.PharmacienService"%>
<%@page import="entities.Utilisateur"%>
<%@page import="service.UtilisateurService"%>
<%@page import="entities.Pharmacien"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>PharmaLoc</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
</head>
<body>

	<!-- Header -->
	<jsp:include page="/WEB-INF/template/header.jsp" />

	<!-- Contenu -->
	<div class="container mt-5">
		<h1>Pharmaciens</h1>
		<form action="PharmacienController" method="get">
			<input type="hidden" name="id"
				value="<%=request.getParameter("id") == null ? "" : request.getParameter("id")%>" />
			
			
		</form>

		<br>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">NOM PRENOM</th>
					<th scope="col">LOGIN</th>
					<th scope="col">EMAIL</th>
					<th scope="col">MOT DE PASSE</th>
					<th scope="col">TELEPHONE</th>
					<th scope="col">DATE DE CREATION</th>
				</tr>
			</thead>
			<tbody>
				<!-- Ajoutez ici les lignes du tableau pour chaque Utilisateur -->
				<%
				PharmacienService ps = new PharmacienService();
				for (Pharmacien p : ps.findAll()) {
				%>
				<tr>
					<td><%=p.getId()%></td>
					<td><%=p.getNom()+" "+p.getPrenom()%></td>
					<td><%=p.getLogin()%></td>
					<td><%=p.getEmail()%></td>
					<td style="-webkit-text-security:disc;"><%=p.getPassword()%></td>
					<td><%=p.getTelephone()%></td>
					<td><%=p.getDateCreation()%></td>
					<td><a href="PharmacienController?id=<%=p.getId()%>&op=delete"
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
