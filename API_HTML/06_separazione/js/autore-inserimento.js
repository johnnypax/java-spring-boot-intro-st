async function salva() {
    let codice = document.getElementById("input-codice").value;
    let nome = document.getElementById("input-nome").value;
    let biografia = document.getElementById("input-biografia").value;

    let autore = {
        cod: codice,
        nom: nome,
        bio: biografia,
    }
    
    const response = await fetch("http://localhost:8082/api/autori", {
        method: "POST",
        body: JSON.stringify(autore),
        headers: {
            "Content-Type": "application/json"
        }
    });

    if (response.ok) {
        alert("STAPPOOOOOO");
        window.location.href = "autore-elenco.html"
    }
    else {
        alert("ERRORE")
    }
}