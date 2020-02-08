package wg.grpc.repository;

import wg.grpc.model.MovieModel;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepository extends MongoRepository<MovieModel, String> {
}


