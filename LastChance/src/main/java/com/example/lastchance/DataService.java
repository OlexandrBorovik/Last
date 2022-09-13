package com.example.lastchance;

import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Service
public class DataService {
    private final DataRepository dataRepository;



    public DataService(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }


    public Long convertToData (DataDTO dataDto) throws ParseException {
        SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
        String inputString1 = dataDto.getDataTime();
        String inputString2 = "01 01 2023";
        try{
            Date oldDate = myFormat.parse(inputString1);
            Date newYear = myFormat.parse(inputString2);
            int diffInDays = (int)( (newYear.getTime() - oldDate.getTime())
                    / (1000 * 60 * 60 * 24) );
            Long ret = Long.valueOf(diffInDays);
            return ret;

        }catch(Exception ex){
            System.out.println(ex);
        }


        return null;
    }

}
