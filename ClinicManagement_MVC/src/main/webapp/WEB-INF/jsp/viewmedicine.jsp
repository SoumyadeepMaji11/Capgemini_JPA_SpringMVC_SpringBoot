<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

	<h1>Medicine List</h1>
	<table border="2" width="70%" cellpadding="2">
	<tr><th>Id</th><th>Name</th><th>Price</th></tr>
    <c:forEach var="me" items="${list}"> 
    <tr>
    <td>${me.id}</td>
    <td>${me.name}</td>
    <td>${me.price}</td>
    <td><a href="meditmedicine/${me.id}">Edit</a></td>
    <td><a href="mdeletemedicine/${me.id}">Delete</a></td>
    </tr>
    </c:forEach>
    </table>
    <br/>
    <a href="medicineform">Add New Medicines</a>