"using strict"

let Node = require("./Node");

class HuffmanTree
{
    constructor(char, weight)
    {
        this._root = new Node(char, null, null);
        this._weight = weight;
    }

    combine(tree2)
    {
        let newWeight = this._weight + tree2.weight;
        let newTree = new HuffmanTree(null, newWeight);
        newTree.root.leftNode = this._root;
        newTree.root.rightNode = tree2.root;
        return newTree;
    }

    compareTo(tree2)
    {
        let result = 0;
        if(this._weight < tree2.weight)
        {
            result = -1;
        }
        else if(this._weight > tree2.weight)
        {
            result = 1;
        }
        else
        {
            let thisChar = this.findLowestChar();
            let tree2Char = tree2.findLowestChar();
            if(thisChar < tree2Char)
            {
                result = -1;
            }
            else if(thisChar > tree2Char)
            {
                result = 1;
            }
            else
            {
                result = 0;
            }
        }
        return result;
    }

    findLowestChar()
    {
        let lowestChar = this.lowestCharRecur(this._root);
        return lowestChar;
    }

    lowestCharRecur(node)
    {
        let lowestChar = null;
        if(node.leftNode == null)
        {
            lowestChar = node.value;
        }
        else
        {
            let leftChar = this.lowestCharRecur(node.leftNode);
            let rightChar = this.lowestCharRecur(node.rightNode);
            if(leftChar <= rightChar)
            {
                lowestChar = leftChar;
            }
            else
            {
                lowestChar = rightChar;
            }
        }
        return lowestChar;
    }

    search(char)
    {
        let directions = [];
        let dirString = "";
        this.searchRecur(char, this._root, directions);
        for(let i = directions.length-1; i >= 0; i--)
        {
            dirString += directions[i];
        }
        return dirString;
    }

    searchRecur(char, node, directions)
    {
        let result = false;
        if(node.leftNode == null)
            {
            if(char == node.value)
            {
                result = true;
            }
            else if(char != node.value)
            {
                result = false;
            }
        }
        else
        {
            let leftSearch = this.searchRecur(char, node.leftNode, directions);
            let rightSearch = this.searchRecur(char, node.rightNode, directions);
            if(leftSearch || rightSearch)
            {
                if(leftSearch)
                {
                    directions.push(0);
                }
                else
                {
                    directions.push(1);
                }
                result = true;
            }
        }
        return result;
    }

    get root()
    {
        return this._root;
    }

    get weight()
    {
        return this._weight;
    }
}

module.exports = HuffmanTree;