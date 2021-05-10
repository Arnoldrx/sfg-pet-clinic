package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 =  new Owner();
        owner1.setFirstName("Micheal");
        owner1.setLastName("Paul");
        owner1.setAddress("123 Brickerel");
        owner1.setCity("Miami");
        owner1.setTelephone("261513");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedCatPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDay(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2 =  new Owner();
        owner2.setFirstName("Arnold");
        owner2.setLastName("Jay");
        owner2.setAddress("123 Brick");
        owner2.setCity("Miami Beach");
        owner2.setTelephone("84512");

        Pet fionaCat = new Pet();
        fionaCat.setName("Cat");
        fionaCat.setOwner(owner2);
        fionaCat.setBirthDay(LocalDate.now());
        fionaCat.setPetType(savedCatPetType);
        owner2.getPets().add(fionaCat);

        ownerService.save(owner2);

        System.out.println("Loaded Owner...");

        Vet vet1 =  new Vet();
        vet1.setFirstName("Dangote");
        vet1.setLastName("Paul");

        vetService.save(vet1);

        Vet vet2 =  new Vet();
        vet2.setFirstName("Mike");
        vet2.setLastName("Big");

        vetService.save(vet2);

        System.out.println("Loaded Vets.....");

    }
}
