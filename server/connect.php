<?php
	$hostName = "localhost";
	$userName = "id10216082_nguyendinhsang";
	$password = "91dinhsang99123";
	$dataBaseName = "id10216082_applistenenglish1";
	
	$connect = mysqli_connect($hostName, $userName, $password, $dataBaseName);

	mysqli_query($connect,"SET NAMES 'utf8'");
?>