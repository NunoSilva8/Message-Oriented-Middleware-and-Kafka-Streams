package entities;

import java.sql.Date;

public class Currency{

    private Integer id;
    private String name;
    private Long toEuro;

    public Currency(Integer id, String name, Long toEuro) {
        this.id = id;
        this.name = name;
        this.toEuro = toEuro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", toEuro=" + toEuro +
                '}';
    }
}