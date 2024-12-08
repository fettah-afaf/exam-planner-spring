<%@ page import="com.ensah.core.bo.Groupe" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
                        <h2 class="text-white ms-4 mb-0">Groups</h2>
                    </div>

                    <!-- Form for adding a new group -->
                    <div class="row pt-lg-5">
                        <div class="col">
                            <h3>Add New Group</h3>
                            <f:form action="${pageContext.request.contextPath}/admin/addGroup" method="POST" modelAttribute="newGroup">
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                                <div class="form-group">
                                    <label for="title">Group Name</label>
                                    <f:input path="title" id="title" type="text" class="form-control" />
                                    <f:errors path="title" class="text-danger" />
                                </div>
                                <button type="submit" class="btn btn-primary">Add Group</button>
                            </f:form>
                        </div>

                        <div>
                            <h3>Group List</h3>
                            <table class="table">
                                <thead>
                                <tr>
                                    <th scope="col">Name</th>
                                    <th>Actions</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="group" items="${groupList}">
                                    <tr>
                                        <td><c:out value="${group.title}" /></td>
                                        <td>
                                            <ul>
                                                <li>
                                                    <a href="${pageContext.request.contextPath}/admin/updateGroupName/${group.idGroupe}">edit</a></li>
                                                <li>
                                                    <a href="${pageContext.request.contextPath}/admin/deleteGroup/${group.idGroupe}">Delete Group</a></li>
                                                <li>
                                                    <a href="${pageContext.request.contextPath}/admin/addProfGroupe/${group.idGroupe}">Add Prof</a></li>


                                            </ul>
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
