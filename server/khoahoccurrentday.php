<?php
	require "connect.php";
	
	// trong một ngày sẻ cùng một kết quả
	$query = "SELECT DISTINCT * FROM `KHOA_HOC` ORDER BY RAND(" . DATE("Ymd") . ") LIMIT 3";
	
	$data = mysqli_query($connect, $query);
	
	class KhoaHocToday {
		function KhoaHocToday($idKhoaHoc, $tenKhoaHoc, $iconKhoaHoc, $moTa) {
			$this -> IdKhoaHoc = $idKhoaHoc;
			$this -> TenKhoaHoc = $tenKhoaHoc;
			$this -> IconKhoaHoc = $iconKhoaHoc;
			$this -> MoTa = $moTa;
		}
	}
	
	$arrayKhoaHocToDay = array();
	while ($row = mysqli_fetch_assoc($data)) {
		array_push($arrayKhoaHocToDay, new KhoaHocToday(
			$row['IdKhoaHoc'],
			$row['TenKhoaHoc'],
			$row['LinkIcon'],
			$row['MoTa']
		));
	}
	
	echo json_encode($arrayKhoaHocToDay);
?>