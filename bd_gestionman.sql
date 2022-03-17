-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 06-08-2021 a las 18:56:09
-- Versión del servidor: 10.3.16-MariaDB
-- Versión de PHP: 7.3.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_gestionman`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `id_cliente` int(11) NOT NULL,
  `nombre_cliente` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `mail_cliente` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `tel_cliente` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `dir_cliente` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `ultima_modificacion` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`id_cliente`, `nombre_cliente`, `mail_cliente`, `tel_cliente`, `dir_cliente`, `ultima_modificacion`) VALUES
(0, 'Evertec', 'everinc@hotmail.com', '12345678', 'cra 68 11 20', 'Alexander G.'),
(1, 'Lanet Ltda', 'lanet.ltda@gmail.com', '2381718', 'cra 69 B 31 - 30 SUR Piso 3', 'Alexander G.'),
(2, 'Tecnomag', 'tecnomagco@gmail.com', '8231018', 'trav 4d', 'Alexander G.'),
(3, 'Bancolombi', 'banco@colombia.com', '5263564', 'soacha cun', 'Alexander G.'),
(4, 'PaolaLopez', 'pao@gmail.com', '1235648', 'cra 60 20 58', 'Alexander G.'),
(5, 'Alkosto', 'alkost@gmail.com', '568989563', 'cra 89', 'Alexander G.'),
(6, 'Colmena', 'colmena@gmail.com', '5462389', 'Cra 85 69 32', 'Alexander G.'),
(7, 'ColpatriA', 'COLPATRI@GMAIL.COM', '5645655466', 'HVGGHVHJ54534', 'Alexander G.');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `equipos`
--

CREATE TABLE `equipos` (
  `id_equipo` int(11) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `tipo_equipo` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `marca` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `modelo` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `num_serie` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `fecha_ingreso` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `observaciones` longtext CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `status` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `ultima_modificacion` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `comentarios_tecnicos` longtext CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `revision_tecnica` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `equipos`
--

INSERT INTO `equipos` (`id_equipo`, `id_cliente`, `tipo_equipo`, `marca`, `modelo`, `num_serie`, `fecha_ingreso`, `observaciones`, `status`, `ultima_modificacion`, `comentarios_tecnicos`, `revision_tecnica`) VALUES
(1, 1, 'Laptop', 'Acer', '12345', '123456789', '06/08/2019', 'Jodido', 'En revision', 'Alexander G.', 'Se esta revisando', 'Alexander G.'),
(2, 1, 'Desktop', 'Alienware', '98765', '98765432100', '06/08/2019', 'Re Jodido', 'Reparado', 'Alexander G.', 'Ya no esta jodido', 'Alexander G.'),
(3, 1, 'Impresora', 'Asus', '555555', '555666555666', '06/08/2019', 'Jodida', 'Entregado', 'Alexander G.', 'Ya quedo lista', 'Alexander G.');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id_usuario` int(11) NOT NULL,
  `nombre_usuario` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `telefono` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `tipo_nivel` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `status` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `registrado_por` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id_usuario`, `nombre_usuario`, `email`, `telefono`, `username`, `password`, `tipo_nivel`, `status`, `registrado_por`) VALUES
(0, 'Milena Guerrero', 'anelim@gmail.com', '56235891', 'Mili', 'milena', 'Capturista', 'Activo', 'Alexander G.'),
(1, 'Alexander G.', 'alexgonzan@gmail.com', '3115460313', 'Alex', 'jesus', 'Administrador', 'Activo', 'Alexander Gonzalez'),
(5, 'Milena', 'anelimgm@gmail.com', '3224755940', 'Mili', 'milena', 'Capturista', 'Activo', 'Alexander'),
(6, 'Oscar Ortiz L', 'oscarortiz@ortiz.org', '2345678', 'oscar', 'bamby', 'Tecnico', 'Activo', 'Alexander G.'),
(7, 'Santiago Martinez', 'bien@gmail.com', '2354689', 'bien', 'santi', 'Capturista', 'Activo', 'Alexander G.');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id_cliente`);

--
-- Indices de la tabla `equipos`
--
ALTER TABLE `equipos`
  ADD PRIMARY KEY (`id_equipo`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `equipos`
--
ALTER TABLE `equipos`
  MODIFY `id_equipo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
