package June_7st.Relationships.runner;

import June_7st.Relationships.entities.Student;
import June_7st.Relationships.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class StudentDataLoader implements CommandLineRunner {
    @Autowired
    StudentRepo studentRepo;

    @Override
    public void run(String... args) throws Exception {

        Student student = new Student();
        student.setId(4);
        student.setFirstName("Nikhil");
        student.setLastName("pal");
        student.setEmail("nikhil@gmail.com");
        student.setPhoneNumber("5194988971");


        studentRepo.save(student);

    }
}
