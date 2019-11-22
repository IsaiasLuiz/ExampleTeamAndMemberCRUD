register = () => {
	let team = { name: document.getElementById('team').value };
	registerTeam(team);
};

viewRegisteredTeams = () => {
	window.location = './registeredTeams.html';
};
