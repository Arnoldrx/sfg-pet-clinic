package guru.springframework.sfgpetclinic.sfgpetclinic.repositories;

import guru.springframework.sfgpetclinic.sfgpetclinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepository extends CrudRepository<Speciality,Long> {
}
