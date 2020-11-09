<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    

<script>
	$(document).ready(function(){
		$("#upbutton").on("click", function(){
			document.location="/member/memberUpdate?userid=${mv.userid}";
		});

		
		$("#profileDownBtn").on("click", function(){
			document.location="/downloadView?userid=${mv.userid}";
		});

	});
</script>

<div class="row">
	tiles : memberContent.jsp

				<form class="form-horizontal" role="form" enctype="multipart/form-data">
<!-- 					<div class="form-group"> -->
<!-- 						<label for="userNm" class="col-sm-2 control-label">사용자 아이디</label> -->
<!-- 						<div class="col-sm-10"> -->
<!-- 							<input type="text" class="form-control" id="userId" name="userId" -->
<!-- 								placeholder="사용자 아이디"> -->
<!-- 						</div> -->
<!-- 					</div> -->

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 사진</label>
						<div class="col-sm-10">
<%-- 							<img src="${cp}/profile/${mv.filename}"/> --%>
							
							<img src="${cp}/profileImgView?userid=${mv.userid}" name="realfile"/><br>
							<button id="profileDownBtn" type="button" class="btn btn-default">다운로드 : ${mv.realfilename}</button>
							
						</div>
					</div>
					
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 아이디</label>
						<div class="col-sm-10">
							<label class="control-label" >${mv.userid}</label>
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 이름</label>
						<div class="col-sm-10">
							<label class="control-label" >${mv.usernm}</label>
						</div>
					</div>
					
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">별명</label>
						<div class="col-sm-10">
							<label class="control-label" >${mv.alias}</label>
						</div>
					</div>
					
					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">Password</label>
						<div class="col-sm-10">
							<label class="control-label" >********</label>
						</div>
					</div>
					
					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">주소</label>
						<div class="col-sm-10">
							<label class="control-label" >${mv.addr1}</label>
						</div>
					</div>
					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">상세주소</label>
						<div class="col-sm-10">
							<label class="control-label" >${mv.addr2}</label>
						</div>
					</div>
					
					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">우편번호</label>
						<div class="col-sm-10">
							<label class="control-label" >${mv.zipcode}</label>
						</div>
					</div>
					
					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">등록일자</label>
						<div class="col-sm-10">
							<label class="control-label"><fmt:formatDate value="${mv.reg_dt }" pattern="yyyy-MM-dd"/></label>
						</div>
					</div>

					
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="button" id="upbutton" class="btn btn-default">사용자 수정</button>
						</div>
					</div>
				</form>
			</div>
</html>