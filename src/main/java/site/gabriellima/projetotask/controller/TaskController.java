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

	private static final String ATTRIBUTE_TITLE = "title";
	private static final String ATTRIBUTE_NOTIFICATION = "notification";
	private static final String PAGE_ADD_OR_UPDATE = "addOrUpdate";
	private static final String REDIRECT_ROOT = "redirect:/";

	@Autowired
	private TaskService service;
	
	@GetMapping(value = "/")
	public String index(Model model	) {
		List<Task> tasks = service.findAll();

		if (tasks.isEmpty()) {
			tasks = null;
		}
		model.addAttribute("tasks", tasks);
		return "index";
	}
	
	@GetMapping(value = "/add")
	public String addTask(Task task, Model model) {
		model.addAttribute(ATTRIBUTE_TITLE, "Add task");
		return PAGE_ADD_OR_UPDATE;
	}
	
	@PostMapping(value = "/add")
	public ModelAndView addTask(@Valid Task task, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return new ModelAndView(PAGE_ADD_OR_UPDATE).addObject(ATTRIBUTE_TITLE, "Add task");
		}
		
		service.save(task);
		redirect.addFlashAttribute(ATTRIBUTE_NOTIFICATION, "Task added!");
		return new ModelAndView(REDIRECT_ROOT);
	}
	
	@GetMapping(value = "/delete/{id}")
	public String deleteTask(@PathVariable("id") Integer id, RedirectAttributes redirect) {
		service.delete(id);
		redirect.addFlashAttribute(ATTRIBUTE_NOTIFICATION, "Task deleted!");
		return REDIRECT_ROOT;
	}
	
	@GetMapping(value = "/update/{id}")
	public String updateTask(@PathVariable("id") Integer id, Model model) {
		Task task = service.find(id);
		model.addAttribute("task", task);
		model.addAttribute(ATTRIBUTE_TITLE, "Task Update");
		return PAGE_ADD_OR_UPDATE;
	}
	
	@PostMapping(value = "/update")
	public ModelAndView updateTask(@Valid Task task, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return new ModelAndView(PAGE_ADD_OR_UPDATE).addObject(ATTRIBUTE_TITLE, "Task Update");
		}
		
		service.update(task);
		redirect.addFlashAttribute(ATTRIBUTE_NOTIFICATION, "Task updated!");
		return new ModelAndView(REDIRECT_ROOT);
	}
}
