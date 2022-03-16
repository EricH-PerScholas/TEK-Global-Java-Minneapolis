package perscholas.database.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "movie_actors")
public class MovieActor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "character_name")
    private String characterName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "actor_id", nullable = false)
    private Actor actor;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    @Column(name = "actor_id", updatable = false, insertable = false)
    private Integer actorId;

    @Column(name = "movie_id", updatable = false, insertable = false)
    private Integer movieId;

    @Override
    public String toString() {
        return "MovieActor{" +
                "id=" + id +
                ", characterName='" + characterName + '\'' +
                ", actor=" + actor +
                '}';
    }
}
