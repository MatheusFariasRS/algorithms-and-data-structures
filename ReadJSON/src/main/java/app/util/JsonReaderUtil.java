package app.util;

import app.Main;
import app.entities.Course;
import app.entities.Lesson;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.InputStream;
import java.util.List;

public class JsonReaderUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.registerModule(new JavaTimeModule());
    }

    public static void readAndPrint() {
        try (InputStream is =
                     Main.class
                             .getClassLoader()
                             .getResourceAsStream("file.json")) {

            if (is == null) {
                throw new RuntimeException("file.json não encontrado no classpath");
            }

            List<Course> courses =
                    objectMapper.readValue(is, new TypeReference<List<Course>>() {});

            for (Course course : courses) {
                System.out.println("Course Id: " + course.getId());
                System.out.println("Course Title: " + course.getTitle());

                List<Lesson> lessons = course.getLessons();

                for (Lesson lesson : lessons) {
                    System.out.println();
                    System.out.println("    id: " + lesson.getId());
                    System.out.println("    title: " + lesson.getTitle());
                    System.out.println("    media: " + lesson.getMedia());
                    System.out.println("    timestamp: " + lesson.getTimestamp());
                }
                System.out.println();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

