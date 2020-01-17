package ua.training;

import ua.training.model.dao.CarDao;
import ua.training.model.dao.DaoFactory;
import ua.training.model.dao.DriverDao;

public class App {
    public static void main(String[] args) throws Exception {
        DaoFactory factory = DaoFactory.getInstance();
        CarDao carDao = factory.createCarDao();
        DriverDao driverDao = factory.createDriverDao();

        System.out.println(carDao.findById(2));
        System.out.println(driverDao.findById(5));
        System.out.println(carDao.findAll());
    }
}
