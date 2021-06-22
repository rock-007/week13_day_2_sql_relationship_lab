package com.relationshiplab.demo;

import com.relationshiplab.demo.models.Department;
import com.relationshiplab.demo.models.Employee;
import com.relationshiplab.demo.models.Project;
import com.relationshiplab.demo.repositories.DepartmentRepository;
import com.relationshiplab.demo.repositories.EmployeeRepository;
import com.relationshiplab.demo.repositories.ProjectRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    ProjectRepository projectRepository;

    @Test
    public void contextLoads() {
    }

    @Test
    public void createEmployeeAndDepartment() {
        Department department = new Department("IT");
        departmentRepository.save(department);
        Employee employee = new Employee("Andrew", "High", 1234, department);
        employeeRepository.save(employee);
    }

    @Test
    public void addEmployeesToProject() {
        Department department = new Department("IT");
        departmentRepository.save(department);
        Employee employee = new Employee("Andrew", "High", 1234, department);
        Employee employee2 = new Employee("Umair", "Ashraf", 456, department);

        employeeRepository.save(employee);
        employeeRepository.save(employee2);

        Project project = new Project("Final_project", 60);
        projectRepository.save(project);

        project.addEmployee(employee);
        project.addEmployee(employee2);

        projectRepository.save(project);

    }

}
