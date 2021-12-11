package com.omega.services.department.repository;

import com.omega.services.department.model.Department;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by fabreu on 11/12/2021
 */
public class DepartmentRepository {

    private List<Department> departments = new ArrayList<>();

    public Department add(Department department) {
        department.setId((long) (departments.size()+1));
        departments.add(department);
        return department;
    }

    public Department findById(Long id) {
        return departments.stream()
                .filter(a -> a.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }

    public List<Department> findAll() {
        return departments;
    }

    public List<Department> findByOrganization(Long organizationId) {
        return departments.stream()
                .filter(a -> a.getOrganizationId().equals(organizationId))
                .collect(Collectors.toList());
    }
}
