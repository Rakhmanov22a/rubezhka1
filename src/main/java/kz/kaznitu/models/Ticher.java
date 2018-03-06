package kz.kaznitu.models;

import javax.persistence.*;

@Entity
public class Ticher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id ;
    private String firstName ;
    private String lastName ;
    private int kafedraId ;

    public Ticher(){}

    public Ticher(String firstName, String lastName, int kafedraId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.kafedraId = kafedraId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getKafedraId() {
        return kafedraId;
    }

    public void setKafedraId(int kafedraId) {
        this.kafedraId = kafedraId;
    }
}
