package com.gmail.evanloafakahaitao.hwk26.sqltask.dao;

import com.gmail.evanloafakahaitao.hwk26.sqltask.dao.model.Flat;

public interface FlatDao {

    void save(Flat flat);

    Flat getById(Long id);
}
