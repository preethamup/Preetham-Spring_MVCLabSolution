<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
	<head>
		<meta charset="utf-8">
		
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	</head>
	<body>
		<div class="container">
			<h1>Library Management System</h1>
			<hr />
			
			<h2>
				Available list of books
				<a href="/lmsvideo/books/new" class="btn btn-primary btn-sm float-end">Add a book</a>
			</h2>
			<table class="table table-bordered table-striped">
				<thead>
					<tr>
						<th>Name</th>
						<th>Category</th>
						<th>Author</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${books}" var="book">
						<tr>
							<td><c:out value="${book.name}" /></td>
							<td><c:out value="${book.category}" /></td>
							<td><c:out value="${book.author}" /></td>
							<td>
								<a href="/lmsvideo/books/edit?id=${book.id}" class="btn btn-secondary btn-sm">Update</a>
								<a href="/lmsvideo/books/delete?id=${book.id}" class="btn btn-danger btn-sm">Delete</a>
							</td>
						</tr>	
					</c:forEach>
				</tbody>
			</table>
		</div>
		
	</body>
</html>