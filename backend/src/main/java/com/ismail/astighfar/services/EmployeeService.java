package com.ismail.astighfar.services;

import com.ismail.astighfar.entities.Employee;
import com.ismail.astighfar.repositories.EmpolyeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
public class EmployeeService {

    private EmpolyeeRepository empolyeeRepository;

    public List<Employee> getAllEmployees(){
        return empolyeeRepository.findAll();
    }

    public Employee saveEmployee(Employee employee){
        return empolyeeRepository.save(employee);
    }

    public Employee addRandomEmployee() {
        // Generate random values for the new employee
        Employee newEmployee = new Employee();
        newEmployee.setName(generateRandomName());
        newEmployee.setPosition(generateRandomPosition());
        newEmployee.setSalary(generateRandomSalary());

        return empolyeeRepository.save(newEmployee);
    }


    private String generateRandomName() {
        String[] names = {"John", "Jane", "Bob", "Alice", "Charlie"};
        return names[new Random().nextInt(names.length)];
    }

    private String generateRandomPosition() {
        String[] positions = {"Software Engineer", "Product Manager", "Data Scientist", "UX Designer"};
        return positions[new Random().nextInt(positions.length)];
    }

    private double generateRandomSalary() {
        double salary = 50000 + new Random().nextDouble() * 50000; // Random salary between 50000 and 100000
        return Math.round(salary * 100.0) / 100.0;
    }


}
