/*
package area51.servlets;

        import org.eclipse.jetty.util.ajax.JSON;

        import javax.servlet.ServletException;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.io.IOException;
        import java.io.PrintWriter;
        import java.sql.DriverManager;
        import java.sql.PreparedStatement;
        import java.util.ArrayList;
        import java.util.Map;

public class newRecluse extends HttpServlet{

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
*/
            /* TODO output your page here. You may use following sample code. */
/*           out.println("<!DOCTYPE html>");
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


    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
 /*   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8\"");
        PrintWriter out = response.getWriter();

        String name=request.getParameter("name1");
        String birth=request.getParameter("birthdate1");
        String genre=request.getParameter("genre1");
        String disease=request.getParameter("disease1");
        String cause=request.getParameter("cause1");
        String cell=request.getParameter("cell1");

        try{
            Class.forName("com.mysql.jdbc.Driver");
            DataBase con= (DataBase) DataBase.getConnection();
            PreparedStatement ps = con.prepareStatement("insert into Recluse (recluse_name,birthdate,genre,disease,cause,cell) VALUES ('"+ name +"', '"+ birth + "', '"+ genre + "', '" + disease + "', '"+ cause + "', '" + cell + "')");

            ps.setString(1,name);
            ps.setString(2,birth);
            ps.setString(3,genre);
            ps.setString(4,disease);
            ps.setString(5,cause);
            ps.setString(6,cell);

            int i=ps.executeUpdate();
            if(i>0)
                out.print("Registado com Sucesso");


        }catch (Exception e2) {System.out.println(e2);}

        out.close();

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     *//*
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>


}*/