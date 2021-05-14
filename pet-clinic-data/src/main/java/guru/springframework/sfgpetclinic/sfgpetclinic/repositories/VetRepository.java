package guru.springframework.sfgpetclinic.sfgpetclinic.repositories;

import guru.springframework.sfgpetclinic.sfgpetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
