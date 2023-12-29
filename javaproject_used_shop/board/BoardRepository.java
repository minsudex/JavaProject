package javaproject_used_shop.board;

public class BoardRepository {

    private final String id;
    private final String name;
    private final String email;
    private final String password;

    public BoardRepository(String id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}

