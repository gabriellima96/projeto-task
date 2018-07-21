package site.gabriellima.projetotask.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import site.gabriellima.projetotask.model.Task;
import site.gabriellima.projetotask.repository.TaskRepository;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository repoTask;
	
	public List<Task> findAll() {
		return repoTask.findAll();
	}
	
	public void delete(Integer id) {
		repoTask.deleteById(id);
	}

	public Task save(Task task) {
		task.setId(null);
		return repoTask.save(task);
	}
	
	public Task find(Integer id) {
		return repoTask.findOneById(id);
	}

	public Task update(Task task) {
		return repoTask.save(task);
	}
}