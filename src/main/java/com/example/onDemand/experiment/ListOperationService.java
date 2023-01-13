package com.example.onDemand.experiment;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListOperationService {
    ListOperationView getDataList()
    {
        List<Integer> testNumber = new ArrayList<>();
        testNumber.add(1);
        ListOperationView listOperationView =  new ListOperationView(
          testNumber
        );
        return listOperationView;
    }
}
