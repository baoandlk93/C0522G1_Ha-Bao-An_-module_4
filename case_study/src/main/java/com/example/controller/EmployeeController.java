package com.example.controller;

import com.example.dto.EmployeeDto;
import com.example.model.employee.Division;
import com.example.model.employee.EducationDegree;
import com.example.model.employee.Employee;
import com.example.model.employee.Position;
import com.example.service.IDivisionService;
import com.example.service.IEducationService;
import com.example.service.IEmployeeService;
import com.example.service.IPositionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IEducationService educationService;

    @Autowired
    private IDivisionService divisionService;

    @Autowired
    private IPositionService positionService;

    @ModelAttribute
    public List<EducationDegree> getEducation() {
        return educationService.findAll();
    }

    @ModelAttribute
    public List<Position> getPosition() {
        return positionService.findAll();
    }

    @ModelAttribute
    public List<Division> getDivision() {
        return divisionService.findAll();
    }

    @GetMapping("/list")
    public String showList(@PageableDefault(value = 3) Pageable pageable,
                           @RequestParam(defaultValue = "") String name,
                           Model model) {
        model.addAttribute("employeeList", employeeService.findAll(pageable, name));
        model.addAttribute("position", getPosition());
        model.addAttribute("education", getEducation());
        model.addAttribute("division", getDivision());
        model.addAttribute("employeeDto", new EmployeeDto());
        model.addAttribute("employeeDtoUpdate", new EmployeeDto());
        model.addAttribute("name",name);
        return "employee/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("employeeDto", new EmployeeDto());
        model.addAttribute("position", getPosition());
        model.addAttribute("education", getEducation());
        model.addAttribute("division", getDivision());
        return "/employee/list";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("employeeDto") EmployeeDto employeeDto, RedirectAttributes attributes) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);

        EducationDegree degree = new EducationDegree();
        degree.setId(employeeDto.getEducationDegreeID());
        employee.setEducationDegreeID(degree);

        Division division = new Division();
        division.setId(employeeDto.getDivisionID());
        employee.setDivisionID(division);

        Position position = new Position();
        position.setId(employeeDto.getPosition());
        employee.setPosition(position);

        employeeService.save(employee);

        attributes.addFlashAttribute("success", "Thêm mới thành công");
        return "redirect:/employees/list";

    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id,
                       EmployeeDto employeeDto,
                       Model model,
                       @PageableDefault(value = 3) Pageable pageable,
                       @RequestParam(defaultValue = "") String name) {
        Optional<Employee> employee = employeeService.findById(id);
        if (employee.isPresent()){
            BeanUtils.copyProperties(employee.get(), employeeDto);

            employeeDto.setDivisionID(employee.get().getDivisionID().getId());
            employeeDto.setEducationDegreeID(employee.get().getEducationDegreeID().getId());
            employeeDto.setPosition(employee.get().getPosition().getId());
        }
        model.addAttribute("employeeDtoUpdate", employeeDto);
        model.addAttribute("employeeDto", new EmployeeDto());
        model.addAttribute("position", getPosition());
        model.addAttribute("education", getEducation());
        model.addAttribute("division", getDivision());
        model.addAttribute("employeeList", employeeService.findAll(pageable, name));
        model.addAttribute("updateModal","open");
        return "/employee/list";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("employeeDto") EmployeeDto employeeDto, RedirectAttributes attributes) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);

        EducationDegree degree = new EducationDegree();
        degree.setId(employeeDto.getEducationDegreeID());
        employee.setEducationDegreeID(degree);

        Division division = new Division();
        division.setId(employeeDto.getDivisionID());
        employee.setDivisionID(division);

        Position position = new Position();
        position.setId(employeeDto.getPosition());
        employee.setPosition(position);

        employeeService.save(employee);

        attributes.addFlashAttribute("success", "Cập nhật thành công");
        return "redirect:/employees/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id, RedirectAttributes attributes) {
        employeeService.remove(id);
        attributes.addFlashAttribute("success", "Xóa thành công " + employeeService.findById(id).get().getName());
        return "redirect:/employees/list";
    }

}
