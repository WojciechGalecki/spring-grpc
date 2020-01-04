package wg.grpc.server;

import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import wg.grpc.mapper.MovieMapper;
import wg.grpc.model.MovieModel;
import wg.grpc.repository.MovieRepository;

import com.proto.movie.AddMovieResponse;
import com.proto.movie.Movie;
import com.proto.movie.MovieServiceGrpc;

@GrpcService
@Slf4j
public class MovieService extends MovieServiceGrpc.MovieServiceImplBase {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {this.movieRepository = movieRepository;}

    @Override
    public void addMovie(Movie request, StreamObserver<AddMovieResponse> responseObserver) {
        log.info("Received add movie request");

        MovieModel movieModel = MovieMapper.map(request);

        MovieModel insertedMovie = movieRepository.insert(movieModel);
        String movieId = insertedMovie.id;
        log.info("Added new movie with id: {}", movieId);

        responseObserver.onNext(AddMovieResponse.newBuilder()
            .setMovieId(movieId)
            .build());

        responseObserver.onCompleted();
    }
}
