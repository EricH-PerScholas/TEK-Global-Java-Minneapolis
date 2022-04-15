<jsp:include page="include/header.jsp" />

<h1>Product</h1>

<form action="/conversation/conversationSubmit" method="get">

    Name : <input type="text" name="productName">
    <br>
    Description : <input type="text" name="description">
    <br>
    Image URL : <input type="text" name="imageURL">
    <br>
    Price : <input type="text" name="price">

    <button type="submit">Submit</button>
</form>


<jsp:include page="include/footer.jsp" />