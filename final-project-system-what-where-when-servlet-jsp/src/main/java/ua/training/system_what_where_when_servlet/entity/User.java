package ua.training.system_what_where_when_servlet.entity;

public class User {
    private Integer id;
    private String nameUa;
    private String nameEn;
    private String email;
    private String password;
    private Role role;
//    private List<Game> games = new ArrayList<>();


    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameUa() {
        return nameUa;
    }

    public void setNameUa(String nameUa) {
        this.nameUa = nameUa;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nameUa='" + nameUa + '\'' +
                ", nameEn='" + nameEn + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
