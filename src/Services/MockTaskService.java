package Services;

import Objects.Clan;
import Objects.Task;

public class MockTaskService implements TaskService {
    private final TaskCrudRepository repository;

    public MockTaskService(TaskCrudRepository repository) {
        this.repository = repository;
        repository.save(new Task(1, 50));//У каждого задания своя награда (award)
        repository.save(new Task(2, 20));
        repository.save(new Task(3, 10));
        repository.save(new Task(4, 300));
        repository.save(new Task(5, 30));
        repository.save(new Task(6, 30));
    }

    @Override
    public Task getTask(long taskId) {
        return repository.findById(taskId);
    }
}

