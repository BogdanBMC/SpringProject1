package domain;


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Factory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

   private String continent;
   private String country;

   @OneToMany
   @JoinColumn(name = "publisher_id")
   private Set<Model> models = new HashSet<>();

    public Factory(){
    }
    public Factory(String continent, String country) {
        this.continent = continent;
        this.country = country;
    }

    public Set<Model> getModels() {
        return models;
    }

    public void setModels(Set<Model> models) {
        this.models = models;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getContinent() {
        return continent;
    }
    public void setContinent(String continent) {
        this.continent = continent;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    @Override
    public String toString() {
        return "Factory{" +
                "id=" + id +
                ", continent='" + continent + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Factory factory = (Factory) o;
        return id == factory.id;
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
