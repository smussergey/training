package ua.training;

import ua.training.model.dao.CarDao;
import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.ManufacturerDao;
import ua.training.model.dao.ShopDao;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )throws Exception
    {
        DaoFactory factory = DaoFactory.getInstance();

        CarDao carDao = factory.createCarDao();
        System.out.println("----------------------------carDao.findById(10)");
        System.out.println(carDao.findById(10));
        System.out.println("----------------------------carDao.findAll()");
        System.out.println(carDao.findAll());
        System.out.println("");
        System.out.println("");

        ManufacturerDao manufacturerDao = factory.createManufacturerDao();
        System.out.println("----------------------------manufacturerDao.findById(1)");
        System.out.println(manufacturerDao.findById(1));
        System.out.println("----------------------------manufacturerDao.findAll()");
        System.out.println(manufacturerDao.findAll());
        System.out.println("");
        System.out.println("");

        ShopDao shopDao = factory.createShopDao();
        System.out.println("----------------------------shopDao.findById(20)");
        System.out.println(shopDao.findById(20));
        System.out.println("----------------------------shopDao.findAll()");
        System.out.println(shopDao.findAll());



        /*Connection con =
                DriverManager.
                        getConnection(  "jdbc:"+
                                        "mysql:"+
                                        "//localhost:3306/"+
                                        //"world" ,
                                        "mycardb",
                                "root" ,
                                "root");

        Statement query = con.createStatement();
        //ResultSet rs = query.executeQuery("SELECT * FROM city");
        ResultSet rs = query.executeQuery("SELECT * FROM car");
        while( rs.next()) {
            System.out.println(rs.getString("model"));}*/
/*

#SELECT * FROM manufacturer JOIN shop ON
                        manufacturer.idmanufacturer = shop.idmanufacturer
#SELECT * FROM manufacturer LEFT join shop ON
                        manufacturer.idmanufacturer = shop.idmanufacturer
#SELECT * FROM shop right join manufacturer ON
                        manufacturer.idmanufacturer = shop.idmanufacturer
#SELECT * FROM manufacturer right join shop ON
                        manufacturer.idmanufacturer = shop.idmanufacturer

#SELECT * FROM mycardb.car;
#SELECT * FROM manufacturer JOIN car using (idmanufacturer)
#SELECT * FROM manufacturer LEFT join car using (idmanufacturer)
#SELECT * FROM manufacturer LEFT join car using (idmanufacturer) where manufacture = "BMV"
#SELECT * FROM car right join manufacturer using (idmanufacturer)
#SELECT * FROM manufacturer right join car using (idmanufacturer)

*/
        }
    }

