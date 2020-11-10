<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    

<script>
	$(document).ready(function(){
		
		// client side에서는 server side 변수나 값을 사용가능
		memberAjax("${param.userid}");

		var userid = "${param.userid}";
		
		$("#upbutton").on("click", function(){
			document.location="/member/memberUpdate?userid="+userid;
		});

		
		$("#profileDownBtn").on("click", function(){
			document.location="/downloadView?userid="+userid;
		});

		

	});

	function memberAjax(userid){
		$.ajax({url : "/member/memberAjax",
			data : {userid : userid},
		    method : "get",
		    success : function(data){
				var member = data.mv;
			    
				$("#profile").attr("src", "${cp}/profileImgView?userid="+userid);
			    $("#profileDownBtn").html("다운로드 : " + member.realfilename);
				$("#userid").html(member.userid);
				$("#usernm").html(member.usernm);
				$("#alias").html(member.alias);
				$("#addr1").html(member.addr1);
				$("#addr2").html(member.addr2);
				$("#zipcode").html(member.zipcode);
				$("#reg_dt").html(member.fmt_reg_dt);
			}
		});
	}
	
</script>


</head>

<body>
	
	<div class="container-fluid">
		<div class="row">
				<form class="form-horizontal" role="form" enctype="multipart/form-data">
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 사진</label>
						<div class="col-sm-10">
							
							<img id="profile" src="${cp}/profileImgView?userid=${mv.userid}" name="realfile"/><br>
							<button id="profileDownBtn" type="button" class="btn btn-default"></button>
							
						</div>
					</div>
					
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 아이디</label>
						<div class="col-sm-10">
							<label id="userid" class="control-label" ></label>
						</div>
					</div>
				
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 이름</label>
						<div class="col-sm-10">
							<label id="usernm" class="control-label" ></label>
						</div>
					</div>
					
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">별명</label>
						<div class="col-sm-10">
							<label id="alias" class="control-label" ></label>
						</div>
					</div>
					
					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">Password</label>
						<div class="col-sm-10">
							<label id="password" class="control-label" >********</label>
						</div>
					</div>
					
					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">주소</label>
						<div class="col-sm-10">
							<label id="addr1" class="control-label" ></label>
						</div>
					</div>
					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">상세주소</label>
						<div class="col-sm-10">
							<label id="addr2" class="control-label" ></label>
						</div>
					</div>
					
					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">우편번호</label>
						<div class="col-sm-10">
							<label id="zipcode" class="control-label" ></label>
						</div>
					</div>
					
					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">등록일자</label>
						<div class="col-sm-10">
							<label id="reg_dt" class="control-label"></label>
						</div>
					</div>
				
					
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="button" id="upbutton" class="btn btn-default">사용자 수정</button>
						</div>
					</div>
				</form>
			</div>
		</div>
</body>
</html>
