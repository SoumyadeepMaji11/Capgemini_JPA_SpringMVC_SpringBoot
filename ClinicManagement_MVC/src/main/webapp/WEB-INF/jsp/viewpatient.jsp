
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

	<h1>Patients List</h1>
	<table border="2" width="70%" cellpadding="2">
	<tr><th>Id</th><th>FName</th><th>LName</th><th>Age</th><th>Gender</th><th>Address</th><th>PhoneNo</th><th>Edit</th><th>Delete</th></tr>
    <c:forEach var="pa" items="${list}"> 
    <tr>
    <td>${pa.id}</td>
    <td>${pa.fname}</td>
    <td>${pa.lname}</td>
    <td>${pa.age}</td>
    <td>${pa.gender}</td>
    <td>${pa.address}</td>
    <td>${pa.pNo}</td>
    <td><a href="editpatient/${pa.id}">Edit</a></td>
    <td><a href="deletepatient/${pa.id}">Delete</a></td>
    </tr>
    </c:forEach>
    </table>
    <br/>
    <a href="patientform">Add New Patients</a>