package teamView.domain.EmployeeType;

import teamView.domain.interfaces.Equipment;
import teamView.service.Status;

public class Architect extends Designer {
    private int stock;

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    

    public Architect() {
        super();
    }

    public Architect(int id, String name, int age, int salary, int memberId, Status status, Equipment equipment,
        int bonus, int stock) {
        super(id, name, age, salary, memberId, status, equipment, bonus);
        this.stock = stock;
    }

    public Architect(int bonus, int stock) {
        super(bonus);
        this.stock = stock;
    }
}
