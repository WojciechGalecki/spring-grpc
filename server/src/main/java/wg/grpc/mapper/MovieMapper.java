package wg.grpc.mapper;

import wg.grpc.model.MovieModel;

import org.modelmapper.ModelMapper;

import com.proto.movie.Movie;

public class MovieMapper {

    public static MovieModel map(Movie movie) {
        ModelMapper modelMapper = new ModelMapper();
        MovieModel mappedModel = modelMapper.map(movie, MovieModel.class);
        mappedModel.setId(null);

        return mappedModel;
    }
}
