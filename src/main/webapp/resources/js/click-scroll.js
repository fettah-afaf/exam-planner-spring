
    document.addEventListener("DOMContentLoaded", function () {
    var personManagementLink = document.getElementById("personManagementLink");
    var choiceList = document.getElementById("choiceList");

    personManagementLink.addEventListener("click", function () {
    choiceList.style.display = (choiceList.style.display === "block") ? "none" : "block";
});
});
