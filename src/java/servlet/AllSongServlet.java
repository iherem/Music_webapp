/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Song;

/**
 *
 * @author mmPC
 */
public class AllSongServlet extends HttpServlet {

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
        String tag = request.getParameter("tag");
        String page = "";
        List<Song> songtop100 = null;
        if (tag != null) {
            switch (tag) {
                case "all":
                    songtop100 = Song.getSongFromTable("songtop100", 100, false);
                    page = "all";
                    break;
                case "allthai":
                    songtop100 = Song.getSongFromTable("songtop50thai", 50, false);
                    page = "allthai";
                    break;
                case "allinter":
                    songtop100 = Song.getSongFromTable("songtop50inter", 50, false);
                    page = "allinter";
                    break;
                case "alllooktung":
                    songtop100 = Song.getSongFromTable("songtop50looktung", 50, false);
                    page = "alllooktung";
                    break;
                case "allindy":
                    songtop100 = Song.getSongFromTable("songtop50indy", 50, false);
                    page = "allindy";
                    break;
                default:
                    songtop100 = Song.getSongFromTable("songtop100", 100, false);
                    page = "all";
                    break;
            }
        }else{
            songtop100 = Song.getSongFromTable("songtop100", 100, false);
            page = "all";
        }

        request.setAttribute("listsong", songtop100);
        request.setAttribute("page", page);
        getServletContext().getRequestDispatcher("/allsong.jsp").forward(request, response);
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
