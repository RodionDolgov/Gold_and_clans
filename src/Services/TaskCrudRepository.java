package Services;

import Objects.Task;

public interface TaskCrudRepository {

    void save(Task task);

    Task findById(long id);

    void update(long id, Task task);

    void delete(long id);
}
