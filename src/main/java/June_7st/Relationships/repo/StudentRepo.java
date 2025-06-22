package June_7st.Relationships.repo;

import June_7st.Relationships.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo  extends JpaRepository<Student, Integer> {
    List<Student> findAllStudentByFirstName(String name);

    /// list of last name by their first name

    ///  we are writing a query not relying on jpa

    /*@Query("SELECT s.lastName from Student s " + " where s.firstName = :name")*/

    /// SQL QUERY(NATIVE QUERY)
    @Query(nativeQuery = true, value = "select s.last_name from STU s where s.first_name =?")
    List<String> findAllLastNamesByFirstName(String name);
}
