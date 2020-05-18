package jdi.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.MapLikeType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import jdi.entity.MetalsColorsDataSet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class JsonParser {

    private static String path = "src/test/resources/TestData/MetalsColorsDataSet.json";

    public static List<MetalsColorsDataSet> readData() {
        ObjectMapper mapper = new ObjectMapper();
        TypeFactory factory = mapper.getTypeFactory();
        try {
            File json = new File(path);
            MapLikeType mapType = factory.constructMapLikeType(Map.class, String.class, MetalsColorsDataSet.class);
            Map<String, MetalsColorsDataSet> map = mapper.readValue(json, mapType);
            return  new ArrayList<>(map.values());

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return null;
    }
}
