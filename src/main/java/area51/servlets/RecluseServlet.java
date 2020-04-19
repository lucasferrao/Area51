package area51.servlets;

import org.eclipse.jetty.util.ajax.JSON;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecluseServlet extends HttpServlet {

    protected Map<String, String> getRecluseData(String id) {
        Map<String, String> results = new HashMap<>();

        Connection conn = DataBase.getConnection();

        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = conn.prepareStatement("SELECT * FROM recluse WHERE id_recluse=?");
            statement.setString(1, id);

            resultSet = statement.executeQuery();
            if(!resultSet.first()) {
                resultSet.close();
                statement.close();
                return results;
            }

            for(int i = 0; i < resultSet.getMetaData().getColumnCount(); i++) {
                results.put(resultSet.getMetaData().getColumnName(i + 1), resultSet.getString(i + 1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(resultSet != null) {
                    resultSet.close();
                }
                if(statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return results;
    }


    protected void createNewRecluse (HttpServletRequest request, HttpServletResponse response) throws IOException {
        Connection conn = DataBase.getConnection();
        PreparedStatement stmt;

        try {
            String name = request.getParameter("name1");
            String birth = request.getParameter("birthdate1");
            String genre = request.getParameter("genre");
            String disease = request.getParameter("disease1");
            String cause = request.getParameter("cause1");
            String cell = request.getParameter("cell1");

            stmt = conn.prepareStatement(
                    "INSERT INTO `recluse`" +
                            "(`recluse_name`," +
                            "`birthdate`," +
                            "`genre`," +
                            "`disease`," +
                            "`cause`," +
                            "`cell`) " +
                            "VALUES \n" +
                            "(?, ?, ?, ?, ?, ?);");

            stmt.setString(1, name);
            stmt.setDate(2, Date.valueOf(LocalDate.parse(birth)));
            stmt.setString(3, genre);
            stmt.setString(4, disease);
            stmt.setString(5, cause);
            stmt.setString(6, cell);

            stmt.executeUpdate();

            stmt.close();
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










    protected List<Integer> getAllRecluseIds() {
        List<Integer> results = new ArrayList<>();

        Connection conn = DataBase.getConnection();

        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = conn.prepareStatement("SELECT id_recluse FROM recluse");

            resultSet = statement.executeQuery();

            if(!resultSet.first()) {
                resultSet.close();
                statement.close();
                return results;
            }

            do {
                results.add(resultSet.getInt("id_recluse"));
            } while(resultSet.next());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(resultSet != null) {
                    resultSet.close();
                }
                if(statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return results;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        String id;
        if((id = req.getParameter("id")) != null) {
            resp.getWriter().write(JSON.toString(getRecluseData(id)));
        }

        else {
            resp.getWriter().write(JSON.toString(getAllRecluseIds().toArray()));
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        createNewRecluse(req, resp);
    }
}
