import { Validator } from "./validator.js";
import { CanvasManager } from "./canvasManager.js";
import { StorageManager } from "./storageManager.js";
import { HistoryManager } from "./historyManager.js";

StorageManager.refresh();

function send_point(x, y, r, drawn) {
    if (Validator.validate(x, y, r, drawn)) {
        let data = {
            "x": x,
            "y": y,
            "r": r,
            "drawn": drawn
        }
        StorageManager.addPoint(data);
    }
    else if (!drawn){
        Swal.fire({
            icon: "error",
            title: "Некорректные данные",
        });
    }
    else {
        Swal.fire({
            icon: "error",
            title: "Выберите другой радиус",
        });
    }
}

$("#r").on("input", function() {
    let r = this.value;
    if (Validator.validateR(r)) {
        CanvasManager.updatePonits(StorageManager.getPoints());
    }
});

$("#submit_point").on("click", function(event) {    
    event.preventDefault();
    
    let checkboxes = document.getElementsByName("x");
    let y = document.getElementById("y").value;
    let r = document.getElementById("r").value;
    for (let i = 0; i < checkboxes.length; i++) {
        if (checkboxes[i].checked) {
            let x = checkboxes[i].value;
            send_point(x, y, r, false);
        }
    }
})


$("#canvas").on("click", function(event) {
    let coords = CanvasManager.handleClick(event);
    send_point(coords.x, coords.y, coords.r, true);
});


$("#update-history").on("click", function(event) {    
    event.preventDefault();
    console.log(HistoryManager.lastModified);
    console.log("Updating...");
    StorageManager.load();
    console.log(HistoryManager.lastModified);
})