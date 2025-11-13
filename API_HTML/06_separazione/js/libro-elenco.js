function elimina(varIsbn) {

    if (varIsbn) {
        fetch(`http://localhost:8082/api/libri/${varIsbn}`, { method: "DELETE" })
            .then(() => {
                alert("STAPPOOOOOOO");
                stampa();
            })
            .catch(errore => {
                alert("PROBLEMA");
                console.log(errore)
            })

        // const response = 
        //     await fetch(`http://localhost:8082/api/libri/${varIsbn}`, { method: "DELETE" });

        // if(response.ok){
        //     alert("STAPPOOOOOOO");
        //     stampa();
        // }
        // else{
        //     alert("PROBLEMA")
        // }
    }

}

// Stampa con Await e Async
async function stampa() {

    const response = await fetch("http://localhost:8082/api/libri");

    if (response.ok) {
        document.getElementById("corpo-tabella").innerHTML = "";
        const payload = await response.json();

        for (let [index, item] of payload.entries()) {
            let contenuto = `
                <tr>
                    <td>${item.isb}</td>
                    <td>${item.tit}</td>
                    <td>${item.ann}</td>
                    <td>${item.pre}</td>
                    <td>
                        <button type="button" 
                            class="btn btn-danger" onclick="elimina('${item.isb}')">
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
    
