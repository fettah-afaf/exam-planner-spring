<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags"%>


<jsp:include page="../fragments/adminHeader.jsp" />


<nav class="container">

	<nav class="navbar navbar-expand-lg" style="background-color: #535da1">

		<jsp:include page="../fragments/menu.jsp" />
	</nav>
	<section class="services section-padding" id="section_3" >
		<div class="container" >
			<div class="row">

				<div class="col-lg-10 col-12 mx-auto">
					<div class="section-title-wrap d-flex justify-content-center align-items-center mb-5">
						<h2 class="text-white ms-4 mb-0">Ajout</h2>
					</div>

					<div class="row pt-lg-5">


	<div>
		<h3>List of Persons</h3>
	</div>

	<div>




			
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Type</th>
					<th scope="col">CIN</th>
					<th scope="col">Nom</th>
					<th scope="col">Prénom</th>
					<th scope="col">Email</th>
					<th scope="col">Specialite</th>
					<th scope="col">Departement</th>
					<th scope="col">Filiere</th>
					<th scope="col">Profession</th>
					<th>Actions</th>
				</tr>
			</thead>

			<c:forEach items="${personList}" var="p">
				<tr>

					<td><c:if test="${p.typePerson== 1}" var="variable">
							<span class="badge bg-primary">Prof</span>
						</c:if> <c:if test="${p.typePerson==2}" var="variable">
							<span class="badge bg-success">Administrateur</span>
						</c:if> </td>
					<td><c:out value="${p.cin}" /></td>
					<td><c:out value="${p.nom} " /></td>
					<td><c:out value="${p.prenom}" /></td>
					<td><c:out value="${p.email}" /></td>
					<td><c:out value="${p.specialite}" /></td>
					<td><c:out value="${p.departement}" /></td>
					<td><c:out value="${p.filiere}" /></td>
					<td><c:out value="${p.profession}" /></td>


					<td>
						<ul>
							<li><a
								href="${pageContext.request.contextPath}/admin/deletePerson/${p.idPersonnel}">Delete</a></li>

							<li><a
								href="${pageContext.request.contextPath}/admin/updatePersonForm/${p.idPersonnel}">Update</a></li>


						</ul>
					</td>

				</tr>

			</c:forEach>

		</table>
	</div>
</div>
</div>
</div>
</div>

</section>
</nav>
	
	<jsp:include page="../fragments/adminfooter.jsp" />