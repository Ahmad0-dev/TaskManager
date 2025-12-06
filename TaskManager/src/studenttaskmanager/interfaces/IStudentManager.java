package studenttaskmanager.interfaces;

import studenttaskmanager.models.Student;
import java.util.List;

public interface IStudentManager {
    void addStudent(Student student);
    Student getStudentById(int id);
    List<Student> listAllStudents();
}
