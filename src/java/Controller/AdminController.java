/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.MenuItem;
import Model.MenuService;
import Model.SeviceStrategy;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "AdminController", urlPatterns = {"/AdminController"})
public class AdminController extends HttpServlet {

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
            out.println("<title>Servlet AdminController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminController at " + request.getContextPath() + "</h1>");
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
       MenuItem entree = null;
        String edit = null;
        String addRecord = null;
        SeviceStrategy item = new MenuService();
        
        edit = request.getParameter("edit");
        addRecord = request.getParameter("addRecord");
        
        if(edit != null){
            
            try{
                
            entree = item.getEntreeByEntreeId(edit);
            
            request.setAttribute("entree", entree);
            
            }catch(Exception e){
                
            }
            
            
            
            
            
        }else if(addRecord.equalsIgnoreCase("yes")){
            String add_record = "yes";
            request.setAttribute("add_record", add_record);
            
            
        }
        
         RequestDispatcher view =
                request.getRequestDispatcher("/loggedIn.jsp");
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
        SeviceStrategy service = new MenuService();
       String action = null;//action being performed
        String[] delete = null;//array of deleted entrees
        String name = null;//name of entree
        String price = null;//price
        String meal = null;//breakfast, lunch, or dinner
        String id = null;//id of entree
        int count = 0;//number of records updated
        
        action = request.getParameter("action");
        
        
        
        /************** Delete Records *****************/
        if(action.equalsIgnoreCase("delete")){
        
        
        delete = request.getParameterValues("entree");
        
        try{
            
            count = service.deleteMenuItem(delete);
        }catch(Exception e){
            
        }
       
        String cnt = Integer.toString(count);
            request.setAttribute("cnt", cnt);
       
        /*************** Add new Record ******************/
        }else if(action.equalsIgnoreCase("new")){
            name = request.getParameter("name");
            price = request.getParameter("price");
            meal = request.getParameter("meal");
             try{
              
               count = service.addNewMenuItem(price, meal, name);
               
            }catch(Exception e){
               
            }
             
             
             String cnt = Integer.toString(count);
            request.setAttribute("cnt", cnt);
           
            
       /*************** Edit Record *********************/     
        }else if(action.equalsIgnoreCase("edit")){
            id= request.getParameter("id");
            name = request.getParameter("name");
            price = request.getParameter("price");
            meal = request.getParameter("meal");
            
            try{
              
               count = service.editEntreeItemById(id, price, meal, name);
               
            }catch(Exception e){
               
            }
            
            String cnt = Integer.toString(count);
         request.setAttribute("cnt", cnt);
            
        }
        /***************end of edit***********************/
        
        
        
        
        
       
        
         RequestDispatcher view =
                request.getRequestDispatcher("/loggedIn.jsp");
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
