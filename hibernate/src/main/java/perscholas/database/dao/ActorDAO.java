package perscholas.database.dao;

import perscholas.database.entity.Actor;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

public class ActorDAO {

    private static final String PERSISTENCE_UNIT_NAME = "moviesdb";

    private EntityManagerFactory emFactoryObj =
            Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);


    public Actor findById(Integer id) {
        EntityManager em = emFactoryObj.createEntityManager();

        // select * from actors where id = 1
        String sql = "SELECT a FROM Actor a WHERE a.id = :actorId";
        TypedQuery<Actor> query = em.createQuery(sql, Actor.class);
        query.setParameter("actorId", id);

        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public List<Actor> findByFirstName(String firstName) {
        EntityManager em = emFactoryObj.createEntityManager();

        // select * from actors where first_name = 'Mark';
        // select a.* from actors a where a.first_name = 'Mark';
        // select actors.* from actors where actors.first_name = 'Mark';
        String sql = "SELECT a FROM Actor a WHERE a.firstName = :firstName";
        TypedQuery<Actor> query = em.createQuery(sql, Actor.class);
        query.setParameter("firstName", firstName);

        List<Actor> result = query.getResultList();

        return result;
    }

    public Actor save( Actor actor ) {
        EntityManager em = emFactoryObj.createEntityManager();
        em.getTransaction().begin();

        // save the actor to the database
        em.persist(actor);

        // commit the transaction
        em.getTransaction().commit();
        em.clear();

        return actor;
    }

    public Actor update( Actor actor ) {
        EntityManager em = emFactoryObj.createEntityManager(/**/);
        em.getTransaction().begin();

        // save the actor to the database
        em.merge(actor);

        // commit the transaction
        em.getTransaction().commit();
        em.clear();

        return actor;
    }


    public void delete( Actor actor ) {
        if ( actor == null ) {
            System.out.println("Can not delete a null object");
            return;
        }

        EntityManager em = emFactoryObj.createEntityManager();
        em.getTransaction().begin();

        // save the actor to the database
        em.remove(em.contains(actor) ? actor : em.merge(actor));
        em.getTransaction().commit();

        // commit the transaction
        em.clear();
    }

    public int deleteById(Integer id) {
        EntityManager em = emFactoryObj.createEntityManager();
        em.getTransaction().begin();

        // delete from actors where id = 1
        String sql = "DELETE FROM Actor a WHERE a.id = :actorId";
        Query query = em.createQuery(sql);
        query.setParameter("actorId", id);

        int count = query.executeUpdate();
        em.getTransaction().commit();

        return count;
    }


}
