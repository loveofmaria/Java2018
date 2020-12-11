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

    public Architect(int id, String name, int age, int salary, Equipment equipment,
        int bonus, int stock) {
        super(id, name, age, salary, equipment, bonus);
        this.stock = stock;
    }
   
    @Override
    public String getDescription() {  
        return this.getId() + "\t\t" + this.getName() 
        + "\t\t" + this.getAge() + "\t\t" 
        + this.getSalary() 
        + "\t\t" + "架构师"
        + "\t\t" + this.getStatus().getName() 
        + "\t" + this.getBonus() + "\t\t" + this.stock + "\t\t" + this.getEquipment().getDescription();
    } 

}
