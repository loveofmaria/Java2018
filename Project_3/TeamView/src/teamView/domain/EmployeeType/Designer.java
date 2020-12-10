package teamView.domain.EmployeeType;

import teamView.domain.interfaces.Equipment;
import teamView.service.Status;

public class Designer extends Programmer {
    private int bonus;

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public Designer(){
        super();
    }
    public Designer(int id, String name, int age, int salary, int memberId, Status status, Equipment equipment,
            int bonus) {
        super(id, name, age, salary, memberId, status, equipment);
        this.bonus = bonus;
    }

    public Designer(int bonus) {
        this.bonus = bonus;
    }

    
}
