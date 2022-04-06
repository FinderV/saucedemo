package org.tms.model;                                                 //4.

public class User {                                                                        //то что будет взаимод с прилож

    private String name = "standard_user";                                               //инкапсул, имя пользователя из перечня
    private String password = "secret_sauce";

    public User() {                                                                    //если много имен подтяг из xml, др класс
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
