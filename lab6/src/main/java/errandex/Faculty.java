package errandex;

import java.util.List;

public class Faculty {
    private int id;
    private String name;
    private List<Group> groups;

    public Faculty(int id, String name, List<Group> groups) {
        this.id = id;
        this.name = name;
        this.groups = groups;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public void checkGroups() throws GroupException{
        if(this.groups.isEmpty())
            throw new GroupException("there is no group in this faculty");
    }
}
