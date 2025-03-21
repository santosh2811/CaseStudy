package com.casestudy;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ReportGenerator {
    public static void main(String[] args) throws IOException {
        ReadData readData = new ReadData();
        List<String> employeeData = readData.getReadData("testData.csv");
        EmployeeService employeeService = new EmployeeService(employeeData);
        System.out.println("Managers earn less than they should, and by how much :");
        Map<String,Double> lowerSalaryManagers = employeeService.getAverageSalaryDetails(true);
        lowerSalaryManagers.forEach((k,v )-> System.out.println(k + "    " +v));
        System.out.println("------------------------------------------------------");
        System.out.println("Managers earn more than they should, and by how much :");
        Map<String,Double> higherSalaryManagers = employeeService.getAverageSalaryDetails(false);
        higherSalaryManagers.forEach((k,v )-> System.out.println(k + "    " +v));
        System.out.println("------------------------------------------------------");
        System.out.println("employees have a reporting line which is too long, and by how much :");
        Map<String,Integer> higherLevelEmployeeList = employeeService.getHigherLevelEmployeeList();
        higherLevelEmployeeList.forEach((k,v )-> System.out.println(k + "    " +v));
        System.out.println("------------------------------------------------------");

    }
}
