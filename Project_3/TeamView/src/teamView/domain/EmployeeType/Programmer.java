package teamView.domain.EmployeeType;

import teamView.domain.interfaces.Equipment;
import teamView.service.Status;

public class Programmer extends Employee implements Equipment {

    private int memberId;
    private Status status;
    private Equipment equipment;

    @Override
    public String getDescription() {
        // TODO Auto-generated method stub
        return null;
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

    public Programmer(int id, String name, int age, int salary, int memberId, Status status, Equipment equipment) {
        super(id, name, age, salary);
        this.memberId = memberId;
        this.status = status;
        this.equipment = equipment;
    }

    public Programmer() {
        super();
    }

}
