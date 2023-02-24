package com.kristin.Tasks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class TaskController {

    @Autowired
    private TaskRepository repository;

    @Autowired
    private TaskRepo tasksRepo;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    String taskList(HttpSession session, Model model) {
        if (session.getAttribute("taskList") == null) {
            User user = userRepository.save(new User());
            session.setAttribute("taskList", user);
        }
        model.addAttribute("taskList", session.getAttribute("taskList"));
        userRepository.save((User) model.getAttribute("taskList"));
        for (User u : repository.getLists()) {
            userRepository.save(u);
        }

            return "User";

    }
    @PostMapping("/")
    String taskListPost(HttpSession session, Model model, @ModelAttribute User taskList) {
        User sessionTaskList = (User) session.getAttribute("taskList");
        sessionTaskList.setName(taskList.getName());
        sessionTaskList.setEmail(taskList.getEmail());
        model.addAttribute("taskList", session.getAttribute("taskList"));
        return "Task";
    }

    /*@GetMapping("/login")
    String logIn(HttpSession session, Model model, @ModelAttribute User logIn) {
        User sessionLogIn = (User) session.getAttribute("logIn");
        sessionLogIn.setUsername(logIn.getName());
        sessionLogIn.setPassword(logIn.getPassword());
        model.addAttribute("logIn", session.getAttribute("logIn"));
        return "Login";
    }*/
    @GetMapping("/login")
    String logIn(HttpSession session, Model model){
        if (session.getAttribute("logIn") == null) {
            User user = userRepository.save(new User());
            session.setAttribute("logIn", user);
        }

        model.addAttribute("logIn", session.getAttribute("logIn"));

        return "Login";
    }
    @PostMapping("/login")
    String logInPost(HttpSession session, Model model, @ModelAttribute User logIn){
        User sessionLogIn = (User) session.getAttribute("logIn");
        sessionLogIn.setUsername(logIn.getUsername());
        sessionLogIn.setPassword(logIn.getPassword());
        model.addAttribute("logIn", session.getAttribute("logIn"));
        return "Login";
    }

    @GetMapping("/task")
    String list(HttpSession session, Model model, @ModelAttribute User taskList) {
        User sessionTaskList = (User) session.getAttribute("taskList");
        sessionTaskList.setName(taskList.getName());
        sessionTaskList.setEmail(taskList.getEmail());
        model.addAttribute("taskList", session.getAttribute("taskList"));
        return "Task";
    }
    @PostMapping("/task")
    String addTask(HttpSession session, Model model, @RequestParam(required = false) String task) {
        Tasks tasks = new Tasks();
        tasks.setTask(task);
        User user = (User) session.getAttribute("taskList");
        user.setName(user.getName());
        user.setEmail(user.getEmail());
        model.addAttribute("taskList", session.getAttribute("taskList"));
        tasks.setUser(user);
        user.addTask(tasks);
        return "Task";
    }
    @GetMapping("/list")
    String lists(HttpSession session, Model model, @ModelAttribute User taskList) {
        User sessionTaskList = (User) session.getAttribute("taskList");
        sessionTaskList.setName(taskList.getName());
        sessionTaskList.setEmail(taskList.getEmail());
        model.addAttribute("taskList", session.getAttribute("taskList"));
        return "Task";
}

}
