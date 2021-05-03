package guru.springframework.sfgpetclinic.services;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Owner findById(Long id);

    Owner save(Pet owner);

    Set<Owner> findAll();
}
