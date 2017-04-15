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
public class HomeServlet extends HttpServlet {

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
        List<Song> top100song = Song.getSongFromTable("songtop100",10,false);
        List<Song> newsong = Song.getNewSong();
        List<Song> top50thai = Song.getSongFromTable("songtop50thai",8,false);
        List<Song> top50inter = Song.getSongFromTable("songtop50inter",8,false);
        List<Song> top50looktung = Song.getSongFromTable("songtop50looktung",8,false);
        List<Song> top50indy = Song.getSongFromTable("songtop50indy",8,false);
        request.setAttribute("top100song", top100song);
        request.setAttribute("newsong", newsong);
        request.setAttribute("top50thai", top50thai);
        request.setAttribute("top50inter", top50inter);
        request.setAttribute("top50looktung", top50looktung);
        request.setAttribute("top50indy", top50indy);
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
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
