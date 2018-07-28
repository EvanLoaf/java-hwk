package com.gmail.evanloafakahaitao.hwk26.sqltask;

import com.gmail.evanloafakahaitao.hwk26.sqltask.dao.CreateTablesService;
import com.gmail.evanloafakahaitao.hwk26.sqltask.dao.FlatDao;
import com.gmail.evanloafakahaitao.hwk26.sqltask.dao.connection.ConnectionSingletonService;
import com.gmail.evanloafakahaitao.hwk26.sqltask.dao.impl.FlatDaoImpl;
import com.gmail.evanloafakahaitao.hwk26.sqltask.dao.model.Flat;
import com.gmail.evanloafakahaitao.hwk26.sqltask.service.GeneratorSingletonService;
import com.gmail.evanloafakahaitao.hwk26.sqltask.service.PopulateFlatsSingletonService;

import java.util.List;

public class CityApp {
    
    public void runApp() {
        CreateTablesService createTablesService = new CreateTablesService();
        createTablesService.createTables();
        System.out.println("\n----------------------------------------\n");
        GeneratorSingletonService generator = GeneratorSingletonService.getInstance();
        generator.generateAddHousesAndFlats(3, 20);
        System.out.println("\n----------------------------------------\n");
        System.out.println("Here are the flats we got:");
        FlatDao flatDao = new FlatDaoImpl();
        List<Flat> listOfFlats = ((FlatDaoImpl) flatDao).getFlats();
        for (Flat flat : listOfFlats) {
            System.out.println(flat);
        }
        System.out.println("\n----------------------------------------\n");
        PopulateFlatsSingletonService populateFlats = PopulateFlatsSingletonService.getInstance();
        populateFlats.populateFlats(1, 40, 49);
        System.out.println("\n----------------------------------------\n");
        ((FlatDaoImpl) flatDao).getAndPrintPopulatedFlats();
        System.out.println("\n----------------------------------------\n");
        System.out.println("Closing connection");
        ConnectionSingletonService.getInstance().closeConnection();
    }
}
