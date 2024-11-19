import {CanvasManager} from "./canvasManager.js";
import {HistoryManager} from "./historyManager.js";

export class StorageManager{
    static #CONTROLLER_URL = '/app/controller';
    static #DATA_URL = '/app/history';
    static #lastModified = new Date().toUTCString();
    static #localPoints = [];

    static refresh(){
        this.load(true);
    }

    static getPoints(){
        return this.#localPoints;
    }

    static load(isRefreshed = false){
        const thisClass = this;
        $.ajax({
            url: this.#DATA_URL,
            method: 'GET',
            beforeSend: function (request) {
                if (!isRefreshed){
                    request.setRequestHeader("If-Modified-Since", thisClass.#lastModified);
                }
            }.bind(this),
            statusCode: {
                304: function () {
                    Swal.fire({
                        icon: "info",
                        title: "История",
                        text: "История в актуальном состоянии"
                    });
                },
                200: function(point_list){
                    CanvasManager.updatePonits(point_list);
                    HistoryManager.updateTable(point_list);

                    thisClass.#lastModified = new Date().toUTCString();
                    thisClass.#localPoints = point_list;
                }
            },
            error: function(error){
                Swal.fire({
                    icon: "error",
                    title: `Ошибка ${error.statusText}`,
                    text: error.responseText
                });    
                console.log(error);
            }
        });
    }

    static addPoint(data){
        const thisClass = this;
        $.ajax({
            url: this.#CONTROLLER_URL + '?' + $.param(data),
            method: 'GET',
            success: function(){
                thisClass.load();
            },
            error: function(error){
                Swal.fire({
                    icon: "error",
                    title: `Ошибка ${error.statusText}`,
                    text: error.responseText
                });    
                console.log(error);
            }
        });
    }
}