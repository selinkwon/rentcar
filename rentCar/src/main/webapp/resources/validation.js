function checkValues(htmlForm) {

	let url = "join.jsp?";

	const name = document.getElementById("name").value;
	const id = document.getElementById("id").value;
	const password = document.getElementById("password").value;
	const contact = document.getElementById("contact").value;
	const joindate = document.getElementById("joindate").value;

	let check = true;
	
	if (name !== "")
		url += "name=" + name + "&";
		
	if (id)
		url += "id=" + id + "&";
		
	if (password)
		url += "password=" + password + "&";
		
	if (contact)
		url += "contact=" + contact + "&";


	if (joindate)
		url += "joindate=" + joindate + "&";




	if (id === "") {
		alert('아이디가 입력되지 않았습니다.');
		check = false;
	}
	else if (password === "") {
		alert('비밀번호가 입력되지 않았습니다.');
		check = false;
	}

	else if (name === "") {
		alert('회원성명이 입력되지 않았습니다.');
		check = false;
	}
	else if (contact === "") {
		alert('연락처가 입력되지 않았습니다.');
		check = false;
	}
	else if (joindate === "") {
		alert('가입일자가 입력되지 않았습니다.');
		check = false;
	}
	
	if(check === false){
		location.href=url;
	}
	else {
		htmlForm.submit();
	}
}