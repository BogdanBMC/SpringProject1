package Bootstrap;


import Repositories.FactoryRepository;
import Repositories.ManufacturerRepository;
import Repositories.ModelRepository;
import domain.Factory;
import domain.Manufacturer;
import domain.Model;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


//dependency injections need to clarify!!!!!!!!!!

@Component
public class BootStrapData implements CommandLineRunner {

   private final ManufacturerRepository manufacturerRepository;
   private final ModelRepository modelRepository;
   private final FactoryRepository factoryRepository;

    public BootStrapData(ManufacturerRepository manufacturerRepository, ModelRepository modelRepository, FactoryRepository factoryRepository) {
        this.manufacturerRepository = manufacturerRepository;
        this.modelRepository = modelRepository;
        this.factoryRepository = factoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Factory factory = new Factory();
        factory.setContinent("europe");

        factoryRepository.save(factory);

        System.out.println("Publisher Count: " + factoryRepository.count());

        Manufacturer vag = new Manufacturer("vw", "r");
        Model m1 = new Model("scirocco ", "blue");
        vag.getModels().add(m1);
        m1.getManufacturers().add(vag);

        m1.setFactory(factory);
        factory.getModels().add(m1);

        manufacturerRepository.save(vag);
        modelRepository.save(m1);
        factoryRepository.save(factory);



    }

}
