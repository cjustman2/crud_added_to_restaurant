/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DB_Generic;
import Model.MenuService;
import Model.SeviceStrategy;
import Model.DatabaseAccessor;
import Model.MenuItem;
import Model.Receipt;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Array;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author chris
 */
@WebServlet(name = "GetEntreeItemsController", urlPatterns = {"/GetEntreeItemsController"})
public class GetEntreeItemsController extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet OnPageLoadController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet OnPageLoadController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String SEND_TO_PAGE = null;
        List<MenuItem> list = null;
        
           SeviceStrategy das = new MenuService();
           
           
           
           
           
           
           
            SEND_TO_PAGE = request.getParameter("page");
            
            
            
            if(SEND_TO_PAGE == null){
                SEND_TO_PAGE = "index.jsp";
            }
            
            
            
            
     
                try{

              list = das.getAllEntreeItems();
                }catch(Exception e){
                    request.setAttribute("e", e);
                }
   
   request.setAttribute("list", list);
        
          RequestDispatcher view =
                request.getRequestDispatcher("/"+SEND_TO_PAGE);
        view.forward(request, response);
        
    }


    
    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*
         * Upon choosing a meal from select box, form submits here
         * 
         * 
         */
        
       List list = null;
        
       SeviceStrategy  das = new MenuService();
       
       
        String meal_id = request.getParameter("choose_meal");
        
        if(meal_id.equalsIgnoreCase("4"))
        {
                        try{
                   list = das.getAllEntreeItems();

                   }catch(Exception e){

                   } 
             
             
        }else{
        
                try{
                list = das.getEntreesByMealId(meal_id);

                }catch(Exception e){

                }
        }
        
        request.setAttribute("list", list);
        
          RequestDispatcher view =
                request.getRequestDispatcher("/index.jsp");
        view.forward(request, response);
        
        
        
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
