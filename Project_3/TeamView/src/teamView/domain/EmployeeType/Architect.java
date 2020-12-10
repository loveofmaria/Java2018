package teamView.domain.EmployeeType;

import teamView.domain.interfaces.Equipment;

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

    public Architect(int id, String name, int age, int salary, Equipment equipment,
        int bonus, int stock) {
        super(id, name, age, salary, equipment, bonus);
        this.stock = stock;
    }

}
