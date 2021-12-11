package com.omega.services.employee.controller;

import com.omega.services.employee.model.Employee;
import com.omega.services.employee.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by fabreu on 11/12/2021
 */
@RestController
@Slf4j
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @PostMapping("/")
    public Employee add(@RequestBody Employee employee) {
        log.info("Employee add: {}", employee);
        return employeeRepository.add(employee);
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable("id") Long id) {
        log.info("Employee find: id={}", id);
        return employeeRepository.findById(id);
    }

    @GetMapping("/")
    public List<Employee> findAll() {
        log.info("Employee find");
        return employeeRepository.findAll();
    }

    @GetMapping("/department/{departmentId}")
    public List<Employee> findByDepartment(@PathVariable("departmentId") Long departmentId) {
        log.info("Employee find: departmentId={}", departmentId);
        return employeeRepository.findByDepartment(departmentId);
    }

    @GetMapping("/organization/{organizationId}")
    public List<Employee> findByOrganization(@PathVariable("organizationId") Long organizationId) {
        log.info("Employee find: organizationId={}", organizationId);
        return employeeRepository.findByOrganization(organizationId);
    }

}
