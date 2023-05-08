package org.example.filma24.repository;


import org.example.filma24.Filma24Application;
import org.example.filma24.model.Movie;
import org.example.filma24.model.enums.Rating;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class MovieRepository {

    public List<Movie> getAllBadMovies(){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("filma24-em");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery("Select m from Movie m where m.rating = :ratingChosen", Movie.class);
        query.setParameter("ratingChosen", Rating.VERY_BAD);
        List <Movie> resultList = query.getResultList();

        entityManager.getTransaction().commit();

        entityManager.close();

        entityManagerFactory.close();
        return resultList;

    }

    public List<Movie> getAll(){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("filma24-em");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Query query = entityManager.createQuery("Select m from Movie m", Movie.class);
        List <Movie> resultList = query.getResultList();

        entityManager.getTransaction().commit();

        entityManager.close();

        entityManagerFactory.close();
        return resultList;

    }
    public Movie insert(Movie movie){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("filma24-em");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(movie);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
        return movie;

    }
    public Movie getById(int id){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("filma24-em");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Movie movie = entityManager.find(Movie.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
        return movie;
    }

    public Movie update(Movie movie){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("filma24-em");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.merge(movie);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return movie;
    }

    public void delete(int id){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("filma24-em");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Movie movie = entityManager.find(Movie.class, id);
        entityManager.remove(movie);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
