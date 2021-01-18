<?php
	require "connect.php";
	
	$queryKhoaHoc = "SELECT DISTINCT * FROM `KHOA_HOC` ORDER BY RAND(" . DATE("Ymd") . ") LIMIT 4";
	$queryBaiHoc = "SELECT DISTINCT * FROM `BAI` ORDER BY RAND(" . DATE("Ymd") . ") LIMIT 4";
	
	$dataKhoaHoc = mysqli_query($connect, $queryKhoaHoc);
	$dataBaiHoc = mysqli_query($connect, $queryBaiHoc);
	
	class KhoaHoc {
		function KhoaHoc($idKhoaHoc, $tenKhoaHoc, $iconKhoaHoc, $moTa) {
			$this -> IdKhoaHoc = $idKhoaHoc;
			$this -> TenKhoaHoc = $tenKhoaHoc;
			$this -> IconKhoaHoc = $iconKhoaHoc;
			$this -> MoTa = $moTa;
		}
	}
	
	class BaiHoc {
		function BaiHoc($idBaiHoc, $idKhoaHoc, $tenBaiHoc, $iconBaiHoc, $moTa) {
			$this -> IdBaiHoc = $idBaiHoc;
			$this -> IdKhoaHoc = $idKhoaHoc;
			$this -> TenKhoaHoc = $tenBaiHoc;
			$this -> IConBaiHoc = $iconBaiHoc;
			$this -> MoTa = $moTa;
		}
	}
	
	$arrayKhoaHoc = array();
	$arrayBaiHoc = array();
	
	while ($row = mysqli_fetch_assoc($dataKhoaHoc)){
		array_push($arrayKhoaHoc, new KhoaHoc(
			$row['IdKhoaHoc'],
			$row['TenKhoaHoc'],
			$row['LinkIcon'],
			$row['MoTa']
		));
	}
	
	while ($row = mysqli_fetch_assoc($dataBaiHoc)){
		array_push($arrayBaiHoc, new BaiHoc(
			$row['IdBai'],
			$row['IdKhoaHoc'],
			$row['TenBai'],
			$row['LinkIcon'],
			$row['MoTa']
		));
	}
	
	$arrayKhoaHocBaiHoc = array(
		'KhoaHoc' => $arrayKhoaHoc,
		'BaiHoc' => $arrayBaiHoc
	);
	
	echo json_encode($arrayKhoaHocBaiHoc);
?>