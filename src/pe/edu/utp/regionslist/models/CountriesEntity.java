package pe.edu.utp.regionslist.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by GrupoUTP on 24/02/2017.
 */
public class CountriesEntity extends BaseEntity {
    private static String DEFAULT_SQL = "SELECT * FROM hr.countries";
    private RegionsEntity regionsEntity;

    public List<Country> findAll() {
        return findByCriteria(DEFAULT_SQL);
    }

    public Country findById(String id) {
        List<Country> countries = findByCriteria(DEFAULT_SQL +
                " WHERE country_id = '" + id + "'");
        return (countries != null) ? countries.get(0) : null;
    }

    public Country findByName(String name) {
        List<Country> countries = findByCriteria(DEFAULT_SQL +
                " WHERE country_name = '" + name + "'");
        return (countries.isEmpty()) ? null : countries.get(0);
    }

    private List<Country> findByCriteria(String sql) {
        List<Country> countries;
        if(getConnection() != null) {
            countries = new ArrayList<>();
            try {
                ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
                while(resultSet.next()) {
                    Country country = Country.build(resultSet, getRegionsEntity());
                    countries.add(country);
                }
                return countries;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public RegionsEntity getRegionsEntity() {
        return regionsEntity;
    }

    public void setRegionsEntity(RegionsEntity regionsEntity) {
        this.regionsEntity = regionsEntity;
    }

    public Country create(String id, String name, int regionId) {
        if(findByName(name) == null) {
            if(getConnection() != null) {
                String sql = "INSERT INTO countries(country_id, country_name, region_id) VALUES('" +
                         id + "', '" +
                        name + "', " + String.valueOf(regionId) + ")";
                try {
                    int results = getConnection().createStatement().executeUpdate(sql);
                    if(results > 0) {
                        Country country = new Country(id, name, getRegionsEntity().findById(regionId));
                        return country;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    private int updateByCriteria(String sql) {
        if(getConnection() != null) {
            try {
                return getConnection().createStatement().executeUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public boolean delete(String id) {
        return updateByCriteria("DELETE FROM countries WHERE country_id = '"+
                id + "'") > 0;
    }


    public boolean update(Country country) {
        return updateByCriteria("UPDATE countries SET country_name = '" +
                country.getName() + "' WHERE country_id = '" + country.getId() + "'") > 0;
    }


}
