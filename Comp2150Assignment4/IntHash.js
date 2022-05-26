"using strict"

let Hashable = require("./Hashable");

class IntHash extends Hashable
{
    constructor(preHash)
    {
        super(preHash);
        this.hashVal();
    }

    hashVal()
    {
        this._hashVal = this._preHash;
    }

    equals(hashable)
    {
        let result = false;
        if(hashable instanceof IntHash)
        {
            result = this._preHash === hashable.preHash;
        }
        return result;
    }
}

module.exports = IntHash;
