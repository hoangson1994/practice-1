package controller;

import entity.Phone;
import model.PhoneModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class PhoneController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if ("/add/".contains(uri)) {
            req.getRequestDispatcher("/addphone.jsp").forward(req, resp);
        } else if ("/list/".contains(uri)) {
            PhoneModel phoneModel = new PhoneModel();
            ArrayList<Phone> phones = phoneModel.list();
            req.setAttribute("phones", phones);
            req.getRequestDispatcher("/listphone.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String brand = req.getParameter("brand");
        String price = req.getParameter("price");
        String description = req.getParameter("description");

        Phone phone = new Phone(name, brand, Integer.parseInt(price), description);

        PhoneModel phoneModel = new PhoneModel();
        boolean result = phoneModel.insert(phone);
        if (result) {
            resp.sendRedirect("/list");
        } else {
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}
