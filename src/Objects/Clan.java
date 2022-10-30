package Objects;

import java.util.concurrent.atomic.AtomicInteger;

public class Clan {
    private long id;     // id клана
    private String name; // имя клана
    private AtomicInteger gold = new AtomicInteger(0);    // текущее количество золота в казне клана

    public Clan() {}

    public Clan(long id, String name, int gold){
        this.id = id;
        this.name = name;
        this.gold = new AtomicInteger(gold);
    }

    public Clan(long id, String name){
        this(id, name, 0);
    }

    public int getGold() {
        return gold.get();
    }

    public synchronized void addGold(int gold) {//synchronized метод
        this.gold.set(this.gold.get() + gold);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Clan{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
