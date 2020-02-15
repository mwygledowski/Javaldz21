

<form action="/home">
    <c:forEach items="${brands}" var="brand">
    <input type="checkbox" ${selectedBrands.contains(brand)?"checked":""} id="${brand}" name="brand" value="${brand}">
    <label for="${brand}"> ${brand} </label><br>
    </c:forEach>
    <input type="submit" value="Submit">
</form>

