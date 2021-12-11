package com.omega.services.organization.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by fabreu on 11/12/2021
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

    private Long id;
    private String name;
    private int age;
    private String position;
}
