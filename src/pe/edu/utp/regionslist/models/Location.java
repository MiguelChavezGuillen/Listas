package pe.edu.utp.regionslist.models;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by User on 02/07/2017.
 */
public class Location {
    private int id;
    private String address;
    private String postal_code;
    private String city;
    private String province;
    private Country country;

    public Location(int id,String address,String postal_code,String city,String province, Country country){
        this.id=id;
        this.address=address;
        this.postal_code=postal_code;
        this.city=city;
        this.province=province;
        this.country=country;
    }
    public int getId() {
        return id;
    }

    public Location setId(int id) {
        this.id = id;
        return  this;
    }

    public String getAddress() {
        return address;
    }

    public Location setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public Location setPostal_code(String postal_code) {
        this.postal_code = postal_code;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Location setCity(String city) {
        this.city = city;
        return this;
    }

    public String getProvince() {
        return province;
    }

    public Location setProvince(String province) {
        this.province = province;
        return this;
    }

    public Country getCountry() {
        return country;
    }

    public Location setCountry(Country country) {
        this.country = country;
        return this;
    }

    public static Location build(ResultSet resultSet, CountriesEntity countriesEntity){
        try {
            return new Location(resultSet.getInt("location_id"),
                    resultSet.getString("street_address"),
                    resultSet.getString("postal_code"),
                    resultSet.getString("city"),
                    resultSet.getString("state_province"),
                    countriesEntity.findById(resultSet.getString("country_id")));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }


}
