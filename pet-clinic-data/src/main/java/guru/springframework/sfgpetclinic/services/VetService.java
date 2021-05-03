package guru.springframework.sfgpetclinic.services;

import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
