package Services;

import Objects.Clan;
import Objects.Task;

import java.util.HashMap;
import java.util.Map;

public class TaskCrudRepositoryMock  implements TaskCrudRepository {
    private final Map<Long, Task> taskMap = new HashMap<>();

    @Override
    public void save(Task task) {taskMap.put(task.getId(), task);}

    @Override
    public Task findById(long id) {
        return taskMap.get(id);
    }

    @Override
    public void update(long id, Task clan) {//Меняем имя
        Task oldTask = taskMap.get(id);
        if (oldTask != null) {
            oldTask.setName(clan.getName());
        }
    }

    @Override
    public void delete(long id) {
        taskMap.remove(id);
    }
}
