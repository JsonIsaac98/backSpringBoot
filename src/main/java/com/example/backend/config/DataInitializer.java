package com.example.backend.config;

import com.example.backend.model.Category;
import com.example.backend.model.News;
import com.example.backend.model.Tag;
import com.example.backend.model.User;
import com.example.backend.repository.CategoryRepository;
import com.example.backend.repository.NewsRepository;
import com.example.backend.repository.TagRepository;
import com.example.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final TagRepository tagRepository;
    private final NewsRepository newsRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        //  usuario
        if (userRepository.findByUsername("admin").isEmpty()) {
            User admin = User.builder()
                    .username("admin")
                    .password(passwordEncoder.encode("admin"))
                    .build();
            userRepository.save(admin);

            User user = User.builder()
                    .username("user")
                    .password(passwordEncoder.encode("password"))
                    .build();
            userRepository.save(user);
        }

        Category tech = createCategoryIfNotExists("Tecnología", "Noticias sobre avances tecnológicos");
        Category sports = createCategoryIfNotExists("Deportes", "Noticias deportivas de todo el mundo");
        Category politics = createCategoryIfNotExists("Política", "Actualidad política nacional e internacional");
        Category health = createCategoryIfNotExists("Salud", "Noticias sobre salud y bienestar");
        Category entertainment = createCategoryIfNotExists("Entretenimiento", "Noticias sobre cine, música y cultura");

        Tag innovation = createTagIfNotExists("Innovación");
        Tag ai = createTagIfNotExists("Inteligencia Artificial");
        Tag football = createTagIfNotExists("Fútbol");
        Tag olympics = createTagIfNotExists("Olimpiadas");
        Tag election = createTagIfNotExists("Elecciones");
        Tag healthcare = createTagIfNotExists("Salud pública");
        Tag covid = createTagIfNotExists("COVID-19");
        Tag movies = createTagIfNotExists("Cine");
        Tag music = createTagIfNotExists("Música");

        if (newsRepository.count() == 0) {
            // Tecnolo 1
            News techNews1 = new News();
            techNews1.setTitle("Avances en Inteligencia Artificial transforman la industria");
            techNews1.setDescription("Nuevos desarrollos en IA están revolucionando múltiples sectores económicos");
            techNews1.setImageUrl("https://via.placeholder.com/800x400?text=AI+Revolution");
            techNews1.setContent("La inteligencia artificial continúa su imparable avance transformando industrias completas. Los últimos algoritmos de aprendizaje profundo han demostrado capacidades sorprendentes que superan en muchos aspectos a las técnicas tradicionales. Expertos aseguran que estamos solo al comienzo de una revolución tecnológica sin precedentes.\n\nEmpresas de todos los sectores están adoptando estas tecnologías para optimizar procesos, reducir costos y ofrecer nuevos servicios a sus clientes. Desde la medicina personalizada hasta los vehículos autónomos, la IA está cambiando nuestra forma de vivir y trabajar.\n\nSin embargo, estos avances también plantean importantes desafíos éticos y laborales que la sociedad deberá abordar en los próximos años.");
            techNews1.setPublishDate(LocalDateTime.now().minusDays(2));
            techNews1.setCategory(tech);
            techNews1.setTags(new HashSet<>(Arrays.asList(innovation, ai)));
            newsRepository.save(techNews1);

            // Tecnología 2
            News techNews2 = new News();
            techNews2.setTitle("Nueva generación de robots más humanos");
            techNews2.setDescription("Desarrollan robots con capacidades emocionales y expresivas similares a las humanas");
            techNews2.setImageUrl("https://via.placeholder.com/800x400?text=Human+Robots");
            techNews2.setContent("Un equipo de científicos ha presentado hoy un prototipo de robot con capacidades emocionales y expresivas nunca antes vistas. Este avance supone un salto cualitativo en la robótica social y abre nuevas posibilidades para la integración de estas máquinas en entornos humanos.\n\nEl robot, denominado EmotionX, puede reconocer expresiones faciales y adaptar su comportamiento según el estado emocional de las personas con las que interactúa. Además, cuenta con un rostro capaz de expresar más de 20 emociones diferentes de forma natural.\n\nLos investigadores aseguran que estos robots podrían tener aplicaciones en campos como la asistencia a personas mayores, la educación o la terapia psicológica.");
            techNews2.setPublishDate(LocalDateTime.now().minusDays(5));
            techNews2.setCategory(tech);
            techNews2.setTags(new HashSet<>(Arrays.asList(innovation)));
            newsRepository.save(techNews2);

            //  Deportes
            News sportsNews = new News();
            sportsNews.setTitle("Sorpresa en el mundial de fútbol");
            sportsNews.setDescription("Equipo no favorito avanza a semifinales tras una histórica victoria");
            sportsNews.setImageUrl("https://via.placeholder.com/800x400?text=Football+Surprise");
            sportsNews.setContent("En un partido lleno de emoción y sorpresas, el equipo considerado como outsider ha logrado una histórica victoria que le permite avanzar a las semifinales del mundial. Con un juego disciplinado y aprovechando las pocas oportunidades de gol, consiguieron derrotar a uno de los grandes favoritos.\n\nEl gol decisivo llegó en el minuto 87, cuando su delantero estrella aprovechó un error defensivo para anotar el tanto que hizo estallar de alegría a sus aficionados. El portero del equipo también fue figura clave al detener un penalti en los minutos finales.\n\nEsta victoria representa uno de los mayores logros en la historia deportiva del país y ha desatado celebraciones masivas en sus ciudades principales.");
            sportsNews.setPublishDate(LocalDateTime.now().minusDays(1));
            sportsNews.setCategory(sports);
            sportsNews.setTags(new HashSet<>(Arrays.asList(football)));
            newsRepository.save(sportsNews);

            // Política
            News politicsNews = new News();
            politicsNews.setTitle("Resultados electorales marcan un cambio de rumbo");
            politicsNews.setDescription("Las elecciones generales dan la victoria a un nuevo partido político");
            politicsNews.setImageUrl("https://via.placeholder.com/800x400?text=Election+Results");
            politicsNews.setContent("Los resultados de las elecciones celebradas ayer han supuesto un auténtico terremoto político. El partido que ha gobernado durante los últimos 12 años ha sufrido una contundente derrota, cediendo el poder a una nueva formación política que promete cambios estructurales.\n\nCon una participación récord del 78%, los ciudadanos han enviado un claro mensaje de deseo de renovación. El nuevo gobierno ha anunciado que sus prioridades serán la regeneración democrática, la lucha contra la corrupción y un nuevo modelo económico más sostenible.\n\nLos mercados financieros han reaccionado con cautela ante esta nueva etapa política, mientras que líderes internacionales ya han felicitado al nuevo presidente electo.");
            politicsNews.setPublishDate(LocalDateTime.now().minusDays(3));
            politicsNews.setCategory(politics);
            politicsNews.setTags(new HashSet<>(Arrays.asList(election)));
            newsRepository.save(politicsNews);

            // Salud
            News healthNews = new News();
            healthNews.setTitle("Nuevo tratamiento promete combatir enfermedades crónicas");
            healthNews.setDescription("Científicos desarrollan terapia innovadora para múltiples condiciones");
            healthNews.setImageUrl("https://via.placeholder.com/800x400?text=Health+Innovation");
            healthNews.setContent("Un equipo internacional de científicos ha anunciado el desarrollo de un tratamiento innovador que podría revolucionar el abordaje de múltiples enfermedades crónicas. La terapia, basada en la edición genética CRISPR, ha mostrado resultados prometedores en ensayos clínicos preliminares.\n\nSe trata de un enfoque personalizado que adapta el tratamiento al perfil genético específico de cada paciente, maximizando su eficacia y reduciendo efectos secundarios. Los primeros pacientes tratados han experimentado mejoras significativas en sus condiciones, con mínimas complicaciones.\n\nLas autoridades sanitarias han mostrado un cauto optimismo, aunque señalan que aún se requieren más estudios para confirmar la seguridad y eficacia a largo plazo de esta terapia revolucionaria.");
            healthNews.setPublishDate(LocalDateTime.now().minusDays(4));
            healthNews.setCategory(health);
            healthNews.setTags(new HashSet<>(Arrays.asList(healthcare)));
            newsRepository.save(healthNews);

            // Entretenimiento
            News entertainmentNews = new News();
            entertainmentNews.setTitle("Película independiente arrasa en los premios cinematográficos");
            entertainmentNews.setDescription("Film de bajo presupuesto se convierte en la sensación de la temporada");
            entertainmentNews.setImageUrl("https://via.placeholder.com/800x400?text=Movie+Awards");
            entertainmentNews.setContent("En una gala llena de sorpresas, una película independiente de bajo presupuesto se ha convertido en la gran triunfadora de la noche al llevarse cinco de los principales premios, incluyendo Mejor Película y Mejor Dirección.\n\nProducida con apenas un millón de dólares, esta conmovedora historia sobre las relaciones familiares ha conectado profundamente con el público y la crítica. Su director, en su discurso de agradecimiento, destacó la importancia de contar historias auténticas y personales en un momento dominado por las superproducciones.\n\nEsta victoria representa un soplo de aire fresco para el cine independiente y podría influir en las futuras tendencias de la industria cinematográfica.");
            entertainmentNews.setPublishDate(LocalDateTime.now().minusDays(6));
            entertainmentNews.setCategory(entertainment);
            entertainmentNews.setTags(new HashSet<>(Arrays.asList(movies)));
            newsRepository.save(entertainmentNews);
        }
    }

    private Category createCategoryIfNotExists(String name, String description) {
        Category category = categoryRepository.findByName(name);
        if (category == null) {
            category = new Category();
            category.setName(name);
            category.setDescription(description);
            categoryRepository.save(category);
        }
        return category;
    }

    private Tag createTagIfNotExists(String name) {
        Tag tag = tagRepository.findByName(name);
        if (tag == null) {
            tag = new Tag();
            tag.setName(name);
            tagRepository.save(tag);
        }
        return tag;
    }
}