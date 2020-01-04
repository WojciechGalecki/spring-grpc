package wg.grpc.client;

import javax.annotation.PostConstruct;

import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;

import org.springframework.stereotype.Service;

import com.proto.movie.AddMovieResponse;
import com.proto.movie.Movie;
import com.proto.movie.MovieGenre;
import com.proto.movie.MovieServiceGrpc;
import com.proto.movie.Person;

@Service
@Slf4j
public class MovieClient {

    @GrpcClient("localhost:9090")
    private MovieServiceGrpc.MovieServiceBlockingStub client;

    @PostConstruct
    public String addMovie() {
        Movie movie = Movie.newBuilder()
            .setTitle("The Shawshank Redemption")
            .addGenres(MovieGenre.DRAMA)
            .addDirectors(Person.newBuilder()
                .setFirstName("Frank")
                .setLastName("Darabont")
                .build())
            .addWriters(Person.newBuilder()
                .setFirstName("Frank")
                .setLastName("Darabont")
                .build())
            .addWriters(Person.newBuilder()
                .setFirstName("Stephen")
                .setLastName("King")
                .build())
            .addStars(Person.newBuilder()
                .setFirstName("Tim")
                .setLastName("Robbins")
                .build())
            .addStars(Person.newBuilder()
                .setFirstName("Morgan")
                .setLastName("Freeman")
                .build())
            .setYearOfProduction(1994)
            .setDurationMinutes(142)
            .build();

        log.info("Sending add movie request to the server...");
        AddMovieResponse addMovieResponse = client.addMovie(movie);
        log.info("Add movie response: {}", addMovieResponse.toString());

        return addMovieResponse.getMovieId();
    }
}
