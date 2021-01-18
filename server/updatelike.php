<?php
	require "connect.php";
	
	$luotThich = $_POST['luotthich'];
	$idFile = $_POST['idfile'];

	$query = "SELECT LuotThich FROM FILE WHERE IdFile = '$idFile'";
	$data = mysqli_query($connect, $query);
	$row = mysqli_fetch_assoc($data);
	$tongLuotThich = $row['LuotThich'];
	
	if (isset($luotThich)) {
		$tongLuotThich = $tongLuotThich + $luotThich;
		$querySum = "UPDATE FILE SET LuotThich = '$tongLuotThich' WHERE IdFile = '$idFile'";
		$dataUpdate = mysqli_query($connect, $querySum);
		if ($dataUpdate) {
			echo "Success";
		} else {
			echo "Fail";
		}
	}
?>