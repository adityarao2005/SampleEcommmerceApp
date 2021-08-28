<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav aria-label="...">
	<ul class="pagination">
		<c:choose>
			<c:when test="${page == 1 && lastPageNumber > 2}">
				<li class="page-item disabled"><a class="page-link" href="#"
					tabindex="-1" aria-disabled="true">Previous</a></li>
				<li class="page-item active" aria-current="page"><a
					class="page-link" href="products?page=1">1</a></li>
				<li class="page-item"><a class="page-link" href="products?page=2">2</a></li>
				<li class="page-item"><a class="page-link" href="products?page=3">3</a></li>
				<li class="page-item"><a class="page-link" href="products?page=${page + 1}">Next</a></li>
			</c:when>
			<c:when test="${page == lastPageNumber && lastPageNumber > 2}">
				<li class="page-item"><a class="page-link" href="products?page=${page - 1}">Previous</a></li>
				<li class="page-item"><a class="page-link" href="products?page=${page - 2}">${lastPageNumber - 2}</a></li>
				<li class="page-item"><a class="page-link" href="products?page=${page - 1}">${lastPageNumber - 1}</a></li>
				<li class="page-item active" aria-current="page"><span
					class="page-link"> ${lastPageNumber} <span class="sr-only">(current)</span>
				</span></li>
				<li class="page-item disabled"><a class="page-link" href="#"
					tabindex="-1" aria-disabled="true">Next</a></li>
			</c:when>
			<c:when test="${page == 1 && lastPageNumber > 1}">
				<li class="page-item disabled"><a class="page-link" href="#"
					tabindex="-1" aria-disabled="true">Previous</a></li>
				<li class="page-item active" aria-current="page"><a
					class="page-link" href="products?page=1">1</a></li>
				<li class="page-item"><a class="page-link" href="products?page=2">2</a></li>
				<li class="page-item"><a class="page-link" href="products?page=${page + 1}">Next</a></li>
			</c:when>
			<c:when test="${page == lastPageNumber && lastPageNumber > 1}">
				<li class="page-item"><a class="page-link" href="products?page=${page - 1}">Previous</a></li>
				<li class="page-item"><a class="page-link" href="products?page=${page - 1}">${lastPageNumber - 1}</a></li>
				<li class="page-item active" aria-current="page"><span
					class="page-link"> ${lastPageNumber} <span class="sr-only">(current)</span>
				</span></li>
				<li class="page-item disabled"><a class="page-link" href="#"
					tabindex="-1" aria-disabled="true">Next</a></li>
			</c:when>
			<c:when test="${page == lastPageNumber}">
				<li class="page-item disabled"><a class="page-link" href="#"
					tabindex="-1" aria-disabled="true">Previous</a></li>
				<li class="page-item active" aria-current="page"><span
					class="page-link"> ${lastPageNumber} <span class="sr-only">(current)</span>
				</span></li>
				<li class="page-item disabled"><a class="page-link" href="#"
					tabindex="-1" aria-disabled="true">Next</a></li>
			</c:when>
			<c:otherwise>
				<li class="page-item"><a class="page-link" href="products?page=${page - 1}">Previous</a></li>
				<li class="page-item"><a class="page-link" href="products?page=${page - 1}">${page - 1}</a></li>
				<li class="page-item active" aria-current="page"><a
					class="page-link" href="products?page=1">1</a></li>
				<li class="page-item"><a class="page-link" href="products?page=${page + 1}">${page + 1}</a></li>
				<li class="page-item"><a class="page-link" href="products?page=${page + 1}">Next</a></li>
			</c:otherwise>
		</c:choose>
	</ul>
</nav>