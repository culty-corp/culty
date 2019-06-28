package com.github.saulocalixto.culty.cultyserver.utilidade;

import com.github.saulocalixto.culty.cultyserver.servico.exceptions.DataInvalida;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class FormatarData {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public static String formatarData(Date dataDeNascimento) {
        sdf.setTimeZone(TimeZone.getTimeZone("GMT-3"));
        return sdf.format(dataDeNascimento);
    }

    public static Date parsearData (String string) {
        try {
            return sdf.parse(string);
        } catch (ParseException e) {
            throw new DataInvalida("A data informada é inválida!");
        }
    }
}
