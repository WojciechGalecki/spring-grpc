package wg.grpc.server;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.grpc.internal.testing.StreamRecorder;
import wg.grpc.model.MovieModel;
import wg.grpc.repository.MovieRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.proto.movie.AddMovieResponse;
import com.proto.movie.Movie;

@RunWith(MockitoJUnitRunner.class)
public class MovieServiceTest {
    private static final String TITLE = "test";
    private static final String ID = "id";

    @Mock
    private MovieRepository repository;

    @InjectMocks
    private MovieService service;

    @Test
    public void demo() {
        Movie request = Movie.newBuilder()
            .setTitle(TITLE)
            .build();

        MovieModel insertedModel = new MovieModel();
        insertedModel.setId(ID);

        when(repository.insert(any(MovieModel.class))).thenReturn(insertedModel);

        StreamRecorder<AddMovieResponse> responseObserver = StreamRecorder.create();

        service.addMovie(request, responseObserver);

        assertNull(responseObserver.getError());
        assertEquals(ID, responseObserver.getValues().get(0).getMovieId());
    }
}
