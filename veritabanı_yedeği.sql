-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 23 Haz 2023, 15:53:13
-- Sunucu sürümü: 10.4.28-MariaDB
-- PHP Sürümü: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `projem_fx`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `asistan`
--

CREATE TABLE `asistan` (
  `doktor_adi` varchar(30) NOT NULL,
  `hasta_TC` varchar(11) NOT NULL,
  `hasta_adi` varchar(30) NOT NULL,
  `hasta_soyadi` varchar(30) NOT NULL,
  `tarih` date NOT NULL,
  `telefon` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `asistan`
--

INSERT INTO `asistan` (`doktor_adi`, `hasta_TC`, `hasta_adi`, `hasta_soyadi`, `tarih`, `telefon`) VALUES
('Eda şahin', '12365897456', 'Ece', 'Yaman', '2023-06-07', '05317201675'),
('eda şahin', '15698745635', 'Özgün', 'Demir', '2023-06-01', '05369871542');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `dt1`
--

CREATE TABLE `dt1` (
  `hasta_TC` varchar(11) NOT NULL,
  `islem` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `dt1`
--

INSERT INTO `dt1` (`hasta_TC`, `islem`) VALUES
('12365478961', 'Diş Beyazlatma'),
('15632489756', 'Diş Beyazlatma'),
('12365897456', 'İmplant Uygulama'),
('25698745632', 'Kanal Tedavisi');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `dt2`
--

CREATE TABLE `dt2` (
  `hasta_TC` varchar(11) NOT NULL,
  `islem` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `dt2`
--

INSERT INTO `dt2` (`hasta_TC`, `islem`) VALUES
('12365478998', 'Diş Teli (Başlangıç)'),
('12365895321', 'Diş Teli (Yenileme)');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `login`
--

CREATE TABLE `login` (
  `kul_adi` varchar(30) NOT NULL,
  `sifre` varchar(32) NOT NULL,
  `giris_turu` varchar(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;

--
-- Tablo döküm verisi `login`
--

INSERT INTO `login` (`kul_adi`, `sifre`, `giris_turu`) VALUES
('eda_sahin', 'c4ca4238a0b923820dcc509a6f75849b', '1'),
('serdar_yilmaz', '202cb962ac59075b964b07152d234b70', '2'),
('asistan', '81dc9bdb52d04dc20036dbd8313ed055', '0');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
