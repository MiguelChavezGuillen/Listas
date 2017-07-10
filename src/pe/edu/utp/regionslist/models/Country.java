package pe.edu.utp.regionslist.models;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by GrupoUTP on 24/02/2017.
 */
public class Country {
    private String id;
    private String name;
    private Region region;

    public Country(String id, String name, Region region) {
        this.id = id;
        this.name = name;
        this.region = region;
    }

    public String getId() {
        return id;
    }

    public Country setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Country setName(String name) {
        this.name = name;
        return this;
    }

    public Region getRegion() {
        return region;
    }

    public Country setRegion(Region region) {
        this.region = region;
        return this;
    }

    public static Country build(ResultSet resultSet, RegionsEntity regionsEntity) {
        try {
            return new Country(resultSet.getString("country_id"),
                    resultSet.getString("country_name"),
                    regionsEntity.findById(resultSet.getInt("region_id")));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
