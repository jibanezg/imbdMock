package series.mum.domain;

import actor.mum.domain.Actor;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Grimg on 12/11/2017.
 */
@Entity
@SequenceGenerator(name = "seriesSeq", sequenceName = "Series_Sequence")
public class Series {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seriesSeq")
    private int id;

    private String studio;
    private String description;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "seriesId")
    private List<Actor> cast;
    private String director;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Actor> getCast() {
        return cast;
    }

    public void setCast(List<Actor> cast) {
        this.cast = cast;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
