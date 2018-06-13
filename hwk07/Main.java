package com.gmail.evanloafakahaitao.hwk07;

/**
 * Class Tasks
 * 1. Cоставить из частей слова “информатика” слово “торт” и вывести его на экран.
 * 2. Заменить все буквы “а” на буквы “б” в заданной строке(строка вводится с консоли).
 * 3. Удалить в строке все цифры.
 * 4. В заданной строке подсчитать количество цифр 9.
 * 5. Ввести массив строк и найти в нем максимальную по длине строку:
 * * a) Не учитывать случай, когда таких строк несколько.
 * * b) Если строка с максимальной длиной не одна, вывести все.
 */

import com.gmail.evanloafakahaitao.hwk07.classTasks.task01.ChangeWordService;
import com.gmail.evanloafakahaitao.hwk07.classTasks.task02.ReplaceLettersService;
import com.gmail.evanloafakahaitao.hwk07.classTasks.task03.DeleteDigitsService;
import com.gmail.evanloafakahaitao.hwk07.classTasks.task04.DigitsCounterService;
import com.gmail.evanloafakahaitao.hwk07.classTasks.task05.LongestStringService;
import com.gmail.evanloafakahaitao.hwk07.task01.SymbolsSimilarToLastService;
import com.gmail.evanloafakahaitao.hwk07.task02.StringsWithSubstringService;
import com.gmail.evanloafakahaitao.hwk07.task03.DeleteSymbolsWithinIndicesService;

/**
 * Homework Tasks
 * 1. Ввести с консоли строку. Показать номера символов, совпадающих с последним символом строки.
 * 2. Ввести n строк с консоли. Вывести на консоль те строки, в которых встречается слово cat или dog. Подсчитать длину этих строк. Вывести на экран количество строк, которые не соответствуют критерию.
 * 3. Ввести с консоли строку в программу:
 * "На вопрос "Откуда?" - От верблюда! На вопрос "Зачем?" - Затем! На вопрос "Что?"- Цирк Шапито! На вопрос "Как?"- На тебя напал столбняк!".
 * Во введенной строке удалить пробелы между вторым и третьим вопросительным знаком.
 */

public class Main {
    
    public static void main(String[] args) {
        
        StringScannerService scannerService = new StringScannerService();
        
        // Class Task 1
        System.out.println("\nClass Task1.");
        ChangeWordService newWord = new ChangeWordService();
        System.out.print("Please, type a word or line in russian containing letters {т,о,р}: ");
        String word = scannerService.getStringFromConsole();
        newWord.getNewWord(word);
        System.out.println("--------------------\n");
        
        // Class Task 2
        System.out.println("\nClass Task2.");
        ReplaceLettersService replace = new ReplaceLettersService();
        System.out.println("Please, type a word or line in russian containing letter 'а': ");
        String myWord = scannerService.getStringFromConsole();
        replace.replaceLetters(myWord);
        System.out.println("--------------------\n");
        
        // Class Task 3
        System.out.println("\nClass Task3.");
        DeleteDigitsService delDigits = new DeleteDigitsService();
        System.out.println("Please, type a word or line containing digits: ");
        String lineWithDigits = scannerService.getStringFromConsole();
        System.out.println("No pesky numbers anymore! Look: ");
        System.out.println(delDigits.deleteDigitsCasual(lineWithDigits));
        System.out.println("New we got rid of digits with RegExp: ");
        System.out.println(delDigits.deleteDigitsRegexp(lineWithDigits));
        System.out.println("--------------------\n");
        
        // Class Task 4
        System.out.println("\nClass Task4.");
        DigitsCounterService countNines = new DigitsCounterService();
        System.out.println("Please, type a word or line containing digits '9': ");
        String lineWithNines = scannerService.getStringFromConsole();
        System.out.println("Digit '9' was encountered: " + countNines.countDigitsNine(lineWithNines) + " times.");
        System.out.println("--------------------\n");
        
        // Class Task 5
        System.out.println("\nClass Task5.");
        LongestStringService longstr = new LongestStringService();
        System.out.println("Please, type in five strings for an array: ");
        String str1 = scannerService.getStringFromConsole();
        String str2 = scannerService.getStringFromConsole();
        String str3 = scannerService.getStringFromConsole();
        String str4 = scannerService.getStringFromConsole();
        String str5 = scannerService.getStringFromConsole();
        System.out.println("Now let the magic begin!");
        System.out.println("\nOnly find the length of the longest string: ");
        System.out.println(longstr.longestStringOnlyLength(str1, str2, str3, str4, str5));
        System.out.println("\nNow lets find the longest string, print it and it's length. \nIf There are several 'longest' strings, lets print them all!");
        System.out.println(longstr.longestStringOutputAll(str1, str2, str3, str4, str5));
        System.out.println("--------------------\n");
        
        // Homework Task 1
        System.out.println("\nHomework Task1.");
        SymbolsSimilarToLastService similarChars = new SymbolsSimilarToLastService();
        System.out.println("Please type in the string you wanna analyze: ");
        String testStr = scannerService.getStringFromConsole();
        similarChars.indicesOfSymbolsSimilarToTheLastOne(testStr);
        System.out.println("--------------------\n");
        
        // Homework Task 2
        System.out.println("\nHomework Task2.");
        StringsWithSubstringService substr = new StringsWithSubstringService();
        System.out.println("How many strings do you wanna use?");
        int numOfStrings = Integer.valueOf(scannerService.getStringFromConsole());
        substr.getStrings(numOfStrings);
        System.out.println("--------------------\n");
        
        // Homework Task 3
        // Works not only in 1 specific situation, defined in task 3
        System.out.println("\nHomework Task3.");
        DeleteSymbolsWithinIndicesService delInRange = new DeleteSymbolsWithinIndicesService();
        System.out.println("What string do you wanna edit?");
        // acc to the task: "На вопрос "Откуда?" - От верблюда! На вопрос "Зачем?" - Затем! На вопрос "Что?"- Цирк Шапито! На вопрос "Как?"- На тебя напал столбняк!"
        String myString = scannerService.getStringFromConsole();
        System.out.println("In between which symbols do you wanna edit the string?");
        // acc to the task: "?"
        char rangeChar = scannerService.getStringFromConsole().charAt(0);
        System.out.println("What number of symbol from the beginning of the string will start the range?");
        // acc to the task: 2
        int rangeStart = Integer.valueOf(scannerService.getStringFromConsole());
        System.out.println("What number of symbol from the beginning of the string will end the range?");
        // acc to the task: 3
        int rangeEnd = Integer.valueOf(scannerService.getStringFromConsole());
        System.out.println("What symbol do you wanna delete?");
        // acc to the task: " " (space)
        String delChar = scannerService.getStringFromConsole();
        System.out.println(delInRange.symbolDeletion(myString, rangeChar, rangeStart, rangeEnd, delChar));
        System.out.println("--------------------\n");
        
    }
    
}
