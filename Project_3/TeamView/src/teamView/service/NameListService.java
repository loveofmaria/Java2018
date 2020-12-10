package teamView.service;

import teamVIew.view.Data;
import teamView.domain.EmployeeType.Employee;
import teamView.domain.EmployeeType.Programmer;

public class NameListService {
    private Employee[] employees;

    public void NameListServer() {

    }

    public Employee[] getAllEmployees() {

    }

    public Employee getEmployee(int id) throws TeamException {
        return employees[id];
    }

    public Employee[] getEmployees() {
        return employees;
    }

    public void setEmployees(Employee[] employees) {
        this.employees = employees;
    }

    public NameListService(Employee[] employees) {
        this.employees = employees;
    }

    // 把Employee 实例存储起来
    //Employee  :  10, id, name, age, salary
    //Programmer:  11, id, name, age, salary
    //Designer  :  12, id, name, age, salary, bonus
    //Architect :  13, id, name, age, salary, bonus, stock
    public NameListService() {
        employees = new Employee[Data.EMPLOYEES.length];
        for(int i=0; i<employees.length; i++) {
            int employeeType = Integer.parseInt(Data.EMPLOYEES[i][0]);
            if (employeeType == 10) {
                employees[i] = new Programmer(
                    Integer.parseInt(Data.EMPLOYEES[i][1]),
                    Data.EMPLOYEES[i][2],
                    Integer.parseInt(Data.EMPLOYEES[i][1]),
                );
            }
        }
    }
}
