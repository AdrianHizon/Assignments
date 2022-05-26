"using strict"

let fs = require("fs");
let Dictionary = require("./Dictionary");
let StringHash = require("./StringHash");
let HuffmanTree = require("./HuffmanTree");

class HuffmanEncoder
{
    constructor(fileName)
    {
        this._fileName = fileName;
        this._dictionary = new Dictionary(157);
        this._trees = new Array(0);
        this._combinedTree = null;
    }

    encode()
    {
        this.calculateFrequency();
        this.combineTrees();
        this.calculateCode();

        let encodedFile = "";
        let contents = fs.readFileSync(this._fileName, "utf8");

        for(let i = 0; i < contents.length; i++)
        {
            let currChar = contents.charAt(i);
            let charKey = new StringHash(currChar);
            encodedFile += this._dictionary.get(charKey) + " ";
        }
        encodedFile += "\n";
        let huffFileName = this._fileName + ".huff";
        fs.writeFileSync(huffFileName, encodedFile);
    }

    calculateFrequency()
    {
        let contents = fs.readFileSync(this._fileName, "utf8");

        for(let i = 0; i < contents.length; i++)
        {
            let currChar = contents.charAt(i);
            let charKey = new StringHash(currChar);
            if(!this._dictionary.contains(charKey))
            {
                this._dictionary.put(charKey, 1);
            }
            else
            {
                this._dictionary.put(charKey, this._dictionary.get(charKey) + 1);
            }
        }

        for(let i = 0; i < this._dictionary.dictArray.length; i++)
        {
            if(this._dictionary.dictArray[i] != null)
            {
                for(let j = 0; j < this._dictionary.dictArray[i].length; j++)
                {
                    let currKey = this._dictionary.dictArray[i][j][0];
                    let currFreq = this._dictionary.get(currKey)/contents.length;
                    this._dictionary.put(currKey, currFreq);
                    this._trees.push(new HuffmanTree(currKey.preHash, currFreq));
                }
            }
        }
    }

    combineTrees()
    {
        let currLength = this._trees.length;
        let treesCopy = new Array(0);
        for(let i = 0; i < this._trees.length; i++)
        {
           treesCopy.push(this._trees[i]); 
        }
        while(currLength > 1)
        {
            for(let i = 0; i < currLength; i++)
            {
                let j = i - 1;
                let currTree = treesCopy[i];
                while(j >= 0 && currTree.compareTo(treesCopy[j]) < 0)
                {
                    treesCopy[j + 1] = treesCopy[j];
                    j--;
                }
                treesCopy[j + 1] = currTree;
            }
            treesCopy[1] = treesCopy[0].combine(treesCopy[1]);
            let newTrees = new Array(0);
            for(let i = 1; i < currLength; i++)
            {
                newTrees.push(treesCopy[i]);
            }
            treesCopy = newTrees;
            currLength--;
        }
        this._combinedTree = treesCopy[0];
    }

    calculateCode()
    {
        for(let i = 0; i < this._dictionary.dictArray.length; i++)
        {
            if(this._dictionary.dictArray[i] != null)
            {
                for(let j = 0; j < this._dictionary.dictArray[i].length; j++)
                {
                    let currKey = this._dictionary.dictArray[i][j][0];
                    this._dictionary.put(currKey, this._combinedTree.search(currKey.preHash));
                }
            }
        }
    }

    get dictionary()
    {
        return this._dictionary;
    }
}

module.exports = HuffmanEncoder;