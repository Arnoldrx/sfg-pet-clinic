package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.sfgpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) {
        int count = petTypeService.findAll().size();
        if (count == 0){
            loadData();
        }

    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);


        Owner owner1 =  new Owner();
        owner1.setFirstName("Micheal");
        owner1.setLastName("Paul");
        owner1.setAddress("123 Brickerel");
        owner1.setCity("Miami");
        owner1.setTelephone("261513");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
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

        Visit catVisit = new Visit();
        catVisit.setPet(fionaCat);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneezy Killy");


         visitService.save(catVisit);
        System.out.println("Loaded Owner...");

        Vet vet1 =  new Vet();
        vet1.setFirstName("Dangote");
        vet1.setLastName("Paul");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 =  new Vet();
        vet2.setFirstName("Mike");
        vet2.setLastName("Big");
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loaded Vets.....");
    }
}
