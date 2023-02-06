<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
   
    
<body>

  <!-- Content Wrapper. Contains page content -->
  <div >
   
   
	<section class="content-header">
	  	<div class="container-fluid">
	  		<div class="row md-2">
	  			<div class="col-sm-6">
	  				<h1>상세보기</h1>  				
	  			</div>
	  			<div class="col-sm-6">
	  				<ol class="breadcrumb float-sm-right">
			        <li class="breadcrumb-item">
			        	<a href="list.do">
				        	<i class="fa fa-dashboard"></i>공지사항
				        </a>
			        </li>
			        <li class="breadcrumb-item active">
			        	상세보기
			        </li>		        
	    	  </ol>
	  			</div>
	  		</div>
	  	</div>
	</section>
	 
   
      <!-- Main content -->
    <section class="content container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="card card-outline card-info">
					<div class="card-header">
						<h3 class="card-title">상세보기</h3>
						<div class="card-tools">
							<button type="button" id="modifyBtn" class="btn btn-warning" onclick="modify_go();">MODIFY</button>						
						    <button type="button" id="removeBtn" class="btn btn-danger" onclick="remove_go();">REMOVE</button>
						    <button type="button" id="listBtn" class="btn btn-primary" onclick="CloseWindow();">CLOSE</button>
					    </div>
					</div>
					<div class="card-body">
						<div class="form-group col-sm-12">
							<label for="title">제 목</label>
							<span class="form-control" id="title">${notice.title }</span>							
						</div>
						<div class="row">	
							<div class="form-group col-sm-4" >
								<label for="writer">작성자</label>
								<span class="form-control" id="writer">${notice.writer }</span>
							</div>		
							
							<div class="form-group col-sm-4" >
								<label for="regDate">작성일</label>
								<span class="form-control" id="regDate"><fmt:formatDate value="${notice.regDate }" pattern="yyyy-MM-dd" /></span>
							
							</div>
							<div class="form-group col-sm-4" >
								<label for="viewcnt">조회수</label>
								<span class="form-control" id="viewcnt" >${notice.viewcnt }</span>
							</div>
						</div>		
						<div class="form-group col-sm-12">
							<label for="content">내 용</label>
							<div id="content">${notice.content }</div>	
						</div>
												
					</div>													
				</div><!-- end card -->				
			</div><!-- end col-md-12 -->
		</div><!-- end row  -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->   
  
<form role="form">
	<input type="hidden" name="nno" value="${notice.nno }" />
</form>

<script>
var formObj = "";
window.onload=function(){
	formObj = $("form[role='form']");
}

function modify_go(){
	//alert("click modify btn");
	formObj.attr('action','modifyForm.do').submit();
}
function remove_go(){
	//alert("click remove btn");
	var answer = confirm("정말 삭제하시겠습니까?");
	if(answer)	formObj.attr({'action':'remove.do','method':'post'}).submit();
}
</script> 


</body>












    
