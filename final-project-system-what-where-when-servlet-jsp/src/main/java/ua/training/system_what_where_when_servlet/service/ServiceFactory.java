package ua.training.system_what_where_when_servlet.service;

public class ServiceFactory {
    private static ServiceFactory serviceFactory;

    public ServiceFactory() {
    }

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
        return new UserService();
    }

    public UserRegistrationService getUserRegistrationService() {
        return new UserRegistrationService();
    }

    public GameStatisticsAndDetailsService getGameStatisticsAndDetailsService() {
        return new GameStatisticsAndDetailsService();
    }

    public GameDTOService getGameDTOService() {
        return new GameDTOService();
    }
}
