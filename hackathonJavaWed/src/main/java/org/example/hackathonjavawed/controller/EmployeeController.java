package org.example.hackathonjavawed.controller;

import jakarta.validation.Valid;
import org.example.hackathonjavawed.dto.EmployeeDTO;
import org.example.hackathonjavawed.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("employeeList", employeeService.findAll());
        return "employees/list";
    }

    @GetMapping("/add")
    public String viewAdd(Model model) {
        model.addAttribute("employee", new EmployeeDTO());
        model.addAttribute("formTitle", "Them moi nhan vien");
        model.addAttribute("formAction", "/employees/add");
        return "employees/form";
    }

    @PostMapping("/add")
    public String add(
            @Valid @ModelAttribute("employee") EmployeeDTO employee,
            BindingResult bindingResult,
            Model model
    ) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("formTitle", "Them moi nhan vien");
            model.addAttribute("formAction", "/employees/add");
            return "employees/form";
        }

        employeeService.add(employee);
        return "redirect:/employees";
    }

    @GetMapping("/{id}/edit")
    public String viewEdit(@PathVariable("id") String id, Model model) {
        var employee = employeeService.findById(id);
        if (employee == null) {
            return "redirect:/employees";
        }

        model.addAttribute("employee", employeeService.toDto(employee));
        model.addAttribute("formTitle", "Chinh sua nhan vien");
        model.addAttribute("formAction", "/employees/" + id + "/edit");
        return "employees/form";
    }

    @PostMapping("/{id}/edit")
    public String update(
            @PathVariable("id") String id,
            @Valid @ModelAttribute("employee") EmployeeDTO employee,
            BindingResult bindingResult,
            Model model
    ) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("formTitle", "Chinh sua nhan vien");
            model.addAttribute("formAction", "/employees/" + id + "/edit");
            return "employees/form";
        }

        employeeService.update(id, employee);
        return "redirect:/employees";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable("id") String id) {
        employeeService.delete(id);
        return "redirect:/employees";
    }

}
