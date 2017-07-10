package pe.edu.utp.regionslist.services;

import pe.edu.utp.regionslist.models.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by GrupoUTP on 17/02/2017.
 */
public class HrService extends BaseEntity{
    private RegionsEntity regionsEntity;
    private CountriesEntity countriesEntity;
    private LocationsEntity locationsEntity;

    protected LocationsEntity getLocationsEntity(){
        if(getConnection()!=null){
            if(locationsEntity ==null){
                locationsEntity = new LocationsEntity();
                locationsEntity.setConnection(getConnection());
            }
        }
        return locationsEntity;
    }

    public List<Location> findAllLocation(){
        return getLocationsEntity()!=null ? getLocationsEntity().findAll():null;
    }
    public Location findLocationById(int id){
        return getLocationsEntity()!=null? getLocationsEntity().findByid(id):null;
    }
    public Location createLocation(int id,String address,String postal_code,String city, String province, String countryId){
        return getLocationsEntity()!=null?getLocationsEntity().create(id,address,postal_code,city,province,countryId):null;
    }
    public boolean deleteLocation(int id){
        return getLocationsEntity()!=null? getLocationsEntity().delete(id):false;
    }
    public boolean updateLocation (Location location){
        return getLocationsEntity()!=null?getLocationsEntity().update(location):false;
    }

    protected RegionsEntity getRegionsEntity() {
        if(getConnection() != null) {
            if(regionsEntity == null) {
                regionsEntity = new RegionsEntity();
                regionsEntity.setConnection(getConnection());
            }
        }
        return regionsEntity;
    }



    public List<Region> findAllRegions() {
        return getRegionsEntity() != null ? getRegionsEntity().findAll() : null;
    }

    public Region findRegionById(int id) {
        return getRegionsEntity() != null ? getRegionsEntity().findById(id) : null;
    }

    public Region createRegion(String name) { return getRegionsEntity() != null ? getRegionsEntity().create(name): null; }

    public boolean deleteRegion(int id) { return getRegionsEntity() != null ? getRegionsEntity().delete(id) : false; }

    public boolean updateRegion(Region region) { return getRegionsEntity() != null ? getRegionsEntity().update(region) : false; }

    protected CountriesEntity getCountriesEntity() {
        if(getConnection() != null) {
            if(countriesEntity == null) {
                countriesEntity = new CountriesEntity();
                countriesEntity.setConnection(getConnection());
                countriesEntity.setRegionsEntity(getRegionsEntity());
            }
        }
        return countriesEntity;
    }

    public List<Country> findAllCountries() {
        return getCountriesEntity() != null ?
                getCountriesEntity().findAll() :
                null;
    }

    public Country findCountryById(String id) {
        return getCountriesEntity() != null ? getCountriesEntity().findById(id) : null;
    }

    public Country createCountry(String id, String name, int regionId) { return getCountriesEntity() != null ? getCountriesEntity().create(id, name, regionId): null; }

    public boolean deleteCountry(String id) { return getCountriesEntity() != null ? getCountriesEntity().delete(id) : false; }

    public boolean updateCountry(Country country) { return getCountriesEntity() != null ? getCountriesEntity().update(country) : false; }


}
