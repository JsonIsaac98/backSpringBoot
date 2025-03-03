-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 03-03-2025 a las 16:38:59
-- Versión del servidor: 9.1.0
-- Versión de PHP: 7.4.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bdnoticia`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categories`
--

DROP TABLE IF EXISTS `categories`;
CREATE TABLE IF NOT EXISTS `categories` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `description` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `categories`
--

INSERT INTO `categories` (`id`, `name`, `description`) VALUES
(1, 'Tecnología', 'Noticias sobre avances tecnológicos'),
(2, 'Deportes', 'Noticias deportivas de todo el mundo'),
(3, 'Política', 'Actualidad política nacional e internacional'),
(4, 'Salud', 'Noticias sobre salud y bienestar'),
(5, 'Entretenimiento', 'Noticias sobre cine, música y cultura');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `news`
--

DROP TABLE IF EXISTS `news`;
CREATE TABLE IF NOT EXISTS `news` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `content` text,
  `publish_date` datetime DEFAULT NULL,
  `category_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6itmfjj4ma8lfpj10jx24mhvx` (`category_id`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `news`
--

INSERT INTO `news` (`id`, `title`, `description`, `image_url`, `content`, `publish_date`, `category_id`) VALUES
(8, 'Avances en Inteligencia Artificial transforman la industria', 'Nuevos desarrollos en IA están revolucionando múltiples sectores económicos', 'https://mediatek-marketing.transforms.svdcdn.com/production/posts/MediaTek-IA-2023.jpg?w=2048&h=1075&q=80&auto=format&fit=crop&dm=1688130337&s=3b56535c28f441a34db9455d64444cb7', 'La inteligencia artificial continúa su imparable avance transformando industrias completas. Los últimos algoritmos de aprendizaje profundo han demostrado capacidades sorprendentes que superan en muchos aspectos a las técnicas tradicionales. Expertos aseguran que estamos solo al comienzo de una revolución tecnológica sin precedentes.\n\nEmpresas de todos los sectores están adoptando estas tecnologías para optimizar procesos, reducir costos y ofrecer nuevos servicios a sus clientes. Desde la medicina personalizada hasta los vehículos autónomos, la IA está cambiando nuestra forma de vivir y trabajar.\n\nSin embargo, estos avances también plantean importantes desafíos éticos y laborales que la sociedad deberá abordar en los próximos años.', '2025-03-01 16:36:43', 1),
(9, 'Nueva generación de robots más humanos', 'Desarrollan robots con capacidades emocionales y expresivas similares a las humanas', 'https://www.integritas.mx/web/image/35542-a1bda254/robots-con-inteligencia-artificial.png', 'Un equipo de científicos ha presentado hoy un prototipo de robot con capacidades emocionales y expresivas nunca antes vistas. Este avance supone un salto cualitativo en la robótica social y abre nuevas posibilidades para la integración de estas máquinas en entornos humanos.\n\nEl robot, denominado EmotionX, puede reconocer expresiones faciales y adaptar su comportamiento según el estado emocional de las personas con las que interactúa. Además, cuenta con un rostro capaz de expresar más de 20 emociones diferentes de forma natural.\n\nLos investigadores aseguran que estos robots podrían tener aplicaciones en campos como la asistencia a personas mayores, la educación o la terapia psicológica.', '2025-02-26 16:36:43', 1),
(10, 'Sorpresa en el mundial de fútbol', 'Equipo no favorito avanza a semifinales tras una histórica victoria', 'https://www.prensalibre.com/wp-content/uploads/2018/12/ccbc74c6-7149-42c4-aa43-a9c30641fff3.jpg?quality=52', 'En un partido lleno de emoción y sorpresas, el equipo considerado como outsider ha logrado una histórica victoria que le permite avanzar a las semifinales del mundial. Con un juego disciplinado y aprovechando las pocas oportunidades de gol, consiguieron derrotar a uno de los grandes favoritos.\n\nEl gol decisivo llegó en el minuto 87, cuando su delantero estrella aprovechó un error defensivo para anotar el tanto que hizo estallar de alegría a sus aficionados. El portero del equipo también fue figura clave al detener un penalti en los minutos finales.\n\nEsta victoria representa uno de los mayores logros en la historia deportiva del país y ha desatado celebraciones masivas en sus ciudades principales.', '2025-03-02 16:36:43', 2),
(11, 'Resultados electorales marcan un cambio de rumbo', 'Las elecciones generales dan la victoria a un nuevo partido político', 'https://www.councilbox.com/wp-content/uploads/2024/05/Portada_elecciones.png', 'Los resultados de las elecciones celebradas ayer han supuesto un auténtico terremoto político. El partido que ha gobernado durante los últimos 12 años ha sufrido una contundente derrota, cediendo el poder a una nueva formación política que promete cambios estructurales.\n\nCon una participación récord del 78%, los ciudadanos han enviado un claro mensaje de deseo de renovación. El nuevo gobierno ha anunciado que sus prioridades serán la regeneración democrática, la lucha contra la corrupción y un nuevo modelo económico más sostenible.\n\nLos mercados financieros han reaccionado con cautela ante esta nueva etapa política, mientras que líderes internacionales ya han felicitado al nuevo presidente electo.', '2025-02-28 16:36:43', 3),
(12, 'Nuevo tratamiento promete combatir enfermedades crónicas', 'Científicos desarrollan terapia innovadora para múltiples condiciones', 'https://cdn.who.int/media/images/default-source/mca/mca-covid-19/coronavirus-2.tmb-479v.jpg?sfvrsn=4dba955c_19%20479w', 'Un equipo internacional de científicos ha anunciado el desarrollo de un tratamiento innovador que podría revolucionar el abordaje de múltiples enfermedades crónicas. La terapia, basada en la edición genética CRISPR, ha mostrado resultados prometedores en ensayos clínicos preliminares.\n\nSe trata de un enfoque personalizado que adapta el tratamiento al perfil genético específico de cada paciente, maximizando su eficacia y reduciendo efectos secundarios. Los primeros pacientes tratados han experimentado mejoras significativas en sus condiciones, con mínimas complicaciones.\n\nLas autoridades sanitarias han mostrado un cauto optimismo, aunque señalan que aún se requieren más estudios para confirmar la seguridad y eficacia a largo plazo de esta terapia revolucionaria.', '2025-02-27 16:36:43', 4),
(13, 'Película independiente arrasa en los premios cinematográficos', 'Film de bajo presupuesto se convierte en la sensación de la temporada', 'https://plus.unsplash.com/premium_photo-1710961232986-36cead00da3c?fm=jpg&q=60&w=3000&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8bW92aWV8ZW58MHx8MHx8fDA%3D', 'En una gala llena de sorpresas, una película independiente de bajo presupuesto se ha convertido en la gran triunfadora de la noche al llevarse cinco de los principales premios, incluyendo Mejor Película y Mejor Dirección.\n\nProducida con apenas un millón de dólares, esta conmovedora historia sobre las relaciones familiares ha conectado profundamente con el público y la crítica. Su director, en su discurso de agradecimiento, destacó la importancia de contar historias auténticas y personales en un momento dominado por las superproducciones.\n\nEsta victoria representa un soplo de aire fresco para el cine independiente y podría influir en las futuras tendencias de la industria cinematográfica.', '2025-02-25 16:36:43', 5),
(14, 'Juegos Olímpicos de Invierno 2026 se celebrarán en nueva sede', 'Ciudad europea acogerá la próxima edición de los Juegos Olímpicos de Invierno', 'https://concepto.de/wp-content/uploads/2018/02/Bandera-de-los-juegos-olimpicos-scaled-e1726880769235.jpg', 'El Comité Olímpico Internacional ha anunciado que la ciudad de Innsbruck, en Austria, será la sede de los Juegos Olímpicos de Invierno de 2026. Esta decisión ha sido recibida con entusiasmo por los aficionados al deporte y las autoridades locales, que ya han comenzado los preparativos para acoger a los atletas de todo el mundo.\n\nInnsbruck, que ya fue sede de los Juegos Olímpicos de Invierno en 1964 y 1976, cuenta con una amplia experiencia en la organización de eventos deportivos de alto nivel. Las instalaciones deportivas y la infraestructura turística de la ciudad han sido renovadas y ampliadas para garantizar el éxito de la competición.\n\nLos Juegos Olímpicos de Invierno de 2026 prometen ser una celebración del deporte y la amistad entre los pueblos, con la participación de más de 2.500 atletas de más de 90 países.', '2025-02-24 16:36:43', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `new_tags`
--

DROP TABLE IF EXISTS `new_tags`;
CREATE TABLE IF NOT EXISTS `new_tags` (
  `news_id` bigint NOT NULL,
  `tag_id` bigint NOT NULL,
  PRIMARY KEY (`news_id`,`tag_id`),
  KEY `FK8s6immimyyonqqydcou809f2r` (`tag_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `new_tags`
--

INSERT INTO `new_tags` (`news_id`, `tag_id`) VALUES
(1, 1),
(1, 2),
(2, 1),
(3, 3),
(4, 5),
(5, 6),
(6, 8),
(8, 1),
(8, 2),
(9, 1),
(10, 3),
(11, 5),
(12, 6),
(13, 8),
(14, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tags`
--

DROP TABLE IF EXISTS `tags`;
CREATE TABLE IF NOT EXISTS `tags` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `tags`
--

INSERT INTO `tags` (`id`, `name`) VALUES
(1, 'Innovación'),
(2, 'Inteligencia Artificial'),
(3, 'Fútbol'),
(4, 'Olimpiadas'),
(5, 'Elecciones'),
(6, 'Salud pública'),
(7, 'COVID-19'),
(8, 'Cine'),
(9, 'Música');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `users`
--

INSERT INTO `users` (`id`, `username`, `password`) VALUES
(1, 'admin', '$2a$10$880XYQCrAmTfBaW.cD2J6u.rPbhn61mor8/zy821709D2mWnAfd/i'),
(2, 'user', '$2a$10$1NoQr6azMKNRHPfSjPPKBeWmr1ioCDHMnX6l260Xm7Y8/dkhrgr0a'),
(4, 'yeison', '$2a$10$U6E0ly6F9Rm12/2y./H1R.n2TEWn694kC5o9aMueq6bNCAtWJkpCS'),
(5, 'isaac', '$2a$10$9xdl2Kr78digKanwgOH6gurjmWjtdycyqTx6jMOb2UAPk49H0KN8W'),
(6, 'luis', '$2a$10$ubjLeDtAUnGkRaZDIp31Ie2gmK7GEO4Xs0NdLWa2/RD/jyIW1/qO.'),
(7, 'test', '$2a$10$GAMqTGaNLMBjARCqa0FhoOrhgdtkgHxQsVavmyAGU6iUs3TU0oPhq');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
