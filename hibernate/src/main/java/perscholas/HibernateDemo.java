package perscholas;

import perscholas.database.dao.ActorDAO;
import perscholas.database.dao.MovieDAO;
import perscholas.database.entity.Actor;
import perscholas.database.entity.Movie;

import java.util.List;

public class HibernateDemo {

    // CRUD : Create, Read, Update, Delete

    private ActorDAO actorDao = new ActorDAO();
    private MovieDAO movieDao = new MovieDAO();

    public void work() {
        // read();
        //create();
        //deleteWithEntityManager();
        //deleteWithQuery();
        //update();

        addActorToMovie();

        queryManyToMany();

    }

    private void addActorToMovie() {
        // get star wars from the database
        Movie movie = movieDao.findById(1);

        Actor lea = actorDao.findById(4);

        movie.getActors().add(lea);

        lea.getMovies().add(movie);

        movieDao.update(movie);
        actorDao.update(lea);
    }

    private void queryManyToMany() {
        Movie movie = movieDao.findById(1);

        System.out.println(movie);

        for ( Actor actor : movie.getActors() ) {
            System.out.println(actor);
        }

        System.out.println("=================================");

        Actor actor = actorDao.findById(5);
        System.out.println(actor);
        for ( Movie m : actor.getMovies() ) {
            System.out.print(m);
        }


    }

    private void update() {
        Actor actor = actorDao.findById(6);
        System.out.println("Before update : " + actor);

        actor.setFirstName("This is");
        actor.setLastName("An Update");
        actor.setAge(1);

        actorDao.update(actor);

        System.out.println("After update : " + actor);
    }

    private void deleteWithQuery() {
        actorDao.deleteById(8);
    }

    private void deleteWithEntityManager() {
        Actor actor = actorDao.findById(7);
        actorDao.delete(actor);
        //actorDao.delete(null);
    }

    private void create() {
        Actor actor = new Actor();

        actor.setFirstName("FirstName");
        actor.setLastName("LastName");
        actor.setAge(100);

        System.out.println("Before save : " + actor);

        actorDao.save(actor);
        System.out.println("After save : " + actor);
    }

    private void read() {
        int actorId = 3333;
        Actor actor = actorDao.findById(actorId);
        if (actor == null) {
            System.out.println("Unable to find actor by id " + actorId);
        } else {
            System.out.println("Find by id : " + actor.toString());
        }

        List<Actor> actors = actorDao.findByFirstName("Mark");
        if (actors.isEmpty()) {
            System.out.println("No actors found");
        } else {
            for (Actor a : actors) {
                System.out.println("Find by firstName : " + a);
            }
        }
    }


    public static void main(String[] args) {
        new HibernateDemo().work();
    }
}
