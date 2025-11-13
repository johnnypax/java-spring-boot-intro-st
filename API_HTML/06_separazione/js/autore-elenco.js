function elimina(varCodice) {

    if (varCodice) {
        fetch(`http://localhost:8082/api/autori/${varCodice}`, { method: "DELETE" })
            .then(() => {
                alert("STAPPOOOOOOO");
                stampa();
            })
            .catch(errore => {
                alert("PROBLEMA");
                console.log(errore)
            })
    }

}

// Stampa con Await e Async
async function stampa() {

    const response = await fetch("http://localhost:8082/api/autori");

    if (response.ok) {
        document.getElementById("corpo-tabella").innerHTML = "";
        const payload = await response.json();

        for (let [index, item] of payload.entries()) {
            let contenuto = `
                <tr>
                    <td>${item.cod}</td>
                    <td>${item.nom}</td>
                    <td>${item.bio}</td>
                    <td>
                        <button type="button" 
                            class="btn btn-danger" onclick="elimina('${item.cod}')">
                                Elimina
                        </button>
                    </td>
                </tr>
            `

            document.getElementById("corpo-tabella").innerHTML += contenuto;
        }
    }
}

if (document.getElementById("corpo-tabella")){
    stampa();
    setInterval(() => {
        stampa();
    }, 10000)
}
    
