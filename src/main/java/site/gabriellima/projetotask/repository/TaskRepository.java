package site.gabriellima.projetotask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import site.gabriellima.projetotask.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
	public Task findOneById(Integer id);
}
