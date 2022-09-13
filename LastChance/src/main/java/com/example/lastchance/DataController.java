package com.example.lastchance;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
public class DataController {
    private final DataService dataService;

    public DataController(DataService dataService) {
        this.dataService = dataService;


        }
        @PostMapping("count")
        public Long count (@RequestBody DataDTO dataDto) throws ParseException {
           Long days = dataService.convertToData(dataDto);

        return  days;

    }
}
