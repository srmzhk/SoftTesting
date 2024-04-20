package errandex;

import java.util.ArrayList;
import java.util.HashMap;

public class Student {
    private String name;
    private String surname;
    private HashMap<String, Integer> grades = new HashMap<>();

    {
        name = "unknown";
        surname = "unknown";
        grades.put("math", -1);
        grades.put("physics", -1);
        grades.put("biology", -1);
        grades.put("it", -1);
        grades.put("economy", -1);
        grades.put("business", -1);
        grades.put("english language", -1);
    }

    public Student(String name, String surname, int[] grades) {
        this.name = name;
        this.surname = surname;
        this.grades = addGrades(grades);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public HashMap<String, Integer> getGrades() {
        return grades;
    }

    public void checkGrades() throws GradeException {
        if(this.grades.isEmpty())
            throw new GradeException("Empty grades");
        else{
            for(int grade : grades.values()){
                if(grade < 0 || grade > 10)
                    throw new GradeException("Invalid grade");
            }
        }
    }

    private HashMap<String, Integer> addGrades(int[] grades) {
        int i = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for(String key : this.grades.keySet()) {
            if(i == grades.length)
                break;
            else
                map.put(key, grades[i++]);
        }
        return map;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", grades=" + grades +
                "}\n";
    }
}
