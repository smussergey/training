package ua.training.model.dao.imp;

import ua.training.model.dao.ShopDao;
import ua.training.model.entity.Manufacturer;
import ua.training.model.entity.Shop;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCShopDao implements ShopDao {
    private Connection connection;

    public JDBCShopDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Shop entity) {

    }

    @Override
    public Shop findById(int id) {
        try (PreparedStatement ps = connection.prepareStatement
                ("SELECT * FROM shop WHERE idshop = ?")) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Shop result = extractFromResultSet(rs);
                return result;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }


    private Shop extractFromResultSet(ResultSet rs)
            throws SQLException {
        Shop result = new Shop();

        result.setId(rs.getInt("idshop"));
        result.setName(rs.getString("name"));
        result.setTelephone(rs.getString("telephone"));


        return result;
    }

    @Override
    public List<Shop> findAll() {
        List<Shop> resultList = new ArrayList<>();
        Map<String, Manufacturer> manufacturers = new HashMap<>();
        try (Statement ps = connection.createStatement()) {
            ResultSet rs = ps.executeQuery(
                    "select * from shop left join manufacturer " +
                            "using (idmanufacturer)");
            while (rs.next()) {
                Shop result = extractFromResultSet(rs);
                Manufacturer manufacturer =
                        JDBCManufacturerDao.extractFromResultSet(rs);

                makeUniqueManufacturer(manufacturers, result, manufacturer);

                resultList.add(result);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return resultList;
    }

    private void makeUniqueManufacturer(Map<String, Manufacturer>
                                                manufacturers, Shop result, Manufacturer manufacturer) {
        System.out.println("Before " + manufacturer);
        manufacturers.putIfAbsent(manufacturer.getManufacture(),
                manufacturer);
        manufacturer = manufacturers.get(manufacturer.getManufacture());
        System.out.println(manufacturer);

        result.setManufacturer(manufacturer);
        manufacturer.getShops().add(result);
    }

    @Override
    public void update(Shop entity) {

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
