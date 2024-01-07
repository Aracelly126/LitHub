-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3387
-- Tiempo de generación: 07-01-2024 a las 16:36:08
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `biblioteca`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `NOMBRE` varchar(20) NOT NULL,
  `APELLIDO` varchar(20) DEFAULT NULL,
  `CLAVE` varchar(50) DEFAULT NULL,
  `PAIS` varchar(20) DEFAULT NULL,
  `FEC_NAC` varchar(10) DEFAULT NULL,
  `CORREO` varchar(30) DEFAULT NULL,
  `TIPO` varchar(10) DEFAULT NULL CHECK (`TIPO` in ('AUTOR','LECTOR','ADMIN'))
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`NOMBRE`, `APELLIDO`, `CLAVE`, `PAIS`, `FEC_NAC`, `CORREO`, `TIPO`) VALUES
('Anuel', NULL, 'lruxImViiJZybBeV1xN/zQ==', NULL, '05/02/2003', NULL, 'ADMIN');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`NOMBRE`),
  ADD UNIQUE KEY `CLAVE` (`CLAVE`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
