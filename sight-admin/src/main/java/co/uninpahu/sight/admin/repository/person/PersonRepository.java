package co.uninpahu.sight.admin.repository.person;

import co.uninpahu.sight.admin.entity.person.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
