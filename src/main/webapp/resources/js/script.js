function showForm() {
	let elemento = document.getElementById("modal");
	elemento.style.visibility = "visible";
	elemento.style.opacity = "1";
}

function closeForm() {
	let elemento = document.getElementById("modal");
	elemento.style.visibility = "hidden";
	elemento.style.opacity = "0";
}

function closeFormOut(event) {
	let x = event.clientX;
	let y = event.clientY;

	dialogPos = document.getElementById("modal-dialog").getBoundingClientRect();

	if ((x < dialogPos.left || x > dialogPos.right) || (y < dialogPos.top || y > dialogPos.bottom)) {
		let elemento = document.getElementById("modal");
		elemento.style.visibility = "hidden";
		elemento.style.opacity = "0";
	}
}
