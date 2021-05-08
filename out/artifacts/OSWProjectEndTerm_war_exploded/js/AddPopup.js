const popup = document.querySelector(".popup");

function openPopUp() {
    setTimeout(function(){ popup.style.display = "flex"; }, 500);
}
function closePopUp() {
    popup.style.display = "none";
}

