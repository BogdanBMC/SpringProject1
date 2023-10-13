package Bootstrap;


import Repositories.ManufacturerRepository;
import Repositories.ModelRepository;
import domain.Manufacturer;
import domain.Model;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


//dependency injections need to clarify!!!!!!!!!!

@Component
public class BootStrapData implements CommandLineRunner {

   private final ManufacturerRepository manufacturerRepository;
   private final ModelRepository modelRepository;

    public BootStrapData(ManufacturerRepository manufacturerRepository, ModelRepository modelRepository) {
        this.manufacturerRepository = manufacturerRepository;
        this.modelRepository = modelRepository;
    }

    @Override
    public void run(String... args) {


        Manufacturer vag = new Manufacturer("VW","R");
        Model m1 =new Model("Scirocco","blue");


        vag.getModels().add(m1);
        m1.getManufacturers().add(vag);

        manufacturerRepository.save(vag);
        modelRepository.save(m1);

        System.out.println("Started in Bootstrap");



    }
}
