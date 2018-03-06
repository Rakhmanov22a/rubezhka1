package kz.kaznitu.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Kafedra {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String kafedraName;
    private String zavKafedra;

    public Kafedra() {
        this.kafedraName = "" ;
        this.zavKafedra = "" ;
    }

    public Kafedra(String bookName, String zavKafedra) {
        this.kafedraName = kafedraName;
        this.zavKafedra = zavKafedra;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getKafedraName() {
        return kafedraName;
    }

    public void setKafedraName(String bookName) {
        this.kafedraName = bookName;
    }

    public String getZavKafedra() {
        return zavKafedra;
    }

    public void setZavKafedra(String zavKafedra) {
        this.zavKafedra = zavKafedra;
    }
}
