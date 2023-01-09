<%@page import="entities.Pharmacien"%>
<%@page import="entities.Admin"%>
<%@page import="entities.Utilisateur"%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">PharmaLoc</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
	<%
	
      Admin admin = (Admin)session.getAttribute("admin");
 	%>
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#">Acceuil<span class="sr-only">(current)</span></a>
      </li>

      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Gestion
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="nav-link " href="./villes.jsp">Ville</a>
          <a class="nav-link" href="./zones.jsp">Zone</a>
          <a class="nav-link" href="./gardes.jsp">Garde</a>
          <a class="nav-link" href="./pharmaciens.jsp">Pharmacien</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item nav-link disabled" href="#">Pharmacie</a>
          <a class="dropdown-item nav-link disabled" href="#">Pharmacie de garde</a>
        </div>
      </li>
      <li class="nav-item ">
        <a class="nav-link" href="./dashbord.jsp">Statistique</a>
      </li>
      
    </ul>
    </div>
    <div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item active" ><label class="nav-link">Bonjour <%= admin.getNom().toUpperCase()%>,</label></li>
				<li class="nav-item"><a class="nav-link" href="./authentification.jsp">Déconnexion</a></li>
			</ul>
		</div>
 
</nav>