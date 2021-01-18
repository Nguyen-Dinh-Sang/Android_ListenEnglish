<?php
	require "connect.php";
	
	class BaiHoc {
		function BaiHoc($idBaiHoc, $idKhoaHoc, $tenBaiHoc, $iconBaiHoc, $moTa) {
			$this -> IdBaiHoc = $idBaiHoc;
			$this -> IdKhoaHoc = $idKhoaHoc;
			$this -> TenKhoaHoc = $tenBaiHoc;
			$this -> IConBaiHoc = $iconBaiHoc;
			$this -> MoTa = $moTa;
		}
	}
	
	if (isset ($_POST['idkhoahoc'])) {
		$idKhoaHoc = $_POST['idkhoahoc'];
		$query = "SELECT * FROM `BAI` WHERE IdKhoaHoc = '$idKhoaHoc'";
	} else {
		$query = "SELECT * FROM `BAI`";
	}
	
	$data = mysqli_query($connect, $query);
	
	$baiHocArray = array();
	
	while ($row = mysqli_fetch_assoc($data)){
		array_push($baiHocArray, new BaiHoc(
			$row['IdBai'],
			$row['IdKhoaHoc'],
			$row['TenBai'],
			$row['LinkIcon'],
			$row['MoTa']
		));
	}
	
	echo json_encode($baiHocArray);
?>