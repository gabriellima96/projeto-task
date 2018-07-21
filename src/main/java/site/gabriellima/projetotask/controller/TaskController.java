package site.gabriellima.projetotask.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import site.gabriellima.projetotask.model.Task;
import site.gabriellima.projetotask.service.TaskService;

@Controller
public class TaskController {
	
	@Autowired
	private TaskService service;
	
	@GetMapping(value = "/")
	public String index(Model model	) {
		List<Task> tasks = service.findAll();

		if (tasks.size() == 0) {
			tasks = null;
		}
		model.addAttribute("tasks", tasks);
		return "index";
	}
	
	@GetMapping(value = "/add")
	public String addTask(Task task) {
		return "addOrUpdate";
	}
	
	@PostMapping(value = "/add")
	public ModelAndView addTask(@Valid Task task, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return new ModelAndView("/add");
		}
		
		service.save(task);
		redirect.addFlashAttribute("notification", "Task added!");
		return new ModelAndView("redirect:/");
	}
	
	@GetMapping(value = "/delete/{id}")
	public String deleteTask(@PathVariable("id") Integer id, RedirectAttributes redirect) {
		service.delete(id);
		redirect.addFlashAttribute("notification", "Task deleted!");
		return "redirect:/";
	}
}