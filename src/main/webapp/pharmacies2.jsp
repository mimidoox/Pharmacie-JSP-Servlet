
<%@page import="entities.Ville"%>
<%@page import="entities.Pharmacie"%>
<%@page import="entities.Zone"%>
<%@page import="service.VilleService"%>
<%@page import="service.ZoneService"%>
<%@page import="service.PharmacieService"%>
<%@page import="entities.Pharmacien"%>
<%@page import="service.PharmacienService"%>
<!doctype html>
<html lang="fr">

<head>

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
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
				<h1 class="text-center mb-4">Création de pharmacie</h1>
				<form id="firstform" action="PharmacieController" method="get">
				<input type="hidden" name="id"
				value="<%=request.getParameter("id") == null ? "" : request.getParameter("id")%>" />
					<div class="form-group">
						<label for="zoneName">Nom de la pharmacie</label> <input type="text"
							class="form-control" name="nom"
					value="<%=request.getParameter("nom") == null ? "" : request.getParameter("nom")%>"
					class="form-control" id="nom">
					</div>
					<div class="form-group">
						<label for="pharmacieName">Adresse</label> <input type="text"
							class="form-control" name="adresse" class="form-control" id="adresse">
					</div>
					<div class="form-group">
						<label for="pharma">Pharmacien</label> 
						
						<select class="form-control" name="pharmacien"
							id="pharmacien">
							<%
				PharmacienService phs = new PharmacienService();
				for (Pharmacien ph : phs.findAll()) {
				%>
							<option value=<%=ph.getId() %>><%=ph%></option>	
							<%
				}
				%>
						</select>
						
					</div>
					<div class="form-group">
						<label for="pharmacieName">Latitude</label> <input type="number"
							class="form-control" name="latitude" class="form-control" id="latitude">
					</div>
					<div class="form-group">
						<label for="pharmacieName">Longitude</label> <input type="number"
							class="form-control" name="longitude" class="form-control" id="longitude">
					</div>
					<div class="form-group">
						<label for="city">Ville</label> 
						
						<select class="form-control" name="city"
							id="city" onchange="change()">
							<%
				VilleService vs = new VilleService();
				for (Ville v : vs.findAll()) {
				%>
							<option value="<%=request.getParameter("city")==null?"":v.getId()%>"><%=v%></option>	
							
						</select>
						<%}%>
					</div>
					<div class="form-group">
						<label for="zone">Zone</label> 
						<select   class="form-control"  name="zone" id="zone">
						
						
						<%
						Integer n=0;
						
							n = Integer.parseInt(request.getParameter("city"));
								 	ZoneService zs = new ZoneService();
									for(Zone z:zs.findZonesByVille(vs.findById(n))){
						%>
							<option value=<%=z.getId() %>><%=z%></option>
							<%
									}
				%> </select>
					</div>
					<button id="add" type="submit"  class="btn btn-primary btn-block"><%=request.getParameter("id") == null ? "Créer" : "Modifier"%></button>
				</form>
			</div>
		</div>
		<div class="row mt-5">
			<div class="col-md-6 offset-md-3">
				<h2 class="text-center mb-4">Liste des pharmacies</h2>
				<table class="table">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">NOM</th>
					<th scope="col">ADRESSE</th>
					<th scope="col">VILLE</th>
					<th scope="col">ZONE</th>
					<th scope="col">PHARMACIEN</th>
					<th scope="col">ACTIONS</th>
				</tr>
			</thead>
			<tbody>
				<!-- Ajoutez ici les lignes du tableau pour chaque ville -->
				<%
				PharmacieService ps = new PharmacieService();
				for (Pharmacie p : ps.findAll()) {
				%>
				<tr>
					<td><%=p.getId()%></td>
					<td><%=p.getNom()%></td>
					<td><%=p.getAdresse() %></td>
					<td><%=p.getZone().getVille() %></td>
					<td><%=p.getZone() %></td>
					<td><%=p.getPharmacien() %></td>
					<td><a href="ZoneController?id=<%=p.getId()%>&op=update"
						class="btn btn-primary btn-sm mr-2"> <i class="fas fa-edit"></i>
							Modifier
					</a> <a href="ZoneController?id=<%=p.getId()%>&op=delete"
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
<script>
function change()
{
		
		var n = document.getElementById('city').value;
		
			document.getElementById('zone').disabled=false;
			
				
 
    }

					                </script>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script type="text/javascript">
	
</script>
	
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

