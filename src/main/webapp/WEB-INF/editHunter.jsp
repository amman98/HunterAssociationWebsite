<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Hunter</title>
</head>
<body>
	<h3>Edit Hunter</h3>
	
	<form method="POST" action="${pageContext.request.contextPath}/editHunter">
		<table border="0">
            <tr>
               <td>First Name</td>
               <td><input type="text" name="firstName" value="${hunter.firstName}"/></td>
            </tr>
            <tr>
               <td>Last Name</td>
               <td><input type="text" name="lastName" value="${hunter.lastName}"/></td>
            </tr>
			<tr>
               <td>Nen Affinity</td>
               <td><select name="nenAffinity">
               <option value="Unknown">Unknown</option>
               <option value="Enhancer">Enhancer</option>
               <option value="Emitter">Emitter</option>
               <option value="Transmuter">Transmuter</option>
               <option value="Manipulator">Manipulator</option>
               <option value="Conjurer">Conjurer</option>
               <option value="Specialist">Specialist</option>
               
               </select></td>
            </tr>
			<tr>
               <td>Occupation</td>
               <td><input type="text" name="occupation" value="${hunter.occupation}" /></td>
            </tr>
            
            <tr>
               <td>Status</td>
               <td>
               <input type="radio" name="status" value="Unknown">Unknown
               <input type="radio" name="status" value="Alive">Alive
               <input type="radio" name="status" value="Deceased">Deceased
               </td>
            </tr>
            
            <tr>
               <td>Description</td>
               <td><input type="text" name="description" value="${hunter.description}" /></td>
            </tr>
            <tr>
               <td colspan="2">                   
                   <input type="submit" value="Submit" />
                   <a href="currentHunters">Cancel</a>
               </td>
            </tr>
         </table>
	</form>
</body>
</html>