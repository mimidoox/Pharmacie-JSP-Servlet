<%@page import="entities.Ville"%>
<%@page import="entities.Pharmacie"%>
<%@page import="entities.Zone"%>
<%@page import="service.VilleService"%>
<%@page import="service.ZoneService"%>
<%@page import="service.PharmacieService"%>
<%@page import="entities.Pharmacien"%>
<%@page import="service.PharmacienService"%>
<%@page import="entities.Photo"%>
<%@page import="service.PhotoService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<title>Ajout pharmacie</title>
</head>
<body>
<jsp:include page="/WEB-INF/template/headerpharma.jsp" />
	<div class="container mt-5">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<h1 class="text-center mb-4">Création de pharmacie</h1>
				<form id="firstform" action="ajouPharmaController" method="post" enctype="multipart/form-data">
				<input type="hidden" name="id"
				value="<%=request.getParameter("id") == null ? "" : request.getParameter("id")%>" />
				<div class="form-group">
						<label for="pic">Photo de la pharmacie</label> <input type="file" multiple="true"
							class="form-control" name="photo"
					value="<%=request.getParameter("photo") == null ? "" : request.getParameter("photo")%>"
					class="form-control" id="photo">
					</div>
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
						<label for="pharmacieName">Latitude</label> <input type="number" step="any"
							class="form-control" name="latitude" class="form-control" id="latitude">
					</div>
					<div class="form-group">
						<label for="pharmacieName">Longitude</label> <input type="number" step="any"
							class="form-control" name="longitude" class="form-control" id="longitude">
					</div>
					<div class="form-group">
						<label for="ville">Ville</label> 
						<select   class="form-control"  name="ville" id="ville">
						<option value disabled selected>sélectionner une ville</option>
						<%
								 	VilleService vs = new VilleService();
									for(Ville v:vs.findAll()){
						%>	
							<option value=<%=v.getId() %>><%=v%></option>
							<%}%>
						</select>
						</div>
					<div class="form-group">
						<label for="zone">Zone</label> 
						<select   class="form-control"  name="zone" id="zone">
							
					    </select>
					</div>
					<button id="add" type="submit"  class="btn btn-primary btn-block">
					<%=request.getParameter("id") == null ? "Créer" : "Modifier" %>
					</button>
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
					<th scope="col">PHOTO</th>
					<th scope="col">NOM</th>
					<th scope="col">ADRESSE</th>
					<th scope="col">VILLE</th>
					<th scope="col">ZONE</th>
					<th scope="col">ACTIONS</th>
				</tr>
			</thead>
			<tbody>
				<!-- Ajoutez ici les lignes du tableau pour chaque ville -->
				<%
				PharmacieService ps = new PharmacieService();
				for (Pharmacie p : ps.findPharmaciesByOwner((Pharmacien) session.getAttribute("pharmacien"))) {  %>
				<tr>
					<td><%=p.getId()%></td>
					<%PhotoService pss = new PhotoService(); %>
					<td><img src="images/<%=pss.findByPharma(p).getUrl() %>" style="width:75px;height:75px;"></td>
					<td><%=p.getNom()%></td>
					<td><%=p.getAdresse() %></td>
					<td><%=p.getZone().getVille() %></td>
					<td><%=p.getZone() %></td>
					<td>
						<a href="ajouPharmaController?id=<%=p.getId()%>&op=localisation" class="btn btn-link btn-sm mr-2"> <i class="fas fa-edit"></i>Localisation
                        <a href="ajouPharmaController?id=<%=p.getId()%>&op=update" class="btn btn-link btn-sm mr-2"> <i class="fas fa-edit"></i>Modifier</a> 
					    <a href="aajouPharmaController?id=<%=p.getId()%>&op=delete"class="btn btn-link btn-sm"> <i class="fas fa-trash-alt"></i>Supprimer</a>
					</td>
					
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
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
		integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
		crossorigin="anonymous">
	</script>
	<script >
	$(document).ready(function () {
		//$("#ville option[value='']").attr('selected', true)
	    $("#ville").change(function (e) {
	    	var ville=$('#ville').val();
	    		e.preventDefault();
	            $.ajax ({
	            url: 'ZoneByVilleController',
	            data: {ville:ville},
	            datatype: 'json',
	            type: 'POST',
	            success: function (data) {
	            	console.log('success');
	            	console.log(data);
	            	$("#zone").html(data);
	               
	            }
	           
	        });
	    });


	});
	
	</script>
</body>

</html>


</body>
</html>