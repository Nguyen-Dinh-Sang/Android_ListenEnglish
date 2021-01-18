<?php
	require "connect.php";
	
	$query = "SELECT * FROM `FILE` ORDER BY LuotThich DESC LIMIT 5";
	
	$data = mysqli_query($connect, $query);
	
	class FileYeuThich {
		function FileYeuThich($idFile, $idKhoaHoc, $idBaiHoc, $mp3, $tenFile, $noiDung, $iconFile, $moTa, $like) {
			$this -> IdFile = $idFile;
			$this -> IdKhoaHoc = $idKhoaHoc;
			$this -> IdBaiHoc = $idBaiHoc;
			$this -> Mp3 = $mp3;
			$this -> TenFile = $tenFile;
			$this -> NoiDung = $noiDung;
			$this -> IconFile = $iconFile;
			$this -> MoTa = $moTa;
			$this -> Like = $like;
		}
	}
	
	$fileYeuThichArray = array();
	
	while ($row = mysqli_fetch_assoc($data)){
		array_push($fileYeuThichArray, new FileYeuThich(
			$row['IdFile'],
			$row['IdKhoaHoc'],
			$row['IdBai'],
			$row['LinkMp3'],
			$row['TenFile'],
			$row['NoiDung'],
			$row['LinkIcon'],
			$row['MoTa'],
			$row['LuotThich']
		));
	}
	
	echo json_encode($fileYeuThichArray);
?>