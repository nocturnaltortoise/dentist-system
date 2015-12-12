package models;

public class Address {

    int addressId;
    int houseNumber;
    String streetName;
    String cityName;
    String districtName;
    String postCode;

    public Address(int houseNumber, String streetName, String cityName, String districtName, String postCode){
        this.houseNumber = houseNumber;
        this.streetName = streetName;
        this.cityName = cityName;
        this.districtName = districtName;
        this.postCode = postCode;
    }

    @Override
    public String toString() {
        return "<html>" + houseNumber + " " + streetName + "<br>" + cityName + "<br>" + districtName + "<br>" + postCode + "</html>";
    }

}
