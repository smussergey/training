package ua.training.system_what_where_when_servlet.service;

public class ServiceFactory {
    private static ServiceFactory serviceFactory;

    private final UserService userService = new UserService();

    public static ServiceFactory getInstance() {
        if (serviceFactory == null) {
            synchronized (ServiceFactory.class) {
                if (serviceFactory == null) {
                    ServiceFactory temp = new ServiceFactory();
                    serviceFactory = temp;
                }
            }
        }
        return serviceFactory;
    }

    public UserService getUserService() {
        return userService;
    }
}
