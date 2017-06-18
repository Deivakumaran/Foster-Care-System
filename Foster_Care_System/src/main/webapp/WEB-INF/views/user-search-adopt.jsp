<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Home</title>

<script>
            function validate(){
                var query = document.forms["myForm"]["query"].value;   
                
                var queryType = document.forms["myForm"]["searchType"].value; 
                if (query == "") {
                    alert("Please enter the search query");
                    return false;
                }
                else if (queryType == "") {
                    alert("Please enter the search type query");
                    return false;
                }
                
            }
        </script>
        
        <script>
        $(function(){
            $("#example_0, #example_1").change(function(){
                $("#field1, #field2").val("").attr("readonly",true);
                if($("#example_0").is(":checked")){
                    $("#field1").removeAttr("readonly");
                    $("#field1").focus();
                }
                else if($("#example_1").is(":checked")){
                    $("#field2").removeAttr("readonly");
                    $("#field2").focus();   
                }
            });
        });
        </script>
</head>
<body>

<h1>Hi, ${user.firstname}</h1>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>


  <form id='form' name='myForm'  method="post" onsubmit="return validate()" action="movie/movieSearch.htm" >
               
                <br />
                <br />                 
                Enter Keyword for Orphan Search <input type="text" name="query"/> <br/><br/>
                <input type="radio" name="searchType" id="example_0" value=""/> Search By Name
                <input type="radio" name="searchType" id="example_1"value=""/> Search By Age
                
               
      <li>
      <div class='conlabel'>If Yes, then:</div>
          <input type="text" name="field1" id="field1" placeholder="" />
  </li><br>
      <div class='conlabel'>If No, then:</div>
          <input type="text" name="field2" id="field2" placeholder="" />
  </li><br>
  <br>
                <br/><input type="submit" value="SEARCH"/>
            </form>

</body>
</html>