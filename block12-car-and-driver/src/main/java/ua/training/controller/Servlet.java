package ua.training.controller;

import ua.training.model.dao.CarDao;
import ua.training.model.dao.DaoFactory;
import ua.training.model.entity.Car;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Servlet extends HttpServlet {
        public void doGet(HttpServletRequest request,
                          HttpServletResponse response)
                throws IOException, ServletException {
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            request.setCharacterEncoding("UTF-8");

            DaoFactory factory = DaoFactory.getInstance();
            CarDao dao = factory.createCarDao();

//            List<Car> cars= dao.findAll();
            List<Car> cars = new ArrayList<>();
            cars.add(dao.findById(1));
            cars.add(dao.findById(2));
            cars.add(dao.findById(3));
            cars.add(dao.findById(4));

            request.setAttribute("cars" , cars);
            request.getRequestDispatcher("./WEB-INF/carlist.jsp")
                    .forward(request,response);
          /*response.getWriter().print("Hello from servlet");*/
        }

        public void doPost(HttpServletRequest request, HttpServletResponse response)
                throws IOException, ServletException {
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");

        }
}

