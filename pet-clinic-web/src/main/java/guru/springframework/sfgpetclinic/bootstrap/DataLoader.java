package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 =  new Owner();
        owner1.setFirstName("Micheal");
        owner1.setLastName("Paul");

        ownerService.save(owner1);

        Owner owner2 =  new Owner();
        owner2.setFirstName("Arnold");
        owner2.setLastName("Jay");

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
