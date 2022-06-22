package ru.work.accident.model;

import java.util.HashSet;
import java.util.Set;

public class Accident {
    private int id;
    private String name;
    private String text;
    private String address;
    private AccidentType type;
    private Set<Rule> rules = new HashSet<Rule>();

    public static Accident of(String name, String text, String address, AccidentType type) {
        Accident acc = new Accident();
        acc.name = name;
        acc.text = text;
        acc.address = address;
        acc.type = type;
        return acc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public AccidentType getType() {
        return type;
    }

    public void setType(AccidentType type) {
        this.type = type;
    }

    public void addRule(Rule rule) {
        this.rules.add(rule);
    }

}
