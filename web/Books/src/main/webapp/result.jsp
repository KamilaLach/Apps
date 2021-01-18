<%@ page import ="java.util.*" %>
<!DOCTYPE html>
<html>
<body>
<center>
    <h1>
        Available Books
    </h1>
    <%
        List result= (List) request.getAttribute("books");
        Iterator it = result.iterator();

        while(it.hasNext()){
            out.println(it.next()+"<br><br>");
        }
    %>
</body>
</html>