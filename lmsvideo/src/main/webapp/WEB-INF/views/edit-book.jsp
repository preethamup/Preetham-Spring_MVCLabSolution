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
			
			<h2><c:out value="${newBook ? 'Add a new Book' : 'Update book'}" /></h2>
			
			<form action="/lmsvideo/books/save" method="post">
			  <div class="mb-3">
			    <input type="hidden" class="form-control" name="id" value="${book.id}">
			  </div>
			  <div class="mb-3">
			    <label for="name" class="form-label">Name</label>
			    <input type="text" class="form-control" id="name" name="name" value="${book.name}">
			  </div>
			  <div class="mb-3">
			    <label for="author" class="form-label">Author</label>
			    <input type="text" class="form-control" id="author" name="author" value="${book.author}">
			  </div>
			  <div class="mb-3">
			    <label for="category" class="form-label">Category</label>
			    <input type="text" class="form-control" id="category" name="category" value="${book.category}">
			  </div>
			  
			  <button type="submit" class="btn btn-primary">Submit</button>
			  <a href="/lmsvideo/books/list" class="btn btn-danger">Cancel</a>
			</form>
		</div>
		
	</body>
</html>