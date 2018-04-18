function openTab(evt, tabName) {
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
    document.getElementById(tabName).style.display = "block";
    evt.currentTarget.className += " active";
};

function openModal() {
	document.getElementById("editProfileModal").style.display = "block";
};

function closeModal() {
	document.getElementById("editProfileModal").style.display = "none";
};

function selectCourse(courseCode) {
	console.log(courseCode);
};

function openCourseTab(evt) {
	var tabContents, tabLinks, nrCourses, selectedCourse;
	tabContents = document.getElementsByClassName("courseTabContent");
	selectedCourse = evt.currentTarget.id;
	nrCourses = tabContents.length;
	for (i = 0; i < nrCourses; i++) {
		tabContents[i].style.display = "none";
	}
	tablinks = document.getElementsByClassName("courseTablinks");
	for (i = 0; i < nrCourses; i++) {
		tablinks[i].className = tablinks[i].className.replace(" active", "");
	}
	document.getElementById(selectedCourse + "Tab").style.display = "block";
	evt.currentTarget.className += " active";
};