package Objects;

public class Task {
    //private final ClanService service;
    private long id;
    private String taskName;
    private int award;

    public Task(long id, String taskName, int award){
        this.id = id;
        this.taskName = taskName;
        this.award = award;
    }

    public boolean haveDone(long taskId){
        if(1 == 1){// В данном примере будем считать, что при вызове метода игрок уже выполнил условие
            return true;
        }else {
            return false;
        }
    }

    public Task(long id, int award){
        this(id, "Бой", award);
    }

    public String getName() {
        return taskName;
    }

    public void setName(String name) {
        this.taskName = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAward() {
        return award;
    }

    public void setAward(int award) {
        this.award = award;
    }
}
