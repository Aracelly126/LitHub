-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-01-2024 a las 20:55:36
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
-- Estructura de tabla para la tabla `favoritos`
--

CREATE TABLE `favoritos` (
  `CODIGO` int(11) NOT NULL,
  `CORREO_USU` varchar(30) DEFAULT NULL,
  `COD_LIB` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libros`
--

CREATE TABLE `libros` (
  `CODIGO` varchar(10) NOT NULL,
  `CORREO_USU` varchar(30) DEFAULT NULL,
  `NOMBRE` varchar(50) DEFAULT NULL,
  `GENERO` varchar(20) DEFAULT NULL,
  `NUM_PAG` int(11) DEFAULT NULL CHECK (`NUM_PAG` <= 500),
  `PRESTADO` varchar(2) DEFAULT NULL CHECK (`PRESTADO` in ('SI','NO'))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prestamos`
--

CREATE TABLE `prestamos` (
  `CODIGO` int(11) NOT NULL,
  `COD_LIB` varchar(10) DEFAULT NULL,
  `CORREO_USU` varchar(30) DEFAULT NULL,
  `FEC_INI` varchar(10) DEFAULT NULL,
  `FEC_DEV` varchar(10) DEFAULT NULL,
  `ESTADO` varchar(10) DEFAULT NULL CHECK (`ESTADO` in ('DEVUELTO','INDEVUELTO'))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `CORREO` varchar(30) NOT NULL,
  `NOMBRE` varchar(20) DEFAULT NULL,
  `APELLIDO` varchar(20) DEFAULT NULL,
  `CLAVE` varchar(50) DEFAULT NULL,
  `PAIS` varchar(20) DEFAULT NULL,
  `FEC_NAC` varchar(10) DEFAULT NULL,
  `TIPO` varchar(10) DEFAULT NULL CHECK (`TIPO` in ('ADMIN','AUTOR','LECTOR'))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`CORREO`, `NOMBRE`, `APELLIDO`, `CLAVE`, `PAIS`, `FEC_NAC`, `TIPO`) VALUES
('pepito@gmail.com', 'Anuel', NULL, 'lruxImViiJZybBeV1xN/zQ==', NULL, '05/02/2003', 'ADMIN');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `favoritos`
--
ALTER TABLE `favoritos`
  ADD PRIMARY KEY (`CODIGO`),
  ADD KEY `CORREO_USU` (`CORREO_USU`),
  ADD KEY `COD_LIB` (`COD_LIB`);

--
-- Indices de la tabla `libros`
--
ALTER TABLE `libros`
  ADD PRIMARY KEY (`CODIGO`),
  ADD KEY `CORREO_USU` (`CORREO_USU`);

--
-- Indices de la tabla `prestamos`
--
ALTER TABLE `prestamos`
  ADD PRIMARY KEY (`CODIGO`),
  ADD KEY `COD_LIB` (`COD_LIB`),
  ADD KEY `CORREO_USU` (`CORREO_USU`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`CORREO`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `favoritos`
--
ALTER TABLE `favoritos`
  MODIFY `CODIGO` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `prestamos`
--
ALTER TABLE `prestamos`
  MODIFY `CODIGO` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `favoritos`
--
ALTER TABLE `favoritos`
  ADD CONSTRAINT `favoritos_ibfk_1` FOREIGN KEY (`CORREO_USU`) REFERENCES `usuarios` (`CORREO`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `favoritos_ibfk_2` FOREIGN KEY (`COD_LIB`) REFERENCES `libros` (`CODIGO`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `libros`
--
ALTER TABLE `libros`
  ADD CONSTRAINT `libros_ibfk_1` FOREIGN KEY (`CORREO_USU`) REFERENCES `usuarios` (`CORREO`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `prestamos`
--
ALTER TABLE `prestamos`
  ADD CONSTRAINT `prestamos_ibfk_1` FOREIGN KEY (`CORREO_USU`) REFERENCES `usuarios` (`CORREO`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `prestamos_ibfk_2` FOREIGN KEY (`COD_LIB`) REFERENCES `libros` (`CODIGO`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
