package teamView.service;

import teamVIew.view.Data;
import teamView.domain.EmployeeType.Architect;
import teamView.domain.EmployeeType.Designer;
import teamView.domain.EmployeeType.Employee;
import teamView.domain.EmployeeType.Programmer;
import teamView.domain.equipments.NoteBook;
import teamView.domain.equipments.Printer;
import teamView.domain.equipments.StationPC;
import teamView.domain.interfaces.Equipment;

public class NameListService {
    private Employee[] employees;

    // 返回所有员工的数组
    public Employee[] getAllEmployees() {
        return employees;
    }

    // 根据下标获取单个员工
    // 这里的 id 不是employees 下标，而是单条数据的 id 元素
    public Employee getEmployee(int id) throws TeamException {
        for (int i=0; i<employees.length; i++) {
            if(employees[i].getId() == id) {
                return employees[i];
            } 
        }
        throw new TeamException("该员工不存在!");
    }

    public void setEmployees(Employee[] employees) {
        this.employees = employees;
    }

    public NameListService(Employee[] employees) {
        this.employees = employees;
    }

    // 把Employee 实例存储起来
    // Employee : 10, id, name, age, salary
    // Programmer: 11, id, name, age, salary
    // Designer : 12, id, name, age, salary, bonus
    // Architect : 13, id, name, age, salary, bonus, stock
    public NameListService() {
        employees = new Employee[Data.EMPLOYEES.length];
        for (int i = 0; i < employees.length; i++) {
            // 取得员工类型标识
            int employeeType = Integer.parseInt(Data.EMPLOYEES[i][0]);
            // 获取属性
            int id = Integer.parseInt(Data.EMPLOYEES[i][1]);
            String name = Data.EMPLOYEES[i][2];
            int age = Integer.parseInt(Data.EMPLOYEES[i][3]);
            int salary = Integer.parseInt(Data.EMPLOYEES[i][4]);
            Equipment equipment;
            int bonus;
            int stock;

            // 更具标识符创建不同类型员工的对象
            switch (employeeType) {
                case Data.EMPLOYEE:
                    employees[i] = new Employee(id, name, age, salary);
                    break;
                case Data.ARCHIETECT:
                    bonus = Integer.parseInt(Data.EMPLOYEES[i][5]);
                    stock = Integer.parseInt(Data.EMPLOYEES[i][6]);
                    equipment = createEquipment(i);
                    employees[i] = new Architect(id,name,age,salary, equipment, bonus, stock);
                    break;
                case Data.DESIGNER:
                    equipment = createEquipment(i);
                    bonus = Integer.parseInt(Data.EMPLOYEES[i][5]);
                    employees[i] = new Designer(id,name,age,salary, equipment, bonus);
                    break;
                case Data.PROGRAMER:  
                    equipment = createEquipment(i);        
                    employees[i] = new Programmer(id, name, age, salary, equipment);
                    break;
                default:
                    break;
            }
        }
    }

    // 根据标识获取员工设备
    private Equipment createEquipment(int equipmentID) {
        /*
         * {}, 
         * {"22", "联想T4", "6000"}, 
         * {"21", "戴尔", "NEC17寸"}, 
         * {"21", "戴尔", "三星17寸"},
         * {"23", "佳能 2900", "激光"}, 
         * {"21", "华硕", "三星HD239"}, 
         * {"21", "华硕", "三星 17寸"},
         * {"23", "爱普生20K", "针式"}, 
         * {"22", "惠普m6", "5800"}, 
         * {"21", "戴尔", "NEC 17寸"},
         * {"21", "华硕","三星 17寸"}, 
         * {"22", "惠普m6", "5800"}
         * 
         */
        int equipmentType = Integer.parseInt(Data.EQUIPMENTS[equipmentID][0]);
        switch (equipmentType) {
            case (Data.PC):
                return new StationPC(Data.EQUIPMENTS[equipmentID][1], Data.EQUIPMENTS[equipmentID][2]);
            case (Data.NOTEBOOK):
                return new NoteBook(Data.EQUIPMENTS[equipmentID][1], Integer.parseInt(Data.EQUIPMENTS[equipmentID][2]));
            case (Data.PRINTER):
                return new Printer(Data.EQUIPMENTS[equipmentID][1], Data.EQUIPMENTS[equipmentID][2]);
            default:
                return null;
        }
    }
}
