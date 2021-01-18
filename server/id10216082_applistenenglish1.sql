-- phpMyAdmin SQL Dump
-- version 4.9.4
-- https://www.phpmyadmin.net/
--
-- Máy chủ: localhost:3306
-- Thời gian đã tạo: Th2 04, 2020 lúc 04:08 PM
-- Phiên bản máy phục vụ: 10.3.16-MariaDB
-- Phiên bản PHP: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `id10216082_applistenenglish1`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `BAI`
--

CREATE TABLE `BAI` (
  `IdBai` int(11) NOT NULL,
  `IdKhoaHoc` int(11) NOT NULL,
  `TenBai` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `LinkIcon` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `MoTa` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `BAI`
--

INSERT INTO `BAI` (`IdBai`, `IdKhoaHoc`, `TenBai`, `LinkIcon`, `MoTa`) VALUES
(1, 3, 'Bài 1', 'https://applistenenglish1.000webhostapp.com/HinhAnh/BaiHoc/1548496341_typhlosionlgplush2019-1-500x500.jpg', 'Ôn tập lại cấu trúc câu.'),
(2, 3, 'Bài 2', 'https://applistenenglish1.000webhostapp.com/HinhAnh/BaiHoc/20180711_080727.jpg', '12 thì trong tiếng anh.'),
(3, 4, 'Bài 1', 'https://applistenenglish1.000webhostapp.com/HinhAnh/BaiHoc/27607090199_75fc41522e_o.jpg', 'Câu bị động.'),
(4, 4, 'Bài 2', 'https://applistenenglish1.000webhostapp.com/HinhAnh/BaiHoc/8a645fc0097ab18e90e7ac81b0b08190.jpg', 'Liên từ và giới từ.'),
(5, 5, 'Bài 1', 'https://applistenenglish1.000webhostapp.com/HinhAnh/BaiHoc/CAFEDIDONG-POKEMON-SYLVEON.png', 'Giới thiệu bản thân.'),
(6, 5, 'Bài 2', 'https://applistenenglish1.000webhostapp.com/HinhAnh/BaiHoc/pcc-17_jirachi_pokemon_moncolle-ex_grande.jpg', 'Câu hỏi đơn giản.'),
(7, 6, 'Bài 1', 'https://applistenenglish1.000webhostapp.com/HinhAnh/BaiHoc/pokemon-grid.png', 'Ôn tập đối thoại.'),
(8, 6, 'Bài 2', 'https://applistenenglish1.000webhostapp.com/HinhAnh/BaiHoc/pokemon_10_6_2016_3.jpg', 'Giao tiếp trong công việc.');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `FILE`
--

CREATE TABLE `FILE` (
  `IdFile` int(11) NOT NULL,
  `IdKhoaHoc` int(11) NOT NULL,
  `IdBai` int(11) NOT NULL,
  `LinkMp3` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `TenFile` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `NoiDung` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `LinkIcon` varchar(1000) COLLATE utf8_unicode_ci NOT NULL,
  `MoTa` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `LuotThich` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `FILE`
--

INSERT INTO `FILE` (`IdFile`, `IdKhoaHoc`, `IdBai`, `LinkMp3`, `TenFile`, `NoiDung`, `LinkIcon`, `MoTa`, `LuotThich`) VALUES
(1, 3, 1, 'https://applistenenglish2.000webhostapp.com/File/MsHoa/PRE/MINI_TESTS/Mini%20test%20part%202.mp3', 'File 1', 'Dữ liệu đang được cập nhật.', 'https://applistenenglish1.000webhostapp.com/HinhAnh/File/500_F_223334794_Z1LPMW02JIDIJUw8XT9leAoc0VEUzHrO.jpg', 'File 1.', 0),
(2, 3, 1, 'https://applistenenglish2.000webhostapp.com/File/MsHoa/PRE/MINI_TESTS/Mini%20test%20part%203.mp3', 'File 2', 'Dữ liệu đang được cập nhật.', 'https://applistenenglish1.000webhostapp.com/HinhAnh/File/500_F_223334794_Z1LPMW02JIDIJUw8XT9leAoc0VEUzHrO.jpg', 'File 2.', 0),
(3, 3, 2, 'https://applistenenglish2.000webhostapp.com/File/MsHoa/PRE/UNIT_1/File%201.mp3', 'File 1', 'Dữ liệu đang được cập nhật.', 'https://applistenenglish1.000webhostapp.com/HinhAnh/File/500_F_223334794_Z1LPMW02JIDIJUw8XT9leAoc0VEUzHrO.jpg', 'File 1.', 0),
(4, 3, 2, 'https://applistenenglish2.000webhostapp.com/File/MsHoa/PRE/UNIT_1/File%2010.mp3', 'File 2', 'Dữ liệu đang được cập nhật', 'https://applistenenglish1.000webhostapp.com/HinhAnh/File/500_F_223334794_Z1LPMW02JIDIJUw8XT9leAoc0VEUzHrO.jpg', 'File 2.', 0),
(5, 4, 3, 'https://applistenenglish2.000webhostapp.com/File/MsHoa/PRE/UNIT_1/File%2011.mp3', 'File 1', 'Dữ liệu đang được cập nhật.', 'https://applistenenglish1.000webhostapp.com/HinhAnh/File/500_F_223334794_Z1LPMW02JIDIJUw8XT9leAoc0VEUzHrO.jpg', 'File 1.', 0),
(6, 4, 3, 'https://applistenenglish2.000webhostapp.com/File/MsHoa/PRE/UNIT_1/File%2012.mp3', 'File 2', 'Dữ liệu đang được cập nhật.', 'https://applistenenglish1.000webhostapp.com/HinhAnh/File/500_F_223334794_Z1LPMW02JIDIJUw8XT9leAoc0VEUzHrO.jpg', 'File 2.', 0),
(7, 4, 4, 'https://applistenenglish2.000webhostapp.com/File/MsHoa/PRE/UNIT_1/File%203.mp3', 'File 1', 'Dữ liệu đang được cập nhật.', 'https://applistenenglish1.000webhostapp.com/HinhAnh/File/500_F_223334794_Z1LPMW02JIDIJUw8XT9leAoc0VEUzHrO.jpg', 'File 1.', 0),
(8, 4, 4, 'https://applistenenglish2.000webhostapp.com/File/MsHoa/PRE/UNIT_1/File%202.mp3', 'File 2', 'Dữ liệu đang được cập nhật.', 'https://applistenenglish1.000webhostapp.com/HinhAnh/File/500_F_223334794_Z1LPMW02JIDIJUw8XT9leAoc0VEUzHrO.jpg', 'File 2.', 0),
(9, 5, 5, 'https://applistenenglish2.000webhostapp.com/File/MsHoa/PRE/UNIT_1/File%204.mp3', 'File 1', 'Dữ liệu đang được cập nhật.', 'https://applistenenglish1.000webhostapp.com/HinhAnh/File/500_F_223334794_Z1LPMW02JIDIJUw8XT9leAoc0VEUzHrO.jpg', 'File 1.', 0),
(10, 5, 5, 'https://applistenenglish2.000webhostapp.com/File/MsHoa/PRE/UNIT_1/File%205.mp3', 'File 2', 'Dữ liệu đang được cập nhật.', 'https://applistenenglish1.000webhostapp.com/HinhAnh/File/500_F_223334794_Z1LPMW02JIDIJUw8XT9leAoc0VEUzHrO.jpg', 'File 2.', 0),
(11, 5, 6, 'https://applistenenglish2.000webhostapp.com/File/MsHoa/PRE/UNIT_1/File%206.mp3', 'File 1', 'Dữ liệu đang được cập nhật.', 'https://applistenenglish1.000webhostapp.com/HinhAnh/File/500_F_223334794_Z1LPMW02JIDIJUw8XT9leAoc0VEUzHrO.jpg', 'File 1.', 0),
(12, 5, 6, 'https://applistenenglish2.000webhostapp.com/File/MsHoa/PRE/UNIT_1/File%207.mp3', 'File 2', 'Dữ liệu đang được cập nhật.', 'https://applistenenglish1.000webhostapp.com/HinhAnh/File/500_F_223334794_Z1LPMW02JIDIJUw8XT9leAoc0VEUzHrO.jpg', 'File 2.', 0),
(13, 6, 7, 'https://applistenenglish2.000webhostapp.com/File/MsHoa/PRE/UNIT_1/File%208.mp3', 'File 1', 'Dữ liệu đang được cập nhật.', 'https://applistenenglish1.000webhostapp.com/HinhAnh/File/500_F_223334794_Z1LPMW02JIDIJUw8XT9leAoc0VEUzHrO.jpg', 'File 1.', 0),
(14, 6, 7, 'https://applistenenglish2.000webhostapp.com/File/MsHoa/PRE/UNIT_1/File%209.mp3', 'File 2', 'Dữ liệu đang được cập nhật.', 'https://applistenenglish1.000webhostapp.com/HinhAnh/File/500_F_223334794_Z1LPMW02JIDIJUw8XT9leAoc0VEUzHrO.jpg', 'File 2.', 0),
(15, 6, 8, 'https://applistenenglish2.000webhostapp.com/File/MsHoa/PRE/UNIT_2/File%201.mp3', 'File 1', 'Dữ liệu đang được cập nhật.', 'https://applistenenglish1.000webhostapp.com/HinhAnh/File/500_F_223334794_Z1LPMW02JIDIJUw8XT9leAoc0VEUzHrO.jpg', 'File 1.', 0),
(16, 6, 8, 'https://applistenenglish2.000webhostapp.com/File/MsHoa/PRE/UNIT_2/File%2010.mp3', 'File 2', 'Dữ liệu đang được cập nhật.', 'https://applistenenglish1.000webhostapp.com/HinhAnh/File/500_F_223334794_Z1LPMW02JIDIJUw8XT9leAoc0VEUzHrO.jpg', 'File 2.', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `KHOA_HOC`
--

CREATE TABLE `KHOA_HOC` (
  `IdKhoaHoc` int(11) NOT NULL,
  `TenKhoaHoc` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `LinkIcon` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `MoTa` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `KHOA_HOC`
--

INSERT INTO `KHOA_HOC` (`IdKhoaHoc`, `TenKhoaHoc`, `LinkIcon`, `MoTa`) VALUES
(3, 'PRE', 'https://applistenenglish1.000webhostapp.com/HinhAnh/KhoaHoc/17-178668_hnh-nn-ipad-cute.jpg', 'Khóa học toeic cho người mất gốc.'),
(4, 'A', 'https://applistenenglish1.000webhostapp.com/HinhAnh/KhoaHoc/2628d9d1cdf3acbfac718fe29470aca0.jpg', 'Khóa học 550 toeic.'),
(5, 'Giao Tiếp Căn Bản', 'https://applistenenglish1.000webhostapp.com/HinhAnh/KhoaHoc/cute-kawaii-cat-500x500.jpg', 'Khóa học giao tiếp cơ bản cho người mất gốc, mới bắt đầu.'),
(6, 'Giao Tiếp Bản Ngữ', 'https://applistenenglish1.000webhostapp.com/HinhAnh/KhoaHoc/MZ4u0aYJ.png', 'Khóa học giao tiếp cho người đã có nên tảng, giao tiếp với giáo viên bãn ngữ.');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `QUANG_CAO`
--

CREATE TABLE `QUANG_CAO` (
  `IdQuangCao` int(11) NOT NULL,
  `IdFile` int(11) NOT NULL,
  `LinkIcon` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `MoTa` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `QUANG_CAO`
--

INSERT INTO `QUANG_CAO` (`IdQuangCao`, `IdFile`, `LinkIcon`, `MoTa`) VALUES
(1, 1, 'https://applistenenglish1.000webhostapp.com/HinhAnh/QuangCao/0d3f21da5f805f3e455fe1adae79ebcf.jpg', 'File mới của khóa học FRE.'),
(2, 5, 'https://applistenenglish1.000webhostapp.com/HinhAnh/QuangCao/anh-dai-dien-facebook-cho-meo-de-thuong-3.jpg', 'File mới của khóa học A.'),
(3, 9, 'https://applistenenglish1.000webhostapp.com/HinhAnh/QuangCao/hinh-anh-pikachu-de-thuong-kute-nhat-1.jpg', 'File mới của khóa học Giao tiếp căn bản.'),
(4, 13, 'https://applistenenglish1.000webhostapp.com/HinhAnh/QuangCao/hinh-nen-hinh-anh-hoa-bo-cong-anh-dep-nhat-10.jpg', 'File mới của khóa học Giao tiếp bản ngữ.');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `BAI`
--
ALTER TABLE `BAI`
  ADD PRIMARY KEY (`IdBai`),
  ADD KEY `IdKhoaHoc` (`IdKhoaHoc`);

--
-- Chỉ mục cho bảng `FILE`
--
ALTER TABLE `FILE`
  ADD PRIMARY KEY (`IdFile`),
  ADD KEY `IdKhoaHoc` (`IdKhoaHoc`),
  ADD KEY `IdBai` (`IdBai`);

--
-- Chỉ mục cho bảng `KHOA_HOC`
--
ALTER TABLE `KHOA_HOC`
  ADD PRIMARY KEY (`IdKhoaHoc`);

--
-- Chỉ mục cho bảng `QUANG_CAO`
--
ALTER TABLE `QUANG_CAO`
  ADD PRIMARY KEY (`IdQuangCao`),
  ADD KEY `IdFile` (`IdFile`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `BAI`
--
ALTER TABLE `BAI`
  MODIFY `IdBai` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT cho bảng `FILE`
--
ALTER TABLE `FILE`
  MODIFY `IdFile` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT cho bảng `KHOA_HOC`
--
ALTER TABLE `KHOA_HOC`
  MODIFY `IdKhoaHoc` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `QUANG_CAO`
--
ALTER TABLE `QUANG_CAO`
  MODIFY `IdQuangCao` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `BAI`
--
ALTER TABLE `BAI`
  ADD CONSTRAINT `BAI_ibfk_1` FOREIGN KEY (`IdKhoaHoc`) REFERENCES `KHOA_HOC` (`IdKhoaHoc`);

--
-- Các ràng buộc cho bảng `FILE`
--
ALTER TABLE `FILE`
  ADD CONSTRAINT `FILE_ibfk_1` FOREIGN KEY (`IdKhoaHoc`) REFERENCES `KHOA_HOC` (`IdKhoaHoc`),
  ADD CONSTRAINT `FILE_ibfk_2` FOREIGN KEY (`IdBai`) REFERENCES `BAI` (`IdBai`);

--
-- Các ràng buộc cho bảng `QUANG_CAO`
--
ALTER TABLE `QUANG_CAO`
  ADD CONSTRAINT `QUANG_CAO_ibfk_1` FOREIGN KEY (`IdFile`) REFERENCES `FILE` (`IdFile`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
