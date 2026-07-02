package dson.crowee.obj.objects;

public class Item {
    private String formalCode;
    private Integer internalCode;
    private String formalName;
    private String onCarryBy;
    private String carrierCode;

    public String getFormalCode() {
        return formalCode;
    }

    public void setFormalCode(String formalCode) {
        this.formalCode = formalCode;
    }

    public Integer getInternalCode() {
        return internalCode;
    }

    public void setInternalCode(Integer internalCode) {
        this.internalCode = internalCode;
    }

    public String getFormalName() {
        return formalName;
    }

    public void setFormalName(String formalName) {
        this.formalName = formalName;
    }

    public String getOnCarryBy() {
        return onCarryBy;
    }

    public void setOnCarryBy(String onCarryBy) {
        this.onCarryBy = onCarryBy;
    }

    public String getCarrierCode() {
        return carrierCode;
    }

    public void setCarrierCode(String carrierCode) {
        this.carrierCode = carrierCode;
    }
}

