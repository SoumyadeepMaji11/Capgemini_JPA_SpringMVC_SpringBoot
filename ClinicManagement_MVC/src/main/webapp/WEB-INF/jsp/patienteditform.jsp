
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

		<h1>Edit Patients</h1>
       <form:form method="POST" action="/ClinicManagement_MVC/editsave">  
      	<table >  
      	<tr>
      	<td></td>  
         <td><form:hidden  path="id" /></td>
         </tr> 
        <tr>  
          <td>FName : </td> 
          <td><form:input path="fname"  /></td>
         </tr>  
         <tr>  
          <td>LName :</td>  
          <td><form:input path="lname" /></td>
         </tr> 
         <tr>  
          <td>Age :</td>  
          <td><form:input path="age" /></td>
         </tr> 
         <tr> 
         <tr>  
          <td>Gender :</td>  
          <td><form:input path="gender" /></td>
         </tr> 
         <tr> 
         <tr>  
          <td>Address :</td>  
          <td><form:input path="address" /></td>
         </tr> 
         <tr>  
         <tr>  
          <td>PhoneNo:</td>  
          <td><form:input path="pNo" /></td>
         </tr> 
         <tr> 
         <tr>  
          <td> </td>  
          <td><input type="submit" value="Edit Save" /></td>  
         </tr>  
        </table>  
       </form:form>  
