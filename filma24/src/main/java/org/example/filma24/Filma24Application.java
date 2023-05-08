package org.example.filma24;

import org.example.filma24.model.Movie;
import org.example.filma24.model.enums.Rating;
import org.example.filma24.repository.MovieRepository;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class Filma24Application {
    public static void main(String[] args) {
        testGetAllBadMovies();
        //testGetAll();
        //testInsert();
        //testGetById();
        //testUpdate();
        //testDelete();
    }

    public static void testGetAllBadMovies(){
        MovieRepository movieRepository = new MovieRepository();

        List<Movie> movies = movieRepository.getAllBadMovies();

        System.out.println("Movies: " + movies);
    }

    public static void testGetAll(){
        MovieRepository movieRepository = new MovieRepository();

        List<Movie> movies = movieRepository.getAll();

        System.out.println("Movies: " + movies);
    }

    public static void testGetById(){
        int id = 1;

        MovieRepository movieRepository = new MovieRepository();
        System.out.println(movieRepository.getById(id));
    }

    private static void testInsert(){
        Movie movie = createMovie();

        MovieRepository movieRepository = new MovieRepository();
        movieRepository.insert(movie);
    }

    private static Movie createMovie() {
        Movie movie = new Movie();

        movie.setId(4);
        movie.setBoxOffice(42_416_000.00);
        movie.setDuration(112);
        movie.setRating(Rating.VERY_BAD);
        movie.setTitle("The Earth");
        movie.setReleaseDate(LocalDate.of(2022, Month.JANUARY, 21));
        movie.setReleased(true);

        return movie;
    }

    private static void testUpdate(){
        Movie movie = createMovieForUpdate();

        MovieRepository movieRepository = new MovieRepository();
        movieRepository.update(movie);



    }

    private static Movie createMovieForUpdate(){
        Movie movie = new Movie();

        movie.setId(2);
        movie.setBoxOffice(100_500_000.00);
        movie.setDuration(150);
        movie.setRating(Rating.GOOD);
        movie.setTitle("Deadpool - Director's Cut");
        movie.setReleaseDate(LocalDate.of(2017, Month.DECEMBER, 7));
        movie.setReleased(true);

        return movie;
    }

    private static void testDelete(){
        int id = 1;

        MovieRepository movieRepository = new MovieRepository();
        movieRepository.delete(id);

    }
}
