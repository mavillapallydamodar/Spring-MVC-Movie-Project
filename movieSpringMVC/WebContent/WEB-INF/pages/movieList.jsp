<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Movie List</title>
</head>
<body>

<h1>Movie currently in the database</h1>
	<table>
	<c:forEach var="movie" items="${movies}">
	<tr>
		<td>${movie.title}</td>
		<td>${movie.year}</td>
		<td>${movie.summary}</td>
		<td>${movie.rated}</td>
		<td>${movie.genre}</td>
		<td><a href="movie/${movie.movieId}">edit</a></td>
	</tr>
	</c:forEach>
	</table>
	
	<a href="addMovie.html"> Add a Movie</a>
</body>
</html>