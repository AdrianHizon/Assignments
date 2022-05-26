let HuffmanEncoder = require("./HuffmanEncoder");

function main()
{
    let encoder = new HuffmanEncoder("hamlet.txt");
    encoder.encode();
}

main();