-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 06-01-2024 a las 22:43:35
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
-- Estructura de tabla para la tabla `libros`
--

CREATE TABLE `libros` (
  `CODIGO` varchar(10) NOT NULL,
  `AUTOR` varchar(20) DEFAULT NULL,
  `NOMBRE` varchar(50) DEFAULT NULL,
  `GENERO` varchar(20) DEFAULT NULL,
  `NUM_PAG` int(11) DEFAULT NULL CHECK (`NUM_PAG` <= 500),
  `URL_FOTO` varchar(10) DEFAULT NULL,
  `URL_PDF` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prestamos`
--

CREATE TABLE `prestamos` (
  `CODIGO` int(11) NOT NULL,
  `COD_LIB` varchar(10) DEFAULT NULL,
  `NOM_USU` varchar(20) DEFAULT NULL,
  `FEC_INI` varchar(10) DEFAULT NULL,
  `FEC_DEV` varchar(10) DEFAULT NULL,
  `ESTADO` varchar(10) DEFAULT NULL CHECK (`ESTADO` in ('DEVUELTO','INDEVUELTO'))
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

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
('admin1', NULL, 'root', NULL, '05/02/2003', NULL, 'ADMIN');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `libros`
--
ALTER TABLE `libros`
  ADD PRIMARY KEY (`CODIGO`),
  ADD KEY `AUTOR` (`AUTOR`);

--
-- Indices de la tabla `prestamos`
--
ALTER TABLE `prestamos`
  ADD PRIMARY KEY (`CODIGO`),
  ADD KEY `COD_LIB` (`COD_LIB`),
  ADD KEY `NOM_USU` (`NOM_USU`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`NOMBRE`),
  ADD UNIQUE KEY `CLAVE` (`CLAVE`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `prestamos`
--
ALTER TABLE `prestamos`
  MODIFY `CODIGO` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `libros`
--
ALTER TABLE `libros`
  ADD CONSTRAINT `libros_ibfk_1` FOREIGN KEY (`AUTOR`) REFERENCES `usuarios` (`NOMBRE`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `prestamos`
--
ALTER TABLE `prestamos`
  ADD CONSTRAINT `prestamos_ibfk_1` FOREIGN KEY (`NOM_USU`) REFERENCES `usuarios` (`NOMBRE`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `prestamos_ibfk_2` FOREIGN KEY (`COD_LIB`) REFERENCES `libros` (`CODIGO`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
