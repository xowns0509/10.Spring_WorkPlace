// ������� �ڷ� �Է¿��θ� �˻��ϴ� �Լ�
    function checkUserInput() {
    	if( $.trim($("#userId").val()) == '' ){
            alert("���̵� �Է����ּ���.");
            $("#userId").focus();
            return;
        }
    	
    	if($.trim($('#userPass').val())==''){
    		alert("����Է����ּ���.");
    		$('#userPass').focus();
    		return;
    	}
    	
    	if($.trim($('#userPass').val()) != $.trim($('#userPass2').val())){
    		alert("��й�ȣ�� ��ġ���� �ʽ��ϴ�..");
    		$('#userPass2').focus();
    		return;
    	}
    	
    	
    	if($.trim($('#userName').val())==''){
    		alert("�̸��Է����ּ���.");
    		$('#userName').foucs();
    		return;
    	}
       
        // �ڷḦ �����մϴ�.
        document.userinput.submit();
    }

   
    //���̵� �ߺ�üũ
    function idDuplicateCheck(){
    	// �α��� ���μ��� ȣ��
        $.ajax({
            type: 'post',
            async: true,
            //url:'${pageContext.request.contextPath}/login_chk.do',
            url:'idCheck.do',
            contentType:'application/x-www-form-urlencoded;charset=UTF-8',
           // data: $("#userinput").serialize(),
            data: "userId="+$("#userId").val(),
           
            success:function(resultData){
            	//alert("resultData = "+resultData)
    			$('#idCheckResult').html(resultData);
            	
    		}
        });
    }
	
	
	
	
	
	
	
	
	
	