package datos;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Datos extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            String tema = request.getParameter("Tema");
            String pagina = request.getParameter("Pagina");
            String nombreArch = "Tema-" + tema + "_Pagina-" + tema + ".txt";
            String texto = "";
            String linea;
            //try{
                File archivo = new File(getServletContext().getRealPath("/" + nombreArch));
                FileReader fR = new FileReader(archivo);
                BufferedReader reader = new BufferedReader(fR);
                while((linea = reader.readLine()) != null){
                    texto += linea + "\\n";
                }

                out.println("{");
                out.println("\"Tema\": \"" + tema + "\",");
                out.println("\"Pagina\": \" " + pagina + " \",");
                out.println("\"Texto\": \" " + texto + " \"");
                out.println("}");
                out.close();
        }catch (IOException e){
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        processRequest(request, response);
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
        processRequest(request, response);
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
