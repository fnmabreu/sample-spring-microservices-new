package com.omega.services.organization.controller;

import com.omega.services.organization.client.DepartmentClient;
import com.omega.services.organization.client.EmployeeClient;
import com.omega.services.organization.model.Organization;
import com.omega.services.organization.repository.OrganizationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by fabreu on 11/12/2021
 */
@RestController
@Slf4j
public class OrganizationController {

    @Autowired
    OrganizationRepository organizationRepository;

    @Autowired
    DepartmentClient departmentClient;

    @Autowired
    EmployeeClient employeeClient;

    @PostMapping
    public Organization add(@RequestBody Organization organization) {
        log.info("Organization add: {}", organization);
        return organizationRepository.add(organization);
    }

    @GetMapping
    public List<Organization> findAll() {
        log.info("Organization find");
        return organizationRepository.findAll();
    }

    @GetMapping("/{id}")
    public Organization findById(@PathVariable("id") Long id) {
        log.info("Organization find: id={}", id);
        return organizationRepository.findById(id);
    }

    @GetMapping("/{id}/with-departments")
    public Organization findByIdWithDepartments(@PathVariable("id") Long id) {
        log.info("Organization find: id={}", id);
        Organization organization = organizationRepository.findById(id);
        organization.setDepartments(departmentClient.findByOrganization(organization.getId()));
        return organization;
    }

    @GetMapping("/{id}/with-departments-and-employees")
    public Organization findByIdWithDepartmentsAndEmployees(@PathVariable("id") Long id) {
        log.info("Organization find: id={}", id);
        Organization organization = organizationRepository.findById(id);
        organization.setDepartments(departmentClient.findByOrganizationWithEmployees(organization.getId()));
        return organization;
    }

    @GetMapping("/{id}/with-employees")
    public Organization findByIdWithEmployees(@PathVariable("id") Long id) {
        log.info("Organization find: id={}", id);
        Organization organization = organizationRepository.findById(id);
        organization.setEmployees(employeeClient.findByOrganization(organization.getId()));
        return organization;
    }

}
