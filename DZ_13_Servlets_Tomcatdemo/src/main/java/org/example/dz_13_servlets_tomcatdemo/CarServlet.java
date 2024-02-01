package org.example.dz_13_servlets_tomcatdemo;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import org.example.dz_13_servlets_tomcatdemo.model.Car;

@WebServlet(name = "CarServlet", value = "/car")
public class CarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/car_registration.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Car car;
        String model = request.getParameter("model");
        String power = request.getParameter("power");
        String year = request.getParameter("year");
        String price = request.getParameter("price");

        System.out.printf("%s %s %s %s", model, power, year, price);

        if (model != null && power != null && year != null && price != null) {
            car = Car.builder()
                    .model(model)
                    .power(Double.parseDouble(power))
                    .year(Integer.parseInt(year))
                    .price(Double.parseDouble(price))
                    .build();
        } else
            car = new Car();

        DbHandler.save(car);

        PrintWriter pw = response.getWriter();
        pw.println("<html>" +
                "<body>" +
                "<h1>Your car has been successfully registered!</h1>" +
                "</body>" +
                "</html>");
    }
}