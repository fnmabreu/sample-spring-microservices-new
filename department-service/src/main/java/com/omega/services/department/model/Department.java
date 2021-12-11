package com.omega.services.department.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fabreu on 11/12/2021
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {

    private Long id;
    private Long organizationId;
    private String name;
    private List<Employee> employees = new ArrayList<>();
}
