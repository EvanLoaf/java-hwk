package com.gmail.evanloafakahaitao.hwk25.hwktask;

public interface ClientDao {
    
    void save(Client client);
    
    Client getById(Long id);
    
    long getMaxId();
}
