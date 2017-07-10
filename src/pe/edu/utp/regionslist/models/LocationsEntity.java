package pe.edu.utp.regionslist.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 02/07/2017.
 */
public class LocationsEntity extends BaseEntity{
    private static String DEFAULT_SQL = "select * from hr.locations";
    private CountriesEntity countriesEntity;

    public List<Location> findAll(){
        return findByCriteria(DEFAULT_SQL);
    }

    public Location findByid (int id){
        List<Location> locations = findByCriteria(DEFAULT_SQL+"where location_id='"+id+"'");
        return (locations!=null)?locations.get(0):null;
    }
    public Location findByName (String street_address){
        List<Location> locations = findByCriteria(DEFAULT_SQL+
        "where street_address like '%"+street_address+"%'");
        return (locations.isEmpty())?null: locations.get(0);
    }


    private List<Location> findByCriteria(String sql) {
        List<Location> locations;
        if(getConnection()!=null){
            locations = new ArrayList<>();
            try {
                ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
                while(resultSet.next()){
                    Location location = Location.build(resultSet,getCountriesEntity());
                    locations.add(location);
                }
                return locations;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public CountriesEntity getCountriesEntity() {
        return countriesEntity;
    }

    public void setCountriesEntity(CountriesEntity countriesEntity) {
        this.countriesEntity = countriesEntity;
    }

    public Location create(int id,String address,String postal_code,String city, String province, String countryId){
        if(findByName(address)==null){
            if(getConnection()!=null){
                String sql = "insert into locations values('"+
                       String.valueOf(id)+"','"+address+"','"+postal_code+"','"+city+"','"+province+"','"+countryId+")";
                try {
                    int results = getConnection().createStatement().executeUpdate(sql);
                    if(results>0){
                        Location location = new Location(id,address,postal_code,city,province,getCountriesEntity().findById(countryId));
                        return location;
                    }

                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
    private int updateByCriteria (String sql){
        if(getConnection()!=null){
            try {
                return getConnection().createStatement().executeUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }
    public boolean delete(int id){
        return updateByCriteria("Delete from locations where location_id='"+id+"'")>0;
    }
    public boolean update(Location location){
      return updateByCriteria("UPDATE locations SET street_address='"+location.getAddress()+
        "'"+"postal_code='"+location.getPostal_code()+"'"+"city='"+location.getCity()+"'"+"state_province='"+
              location.getProvince()+"' where location_id='"+location.getId()+"'")>0;
    }

}
