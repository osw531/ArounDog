<%@page import="com.itbank.common.pager.Pager"%>
<%@page import="com.aroundog.model.domain.Report"%>
<%@page import="com.aroundog.model.domain.FreeBoard"%>
<%@page import="java.util.List"%>
<%@page import="com.aroundog.model.domain.Admin"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%!Pager pager = new Pager();%>
<%
	Admin admin = (Admin) request.getSession().getAttribute("admin");
	List<Report> reportList = (List) request.getAttribute("reportList");
	out.print("받아온 리스트의 개수는" + reportList.size());
	pager.init(request, reportList.size());
%>
<!DOCTYPE html>
<html>
<head>
<title>게시판 관리</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	crossorigin="anonymous">

<style>
<%@ include file ="/admin/inc/maincss.jsp" %> 
#Report {
	background-color: green;
}
</style>
</head>
<script>
	
<%@ include file="/admin/inc/pagechange.jsp" %>
	
</script>
<body>
	<form>
		<div class="loginName" style="text-align: right"><%=admin.getName()%>님
			로그인중
		</div>
		<button class="tablink" type="button">
			<i class="fas fa-user-friends" style="font-size: 20px"></i> 회원관리
		</button>
		<button class="tablink" type="button">
			<i class="fas fa-bullhorn" style="font-size: 20px"></i> 제보관리
		</button>
		<button class="tablink" type="button">
			<i class="far fa-edit" style="font-size: 20px"></i> 입양신청관리
		</button>
		<button class="tablink" type="button">
			<i class="far fa-comment-alt" style="font-size: 20px"></i> 게시판관리
		</button>
		<button class="tablink" type="button">
			<i class="fas fa-dog" style="font-size: 20px"></i> 입양게시물관리
		</button>
	</form>
	<div id="Report" class="tabcontent">
		<!--   <h3>제보관리 게시판</h3>
  <p>세원이꺼</p> -->
		<table>
			<tr>
				<th>No</th>
				<th>내용</th>
				<th>lati</th>
				<th>longi</th>
				<th>이메일</th>
				<th>전화번호</th>
			</tr>
			<%int num = pager.getNum();%>
			<%int curPos = pager.getCurPos();%>
			<%for (int i = 0; i < pager.getPageSize(); i++) {%>
			<%	if (num < 1)	break;%>
			<%	Report report = reportList.get(curPos++);	%>
			<tr>
				<td><%=num--%></td>
		<%-- 		<td>
					<a href="/report/detail?report_id=<%=report.getReport_id()%>"><%=report.get%></a>
				</td> --%>
				<td><%=report.getContent()%></td>
				<td><%=report.getLati()%></td>
				<td><%=report.getLongi()%></td>
				<td><%=report.getEmail()%></td>
				<td><%=report.getPhone()%></td>
			</tr>
			<%}	%>
			<tr>
				<td colspan="5">
					<%for (int i = pager.getFirstPage(); i <= pager.getLastPage(); i++) {%>
						<%if (i > pager.getTotalPage()) break; %>
						 <a href="/reports?currentPage=<%=i%>">[<%=i%>]</a> 
						 <%	} %>
				</td>
			</tr>
		</table>

	</div>
</body>
</html>
