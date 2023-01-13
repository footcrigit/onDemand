package com.example.onDemand.experiment;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class ListOperationView {

    @JsonView(Views.V1.class)
    private List<Integer> testNumbers;

    class Views
    {
        class V1
        {
        }
    }
}
