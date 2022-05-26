let IntHash = require("./IntHash");
let StringHash = require("./StringHash");
let Dictionary = require("./Dictionary");
let HuffmanTree = require("./HuffmanTree");
let HuffmanEncoder = require("./HuffmanEncoder");
let fs = require("fs");

function main()
{
    // let test1 = new Hashable(21);
    // let test = new IntHash(1);
    // let test2 = new IntHash(98);
    // let test3 = new StringHash("test3");
    // let test4 = new StringHash("test4");

    // console.log(test.hashValue);
    // console.log(test.equals(test2));
    

    // console.log(test3.hashValue);
    // console.log(test4.hashValue);
    // console.log(test3.equals(test4));
    // let testDict = new Dictionary(97);
    // console.log(testDict.getPos(test3));
    // testDict.put(test, "dictionary entry");
    // testDict.put(test2, "dictionary entry 2");
    // testDict.put(test3, "dictionary entry 3");
    // console.log(testDict.get(test));
    // console.log(testDict.get(test2));
    // console.log(testDict.get(test3));

    // let testArr = [0, 1, 2, "pop", 4];
    // let testArr2 = [8, "bleh", 10, 11];
    // let test2D = [testArr];
    // test2D.push(testArr2);
    // for(let i = 0; i < test2D.length; i++)
    // {
    //     for(let j = 0; j < test2D[i].length; j++)
    //     {
    //         console.log(test2D[i][j]);
    //     }
    // }
    // console.log(test2D[1][0]);

    // let tree1 = new HuffmanTree('C', 1);
    // let tree2 = new HuffmanTree('O', 1);
    // let tree3 = new HuffmanTree('L', 1);
    // let tree4 = new HuffmanTree('P', 1);
    
    

    // let tree5 = tree1.combine(tree2);
    // let tree6 = tree3.combine(tree4);

    // let tree7 = tree5.combine(tree6);

    // let tree8 = new HuffmanTree('E', 1);
    // let tree9 = new HuffmanTree('D', 1);
    // let tree10 = new HuffmanTree('X', 1);
    // let tree11 = new HuffmanTree('W', 1);

    // let tree12 = tree8.combine(tree9);
    // let tree13 = tree10.combine(tree11);

    // let tree14 = tree12.combine(tree13);

    // let tree15 = tree7.combine(tree14);

    // let tree16 = new HuffmanTree('Y', 1);
    // let tree17 = new HuffmanTree('Z', 1);

    // let tree18 = tree16.combine(tree17);

    // let tree19 = tree15.combine(tree18);

    // console.log(tree19.weight);
    // console.log(tree19.findLowestChar());
    // console.log(tree19.search('B'));
    // // console.log(tree7.root.rightNode.rightNode.value);
    // console.log(43/1259);

    // let contents = fs.readFileSync("test.txt", "utf8");
    // console.log(contents.length);

    // fs.appendFileSync("test2.txt", contents);

    // for(let i = 55; i < contents.length; i++)
    // {
    //     console.log(contents.charAt(i));
    // }

    let huffTest = new HuffmanEncoder("hamlet.txt");
    // huffTest.calculateFrequency();
    // console.log(huffTest.dictionary.get(new StringHash('E')));
    // huffTest.combineTrees();
    // huffTest.calculateCode();
    huffTest.encode();
    // console.log(huffTest.dictionary);
    // let arr = [1, 2, 3];
    // arr.push(4);
}

main();