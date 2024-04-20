package errandex;

import java.util.List;

public class Group {
    private int id;
    private List<Student> students;

    public Group(int id, List<Student> students) {
        this.id = id;
        this.students = students;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void checkStudents() throws StudentException{
        if(this.students.isEmpty())
            throw new StudentException("there is no student in group");
    }
}
