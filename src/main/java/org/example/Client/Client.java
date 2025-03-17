package org.example.Client;

public class Client {
    private int id;
    private String name;

    public Client(){}

    public Client(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }
    public int setId(){
        return id;
    }

    public String getName(){
        return name;
    }
    public String setName(){
        return name;
    }
}
