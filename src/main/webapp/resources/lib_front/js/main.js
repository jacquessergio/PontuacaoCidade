

function getPontuacao(nome, estado) {
	var data = {
		'Nome' : '' + nome + '',
		'Estado' : '' + estado + ''
	};

	$.ajax({
		type : "POST",
		url : window.location + "/Pontuacao",
		dataType : "json",
		data : data,
	
		//Retorna Pontuação em forma de alerta;

		success : function(result) {
			alert("Pontua\u00e7\u00e4o da Cidade de "+nome+"  \u00e9: " + result);
		}

		
	}).done(function() {
		console.log("success");

	}).fail(function() {
		console.log("error");
	});



}

