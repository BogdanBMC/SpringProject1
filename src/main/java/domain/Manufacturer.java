package domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Manufacturer {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String brand;
    private String division;

    //db mapping
    @ManyToMany(mappedBy = "manufacturers")
    private Set<Model> models = new HashSet<>();

    public Manufacturer(){
    }
    public Manufacturer(String brand, String division){
        this.brand=brand;
        this.division=division;
    }

    public void setId(long id){
        this.id=id;
    }
    public void setBrand(String brand){
        this.brand=brand;
    }
    public void setDivision(String division){
        this.division=division;
    }
    public void setModels(Set<Model> models){
        this.models=models;
    }

    public long getId() {
        return id;
    }
    public String getBrand() {
        return brand;
    }
    public String getDivision() {
        return division;
    }
    public Set<Model> getModels() {
        return models;
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", division='" + division + '\'' +
                ", models=" + models +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manufacturer that = (Manufacturer) o;
        return id == that.id;
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
