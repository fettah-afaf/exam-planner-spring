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
		<h3>
			Mise à jour d'un
			<c:if test="${personModel.typePerson== 1}" var="variable">
					Prof
				</c:if>
			<c:if test="${personModel.typePerson== 2}" var="variable">
					Administrateur
				</c:if>



		</h3>
	</div>
	<div>

		<c:if test="${not empty msg}">
			<div class="alert alert-success" role="alert">${msg}</div>
		</c:if>

		<f:form action="${pageContext.request.contextPath}/admin/updatePerson"
			method="POST" modelAttribute="personModel">
			<f:hidden path="idPersonnel" />
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}">

			<f:hidden path="typePerson" />

			<div class="row">
				<div class="col">
					<label>CIN</label>
					<f:input path="cin" type="text" class="form-control"
						placeholder="cin" />
					<f:errors path="cin" class="text-danger" />
				</div>

				<div class="col">
					<label>Nom</label>
					<f:input path="nom" type="text" class="form-control"
						placeholder="nom" />
					<f:errors path="nom" class="text-danger" />
				</div>
			</div>


			<div class="row">
				<div class="col">
					<label>Prénom</label>
					<f:input path="prenom" type="text" class="form-control"
						placeholder="prenom" />
					<f:errors path="prenom" class="text-danger" />
				</div>


			</div>


			<div class="row">
				<div class="col">
					<label>Email</label>
					<f:input path="email" class="form-control" placeholder="Email" />
					<f:errors path="email" class="text-danger" />
				</div>
				<c:if test="${personModel.typePerson == 1}" var="variable">
					<div class="col">
						<label>Spécialité</label>
						<f:input path="specialite" type="text" class="form-control"
							placeholder="Spécialité" />
						<f:errors path="specialite" class="text-danger" />
					</div>
				</c:if>
				<c:if test="${personModel.typePerson== 1}" var="variable">
					<div class="col">
						<label>departement</label>
						<f:input path="departement" type="text" class="form-control"
							placeholder="departement" />
						<f:errors path="departement" class="text-danger" />
					</div>
				</c:if>
				<c:if test="${personModel.typePerson== 1}" var="variable">
					<div class="col">
						<label>filiere</label>
						<f:input path="filiere" type="text" class="form-control"
								 placeholder="filiere" />
						<f:errors path="filiere" class="text-danger" />
					</div>
				</c:if>
				<c:if test="${personModel.typePerson== 3}" var="variable">
					<div class="col">
						<label>profession</label>
						<f:input path="profession" type="text" class="form-control"
							placeholder="profession" />
						<f:errors path="profession" class="text-danger" />
					</div>
				</c:if>

			</div>



			<div class="row">






			</div>
			<div style="text-align: right">
				<button type="submit" class="btn btn-primary">Update</button>
				<button type="reset" class="btn btn-secondary">Rest</button>
			</div>

		</f:form>
	</div>
					</div>
				</div>
			</div>
		</div>


	</section>
</nav>


	<jsp:include page="../fragments/adminfooter.jsp" />