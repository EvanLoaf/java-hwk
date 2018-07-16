package com.gmail.evanloafakahaitao.hwk19.task1;

import java.util.Iterator;
import java.util.List;

public class ListFactory {
    
    private List<Integer> list;
    private String listType;
    
    public void getList(ListTypeEnum typeEnum) {
        if (typeEnum == ListTypeEnum.ARRAY) {
            list = new ArrayListImplGenerateAndPrintList().generateList();
            listType = list.getClass().getSimpleName();
        } else if (typeEnum == ListTypeEnum.LINKED) {
            list = new LinkedListImplGenerateAndPrintList().generateList();
            listType = list.getClass().getSimpleName();
        } else try {
            throw new Exception("Invalid Enum value");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void printList() {
        System.out.printf("%s:\n", listType);
        Iterator<Integer> iterator = this.list.iterator();
        StringBuilder sb = new StringBuilder();
        int counter = 0;
        while (iterator.hasNext()) {
            if (counter >= 10) {
                counter = 0;
                sb.append(System.lineSeparator());
            }
            int iteration = iterator.next();
            sb.append(iteration);
            sb.append(" ");
            ++counter;
        }
        System.out.println(sb.toString());
    }
}
