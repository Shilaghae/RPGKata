package org.rpgkata;

public class Faction {
    public String getFactionName() {
        return factionName;
    }

    String factionName;

    public Faction(String name) {
        this.factionName = name;
    }

    public void join(Character character) {
        character.setFaction(this);
    }
}
