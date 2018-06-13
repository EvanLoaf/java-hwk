package com.gmail.evanloafakahaitao.hwk07.task03;

public class DeleteSymbolsWithinIndicesService {
    
    private int[] indicesOfSymbols;
    private int searchStartIndex;
    private String substr1;
    private String substr2;
    private String substr3;
    
    public String symbolDeletion(String myString, char rangeSymbol, int firstSymbolNumberInRange, int lastSymbolNumberInRange, String symbolToDelete) {
        indicesOfSymbols = new int[lastSymbolNumberInRange];
        searchStartIndex = 0;
        for (int i = 0; i < lastSymbolNumberInRange; ++i) {
            if (myString.indexOf(rangeSymbol, searchStartIndex) > -1) {
                indicesOfSymbols[i] = myString.indexOf(rangeSymbol, searchStartIndex);
                searchStartIndex = indicesOfSymbols[i] + 1;
            }
        }
        substr1 = myString.substring(0, indicesOfSymbols[firstSymbolNumberInRange - 1]);
        substr2 = myString.substring(indicesOfSymbols[firstSymbolNumberInRange - 1], indicesOfSymbols[lastSymbolNumberInRange - 1] + 1);
        substr3 = myString.substring(indicesOfSymbols[lastSymbolNumberInRange - 1] + 1);
        substr2 = substr2.replace(symbolToDelete, "");
        return substr1.concat(substr2).concat(substr3);
    }
    
}
