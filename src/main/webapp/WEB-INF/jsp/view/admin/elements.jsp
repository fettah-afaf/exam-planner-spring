<%@ page import="com.ensah.core.bo.ElementPedagogique" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags" %>

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
                        <h2 class="text-white ms-4 mb-0">Elements pedagogique</h2>
                    </div>

                    <!-- Form for adding a new element -->
                    <div class="row pt-lg-5">
                        <div class="col">
                            <h3>Add New Element</h3>
                            <f:form action="${pageContext.request.contextPath}/admin/elements/addElement" method="POST" modelAttribute="newElement">
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                                <div class="row">
                                    <div class="col">
                                        <label>Name</label>
                                        <f:input path="nom" type="text" class="form-control" placeholder="Name" />
                                        <f:errors path="nom" class="text-danger" />
                                    </div>
                                    <div class="col">
                                        <label>Niveau</label>
                                        <f:select path="niveau" class="form-control">
                                            <f:option value="">Select Niveau</f:option>
                                            <f:option value="CP1">CP1</f:option>
                                            <f:option value="CP2">CP2</f:option>
                                            <f:option value="CycleIngenieur">Cycle d'Ingenieur</f:option>
                                            <!-- Add more options as needed -->
                                        </f:select>
                                        <f:errors path="niveau" class="text-danger" />
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col">
                                        <label>Type</label>
                                        <f:select path="typeElement" class="form-control">
                                            <f:option value="">Select Type</f:option>
                                            <f:option value="Element">Element</f:option>
                                            <f:option value="Module">Module</f:option>
                                            <!-- Add more options as needed -->
                                        </f:select>
                                        <f:errors path="typeElement" class="text-danger" />
                                    </div>
                                    <div class="col">
                                        <label>Professeur</label>
                                        <select name="professeurId" class="form-control">
                                            <option value="">Select Professeur</option>
                                            <c:forEach var="enseignant" items="${enseignants}">
                                                <option value="${enseignant.idPersonnel}">${enseignant.nom}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="col">
                                        <label>Coordonnateur</label>
                                        <select name="coordonnateurId" class="form-control">
                                            <option value="">Select Coordonnateur</option>
                                            <c:forEach var="enseignant" items="${enseignants}">
                                                <option value="${enseignant.idPersonnel}">${enseignant.nom}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <button type="submit" class="btn btn-primary mt-3">Add Element</button>
                            </f:form>
                        </div>
                    </div>

                    <!-- List of elements -->
                    <div class="row pt-lg-5">
                        <div class="col">
                            <h3>Element List</h3>
                            <table class="table">
                                <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Name</th>
                                    <th>Niveau</th>
                                    <th>Type</th>
                                    <th>Professeur</th>
                                    <th>Coordonnateur</th>
                                    <th>Actions</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="element" items="${elements}">
                                    <tr>
                                        <td>${element.idElementPedagogique}</td>
                                        <td>${element.nom}</td>
                                        <td>${element.niveau}</td>
                                        <td>${element.typeElement}</td>
                                        <td>${element.professeur.nom}</td>
                                        <td>${element.coordonnateur.nom}</td>
                                        <td>
                                            <a href="${pageContext.request.contextPath}/admin/elements/edit/${element.idElementPedagogique}">Edit</a>
                                            <a href="${pageContext.request.contextPath}/admin/elements/delete/${element.idElementPedagogique}">Delete</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</nav>

<jsp:include page="../fragments/adminfooter.jsp" />
