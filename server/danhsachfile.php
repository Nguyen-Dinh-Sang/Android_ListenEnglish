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
	
	/////
	if (isset($_POST['idquangcao'])) {
		$idQuangCao = $_POST['idquangcao'];
		$queryQuangCao = "SELECT * FROM `QUANG_CAO` WHERE IdQuangCao = '$idQuangCao'";
		$dataQuangCao = mysqli_query($connect, $queryQuangCao);
		$rowQuangCao = mysqli_fetch_assoc($dataQuangCao);
		$id = $rowQuangCao['IdFile'];
		$query = "SELECT * FROM `FILE` WHERE IdFile = '$id'";
	}
	
	if (isset ($_POST['idkhoahoc'])) {
		$idKhoaHoc = $_POST['idkhoahoc'];
		$query = "SELECT * FROM `FILE` WHERE IdKhoaHoc = '$idKhoaHoc'";
	} 
	
	if (isset ($_POST['idbaihoc'])) {
		$idBaiHoc = $_POST['idbaihoc'];
		$query = "SELECT * FROM `FILE` WHERE IdBai = '$idBaiHoc'";
	}
	
	/////
	$data = mysqli_query($connect, $query);
	
	$fileNgheArray = array();
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
	
	echo json_encode($fileNgheArray);
?>