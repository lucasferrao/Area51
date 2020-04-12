package area51.servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.eclipse.jetty.util.ajax.JSON;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Proprietario
 */
public class alerts extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet alerts</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet alerts at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    protected void processNewMovements(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        Connection conn = DataBase.getConnection();
        PreparedStatement stmt = null;
        int oldAlertCount = -1;

        final String sql = "SELECT COUNT(id_alert) AS 'count_alerts' FROM alert";

        while (true) {
            // Verificar na base de dados se existe movimento novo
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int alertCount = rs.getInt("count_alerts");
                if (alertCount > oldAlertCount && oldAlertCount > -1) {
                    // Existem novos alertas!! break!!
                    rs.close();
                    stmt.close();
                    break;
                }

                oldAlertCount = alertCount;
            }

            rs.close();
            stmt.close();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        stmt = conn.prepareStatement("SELECT id_device FROM alert ORDER BY `id_alert` DESC LIMIT 1");
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            Map<String, Integer> res = new HashMap<>();

            res.put("sensor", rs.getInt("id_device"));

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().println(JSON.toString(res));
        }

        rs.close();
        stmt.close();
        conn.close();
    }

    protected void processMovement (HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        Connection conn = DataBase.getConnection();
        String sql =
                "INSERT INTO `YrTGCBVRUv`.`alert`\n" +
                "(`alert_type`, `alert_date`, `alert_hour`, `id_officer`, `id_device`)\n" +
                "VALUES\n" +
                "(?, ?, ?,  ?, ?);";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, "Movimento");
        stmt.setString(2, LocalDateTime.now().format(DateTimeFormatter.ISO_DATE));
        stmt.setString(3, LocalDateTime.now().format(DateTimeFormatter.ISO_TIME));
        stmt.setString(4, "1");
        stmt.setString(5, "1");
        stmt.executeUpdate();
        stmt.close();
        conn.close();

        response.getWriter().println("{\"status\": \"ok\"}");
        System.out.println("Movimento detetado em " + request.getParameter("lugar"));
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if("/novosMovimentos".equalsIgnoreCase(request.getPathInfo())) {
            try {
                processNewMovements (request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            ArrayList<String> dur = DataBase.getDDate();
            response.setContentType("application/json");
            // response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().println(dur);
            // response.getWriter().println("Context path: " + request.getServletContext().getContextPath());
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // processRequest(request, response);
        if("/movement".equalsIgnoreCase(request.getPathInfo())) {
            try {
                processMovement(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
