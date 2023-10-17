package domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String modelName;
    private String color;

    public static int modelCounting;

    @ManyToOne
    private Factory factory;

    //db table many2many relation
    @ManyToMany
    @JoinTable(name = "manufacturer_model", joinColumns = @JoinColumn(name = "model_id"),
            inverseJoinColumns = @JoinColumn(name = "manufacturer_id"))
    private Set<Manufacturer> manufacturers = new HashSet<>();


    //constructors and noArg constructor
    public  Model(){

    }

    public Model(String modelName, String color){
        this.modelName=modelName;
        this.color=color;
        modelCounting++;
    }

    public Factory getFactory() {
        return factory;
    }

    public void setFactory(Factory factory) {
        this.factory = factory;
    }

    //setters
    public void setModelName(String modelName){
        this.modelName=modelName;
    }
    public void setColor(String color){
        this.color=color;
    }
    public void setId(long id){
        this.id=id;
    }

    //getters
    public long getId(){
        return id;
    }
    public String getColor(){
        return color;
    }
    public String getModelName(){
        return modelName;
    }

    public Set<Manufacturer> getManufacturers() {
        return manufacturers;
    }

    public void setManufacturers(Set<Manufacturer> manufacturers) {
        this.manufacturers = manufacturers;
    }

    //toString to return ALL fields as a String
    @Override
    public String toString() {
        return "Model{" +
                "id=" + id +
                ", modelName='" + modelName + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
/*Shallow comparison: The default implementation of equals method is defined in Java.lang.Object
class which simply checks if two Object references (say x and y) refer to the same Object. i.e. It checks if x == y
 */
/*Deep Comparison: Suppose a class provides its own implementation of equals() method in order to compare the Objects
 of that class w.r.t state of the Objects. That means data members (i.e. fields) of Objects are to be compared
  with one another. Such Comparison based on data members is known as deep comparison.
 */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Model model = (Model) o;
        return id == model.id;
    }

    /*It returns the hashcode value as an Integer. Hashcode value is mostly used in hashing based collections like HashMap,
     HashSet, HashTable….etc. This method must be overridden in every class which overrides equals() method.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
