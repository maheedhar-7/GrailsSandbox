function getConfirmation() {

    var message = confirm("Are you sure you want to delete ?");
    if (message == true) {
        console.log("Activity deleted")
        alert("Activity Deleted!");
        return true;
    } else {
        console.log("activity not deleted")
        return false;
    }

}


function getConfirmationAthleteDelete() {
    console.log("coming to conformation athlete")
    var message = confirm("Are you sure you want to delete ?");
    if (message == true) {
        return true;
    } else {
        console.log("Athlete not deleted")
        return false;
    }

}

function getCodeFromAuthorization() {

}