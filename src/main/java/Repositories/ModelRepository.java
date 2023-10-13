package Repositories;

import domain.Manufacturer;
import domain.Model;
import org.springframework.data.repository.CrudRepository;

public interface ModelRepository extends CrudRepository<Model,Long>{

}
