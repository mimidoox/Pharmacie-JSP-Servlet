<!DOCTYPE html>
<html>
<head>
	<title>Localisation</title>
	<meta name="viewport" content="initial-scale=1.0, user-scalable=no">
	<meta charset="utf-8">
	<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
	<style>
      /* Always set the map height explicitly to define the size of the div
      * element that contains the map. */
      #map {
      	height: 100vh;
      	width: 100%;
      }
      /* Optional: Makes the sample page fill the window. */
      html, body {
      	height: 100%;
      	margin: 0;
      	padding: 0;
      }
      #floating-panel {
      	position: absolute;
      	top: 0;
      	left: 0%;
      	z-index: 0;
      	background-color: #fff;
      	padding: 5px;
      	border: 1px solid #999;
      	text-align: center;
      	font-family: 'Roboto','sans-serif';
      	line-height: 30px;
      	padding-left: 10px;
      }
  </style>
  <%@include file="/WEB-INF/template/header.jsp" %>
  
</head>
<body>
	
	

<div>
<br> </div>
						</div>
	<div id="map"></div>
	<script>
	function initMap() {
		const query  = window.location.search;

        const url = new URLSearchParams(query)
		  const map = new google.maps.Map(document.getElementById("map"), {
		    zoom: 16,
		    center: { lat: parseFloat(url.get("latitude")), lng: parseFloat(url.get("longitude"))},
		  });
		 
		  const beachMarker = new google.maps.Marker({
		    position: { lat: parseFloat(url.get("latitude")), lng: parseFloat(url.get("longitude"))},
		    map,
		  
		  });
		}

		window.initMap = initMap;
		
	</script>
	<script async defer
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDVc6zYWhW_xasjGUxFO5bjGDhZOAKOcyk&callback=initMap">
</script>
<%@include file="/WEB-INF/template/footer.jsp" %>
</body>
 
</html>