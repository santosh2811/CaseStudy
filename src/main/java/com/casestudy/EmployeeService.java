package com.casestudy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeService {
    List<Employee> employeeList = new ArrayList<>();
    EmployeeService(){}
    EmployeeService(List<String> data){
       data.forEach( line -> {
           String[] values = line.split(",");
               Employee employee = new Employee(values);
               employeeList.add(employee);
       });
        employeeList.forEach(e -> {
            List<Employee> employees = employeeList.stream().filter(emp -> emp.managerId == e.id).toList();
            employees.forEach(k -> k.setDepth(e.getDepth()+1));
        });
    }

    public Map<String, Double> getAverageSalaryDetails( boolean isLowerSalary) {
        Map<String,Double> salaryDeviationMap = new HashMap<>();
        double averageSalary = employeeList.stream()
                .mapToDouble(Employee::getSalary)
                .average().orElse(0.0);
        Map<Boolean,List<Employee>> employeeMap =  employeeList.stream().collect(Collectors.partitioningBy(e -> e.salary > averageSalary));
        if(isLowerSalary){
            List<Employee> lowSalaryEmployeeList = employeeMap.get(false);
            lowSalaryEmployeeList.forEach(e -> salaryDeviationMap.put(e.firstName+" "+e.lastName,averageSalary-e.salary));

        }else{
            List<Employee> highSalaryEmployeeList = employeeMap.get(true);
            highSalaryEmployeeList.forEach(e -> salaryDeviationMap.put(e.firstName+" "+e.lastName,e.salary-averageSalary));
        }
        return salaryDeviationMap;
    }

    public Map<String, Integer> getHigherLevelEmployeeList(){
        Map<String,Integer> higherLevelEmpList = new HashMap<>();
        employeeList.stream().filter(e -> e.level >=4).toList().forEach(ee ->{
            higherLevelEmpList.put(ee.firstName+" "+ee.firstName, ee.level);
        });
        return higherLevelEmpList;
    }


}
