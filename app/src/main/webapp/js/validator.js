// Check if a <= b
function compare(a, b){
    if (a.toString()[0] == "-"){
        if (b.toString()[0] == "-"){
            return compare(b.toString().slice(1), a.toString().slice(1));
        }
        return true;
    }

    let ax = (a.toString() + ".0").split('.');
    let bx = (b.toString() + ".0").split('.');
    let maxLen = Math.max(ax[1].length, bx[1].length);
    ax[1] = ax[1] + '0'.repeat(maxLen - ax[1].length);
    bx[1] = bx[1] + '0'.repeat(maxLen - bx[1].length);
    if (ax[0] !== bx[0]){
        return parseFloat(ax[0]) <= parseFloat(bx[0]);
    }
    for (let i = 0; i < maxLen; i++) {
        if (ax[1][i] !== bx[1][i])
            return ax[1][i] < bx[1][i];
    }
    return true;
}

export class Validator {
    static validate(x, y, r, drawn) {
        return (this.validateX(x) && this.validateY(y) && this.validateR(r)) ||
            (drawn && this.validateR(r));
    }

    static validateX(x){
        return ["-2", "-1.5", "-1", "-0.5", "0", "0.5", "1", "1.5", "2"].includes(x)
    }

    static validateY(y){
        return compare(-3, y) && compare(y, 5);
    }

    static validateR(r){
        return compare(1, r) && compare(r, 4);
    }

}
