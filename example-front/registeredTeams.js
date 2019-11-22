window.onload = () => {
	searchTeams(1);
};

showTeams = data => {
	const element = document.getElementById('teams-list');
	data.map(team => {
		element.innerHTML +=
			'<div class="team">' +
			'<h3>' +
			team.name +
			'</h3>' +
			'<input class="add-member" type="text" name="" id="' +
			team.id +
			'" placeholder="Digite o nome do novo membro">' +
			'<button onclick="addMembers(' +
			team.id +
			')">Add Membro</button>' +
			'<ul>' +
			team.memberList.map(member => {
				return '<li>' + member.name + '</li>';
			});

		('</ul></div>');
	});
};

addMembers = idTeam => {
	team = {
		name: document.getElementById(idTeam).value,
		idTeam: idTeam
	};

	saveMember(team);
	location.reload();
};
