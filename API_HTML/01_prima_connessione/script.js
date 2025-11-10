async function salva(){
    let isbn = document.getElementById("input-isbn").value;
    let titolo = document.getElementById("input-titolo").value;
    let anno = document.getElementById("input-anno").value;
    let prezzo = document.getElementById("input-prezzo").value;
    let autore = document.getElementById("input-autore").value;

    let libro = {
        tit: titolo,
        isb: isbn,
        ann: anno,
        pre: prezzo,
        aut: {
            cod: autore
        }
    }

    const response = await fetch("http://localhost:8082/api/libri", {
        method: "POST",
        body: JSON.stringify(libro),
        headers: {
            "Content-Type": "application/json"
        }
    });

    if(response.ok){
        alert("STAPPOOOOOO");
        stampa();
    }
    else{
        alert("ERRORE")
    }
}


async function stampa() {
    const response = await fetch("http://localhost:8082/api/libri");

    if (response.ok) {
        document.getElementById("corpo-tabella").innerHTML = "";
        const payload = await response.json();

        for(let [index, item] of payload.entries()){
            let contenuto = `
                <tr>
                    <td>${item.isb}</td>
                    <td>${item.tit}</td>
                    <td>${item.ann}</td>
                    <td>${item.pre}</td>
                </tr>
            `

            document.getElementById("corpo-tabella").innerHTML += contenuto;
        }
    }
}

stampa();