<?php
	require "connect.php";
	
	$query = "SELECT QUANG_CAO.IdQuangCao, QUANG_CAO.LinkIcon as Link1, QUANG_CAO.MoTa, QUANG_CAO.IdFile, FILE.TenFile, FILE.LinkIcon as Link2 
	FROM `QUANG_CAO` INNER JOIN `FILE` 
	ON QUANG_CAO.IdFile = FILE.IdFile 
	WHERE QUANG_CAO.IdFile = FILE.IdFile";
	
	$data = mysqli_query($connect, $query);
	
	// dữ liệu trả về
	class QuangCao {
		function QuangCao($idQuangCao, $iconQuangCao, $noiDung, $idFile, $tenFile, $iconFile) {
			$this -> IdQuangCao = $idQuangCao;
			$this -> IconQuangCao = $iconQuangCao;
			$this -> NoiDung = $noiDung;
			$this -> IdFile = $idFile;
			$this -> TenFile = $tenFile;
			$this -> IconFile = $iconFile;
		}
	}
	
	// đổ dữ liệu
	$arrayQuangCao = array();
	while ($row = mysqli_fetch_assoc($data)) {
		array_push($arrayQuangCao, new QuangCao(
			$row['IdQuangCao'],
			$row['Link1'],
			$row['MoTa'],
			$row['IdFile'],
			$row['TenFile'],
			$row['Link2']
		));
	}
	
	echo json_encode($arrayQuangCao);
?>