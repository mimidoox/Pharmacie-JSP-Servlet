<%@page import="entities.PharmacieDeGardePK"%>
<%@page import="entities.Garde"%>
<%@page import="entities.Pharmacie"%>
<%@page import="service.GardeService"%>
<%@page import="service.PharmacieService"%>
<%@page import="entities.PharmacieDeGarde"%>
<%@page import="service.PharmacieDeGardeService"%>
<!doctype html>
<html lang="fr">

<head>

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">

<title>Formulaire de création de pharmacie</title>
<script src="https://code.jquery.com/jquery-3.6.3.js" integrity="sha256-nQLuAZGRRcILA+6dMBOvcRh5Pe310sBpanc6+QBmyVM=" crossorigin="anonymous"></script>
</head>

<body>
	<!-- Header -->
	
	<jsp:include page="/WEB-INF/template/header.jsp" />
	<div class="container mt-5">
		<div class="row">
			<div class="col-md-6 offset-md-3">
			
				<h1 class="text-center mb-4">Pharmacie de garde</h1>
				<form id="firstform" action="PharmaGardeController" method="get" enctype="multipart/form-data">
				<input type="hidden" name="id"
				value="<%=request.getParameter("datedeb") == null ? ""  : request.getParameter("datedeb")%>" />

					<div class="form-group">
						<label for="pharma">Pharmacie</label> 
						
						<select class="form-control" name="pharmacie"
							id="pharmacie">
							<%
				PharmacieService ps = new PharmacieService();
				for (Pharmacie p : ps.findAll()) {
				%>
							<option value=<%=p.getId()%>><%=p.getNom()%></option>	
							<%
				}
				%>
						</select>
						
					</div>
					<div class="form-group">
						<label for="garde">Garde</label> 
						
						<select class="form-control" name="garde" id="garde">
							<%
								GardeService gs = new GardeService();
								for (Garde g : gs.findAll()) {
				%>
							<option value=<%=g.getId() %>><%=g%></option>	
							<%
				}
				%>
						</select>
						
					</div>
					<div class="form-group">
						<label for="datedeb">Date debut</label> <input type="date" 
							class="form-control" name="datedeb" class="form-control" id="datedeb">
					</div>
					<div class="form-group">
						<label for="datefin">Date fin</label> <input type="date" 
							class="form-control" name="datefin" class="form-control" id="datefin">
					</div>
					
					
					<button id="add" type="submit"  class="btn btn-primary btn-block"><%=request.getParameter("datedeb") == null ? "Créer" : "Modifier"%></button>
				</form>
			</div>
		</div>
		<div class="row mt-5">
			<div class="col-md-6 offset-md-3">
				<h2 class="text-center mb-4">Liste des pharmacies de garde</h2>
				<table class="table">
					<thead>
						<tr>
							<th scope="col">PHOTO</th>
							<th scope="col">PHARMACIE</th>
							<th scope="col">GARDE</th>
							<th scope="col">DATE DEBUT</th>
							<th scope="col">DATE FIN</th>
							<th scope="col">ACTIONS</th>
						</tr>
					</thead>
			<tbody>
				<!-- Ajoutez ici les lignes du tableau pour chaque ville -->
				<%
				
				PharmacieDeGardeService pdgs = new PharmacieDeGardeService();
				for (PharmacieDeGarde pdg : pdgs.findAll()) {
					
				%>
				<tr>
				  	<td><img src="images/"<%=pdg.getPharmacie().getPhotos().get(0).getUrl()%> style="width:75px;height:75px;"></td> 
					<td><%=pdg.getPharmacie()%></td>
					<td><%=pdg.getGarde()%></td>
					<td><%=pdg.getPk().getDateDebut() %></td>
					<td><%=pdg.getDateFin() %></td>
					<td><a href="PharmaGardeController?id=<%=request.getParameter("datedeb")%>&op=update"
						class="btn btn-primary btn-sm mr-2"> <i class="fas fa-edit"></i>
							Modifier
					</a> <a href="PharmaGardeController?id=<%=request.getParameter("datedeb")%>&op=delete"
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
		</div>
	</div>
<jsp:include page="/WEB-INF/template/footer.jsp" />

	
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.16.6/dist/umd/popper.min.js"
		integrity="sha384-Q2XjA0n+bJZPVZ8WpZj1nAJpAEYtRnG8WPU9+4B3tJ5Ht3Kj2gSZM5PZO5NQq5g5E"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
		integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
		crossorigin="anonymous"></script>
</body>

</html>

