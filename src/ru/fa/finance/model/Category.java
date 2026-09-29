package ru.fa.finance.model;

public class Category {
    private final long id;
    private final String name;

    public Category(long id, String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Имя категории не может быть пустым");
        }
        this.id = id;
        this.name = name;
    }

    public long getId() { return id; }
    public String getName() { return name; }
}