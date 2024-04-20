package errandex;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Release {
    public static void main(String[] args) {
        List<Group> groups1 = new ArrayList<>();
        groups1.add(new Group(11, addStudents(11)));
        groups1.add(new Group(12, addStudents(12)));
        groups1.add(new Group(13, addStudents(13)));

        List<Group> groups2 = new ArrayList<>();
        groups2.add(new Group(21, addStudents(21)));
        groups2.add(new Group(22, addStudents(22)));
        groups2.add(new Group(23, addStudents(23)));

        List<Group> groups3 = new ArrayList<>();
        groups3.add(new Group(31, addStudents(31)));
        groups3.add(new Group(32, addStudents(32)));
        groups3.add(new Group(33, addStudents(33)));

        List<Faculty> faculties = new ArrayList<>();
        faculties.add(new Faculty(1, "FIT", groups1));
        faculties.add(new Faculty(2, "TOV", groups2));
        faculties.add(new Faculty(3, "IEF", groups3));

        University university = new University("BSTU", faculties);

        System.out.println(countAvgGradesByStudentSurname(university,"surname-29-g13"));
        System.out.println(countAvgGradesByFacultyGroupSubject(university.getFaculties().get(1),
                university.getFaculties().get(1).getGroups().get(2), "math"));
        System.out.println(countAvgBySubjectInUniversity(university, "it"));
    }

    public static List<Student> addStudents(int id){
        List<Student> students = new ArrayList<>();
        Random random = new Random();
        for(int i = 0; i < 30; i++){
            int[] grades = new int[7];
            for(int j = 0; j < 7; j++)
                grades[j] = random.nextInt(10);
            String name = "name-" + i + "-g" + id;
            String surname = "surname-" + i + "-g" + id;
            students.add(new Student(name, surname, grades));
        }
        return students;
    }

    public static double countAvgGradesByStudentSurname(University university, String surname) {
        double avg = 0;
        for(Faculty faculty : university.getFaculties()){
            for(Group group: faculty.getGroups()){
                for (Student student : group.getStudents()){
                    if(student.getSurname().equals(surname)){
                        for (String key : student.getGrades().keySet()){
                            avg += student.getGrades().get(key);
                        }
                    }
                }
            }
        }
        return avg / 7;
    }

    public static double countAvgGradesByFacultyGroupSubject(Faculty faculty, Group group, String subject) {
        double avg = 0;
        for(Group currentGroup : faculty.getGroups()){
            if(currentGroup.equals(group)){
                for(Student student : currentGroup.getStudents()){
                    avg += student.getGrades().get(subject);
                }
            }
        }
        return avg / group.getStudents().size();
    }

    public static double countAvgBySubjectInUniversity(University university, String subject) {
        double avg = 0;
        int counter = 0;
        for(Faculty faculty : university.getFaculties()){
            for(Group group: faculty.getGroups()){
                for (Student student : group.getStudents()){
                    avg += student.getGrades().get(subject);
                    counter++;
                }
            }
        }
        return avg / counter;
    }
}
