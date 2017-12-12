package actor.mum.domain;

import javax.persistence.*;

/**
 * Created by Grimg on 12/12/2017.
 */
@Entity
@SequenceGenerator(name = "actorSeq", sequenceName = "Actor_Sequence")
public class Actor {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "actorSeq")
    private int id;

    private String name;
    private String placeOfBirth;
    private String biography;
    private Byte[] picture;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public Byte[] getPicture() {
        return picture;
    }

    public void setPicture(Byte[] picture) {
        this.picture = picture;
    }
}
