
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 

<html>
<head><title></title></head>
<link href="../boardstyle/stylecss.css" rel="stylesheet" type="text/css" >
<script src="../boardstyle/board.js"></script>
<body>
<center>
<table border="1" cellpadding="0" cellspacing="0" width="600">
 <caption><h1 style="background:pink">글 내 용 보 기</h1></caption>
  <tr height="30" align="center">
  <td width="100">글번호</td>
  <td width="200">${model.b_id }</td>
  <td width="100">조회수</td>
  <td width="200">${model.b_count }</td>
  </tr>
  
  <tr height="30"  align="center">
  <td width="100">작성자</td>
  <td width="200"> ${model.b_name } </td>
  <td width="100">작성일</td>
  <td width="200">${model.b_date}</td>
  </tr>
  
  <tr height="30">
  <td width="100" align="center">글제목</td>
  <td colspan="3">${model.b_title }&nbsp; </td>
  </tr>
  
  <tr height="25">
  <td width="100"  align="center">글내용</td>
  <td colspan="3"><pre>${model.b_content }</pre></td>
  </tr> 
  
   <tr height="30">
  <td width="100" align="center">첨부파일</td>
  <td colspan="3"> 
    <img src="../img/disk.gif">
    <a href="down.do?path=d:/upLoadSave/${model.b_fname}">
    	${model.b_fname }
    </a>
    ( <fmt:formatNumber value="${model.b_fsize}" />byte)
   </td>
  </tr>
      
  <tr height="30">
  <td colspan="4" align="right">
  <input type="button" value="글수정" 
    onclick="move_Action('edit.do')">
    &nbsp;&nbsp;&nbsp;&nbsp;
  <input type="button" value="글삭제" 
    onclick="move_Action('delete.do')">
    &nbsp;&nbsp;&nbsp;&nbsp;  
  <input type="button" value="글목록" 
    onclick="move_Action('list.do')"/>&nbsp;
  </td>
  </tr>
</table>

<!-- 수정/삭제/답변/목록으로  이동할때 가지고 갈 Form -->
<form name="move"  method="post">
  <input type="hidden" name="b_id" value="${param.b_id}"/>
</form>


</body>
</html>



