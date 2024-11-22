import { CanvasManager } from "./canvasManager.js";
import { TableManager } from "./tableManager.js";

init();

function renderPoints(){
    let points = [];
    for (let row of document.querySelectorAll('#history-table tbody tr')) {
        let x = parseFloat(row.children[0].textContent);
        let y = parseFloat(row.children[1].textContent);
        let hit = row.children[2].textContent == "Попадание"; 
        points.push({
            x: x,
            y: y,
            hit: hit,
        });
    }
    CanvasManager.updatePonits(points); 
}


function init(){
    TableManager.updateTable();
    setTimeout(() => {
        renderPoints();
    }, 100);
}

document.getElementsByName("form:r-input").forEach(radio => {
    radio.addEventListener('change', () => {
        renderPoints();
    });
});

document.getElementById("form:x-input").setAttribute("readonly", "readonly");

document.getElementById("canvas").onclick = function(event) {
    let point = CanvasManager.handleClick(event);
    document.getElementById("hidden-form:x-input").value = point.x;
    document.getElementById("hidden-form:y-input").value = point.y;
    document.getElementById("hidden-form:r-input").value = point.r;
    document.getElementById("hidden-form:drawn-input").value = true;
    document.getElementById("hidden-form:submit").click();

    setTimeout(() => {
        renderPoints();
    }, 100);    
}

document.getElementById("form:submit").addEventListener('click', () => {
    let cnt = TableManager.getTableLenght();
    setTimeout(() => {
        if (cnt != TableManager.getTableLenght()) {
            renderPoints();
        }
        else{
            Swal.fire({
                icon: 'error',
                title: 'Ошибка',
                text: 'Некорректные данные',
              })
        }
    }, 200);
});