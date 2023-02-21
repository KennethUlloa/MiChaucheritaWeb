let loginForm = document.querySelector("#loginForm");
loginForm.addEventListener('submit', login);

function login(e) {
	e.preventDefault();
	fetch(loginForm.action, {
		method: loginForm.method,
		body: new URLSearchParams(new FormData(loginForm)),
		redirect: "follow"
	})
	.then(response => {
		if(response.status >= 400) {
			return response.json().then(data => {
				return {type:"error", body: data}
			})	
		}else if(response.status <= 300 && response.status < 400) {
			return {type:"redirect", body: response.url}
		}else {
			return {type:"unknown", body:""}
		}
		
	}).then(data => {
		switch(data.type) {
			case "error": alert(data.body.error); break;
			case "redirect": location.href = data.body; break;
		}
	});
}