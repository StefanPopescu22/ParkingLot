package com.parking.parkinglot.servlets;

import com.parking.parkinglot.ejb.UserBean;
import com.parking.parkinglot.common.UserDto;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "Users", value = "/Users")
public class Users extends HttpServlet {

    @Inject
    private UserBean userBean;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String[] userIdsAsString = request.getParameterValues("user_ids");

        if (userIdsAsString != null) {
            List<Long> userIds = new ArrayList<>();
            for (String userIdAsString : userIdsAsString) {
                try {
                    userIds.add(Long.parseLong(userIdAsString));
                } catch (NumberFormatException e) {
                    // Logare sau tratare a excepției dacă un ID nu este valid
                    e.printStackTrace();
                }
            }

           invoiceBean.getUserIds().addAll(userIds);
        }
             response.sendRedirect(request.getContextPath() + "/Users");
    }

}