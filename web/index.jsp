<%-- 
    Document   : index
    Created on : Sep 11, 2013, 8:18:19 PM
    Author     : chris
--%>

<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Restaurant</title>
        
        <link href="styles/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <style type="text/css">
            #main_heading{
                text-align: center;
                font-size: 80px;
                margin: 30px 0;
                
            }
            </style>
        <script type="text/javascript">
       window.onload = inIt;
       
       
      
     
       
       
       
       
       function inIt(){
       document.getElementById("entry").onclick = showForm;
       document.getElementById("order").onchange = selectItem;
       document.getElementById("orderForm").onsubmit = validate;
       document.getElementById("chosen").onclick = unselectItem;
       }
       
       
       
       function showForm(){
           var form = document.getElementById("container");
           form.style.visibility = "visible";
            document.getElementById("entry").value = "Hide";
           document.getElementById("entry").onclick = hideForm;
       }
       
       
       function hideForm(){
           var form = document.getElementById("container");
           form.style.visibility = "hidden";
           document.getElementById("entry").value = "Order";
           document.getElementById("entry").onclick = showForm;
       }
       
       
       
       function unselectItem(){
         document.getElementById("chosen").innerHTML = "";
         document.getElementById("toBeSubmittedItems").value = "";
       }
       
       
       
       
       function selectItem(){
        var s = document.getElementById("order");  
       var selected = s.value;
       var chosen = document.getElementById("chosen");
       
       
       myMeal = new Array();
         var i = chosen.value;
      
       if(i !== null){
           
           myMeal += i;
       }
      
    
      if(selected !== ""){
      myMeal += selected;
          
      chosen.innerHTML = myMeal + "\r";
      
      var toBeSubmitted = document.getElementById("toBeSubmittedItems");
      toBeSubmitted.value = myMeal;
      
      }
       
       }
       
       
       
       
       
       
       
       function validate(){
          
           var chosen = document.getElementById("chosen").value;
          
           if(chosen === ""){
               alert("Please Make a Selection");
               return false;
           } else{
               return true;
           }
       }
       
       
       
       
       </script>
       
     
    </head>
    <body>
        <input type="button" id="entry" value="Order" style="width: 100%; height: 40px"/>
        <h1 id="main_heading">My Restaurant</h1>
           
        <div class="container" id="container" style="visibility: hidden">
        
            <div class="span6 offset3">
            
            
            
            
            <% //if no order has been place populate select box with available entrees
                if(request.getAttribute("items")== null){ %>
            
             <div id="heading"><h1 id="heading">Place your order</h1></div>
            
            
            <form id="orderForm" name="orderForm" method="post" action="OnSubmitController" >
            
             <% 
                 HashMap<String, String> selections = (HashMap<String, String>)request.getAttribute("selections");
                 
                 int size = selections.size() + 1;
             out.println("<select name='order' id='order' size='"+size+"'>" + 
                "<option value='' style='font-size:16px;font-weight:bold;text-decoration:underline'>Place Your Order</option>");
              
             
             for(Map.Entry<String, String> selection : selections.entrySet()){   
            out.println("<option value='"+selection.getKey()+"'>"+selection.getKey()+"............$" + selection.getValue()+"</option>");
               }  
                 
            %>
                
            </select>
            
            <textarea id="chosen" cols="10" rows="10"></textarea>
           
            <br>
        
            <input type="submit" class="btn" id="submit_btn" value="Place Order"/>
            <input type="hidden" id="toBeSubmittedItems" name="toBeSubmittedItems" value=""/>
            </form>
            <% } %>
            
            
            </div>
            
            </div>
            
            
            
            
            
            
            
            <div class="container">
                <div class="span6 offset3">
            <% 
                
                //if order has been placed display bill
            if(request.getAttribute("items") != null){ %>
            
             <h1 id="heading">Bill</h1><hr>
            
           <% 
            
            StringBuilder items = (StringBuilder)request.getAttribute("items");
            
            out.println(items);
            
            %>
            <a href="OnPageLoadController" class="btn" id="reorder">Reorder</a>
           <% } %>
            
        </div>
        </div>
           
          
           
    </body>
</html>
