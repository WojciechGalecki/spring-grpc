package wg.grpc.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "movie")
@Getter
@Setter
public class MovieModel {

    @Id
    public String id;
    public String title;
    public List<Genre> genres;
    public List<PersonModel> directors;
    public List<PersonModel> writers;
    public List<PersonModel> stars;
    public int yearOfProduction;
    public int durationMinutes;

    public MovieModel() {
    }

    enum Genre {
        ACTION,
        COMEDY,
        DRAMA,
        HORROR,
        SCI_FI,
        THRILLER,
        WAR,
        WESTERN
    }

    @Getter
    @Setter
    static class PersonModel {
        public String firstName;
        public String lastName;
    }
}
