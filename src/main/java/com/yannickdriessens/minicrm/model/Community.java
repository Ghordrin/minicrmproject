package com.yannickdriessens.minicrm.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="community")
public class Community {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;

    @ManyToMany(mappedBy = "member")
    private List<Person> member;

    private String description;

    public Community(){}

    public Community(String description) {
        this.description = description;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Community{" +
                "ID=" + ID +
                ", description='" + description + '\'' +
                '}';
    }
}
