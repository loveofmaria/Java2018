package teamView.domain.equipments;

import teamView.domain.interfaces.Equipment;

public class Printer implements Equipment {

    private String printerName;
    private String printerType;

    // 返回打印机设备的信息
    @Override
    public String getDescription() {
        return printerName + "(" + printerType + ")";
       
    }

    public String getPrinterName() {
        return printerName;
    }

    public void setPrinterName(String printerName) {
        this.printerName = printerName;
    }

    public String getPrinterType() {
        return printerType;
    }

    public void setPrinterType(String printerType) {
        this.printerType = printerType;
    }

    public Printer(String printerName, String printerType) {
        this.printerName = printerName;
        this.printerType = printerType;
    }

    public Printer() {
        super();
    }
}
