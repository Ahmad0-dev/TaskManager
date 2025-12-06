package studenttaskmanager.managers;

import studenttaskmanager.interfaces.IStudentManager;
import studenttaskmanager.models.Student;
import java.util.ArrayList;
import java.util.List;

public class StudentManager implements IStudentManager {
    private List<Student> students = new ArrayList<>();

    @Override
    public void addStudent(Student student) {
        students.add(student);
    }

    @Override
    public Student getStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null; // not found
    }

    @Override
    public List<Student> listAllStudents() {
        return new ArrayList<>(students); // return a copy
    }
}

