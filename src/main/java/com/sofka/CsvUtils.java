package com.sofka;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class CsvUtils {
    private static final char SEPARATION_CHARACTER = ',';

    public CsvUtils() {
    }

    public static List<Map<String, String>> getDataCsv(String csvName) throws IOException {
        List<Map<String, String>> dataList = new ArrayList<>();
        File file = new File("src/main/resources/data_songs.csv");

        InputStream in = new FileInputStream(file);
        Reader reader = new InputStreamReader(in, StandardCharsets.UTF_8);
        Iterator<Map<String, String>> iterator =
                new CsvMapper()
                        .readerFor(Map.class)
                        .with(CsvSchema.emptySchema().withColumnSeparator(SEPARATION_CHARACTER).withHeader())
                        .readValues(reader);
        while (iterator.hasNext()) {
            Map<String, String> row = iterator.next();
            dataList.add(row);
        }
        in.close();
        reader.close();
        return dataList;
    }
}


