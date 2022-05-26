"using strict"

class Hashable
{
    constructor(preHash)
    {
        if(this.constructor === Hashable)
        {
            throw new Error("Trying to create an abstract Hashable class");
        }
        else if(arguments.length === 1)
        {
            this._preHash = preHash;
            this._hashVal = null;
        }
        else
        {
            throw new Error("Invalid arguments in Hashable constructor");
        }
    }

    hashVal()
    {
        throw new Error("Missing hashVal in a concrete class");
    }

    equals(hashable)
    {
        throw new Error("Missing equals in a concrete class");
    }

    get hashValue()
    {
        return this._hashVal;
    }

    get preHash()
    {
        return this._preHash;
    }
}

module.exports = Hashable;