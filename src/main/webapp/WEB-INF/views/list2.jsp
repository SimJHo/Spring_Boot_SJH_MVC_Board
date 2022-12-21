<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- C태그 쓰기 위해 넣은 taglib므로 반드시 확인 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
.page{
	text-align: center;
}
</style>
<body>
	<table width="800" border="1">
		<tr>
			<td>번호</td>
			<td>이름</td>
			<td>제목</td>
			<td>날짜</td>
			<td>히트</td>
		</tr>

		<!--이때 list는 BListCommand에서 메모리에 올린 list를 뜻함. 포워딩시까지 살아있으므로-->
		<!--forEach문을 이용해 데이터를 꺼낼 수 있다.-->
		<c:forEach var="board" items="${boards}">
			<tr>
				<td>${board.bid}</td>
				<td>${board.bname}</td>
				<td><c:forEach begin="1" end="${board.bindent}">[Re]</c:forEach>
					<a href="content_view?bid=${board.bid}">${board.btitle}</a> <!--bindent : 가로 (댓글이 보이는 순서 때문에 들어간 것)-->
				</td>
				<td>${board.bdate}</td>
				<td>${board.bhit}</td>
			</tr>
		</c:forEach>

		<tr>
			<td colspan="5"><a href="write_view">글 작성</a></td>
		</tr>

	</table>

	<table width="800" border="1" class="page">
		<td>
			<c:if test="${pageMaker.prev}">
				<a href="list2${pageMaker.makeQuery(pageMaker.startPage - 1) }">«</a>
			</c:if>
		</td>
		<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="idx">
			<td>
				<c:out value="${pageMaker.cri.pageNum == idx?'':''}" />
				<a href="list2${pageMaker.makeQuery(idx)}">${idx}</a>
			</td>
		</c:forEach>
		<td>
			<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
				<a href="list2${pageMaker.makeQuery(pageMaker.endPage +1) }"> » </a>
			</c:if>
		</td>
	</table>
	
 	<form action="search" method="get" id="searchForm" class="search_area">
		<select name="type">
			<option value="" <c:out value="${pageMaker.cri.type == null ? 'selected' : '' }"/>>--</option>
			<option value="T" <c:out value="${pageMaker.cri.type eq 'T' ? 'selected' : '' }"/>>제목</option>
			<option value="C" <c:out value="${pageMaker.cri.type eq 'C' ? 'selected' : '' }"/>>내용</option>
			<option value="N" <c:out value="${pageMaker.cri.type eq 'N' ? 'selected' : '' }"/>>작성자</option>
		</select>
		<input type="text" name="keyword" value='<c:out value="${pageMaker.cri.keyword}"></c:out>'>
		<input type="hidden" name="pageNum" value="1">
		<input type="hidden" name="amount" value="${pageMaker.cri.amount}">
		<button>검색</button>
	</form>


</body>
</html>