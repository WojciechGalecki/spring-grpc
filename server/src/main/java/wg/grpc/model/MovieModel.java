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
        ADVENTURE,
        ANIMATION,
        BIOGRAPHY,
        COMEDY,
        CRIME,
        DRAMA,
        FAMILY,
        FANTASY,
        FILM_NOIR,
        HISTORY,
        HORROR,
        MUSIC,
        MUSICAL,
        MYSTERY,
        ROMANCE,
        SCI_FI,
        SPORT,
        THRILLER,
        WAR,
        WESTERN,
    }

    @Getter
    @Setter
    static class PersonModel {
        public String firstName;
        public String lastName;
    }
}
