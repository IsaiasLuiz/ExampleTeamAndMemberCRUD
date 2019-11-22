const HTTP = 'http://localhost:8080';

registerTeam = team => {
	teamSend = JSON.stringify(team);
	const object = {
		method: 'POST',
		body: teamSend,
		headers: { 'Content-Type': 'application/json' }
	};

	const request = new Request(`${HTTP}/team`, object);

	fetch(request).then(res =>
		res.status == 201 ? alert('Time Salvo') : alert('Erro na requisição')
	);
};

searchTeams = page => {
	const object = {
		method: 'GET',
		headers: { 'Content-Type': 'application/json' }
	};

	const request = new Request(`${HTTP}/team?page=${page}`, object);

	fetch(request)
		.then(res => res.json())
		.then(res => showTeams(res))
		.catch(res => alert('Erro na requisição'));
};

saveMember = member => {
	member = JSON.stringify(member);
	object = {
		method: 'POST',
		body: member,
		headers: { 'Content-Type': 'application/json' }
	};
	const request = new Request(`${HTTP}/member`, object);

	fetch(request).then(res =>
		res.status == 201 ? alert('Membro Salvo') : alert('Erro na requisição')
	);
};
