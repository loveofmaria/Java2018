package teamView.domain.equipments;

import teamView.domain.interfaces.Equipment;

public class StationPC implements Equipment {

    private String model;
    private String display;

    // 输出领取的设备型号
    @Override
    public String getDescription() {
        return model + "(" + display + ")";        
    }

    // getter + setter + constructor
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public StationPC () {
        super();
    }

    public StationPC(String model, String display) {
        this.model = model;
        this.display = display;
    }
}
