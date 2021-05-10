package guru.springframework.sfgpetclinic.sfgpetclinic.model;

import java.util.Set;

public class Owner extends Person {
    private Set<Pet> pets;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }
}
