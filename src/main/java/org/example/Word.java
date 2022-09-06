package org.example;

public class Word {
    public Word(){}

    public Word(int id, int level, String name, String meaning) {
        this.id = id;
        this.level = level;
        this.name = name;
        this.meaning = meaning;
    }

    private int id;
    private int level;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    private String name;
    private String meaning;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }
}
