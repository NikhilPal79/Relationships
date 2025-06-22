package June_7st.Relationships.api;

import June_7st.Relationships.dto.StudentDTO;
import June_7st.Relationships.entities.Student;
import June_7st.Relationships.services.StudentService;
import June_7st.Relationships.util.StudentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
/// combination of controller + responseBody
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @Autowired
    StudentUtils studentUtils;

    /// HTTP:GET ======>  http://localhost:8080/student/getAll
    /*@RequestMapping(method = RequestMethod.GET, path = "/getAll")*/
    @GetMapping("/getAll")
    public List<Student> getAllStudents(){
        List<Student> students = studentService.getStudent();
        return students;

    }

    ///  there are only threee places where they can send letters
    /// 1. body
    /// 2. url => called path variable
    /// 3. query parameters ===> are also the part of url



    @GetMapping("/byId")
    public Optional<Student> getById(@RequestParam("id") Integer identification){
        Optional<Student> studentById = studentService.getStudentById(identification);

        return studentById;

    }


    /// THE ABOVE METHOD AND BELOW METHOD ARE the SAME

    /*@GetMapping("/byId{id}")
    public Optional<Student> getById(@PathVariable("id{id}") Integer identification) {
        Optional<Student> studentById = studentService.getStudentById(identification);

        return studentById;
    }*/

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student studentEntity = studentService.createStudent(student);

        ResponseEntity<Student> studentResponseEntity = ResponseEntity
                .status(HttpStatusCode.valueOf(201))
                .header("Action", "Created")
                .header("GenId", String.valueOf(studentEntity.getId()))
                .header("Status",String.valueOf(1100))
                .contentType(MediaType.APPLICATION_JSON)
                .body(studentEntity);

        return studentResponseEntity;


    }

    /// WE USE PUT TO UPDATE THE ENTRIES

    @PutMapping("/update")
    public Student updateStudent(@RequestBody Student student){
        Student studentServiceStudent1 = studentService.updateStudent(student);

        return studentServiceStudent1;
    }

    @PatchMapping("/patch")
    public Student patch(@RequestBody Student student){
        return studentService.patchUpdate(student);
    }

    @GetMapping("/allByName")
    public List<Student> getAllByFirstName(@RequestParam String Name){
        List<Student> allByFirstName = studentService.getAllByFirstName(Name);
        return allByFirstName;
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteStudent(@PathVariable Integer id){
        return studentService.deleteStudent(id);

    }

    @PostMapping("/lastnames")
    public List<String> getAllLatNames(@RequestBody StudentDTO studentDTO){
        return   studentService.getLastNames(studentDTO.getFirstName());
    }


}
