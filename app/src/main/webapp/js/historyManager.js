import { TimeManager } from "./timeManager.js";

export class HistoryManager{
    static#tableBody = $("#history-table-body");
    static lastModified = new Date().toUTCString();

    static updateTable(point_list) {
        this.#tableBody.empty();
        point_list.forEach(point => {
            this.addPoint(point);
        });
    }

    static addPoint(point) {
        this.#tableBody.prepend(this.#convertPoint(point));
    }

    static #convertPoint(point) {
        return `<tr class="table-${point.hit ? 'success' : 'danger'}" >
            <td>${point.x}</td>
            <td>${point.y}</td>
            <td>${point.r}</td>
            <td>${point.hit ? 'Попадание' : 'Промах'}</td>
            <td>${TimeManager.dateTimeFromMilliseconds( point.curTime )}</td>
            <td>${TimeManager.timePassedFromNanoseconds( point.scriptTime )}</td>
            <td></td>
        </tr>`;
    }
}