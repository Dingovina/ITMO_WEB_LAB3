export class TableManager{
    static updateTable(){
        document.getElementById("update-form:update-storage").click();
    }

    static getTableLenght(){
        let table = document.querySelectorAll('#history-table tbody tr');
        let cnt = table.length;
        if (cnt == 1 && table[0].lastChild.nodeName == 'TD'){
            cnt = 0;
        }
        return cnt;
    }
}