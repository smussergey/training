package ua.training.system_what_where_when.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "name_ua")
    private String nameUa;

    @Column(name = "name_en")
    private String nameEn;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    //    @Setter(AccessLevel.PRIVATE)
//    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//    @JoinTable(name = "user_game",
//            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "user_id")},
//            inverseJoinColumns = {@JoinColumn(name = "game_id", referencedColumnName = "game_id")})
    @Setter(AccessLevel.PRIVATE)
    @ManyToMany(mappedBy = "users", fetch = FetchType.LAZY)
    private List<Game> games = new ArrayList<>();

//    public void addGame(Game game) {
//        games.add(game);
//        game.getUsers().add(this);
//    }
//
//    public void addGames(List<Game> games) {
//        this.games.addAll(games);
//        games.forEach(game -> game.getUsers().add(this));
//    }
//
//    public void removeGame(Game game) {
//        games.remove(game);
//        game.getUsers().remove(this);
//    }


    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                '}';
    }
}
