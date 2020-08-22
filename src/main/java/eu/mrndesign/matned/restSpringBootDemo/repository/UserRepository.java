package eu.mrndesign.matned.restSpringBootDemo.repository;

import eu.mrndesign.matned.restSpringBootDemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//    @Query("select u from User u where u.name = :name" )
    Optional<User> findUserByName(@Param("name") String name);
}
