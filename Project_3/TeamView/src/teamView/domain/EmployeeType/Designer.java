package teamView.domain.EmployeeType;

import teamView.domain.interfaces.Equipment;

public class Designer extends Programmer {
    private int bonus;

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public Designer() {
        super();
    }

    public Designer(int id, String name, int age, int salary, Equipment equipment, int bonus) {
        super(id, name, age, salary, equipment);
        this.bonus = bonus;
    }

    @Override
    public String getDescription() {
        return this.getId() + "\t\t" + this.getName() + "\t\t" + this.getAge() + "\t\t" + this.getSalary() + "\t\t"
                + "设计师" + "\t\t" + this.getStatus().getName() + "\t" + this.bonus + "\t\t" + "\t\t"
                + this.getEquipment().getDescription();
    }

}
