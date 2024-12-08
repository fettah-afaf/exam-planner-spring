<%@ page import="com.ensah.core.bo.Exam" %>
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
    <h2 class="text-white ms-4 mb-0">Exams</h2>
</div>

<!-- Form for adding a new exam -->
<div class="row pt-lg-5">
<div class="col">
<h3>Add New Exam</h3>
    <f:form action="${pageContext.request.contextPath}/admin/exams/add" method="POST" modelAttribute="newExam">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <div class="row">
        <div class="col">
            <label>Date:</label>
            <f:input path="date" type="date" class="form-control" />
            <f:errors path="date" class="text-danger" />
        </div>
        <div class="col">
            <label>Heure Début:</label>
            <f:input path="heureDebut" type="time" class="form-control" />
            <f:errors path="heureDebut" class="text-danger" />
        </div>
        <div class="col">
            <label>Heure Fin:</label>
            <f:input path="heureFin" type="time" class="form-control" />
            <f:errors path="heureFin" class="text-danger" />
        </div>
    </div>
    <div class="row">
        <div class="col">
            <label>Durée Prévue (minutes):</label>
            <f:input path="duréeprévue" type="number" class="form-control" />
            <f:errors path="duréeprévue" class="text-danger" />
        </div>
        <div class="col">
            <label>Durée Réelle (minutes):</label>
            <f:input path="duréeréelle" type="number" class="form-control" />
            <f:errors path="duréeréelle" class="text-danger" />
        </div>
        <div class="col">
            <label>Type:</label>
            <f:select path="typeExam" class="form-control">
                <f:option value="">Select Type</f:option>
                <f:option value="Devoir surveillé 1">Devoir surveillé 1</f:option>
                <f:option value="Devoir surveillé 2">Devoir surveillé 2</f:option>
            </f:select>
            <f:errors path="typeExam" class="text-danger" />
        </div>
    </div>
    <div class="row">
        <div class="col">
            <label>Semestre:</label>
            <f:select path="semestre" class="form-control">
                <f:option value="printemps">Printemps</f:option>
                <f:option value="automne">Automne</f:option>
            </f:select>
            <f:errors path="semestre" class="text-danger" />
        </div>
        <div class="col">
            <label>Session:</label>
            <f:select path="session" class="form-control">
                <f:option value="normale">Normale</f:option>
                <f:option value="rattrapage">Rattrapage</f:option>
            </f:select>
            <f:errors path="session" class="text-danger" />
        </div>
        <div class="col">
            <label>Année Académique:</label>
            <f:input path="anneeAcademique" type="text" class="form-control" />
            <f:errors path="anneeAcademique" class="text-danger" />
        </div>
    </div>

    <div class="row">
        <div class="col">
            <label>Element Pédagogique:</label>
            <f:select path="elementPedagogique.idElementPedagogique" class="form-control">
                <option value="">Select Element</option>
                <c:forEach var="element" items="${elements}">
                    <option value="${element.idElementPedagogique}">${element.nom}</option>
                </c:forEach>
            </f:select>
            <f:errors path="elementPedagogique.idElementPedagogique" class="text-danger" />
        </div>
    </div>
    <div class="row">
        <div class="col">
            <label>Salles:</label>
            <c:forEach var="salle" items="${salles}">
                <div class="form-check">
                    <input  type="checkbox" name="selectedSalles" value="${salle.id}" id="salle${salle.id}">
                    <label for="salle${salle.id}">
                            ${salle.nameRoom}
                    </label>
                </div>
            </c:forEach>
        </div>
    </div>
    <button type="submit" class="btn btn-primary mt-3">Add Exam</button>
    </f:form>
</div>
</div>
    <!-- List of exams -->
    <div class="row pt-lg-5">
        <div class="col">
            <h3>Exams List</h3>
            <table class="table">
                <thead>
                <tr>
                    <th>date</th>
                    <th>HDebut</th>
                    <th>HFin</th>
                    <th>duréeP</th>
                    <th>duréeR</th>
                    <th>annee</th>
                    <th>type</th>
                    <th>semestre</th>
                    <th>session</th>
                    <th>subject</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="exam" items="${exams}">
                    <tr>
                        <td>${exam.date}</td>
                        <td>${exam.heureDebut}</td>
                        <td>${exam.heureFin}</td>
                        <td>${exam.duréeprévue}</td>
                        <td>${exam.duréeréelle}</td>
                        <td>${exam.anneeAcademique}</td>
                        <td>${exam.typeExam}</td>
                        <td>${exam.semestre}</td>
                        <td>${exam.session}</td>
                        <td>${exam.elementPedagogique.nom}</td>

                        <td>
                            <a href="${pageContext.request.contextPath}/admin/exams/edit/${exam.idExem}">Edit</a>
                            <a href="${pageContext.request.contextPath}/admin/exams/delete/${exam.idExem}">Delete</a>
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
