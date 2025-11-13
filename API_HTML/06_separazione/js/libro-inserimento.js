async function salva() {
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

    if (response.ok) {
        alert("STAPPOOOOOO");
        window.location.href = "index.html"
    }
    else {
        alert("ERRORE")
    }
}

async function popola_autori(){
    
    fetch("http://localhost:8082/api/autori")
        .then(risultato => risultato.json())
        .then(dati => {
            for(let [index, item] of dati.entries()){
                console.log(item)

                document.getElementById("input-autore").innerHTML 
                    += `<option value='${item.cod}'>${item.nom}</option>`;
            }
        })
        .catch(errore => {
            console.log(errore);
            // alert("Errore");
        })


}

popola_autori()