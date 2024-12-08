<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags"%>


<jsp:include page="../fragments/adminHeader.jsp" />


<nav class="container">

	<nav class="navbar navbar-expand-lg" style="background-color: #535da1">

			<jsp:include page="../fragments/menu.jsp" />
	</nav>




	<section class="hero d-flex justify-content-center align-items-center" id="section_1">
		<div class="container">
			<div class="row">

				<div class="col-lg-7 col-12">
					<div class="hero-text">
						<div class="hero-title-wrap d-flex align-items-center mb-4">
							<img src="${pageContext.request.contextPath}/resources/img/admin2.png" class="avatar-image avatar-image-large img-fluid" alt="">

							<h1 class="hero-title ms-3 mb-0"> Administration home page</h1>
						</div>
						<s:authorize access="isAuthenticated()">
							You are connected with:
							<s:authentication property="principal.username" />
							<br>
							Your Email : <s:authentication property="principal.email" />
							<br>
							Your First Name : <s:authentication property="principal.firstName" />
							<br>
							Your Last name : <s:authentication property="principal.LastName" />
							<br>
						</s:authorize>
							<br>
							idPersonne :   ${userInfos.idPersonne}
						    <br>
							idCompte :   ${userInfos.idCompte}
						<br>



					</div>
				</div>

				<div class="col-lg-5 col-12 position-relative">
					<div class="hero-image-wrap"></div>
					<img src="${pageContext.request.contextPath}/resources/img/portrait-happy-excited-man-holding-laptop-computer.png" class="hero-image img-fluid  w-25 small-image" alt="">
				</div>

			</div>
		</div>

		<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 1440 320"><path fill="#535da1" fill-opacity="1" d="M0,160L24,160C48,160,96,160,144,138.7C192,117,240,75,288,64C336,53,384,75,432,106.7C480,139,528,181,576,208C624,235,672,245,720,240C768,235,816,213,864,186.7C912,160,960,128,1008,133.3C1056,139,1104,181,1152,202.7C1200,224,1248,224,1296,197.3C1344,171,1392,117,1416,90.7L1440,64L1440,0L1416,0C1392,0,1344,0,1296,0C1248,0,1200,0,1152,0C1104,0,1056,0,1008,0C960,0,912,0,864,0C816,0,768,0,720,0C672,0,624,0,576,0C528,0,480,0,432,0C384,0,336,0,288,0C240,0,192,0,144,0C96,0,48,0,24,0L0,0Z"></path></svg>
	</section>



</nav>



<jsp:include page="../fragments/adminfooter.jsp" />

