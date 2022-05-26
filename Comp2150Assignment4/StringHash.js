"using strict"

let Hashable = require("./Hashable");

class StringHash extends Hashable
{
    constructor(preHash)
    {
        super(preHash);
        this._prime = 7;
        this.hashVal();
    }

    hashVal()
    {
        this._hashVal = 0;
        for(let i = 0; i < this._preHash.length; i++)
        {
            this._hashVal += this._preHash.charCodeAt(i) * Math.pow(this._prime, this._preHash.length - i);
        }
    }

    equals(hashable)
    {
        let result = false;
        if(hashable instanceof StringHash)
        {
            result = this._preHash === hashable.preHash;
        }
        return result;
    }
}

module.exports = StringHash;