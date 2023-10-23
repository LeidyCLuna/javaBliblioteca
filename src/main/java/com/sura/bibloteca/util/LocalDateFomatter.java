package com.sura.bibloteca.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateFomatter {

    public LocalDate dateStringtoLocalDate(String fecha){
        return LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public String LocalDateToStringDate(LocalDate fecha){
        return fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
