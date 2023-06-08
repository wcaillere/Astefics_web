function renderCards() {
    let table = document.getElementById("table");
    let cards = document.getElementById("cards");

    table.style.display = 'none';
    cards.style.display = 'flex';
}

function renderTable() {
    let table = document.getElementById("table");
    let cards = document.getElementById("cards");

    table.style.display = 'block';
    cards.style.display = 'none';
}