package game.domain;

import java.util.Random;

public class User {
    private String id;
    private String name;
    private String password;
    private boolean status;

    public String createId(){
        StringBuilder sb = new StringBuilder("Hjh");
        Random r = new Random();
        for (int i = 0; i < 5; i++) {
            int num  = r.nextInt(10);
            sb.append(num);
        }
        return sb.toString();
    }


    public User() {
        id = createId();
        status = true;
    }

    public User(String name, String password) {
        id = createId();
        this.name = name;
        this.password = password;
        status = true;
    }





    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
