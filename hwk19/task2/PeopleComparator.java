package com.gmail.evanloafakahaitao.hwk19.task2;

import java.util.Comparator;

public class PeopleComparator implements Comparator<PersonWithBuilder> {
    @Override
    public int compare(PersonWithBuilder o1, PersonWithBuilder o2) {
        int yearCompared = o1.getYear().compareTo(o2.getYear());
        if (yearCompared != 0) {
            return yearCompared;
        } else {
            int surnameCompared = o1.getSurname().compareTo(o2.getSurname());
            if (surnameCompared != 0) {
                return surnameCompared;
            } else {
                return o1.getName().compareTo(o2.getName());
            }
        }
    }
}
