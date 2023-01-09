<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
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

<title>Statistiques des pharmacies</title>
</head>
<body>
	
	<jsp:include page="/WEB-INF/template/header.jsp" />
	<div class="container-fluid">
		<h1>Statistiques de la ville</h1>

		<div class="row mt-5">
			<div class="col-sm-4">
				<div class="card text-center">
					<div class="card-body">
						<h5 class="card-title">Nombre de zones</h5>
						<p class="card-text" id="num-zones">10</p>
					</div>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="card text-center">
					<div class="card-body">
						<h5 class="card-title">Nombre de pharmacies</h5>
						<p class="card-text" id="num-pharmacies">20</p>
					</div>
				</div>
			</div>
		</div>

		<canvas id="pharmacies-by-zone" class="mt-5"></canvas>
	</div>
	<jsp:include page="/WEB-INF/template/footer.jsp" />
</body>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.min.js"></script>
<script type="text/javascript">
	var ctx = document.getElementById('pharmacies-by-zone').getContext('2d');
	var chart = new Chart(ctx, {
		type : 'bar',
		data : {
			labels : [ "Zone 1", "Zone 2", "Zone 3" ],
			datasets : [ {
				label : 'Nombre de pharmacies',
				data : [ 10, 15, 20 ],
				backgroundColor : 'rgba(255, 99, 132, 0.2)',
				borderColor : 'rgba(255, 99, 132, 1)',
				borderWidth : 1
			} ]
		},
		options : {
			scales : {
				yAxes : [ {
					ticks : {
						beginAtZero : true
					}
				} ]
			}
		}
	});
</script>
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
</html>
