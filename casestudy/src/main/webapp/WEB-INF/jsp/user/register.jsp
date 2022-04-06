<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

<!-- rewrite this as a case statement using c:choose -->
<c:if test="${empty form.id}">
   <h1>Sign Up</h1>
</c:if>

<c:if test="${not empty form.id}">
    <h1>Edit User</h1>
</c:if>

<form action="/user/registerSubmit"   method="get">
    <input type="hidden" name="id" value="${form.id}">

    Email <input type="text" name="email" id="emailId" value="${form.email}">
    <br>
    First Name <input type="text" name="firstName" id="firstNameId" value="${form.firstName}">
    <br>
    Last Name <input type="text" name="lastName" id="lastNameId" value="${form.lastName}">
    <br>
    Password <input type="text" name="password" id="passwordId"  value="${form.password}">
    <br>
    Confirm Password <input type="text"
             name="confirmPassword" id="confirmPasswordId"  value="${form.confirmPassword}">
    <br>
    Check Box <input type="checkbox" name="checkbox">
    <br>

    <br>
    <button type="submit">Submit</button>
</form>



<jsp:include page="../include/footer.jsp" />

