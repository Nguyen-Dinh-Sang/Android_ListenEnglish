<?php
	require "connect.php";
	
	$query = "SELECT * FROM `KHOA_HOC`";
	$data = mysqli_query($connect, $query);
	
	class KhoaHoc {
		function KhoaHoc($idKhoaHoc, $tenKhoaHoc, $iconKhoaHoc, $moTa) {
			$this -> IdKhoaHoc = $idKhoaHoc;
			$this -> TenKhoaHoc = $tenKhoaHoc;
			$this -> IconKhoaHoc = $iconKhoaHoc;
			$this -> MoTa = $moTa;
		}
	}
	
	$arrayKhoaHoc = array();
	while ($row = mysqli_fetch_assoc($data)){
		array_push($arrayKhoaHoc, new KhoaHoc(
			$row['IdKhoaHoc'],
			$row['TenKhoaHoc'],
			$row['LinkIcon'],
			$row['MoTa']
		));
	}
	
	echo json_encode($arrayKhoaHoc);
?>