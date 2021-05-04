package guru.springframework.sfgpetclinic.model;

public class Owner extends Person {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
