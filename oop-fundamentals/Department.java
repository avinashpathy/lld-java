import java.util.*;

class Department {
    private String name;
    private List<Professor>professors;

    public Department(String name, List<Professor>professors){
        this.name = name;
        this.professors = professors;
    }

    public void printProfessors(){
        System.out.println("Professors in " + name + " Department:");
        for(Professor professor: professors){
            System.out.println("- " + professor.getName());
        }
    }
}