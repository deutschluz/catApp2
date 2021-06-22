
function getData() {

    let url = 'http://localhost:8080/CatApp2/cats';

    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = receiveData;

    xhttp.open('GET', url, true);

    xhttp.send();

    function receiveData() {

        if (xhttp.readyState == 4) {
            if (xhttp.status == 200) {

                let res = xhttp.responseText;
                
                
                let res = xhttp.responseText;
                console.log(res);

                res = JSON.parse(res);
                console.log(res);
                // Create table
                let catTable = document.createElement('table');
                catTable.id = 'catTable';
                // Create header
                let tHead = document.createElement('tr');
                catTable.appendChild(tHead);
                let headers = ['Name', 'Age', 'Breed'];

                for (let h of headers) {
                    let th = document.createElement('th');
                    th.innerHTML = h;
                    tHead.appendChild(th);
                }

                
                // Iterate through cats
                for (let cat in res) {
                    let tr = document.createElement('tr');
                    catTable.appendChild(tr);
                    let tdName = document.createElement('td');
                    tdName.innerHTML = res[cat].name;
                    tr.appendChild(tdName);
                }

                dataSection.appendChild(catTable);
                // for (let cat of res) {
                    
                // }
            }
        }
    }
}