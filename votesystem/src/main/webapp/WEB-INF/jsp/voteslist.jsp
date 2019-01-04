<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>联系人列表</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/my.js"></script>
<SCRIPT language=javascript>
	function dosavepiao(s){
		$.ajax({
			url:'votestart?id='+s,
			success:function(mobile){
				alert("投票成功");
				location.href="votelist";
			}
		})
	}
	function rest(){
		location.href="voteresrt";
	}
	
	function doadd(){
		window.open('goAdd','_self');
	}
</SCRIPT>

<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
		
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_019.jpg"
						border=0></TD>
					<TD width="100%" background="${pageContext.request.contextPath }/images/new_020.jpg"
						height=20></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_021.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15 background="${pageContext.request.contextPath }/images/new_022.jpg"><IMG
						src="${pageContext.request.contextPath }/images/new_022.jpg" border=0></TD>
					<TD vAlign=top width="100%" bgColor=#ffffff>
						<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
							<TR>
								<TD class=manageHead>当前位置：投票列表
								</TD>
								<TD>
								<a href="${pageContext.request.contextPath}/login" target="right">退出</a>
								</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						<TABLE borderColor=#cccccc cellSpacing=0 cellPadding=0
							width="100%" align=center border=0>
							<TBODY>
								<TR>
									<TD height=25>
										<TABLE cellSpacing=0 cellPadding=2 border=0>
											<TBODY>
												<FORM id="customerForm" name="customerForm"
								action="${pageContext.request.contextPath }/votelist"
								 method=post>
													<TR>
														<TD>候选人名称：</TD>
														<TD><INPUT class=textbox id=sChannel2
															style="WIDTH: 80px" maxLength=50 name="name" value="${param.name}" ></TD>
														<TD>机构名称：</TD>
														<TD><INPUT class=textbox id=sChannel2
															style="WIDTH: 80px" maxLength=50 name="orgName" value="${param.orgName}" ></TD>
														
														<TD><INPUT class=button id=sButton2 type=submit
															value="筛选 " name=sButton2></TD>
														<TD><input type="button" value="重置" onclick="rest()"></TD>
														<c:if test="${role == 'admin'}">
															<TD><input type="button" value="添加一位候选人" onclick="doadd()" ></TD>
														</c:if>
													</TR>
												</FORM>
											</TBODY>
										</TABLE>
									</TD>
								</TR>
							    
								<TR>
									<TD>
										<TABLE id=grid
											style="BORDER-TOP-WIDTH: 0px; FONT-WEIGHT: normal; BORDER-LEFT-WIDTH: 0px; BORDER-LEFT-COLOR: #cccccc; BORDER-BOTTOM-WIDTH: 0px; BORDER-BOTTOM-COLOR: #cccccc; WIDTH: 100%; BORDER-TOP-COLOR: #cccccc; FONT-STYLE: normal; BACKGROUND-COLOR: #cccccc; BORDER-RIGHT-WIDTH: 0px; TEXT-DECORATION: none; BORDER-RIGHT-COLOR: #cccccc"
											cellSpacing=1 cellPadding=2 rules=all border=0>
											<TBODY>
												<TR
													style="FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
													<TD>候选人姓名</TD>
													<TD>候选人票数</TD>
													<TD>参与日期</TD>
													<TD>机构名称</TD>
													<TD>操作</TD>
												</TR>
												<c:forEach items="${list}" var="m">
												<TR
													style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
													<TD>${m.name}</TD>
													<TD>${m.voteNumber}</TD>
													<TD>${m.createTime}</TD>
													<TD>${m.orgName}</TD>
													<TD>
													
													<a href="${pageContext.request.contextPath }/votestart?id=${m.id}">投票</a>
													<%-- <input type="button" value="投票" onclick="dosavepiao(${m.id})"  > --%>
													&nbsp;&nbsp;
													<c:if test="${role == 'admin'}">
															<a href="${pageContext.request.contextPath }/votequery?id=${m.id}">修改</a>
													</c:if>
													&nbsp;&nbsp;
													<c:if test="${role == 'admin'}">
															<a href="${pageContext.request.contextPath }/votedelete?id=${m.id}">删除</a>
													</c:if>
													</TD>
												</TR>
												
												</c:forEach>

											</TBODY>
										</TABLE>
									</TD>
								</TR>
							</TBODY>
						</TABLE>
					</TD>
					<TD width=15 background="${pageContext.request.contextPath }/images/new_023.jpg"><IMG
						src="${pageContext.request.contextPath }/images/new_023.jpg" border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_024.jpg"
						border=0></TD>
					<TD align=middle width="100%"
						background="${pageContext.request.contextPath }/images/new_025.jpg" height=15></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_026.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
</BODY>
</HTML>
