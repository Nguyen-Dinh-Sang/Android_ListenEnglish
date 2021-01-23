<?php
	require "connect.php";
	
	class FileNghe {
		function FileNghe($idFile, $idKhoaHoc, $idBaiHoc, $mp3, $tenFile, $noiDung, $iconFile, $moTa, $like) {
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
	
	$fileNgheArray = array();
	if (isset($_POST['tukhoa'])) {
		$tukhoa = $_POST['tukhoa'];
		$query = "SELECT * FROM `FILE` WHERE LOWER(TenFile) LIKE '%tukhoa%'";
		$data = mysqli_query($connect, $query);
		
		while ($row = mysqli_fetch_assoc($data)){
			array_push($fileNgheArray, new FileNghe(
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
		
		echo json_encode ($fileNgheArray);
	}	
?>