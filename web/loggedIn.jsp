<%-- 
    Document   : loggedIn.jsp
    Created on : Sep 23, 2013, 9:42:39 PM
    Author     : chris
--%>

<%@page import="Model.MenuItem"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="styles/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administrator</title>
        
        <style type="text/css">
            
            th{
                padding: 10px;
                
            }
            
        </style>
    </head>
    <body>
        <div class="container">
            <h1>Administrator</h1>
            
                        <%  
            /**********************status of actions**************/
      
            if(request.getAttribute("cnt") != null){
                out.println(request.getAttribute("cnt").toString());
                System.exit(0);
            }
            
            /*************************************************/
            %>
            
                    <!--if only one entree has not been chosen for edit and new record button hasn't been selected -->
            <%  if(request.getAttribute("entree") == null && request.getAttribute("add_record") == null){%>
            
            
            
            
            
            
            
            <!-- **************************Will show all entrees on page load *******************************-->
            
            
                        <table class="table-striped table-bordered">
                            <form action="AdminController?action=delete" method="post" name="admin">
                            <tr>
                                <th><a href="AdminController?addRecord=yes" name="new" class="btn" id="new">Add New Record</a></th>
                                <th>Name</th>
                                <th>Price</th>
                                <th colspan="2"><input type="submit" id="delete" class="btn pull-right" value="Delete"/></th>
                            </tr>
                
                     
                
            
             <% 
                 
                
               //retrieve the list of query items
               List<MenuItem> list = (List<MenuItem>)request.getAttribute("list");
                
                
             
              
             /****************** Retrieve all entrees on page load ******************/
            for(MenuItem item : list)
              {  
              
                 out.println("<tr><th><a href='AdminController?edit="+item.getEntree_id()+"' name='edit' class='btn btn-mini'>Edit</a></th>"      
                         + "<th>"+item.getEntree_name()+"</th>"
                         + "<th>"+item.getEntree_price()+"</th>"
                         + "<th><input type='checkbox' name='entree' id='checkbox"+item.getEntree_id()+"' value='"+item.getEntree_id()+"'/></th></tr>");
                
                
                  }  
            
            %>
           
                 </form>
            </table>
            
            <%
        /****************************End of show all entrees on page load ***********************/
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            /**************    Editing Entree  ************************/
            
                 }else if(request.getAttribute("entree") != null){//end of if edit is null
                     
                     
                     
                 %>
                 <form name="edit" id="edit" action="AdminController?action=edit" method="post">
                         <%
                     MenuItem item = new MenuItem();
                     
                     item = (MenuItem)request.getAttribute("entree");//entree to be editted
                     
                     out.println("Entree Name <input type='text' value='"+item.getEntree_name()+"' name='name'/><br>");
                     out.println("Entree Price <input type='text' value='"+item.getEntree_price()+"' name='price' /><br>");
                     %>
                     <select name='meal'>
 <% if(item.getMeal_id().equalsIgnoreCase("1")){ out.println("<option value='1' selected>"+item.getMeal()+"</option>");}
 else{ out.println("<option value='1'>Breakfast</option>");}
 
 if(item.getMeal_id().equalsIgnoreCase("2")){ out.println("<option value='2' selected>"+item.getMeal()+"</option>");}
 else{ out.println("<option value='2'>Lunch</option>");}
 
 if(item.getMeal_id().equalsIgnoreCase("3")){ out.println("<option value='3' selected>"+item.getMeal()+"</option>");}
 else{ out.println("<option value='3'>Dinner</option>");}%>  
                         
                     </select>
                     
                    <%
                     out.println("<input type='submit' class='btn' value='Edit Entree'/> <br>");
                     out.println("<input type='hidden' name='id' value='"+item.getEntree_id()+"' name='id'/>");
                     
            
            /********************* End of Edit ***********************/
            %>
            
                 </form>
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            <%
            /**************** Adding new Record **********************/
                 } else if(request.getAttribute("add_record") != null){
                     %>
                     <form action="AdminController?action=new" method="post" name="add_record" id="add_record">
                         
                         <input type="text" name="name" id="entree_name" placeholder="Entree Name" required/><br>
                         <input type="text" name="price" id="entree_price" placeholder="Entree price" required/><br>
                         <select name="meal">
                             <option value="">Select Meal</option>
                             <option value="1">Breakfast</option>
                             <option value="2">Lunch</option>
                             <option value="3">Dinner</option>
                         </select><br>
                         <input type="submit" class="btn" name="add_btn" value="Add Record"/>
                     </form>
          
                     <% }  /******************End of add new record *****************/%>
        </div>
    </body>
</html>
