package area51.servlets;

import org.eclipse.jetty.util.ajax.JSON;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

public class historicOccurrences extends HttpServlet {

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
            out.println("<title>Servlet HistoricoOcorrencias</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet alerts at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    protected void createNewOccurence(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Connection conn = DataBase.getConnection();
        PreparedStatement stmt;

        try {
            String data = request.getParameter("ocurrence_date");
            String idAlert = request.getParameter("id_alert");
            String idOfficer = request.getParameter("id_officer");
            String idRecluse = request.getParameter("id_recluse");
            String occuSubject = request.getParameter("occu_subject");
            String occuDescription = request.getParameter("occu_description");

            stmt = conn.prepareStatement(
                    "INSERT INTO `occurrence` " +
                    "(`id_occurrence`," +
                    "`occurrence_description`," +
                    "`occurrence_subject`," +
                    "`occurrence_date`," +
                    "`id_recluse`," +
                    "`id_officer`) " +
                    "VALUES \n" +
                    "(null, ?, ?, ?, ?, ?);", PreparedStatement.RETURN_GENERATED_KEYS);

            stmt.setString(1, occuDescription);
            stmt.setString(2, occuSubject);
            stmt.setDate(3, Date.valueOf(LocalDate.parse(data)));
            stmt.setInt(4, Integer.parseInt(idRecluse));
            stmt.setInt(5, Integer.parseInt(idOfficer));

            if(stmt.executeUpdate() > 0) {
                ResultSet rs = stmt.getGeneratedKeys();
                rs.next();

                int idOccurrence = rs.getInt(1);

                rs.close();
                stmt.close();

                stmt = conn.prepareStatement(
                        "INSERT INTO `occurrence_by_alert`" +
                        "(`id_alert`, `id_occurrence`) VALUES (?, ?);");

                stmt.setInt(1, Integer.parseInt(idAlert));
                stmt.setInt(2, idOccurrence);

                stmt.executeUpdate();

                stmt.close();
            }
        } catch(SQLException e) {
            e.printStackTrace();
            response.sendError(500);
            return;
        }

        try {
            response.sendRedirect(request.getHeader("Referer"));
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");

        ArrayList<Map<Integer, String>> dur = DataBase.getHistOccurrences(request.getParameter("id"));
        response.setContentType("application/json");
        // response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().println(JSON.toString(dur));
        // response.getWriter().println("Context path: " + request.getServletContext().getContextPath());
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
        createNewOccurence(request, response);
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
