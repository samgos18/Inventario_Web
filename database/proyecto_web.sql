-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-06-2021 a las 07:35:14
-- Versión del servidor: 10.4.19-MariaDB
-- Versión de PHP: 8.0.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `proyecto_web`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `baja`
--

CREATE TABLE `baja` (
  `id_baja` int(11) NOT NULL,
  `aprobada` tinyint(4) NOT NULL,
  `fecha` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `equipo`
--

CREATE TABLE `equipo` (
  `serial` varchar(255) NOT NULL,
  `baja_aceptada` bit(1) NOT NULL,
  `baja_solicitada` bit(1) NOT NULL,
  `color` varchar(255) DEFAULT NULL,
  `disponible` bit(1) NOT NULL,
  `donado` tinyint(4) NOT NULL,
  `fecha` date DEFAULT NULL,
  `fecha_baja` date DEFAULT NULL,
  `foto` varchar(255) DEFAULT NULL,
  `marca` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `precio` int(11) NOT NULL,
  `id_tipo_equipo` int(11) DEFAULT NULL,
  `id_usuario` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `equipo`
--

INSERT INTO `equipo` (`serial`, `baja_aceptada`, `baja_solicitada`, `color`, `disponible`, `donado`, `fecha`, `fecha_baja`, `foto`, `marca`, `nombre`, `precio`, `id_tipo_equipo`, `id_usuario`) VALUES
('audifonos1', b'0', b'0', 'Azul', b'1', 0, '2021-06-17', NULL, '9a2d250a-b75c-4b31-b8fc-b1af1cfe508a_audifonos 1.jpg', 'Apple', 'Diadema ', 25000, 8, '1093799958'),
('audifonos2', b'0', b'0', 'Negro', b'1', 0, '2021-06-17', NULL, 'd7c77a86-f5ad-423f-956e-78405b46e6a1_audifonos 2.jfif', 'Microsoft', 'Audifonos', 900000, 8, '1093799888'),
('CamaraWeb1', b'0', b'0', 'Negro', b'1', 0, '2021-06-17', NULL, 'f36300eb-0205-49d3-9d84-3aac66196121_camara 1.jpg', 'Microsoft', 'Camara HD', 250000, 7, '1093799958'),
('CamaraWeb2', b'0', b'0', 'Negro', b'1', 0, '2021-06-17', NULL, 'c3830a5f-dfe1-460d-9ef8-d41e86df66ef_camara 2.jpg', 'Acer', 'Camara HD', 600000, 7, '1093799888'),
('impresora1', b'0', b'0', 'Blanco', b'1', 0, '2021-06-16', NULL, 'c341bbc1-c662-42c5-830e-37f376ce507c_impresora 1.jpg', 'Samsung', 'Impresora', 400000, 1, '1093799958'),
('impresora2', b'0', b'0', 'Negro', b'1', 0, '2021-06-17', NULL, '7570b848-e3f0-4ec1-a9a5-38c1b4a01c45_impresora 2.jpg', 'MSI', 'Impresora', 250000, 3, '1093799888'),
('Monitor1', b'0', b'0', 'negro', b'1', 0, '2021-06-16', NULL, '14545c33-eafd-4ab9-a968-04d9089a110d_monitor 1.jpg', 'HP', 'Monitor', 100000, 2, '1093799958'),
('monitor2', b'0', b'0', 'Negro', b'1', 0, '2021-06-17', NULL, 'add452f2-8dfd-40b8-bbcc-0ae919efa533_monitor 2.jpg', 'Samsung', 'Monitor ', 300000, 2, '1093799888'),
('mouse1', b'0', b'0', 'Negro', b'1', 0, '2021-06-16', NULL, '72aa66a8-515e-4c61-976c-c20d5f4648f7_Mouse 1.png', 'Alienware', 'Mouse Gamer', 50000, 1, '1093799958'),
('mouse2', b'0', b'0', 'Negro', b'1', 1, '2021-06-17', NULL, '6f546d16-d544-4e3c-8f37-1f10fc75162b_Mouse 2.png', 'HP', 'Mouse', 0, 1, '1093799888'),
('PcEscritorio1', b'0', b'0', 'Negro', b'1', 0, '2021-06-17', NULL, '4013e127-97ed-4bda-a8f6-5d0a7054c984_pc escritorio  1.jpg', 'Lenovo', 'PC escritorio', 800000, 6, '1093799958'),
('PcEscritorio2', b'0', b'0', 'Negro', b'1', 1, '2021-06-17', NULL, '2980f4d3-95e7-4ff4-ac03-e977d59ba2b8_pc escritorio  2.jpg', 'Samsung', 'Computador Escritorio', 0, 6, '1093799888'),
('Portatil1', b'0', b'0', 'blanco', b'1', 0, '2021-06-17', NULL, '6d7a4900-59a8-47b2-b641-25b9cad064ab_portatil 1.png', 'Dell', 'PC Portatil', 1550000, 5, '1093799958'),
('portatil2', b'0', b'0', 'Negro', b'1', 0, '2021-06-17', NULL, 'ba481440-5928-4530-b734-c0bf6cd3e426_portatil 3.jfif', 'Dell', 'Portatil ', 3000000, 5, '1093799888'),
('teclado1', b'0', b'0', 'Negro', b'1', 1, '2021-06-16', NULL, '98a038de-3cf8-4ce8-bd1f-b30887e033b2_teclado 1.jpg', 'MSI', 'Teclado Gamer', 0, 4, '1093799958'),
('teclado2', b'0', b'0', 'Negro', b'1', 1, '2021-06-17', NULL, 'aff7012e-379e-4135-9705-c9b8bc6973f1_teclado 2.jpg', 'Microsoft', 'Teclado ', 0, 4, '1093799888');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `marcas`
--

CREATE TABLE `marcas` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `marcas`
--

INSERT INTO `marcas` (`id`, `nombre`) VALUES
(1, 'Lenovo'),
(2, 'HP'),
(3, 'Acer'),
(4, 'Dell'),
(5, 'Asus'),
(6, 'Samsung'),
(7, 'Apple'),
(8, 'Microsoft'),
(9, 'MSI'),
(10, 'Alienware');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_equipo`
--

CREATE TABLE `tipo_equipo` (
  `id_tipo` int(11) NOT NULL,
  `descripcions` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tipo_equipo`
--

INSERT INTO `tipo_equipo` (`id_tipo`, `descripcions`, `nombre`) VALUES
(1, NULL, 'Mouse'),
(2, NULL, 'Monitor'),
(3, NULL, 'Impresora'),
(4, NULL, 'Teclado'),
(5, NULL, 'Computador Portatil'),
(6, NULL, 'Computador Escritorio'),
(7, NULL, 'Camara'),
(8, NULL, 'Audifonos');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `cedula` varchar(255) NOT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `rol` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`cedula`, `apellido`, `direccion`, `email`, `nombre`, `password`, `rol`, `telefono`, `token`) VALUES
('1093788777', 'Bautista', 'calle 2 # 2-18', 'juan@gmail.com', 'Juan', '$2a$10$XpvI7ufPEXuxiRQuNL716.yH.KiE29W8E2h7qgQyiL0o4jlOEoM.6', 'ROLE_USUARIO', '3158889991', NULL),
('1093799888', 'Higuera', 'calle 3 # 2-91', 'andres@gmail.com', 'Andres', '$2a$10$BnG6YMBvrQbpgoA/G59FPOvCSqfzoVARysdw8xvQ83n7QC4hlIHYy', 'ROLE_USUARIO', '3228082529', NULL),
('1093799958', 'Gonzalez', 'calle 12 #3-19 ', 'samuelguillermogo@ufps.edu.co', 'Samuel ', '$2a$10$8niwXIVDC8F4XEy5azUiFOgmEFeLndRYiEyTDxjwocPDjtmcLwwvq', 'ROLE_USUARIO', '3228082528', NULL),
('1093800414', 'Toloza', 'calle 5 #6-17', 'janith@gmail.com', 'Janith', '$2a$10$dmTZqxR1w3k1c4r/D80DEu8QjZ/Caz3eaGeZb7xjTpwRF8D/Fn4uq', 'ROLE_ADMIN', '3228052627', NULL),
('5538350979', 'Asher', 'Philadelphia, PA 19103', 'johnasher@gustr.com', 'John T. ', '$2a$10$ie88oHeAKvC4suriSwAuM.V08MZtybrvilwt2dQcwI0pVf04cEpIK', 'ROLE_ADMIN', '610-946-9902', NULL);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `baja`
--
ALTER TABLE `baja`
  ADD PRIMARY KEY (`id_baja`);

--
-- Indices de la tabla `equipo`
--
ALTER TABLE `equipo`
  ADD PRIMARY KEY (`serial`),
  ADD KEY `FK688sataa8c8r7bkgh58gj6sdv` (`id_tipo_equipo`),
  ADD KEY `FK8i07gmjg2ioq8b3gpb79tfcpl` (`id_usuario`);

--
-- Indices de la tabla `marcas`
--
ALTER TABLE `marcas`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tipo_equipo`
--
ALTER TABLE `tipo_equipo`
  ADD PRIMARY KEY (`id_tipo`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`cedula`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `baja`
--
ALTER TABLE `baja`
  MODIFY `id_baja` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `marcas`
--
ALTER TABLE `marcas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `tipo_equipo`
--
ALTER TABLE `tipo_equipo`
  MODIFY `id_tipo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `equipo`
--
ALTER TABLE `equipo`
  ADD CONSTRAINT `FK688sataa8c8r7bkgh58gj6sdv` FOREIGN KEY (`id_tipo_equipo`) REFERENCES `tipo_equipo` (`id_tipo`),
  ADD CONSTRAINT `FK8i07gmjg2ioq8b3gpb79tfcpl` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`cedula`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
