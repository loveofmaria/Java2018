package teamView.domain.equipments;

import teamView.domain.interfaces.Equipment;

public class NoteBook implements Equipment {
    private String model;
    private int price;
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public NoteBook(String model, int price) {
		this.model = model;
		this.price = price;
	}

    public NoteBook() {
        super();
    }

    // 输出领取的设备型号
    @Override
    public String getDescription() {
        return model + "(" + price + ")";        
    } 
}
