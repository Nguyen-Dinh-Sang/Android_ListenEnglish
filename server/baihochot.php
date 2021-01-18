<?php
	require "connect.php";
	
	$query = "SELECT DISTINCT * FROM `BAI` ORDER BY RAND(" . DATE("Ymd") . ") LIMIT 4";
	
	$dataBaiHoc = mysqli_query($connect, $query);
	
	class BaiHoc {
		function BaiHoc($idBaiHoc, $idKhoaHoc, $tenBaiHoc, $iconBaiHoc, $moTa) {
			$this -> IdBaiHoc = $idBaiHoc;
			$this -> IdKhoaHoc = $idKhoaHoc;
			$this -> TenKhoaHoc = $tenBaiHoc;
			$this -> IConBaiHoc = $iconBaiHoc;
			$this -> MoTa = $moTa;
		}
	}
	
	$arrayBaiHoc = array();
	
	while ($row = mysqli_fetch_assoc($dataBaiHoc)){
		array_push($arrayBaiHoc, new BaiHoc(
			$row['IdBai'],
			$row['IdKhoaHoc'],
			$row['TenBai'],
			$row['LinkIcon'],
			$row['MoTa']
		));
	}
	
	echo json_encode($arrayBaiHoc);
?>