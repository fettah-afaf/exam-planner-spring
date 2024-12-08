<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>



	<div class="container">

		<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<a href="${pageContext.request.contextPath}/admin/showAdminHome" class="navbar-brand mx-auto mx-lg-0">App</a>



		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav ms-lg-5 ">

				<li class="nav-item dropdown" id="personManagementDropdown">
					<a id="personManagementLink" class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Person Management</a>
					<ul id="choiceList" class="choiceList" aria-labelledby="personManagementLink" style="display: none;">
						<li class="dropdown-item"><a class="nav-link" href="${pageContext.request.contextPath}/admin/showForm?typePerson=2">Add Adminstrateur</a></li>
						<li class="dropdown-item"><a class="nav-link" href="${pageContext.request.contextPath}/admin/showForm?typePerson=1">Add Prof</a></li>
						<li class="dropdown-item"><a class="nav-link" href="${pageContext.request.contextPath}/admin/managePersons">Manage Persons </a></li>

					</ul>
				</li>

				<li class="nav-item dropdown">
					<a class="nav-link click-scroll dropdown-toggle" href="${pageContext.request.contextPath}/admin/manageGroups" >Manage Groups</a>
				</li>
				<li class=" nav-item dropdown">
					<a class="nav-link  nav-link dropdown-toggle" href="${pageContext.request.contextPath}/admin/elements">Manage Subject</a>
				</li>
				<li class="nav-item dropdown">
					<a class="nav-link click-scroll dropdown-toggle" href="${pageContext.request.contextPath}/admin/exams"  >Manage Exam</a>
				</li>

				<li class="nav-item dropdown">
				<form
						action="${pageContext.request.contextPath}/admin/serachPerson"
						class="d-flex" method="GET">
					<input name="cin" class="form-control me-2" type="search"
						   placeholder="Saisir CIN" aria-label="Search">
					<button class="btn btn-outline-success" type="submit">Search</button>
				</form>
				</li>
			</ul>


			<div class="d-lg-flex align-items-center d-none ms-auto">

					<f:form
							action="${pageContext.request.contextPath}/logout" method="POST">
						<input type="hidden" name="${_csrf.parameterName}"
							   value="${_csrf.token}">

						<button type="submit" class="custom-btn btn">logout</button>

					</f:form>



			</div>
		</div>

	</div>
</nav>
