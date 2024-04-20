package errandex;

import java.util.List;

public class University {
    private String name;
    private List<Faculty> faculties;

    public University(String name, List<Faculty> faculties) {
        this.name = name;
        this.faculties = faculties;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(List<Faculty> faculties) {
        this.faculties = faculties;
    }

    public void checkFaculty() throws FacultiyException{
        if(this.faculties.isEmpty())
            throw new FacultiyException("there is no faculty in university");
    }
}
