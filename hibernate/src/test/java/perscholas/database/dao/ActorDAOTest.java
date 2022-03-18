package perscholas.database.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import perscholas.database.entity.Actor;

public class ActorDAOTest {

    private static ActorDAO actorDAO;

    @BeforeAll
    public static void setUp() {
        actorDAO = new ActorDAO();
    }


    @Test
    public void getActorTest() {
        // given
        Actor expected = new Actor();
        expected.setId(1);
        expected.setFirstName("Scarlett");
        expected.setLastName("Johansson");

        // when
        Actor actual = actorDAO.findById(1);

        // then
        Assertions.assertEquals(expected.getFirstName(), actual.getFirstName());
    }

    @Test
    public void getAnotherActorTest() {
        // given
        Actor expected = new Actor();
        expected.setId(2);
        expected.setFirstName("Mark");
        expected.setLastName("Hammel");

        // when
        Actor actual = actorDAO.findById(2);

        // then
        Assertions.assertEquals(expected.getId(), actual.getId());
        Assertions.assertEquals(expected.getFirstName(), actual.getFirstName());
        Assertions.assertEquals(expected.getLastName(), actual.getLastName());

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @Order(1)
    public void insert() {
        // given
        Actor expected = new Actor();
        expected.setFirstName("Deadpool");
        expected.setLastName("Reynolds");
        expected.setAge(5);

        // when
        expected = actorDAO.save(expected);
        Actor actual = actorDAO.findById(expected.getId());

        // then
        Assertions.assertNotNull(expected.getId());
        Assertions.assertEquals(expected.getFirstName(), actual.getFirstName());
        Assertions.assertEquals(expected.getLastName(), actual.getLastName());
    }

    @ParameterizedTest
    @CsvSource({"1,Scarlett,Johansson", "2,Mark,Hammel", "3,Robert,Downy Jr."})
    void testJUnit5CsvParameters(int id, String firstName, String lastName) {
        // given
        Actor expected = new Actor();
        expected.setId(id);
        expected.setFirstName(firstName);
        expected.setLastName(lastName);

        // when
        Actor actual = actorDAO.findById(id);

        // then
        Assertions.assertEquals(expected, actual);
    }


}
