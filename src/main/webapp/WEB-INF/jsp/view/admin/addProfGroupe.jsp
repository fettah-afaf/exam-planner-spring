<%@ page import="com.ensah.core.bo.Groupe" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags"%>

<jsp:include page="../fragments/adminHeader.jsp" />

<nav class="container">
    <nav class="navbar navbar-expand-lg" style="background-color: #535da1">
        <jsp:include page="../fragments/menu.jsp" />
    </nav>

    <section class="services section-padding" id="section_3">
        <div class="container">
            <div class="row">
                <div class="col-lg-10 col-12 mx-auto">
                    <div class="section-title-wrap d-flex justify-content-center align-items-center mb-5">
                        <h2 class="text-white ms-4 mb-0">Group Details</h2>
                    </div>

                    <div class="row pt-lg-5">
                        <div>
                            <c:if test="${not empty error}">
                                <div class="alert alert-danger">${error}</div>
                            </c:if>

                            <c:if test="${not empty group}">
                                <h3>Edit Group Name</h3>
                                <f:form action="${pageContext.request.contextPath}/admin/updateGroupName" method="POST" modelAttribute="group">
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                                    <div class="form-group">
                                        <label for="groupName">Group Name</label>
                                        <input type="text" id="groupName" name="title" class="form-control" value="${group.title}" />
                                        <f:hidden path="idGroupe" />
                                    </div>
                                    <button type="submit" class="btn btn-primary">Update Group Name</button>
                                </f:form>

                                <h3>Enseignants</h3>
                                <table class="table">
                                    <thead>
                                    <tr>
                                        <th scope="col">CIN</th>
                                        <th scope="col">Nom</th>
                                        <th scope="col">Prénom</th>
                                        <th scope="col">Email</th>
                                        <th scope="col">Speciality</th>
                                        <th scope="col">Department</th>
                                        <th scope="col">Filiere</th>
                                        <th scope="col">Action</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="enseignant" items="${allEnseignants}">
                                        <tr>
                                            <td><c:out value="${enseignant.cin}" /></td>
                                            <td><c:out value="${enseignant.nom}" /></td>
                                            <td><c:out value="${enseignant.prenom}" /></td>
                                            <td><c:out value="${enseignant.email}" /></td>
                                            <td><c:out value="${enseignant.specialite}" /></td>
                                            <td><c:out value="${enseignant.departement}" /></td>
                                            <td><c:out value="${enseignant.filiere}" /></td>
                                            <td><a href="${pageContext.request.contextPath}/admin/addProf/${enseignant.idPersonnel}?idGroupe=${group.idGroupe}">add to group</a></td>

                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </c:if>

                            <a href="${pageContext.request.contextPath}/admin/manageGroups" class="btn btn-primary">Back to Groups List</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</nav>

<jsp:include page="../fragments/adminfooter.jsp" />
