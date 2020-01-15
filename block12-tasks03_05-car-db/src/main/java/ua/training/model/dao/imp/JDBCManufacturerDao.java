package ua.training.model.dao.imp;

import ua.training.model.dao.ManufacturerDao;
import ua.training.model.entity.Manufacturer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCManufacturerDao implements ManufacturerDao {
    private Connection connection;

    public JDBCManufacturerDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Manufacturer entity) {

    }

    @Override
    public Manufacturer findById(int id) {
        try (PreparedStatement ps = connection.prepareStatement
                ("SELECT * FROM manufacturer WHERE idmanufacturer = ?")) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Manufacturer result = extractFromResultSet(rs);
                return result;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    static Manufacturer extractFromResultSet(ResultSet rs)throws Exception{
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setId(rs.getInt("idmanufacturer"));
        manufacturer.setManufacture(rs.getString("manufacturer"));
        manufacturer.setDiscount(rs.getInt("discount"));
        return manufacturer;
    }

    @Override
    public List<Manufacturer> findAll() {
        List<Manufacturer> resultList = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(
                "SELECT * FROM manufacturer")){
            ResultSet rs = ps.executeQuery();

            while ( rs.next() ){
                Manufacturer result = extractFromResultSet(rs);
                resultList.add(result);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultList;
    }

    @Override
    public void update(Manufacturer entity) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void close()  {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
