package pe.edu.utp.regionslist.models;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by GrupoUTP on 17/02/2017.
 */
public class Region {
    private int id;
    private String name;

    public Region() {
    }

    public Region(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Region build(ResultSet resultSet) {
        try {
            return new Region(resultSet.getInt("region_id"),
                    resultSet.getString("region_name"));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
