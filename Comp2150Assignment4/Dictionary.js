"using strict"

class Dictionary
{
    constructor(size)
    {
        this._dictArray = new Array(size);
        for(let i of this._dictArray)
        {
            this._dictArray[i] = null;
        }
        this._numEntries = 0;
    }

    put(k, v)
    {
        if(v != undefined)
        {
            let newEntry = [k, v];
            let currPos = this.getPos(k);
            if(!this.contains(k))
            {
                if(this._dictArray[currPos] == null)
                {
                    this._dictArray[currPos] = [newEntry];
                }
                else if("push" in this._dictArray[currPos] && typeof(this._dictArray[currPos].push) === "function")
                {
                    this._dictArray[currPos].push(newEntry);
                }
                this._numEntries++;
            }
            else
            {
                for(let i = 0; i < this._dictArray[currPos].length; i++)
                {
                    if("equals" in k && typeof(k.equals) === "function" && k.equals(this._dictArray[currPos][i][0]))
                    {
                        this._dictArray[currPos][i][1] = v;
                        // this._numEntries++;
                    }
                }
            }
        }
        else
        {
            console.log("Attempting to put invalid value in dictionary");
        }
    }

    get(k)
    {
        let result = null;
        let currPos = this.getPos(k); 
        if(this._dictArray[currPos] != null)
        {
            for(let i = 0; i < this._dictArray[currPos].length; i++)
            {
                if("equals" in k && typeof(k.equals) === "function" && k.equals(this._dictArray[currPos][i][0]))
                {
                    result = this._dictArray[currPos][i][1];
                }
            }
        }
        return result;
    }

    contains(k)
    {
        let result = this.get(k) != null;
        return result;
    }

    isEmpty()
    {
        return numEntries === 0;
    }

    get dictArray()
    {
        return this._dictArray;
    }

    getPos(k)
    {
        let pos = -1;
        if("hashVal" in k)
        {
            pos = k.hashValue % this._dictArray.length;
        }
        return pos;
    }
}

module.exports = Dictionary;