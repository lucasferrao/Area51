package area51.servlets;

import org.eclipse.jetty.util.ajax.JSON;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CamerasServlet extends HttpServlet {
    protected Map<String, String> processCameraInfo(String idCamera) {
        Connection conn = DataBase.getConnection();

        try {
            PreparedStatement stmt = conn.prepareStatement(
                    "SELECT device_location, repair_history, device_type FROM device "
            + "WHERE id_device=?");

            stmt.setInt(1, Integer.parseInt(idCamera));

            ResultSet rs = stmt.executeQuery();

            if(rs.next()) {
                Map<String, String> cameraData = new HashMap<>();

                cameraData.put("id", rs.getString("device_type"));
                cameraData.put("device_location", rs.getString("device_location"));
                cameraData.put("repair_history", rs.getString("repair_history"));

                rs.close();
                stmt.close();

                return cameraData;
            }

            rs.close();
            stmt.close();
        } catch(SQLException e) {
            e.printStackTrace();

            return null;
        }

        return Collections.emptyMap();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("id_camera") != null) {
            resp.setCharacterEncoding("UTF-8");
            resp.setContentType("application/json");
            resp.getWriter().println(JSON.toString(processCameraInfo(req.getParameter("id_camera"))));
        }
    }
}
