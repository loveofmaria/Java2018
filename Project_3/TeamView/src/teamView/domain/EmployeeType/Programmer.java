package teamView.domain.EmployeeType;

import teamView.domain.interfaces.Equipment;
import teamView.service.Status;

public class Programmer extends Employee {

    private int memberId = 23;
    private Status status = Status.FREE;
    private Equipment equipment;

    @Override
    public String getDescription() {  
        return this.getId() + "\t\t" + this.getName() 
        + "\t\t" + this.getAge() + "\t\t" 
        + this.getSalary() 
        + "\t\t" + "程序员"
        + "\t\t" + this.status.getName() 
        + "\t" + "\t\t\t\t" + "" + this.equipment.getDescription();
    } 

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public Programmer(int id, String name, int age, int salary, Equipment equipment) {
        super(id, name, age, salary);
        this.memberId = 2;
        this.status = Status.FREE;
        this.equipment = equipment;
    }

    public Programmer() {
        super();
    }

}
