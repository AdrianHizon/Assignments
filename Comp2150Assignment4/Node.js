class Node
{
    constructor(val, left, right)
    {
        this._value = val;
        this._leftNode =  left;
        this._rightNode = right;
    }

    get value()
    {
        return this._value;
    }

    set value(val)
    {
        this._value = val;
    }

    get leftNode()
    {
        return this._leftNode;
    }

    set leftNode(node)
    {
        this._leftNode = node;
    }

    get rightNode()
    {
        return this._rightNode;
    }

    set rightNode(node)
    {
        this._rightNode = node;
    }
}

module.exports = Node;