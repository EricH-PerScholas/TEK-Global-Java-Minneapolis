package teksystems.casestudy.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import teksystems.casestudy.database.entity.User;

import java.util.List;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {

    public User findById(@Param("id") Integer id);

    public User findByEmail(@Param("email") String email);

    // select * from user where upper(first_name) like '%A%';
    public List<User> findByFirstNameIgnoreCaseContaining(@Param("firstName") String firstName);

    public List<User> findByFirstNameAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);


}
