package DTO;

public class ShortTermRentalDTO {

    private String dwelling = null, parking = null, sleeps = null, bedrooms = null, bathroom = null;
    private AdvertCommonPropertiesDTO advertCommonPropertiesDTO = new AdvertCommonPropertiesDTO();

    public AdvertCommonPropertiesDTO getAdvertCommonPropertiesDTO() {
        return advertCommonPropertiesDTO;
    }

    public void setAdvertCommonPropertiesDTO(AdvertCommonPropertiesDTO advertCommonPropertiesDTO) {
        this.advertCommonPropertiesDTO = advertCommonPropertiesDTO;
    }

    public String getParking() {
        return parking;
    }

    public void setParking(String parking) {
        this.parking = parking;
    }

    public String getDwelling() {
        return dwelling;
    }

    public void setDwelling(String dwelling) {
        this.dwelling = dwelling;
    }

    public String getSleeps() {
        return sleeps;
    }

    public void setSleeps(String sleeps) {
        this.sleeps = sleeps;
    }

    public String getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(String bedrooms) {
        this.bedrooms = bedrooms;
    }

    public String getBathroom() {
        return bathroom;
    }

    public void setBathroom(String bathroom) {
        this.bathroom = bathroom;
    }

}
