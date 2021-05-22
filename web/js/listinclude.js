// fetch API
function list(name) {
    fetch(name).then(function(response) {
        response.text().then(function(text) {
            document.querySelector('#listinclude').innerHTML = text;
        })
    })
}