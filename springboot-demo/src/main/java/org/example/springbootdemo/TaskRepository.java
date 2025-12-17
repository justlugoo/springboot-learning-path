package org.example.springbootdemo;

import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class TaskRepository {

    private final Map<Long, Task> tasks = new HashMap<>();
    private final AtomicLong counter = new AtomicLong();

    public List<Task> findAll() {
        return new ArrayList<>(tasks.values());
    }

    public Optional<Task> findById(Long id) {
        return Optional.ofNullable(tasks.get(id));
    }

    public Task save(String title) {
        long id = counter.incrementAndGet();
        Task task = new Task(id, title, false);
        tasks.put(id, task);
        return task;
    }

    public Optional<Task> update(long id, Task task) {
        if (tasks.containsKey(id)) {
            tasks.put(id, task);
            return Optional.of(task);
        }
        return Optional.empty();
    }

    public boolean deleteById(Long id) {
        return tasks.remove(id) != null;
    }
}
