package org.example.teapot.service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class RepairBayService {
    static String json = "{\n" +
            "  \"navigation\": \"NAV-01\",\n" +
            "  \"communications\": \"COM-02\",\n" +
            "  \"life_support\": \"LIFE-03\",\n" +
            "  \"engines\": \"ENG-04\",\n" +
            "  \"deflector_shield\": \"SHLD-05\"\n" +
            "}";

    public static Map loadRepairBay() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, Map.class);
    }
    public static String getSystem(String systemName) throws JsonProcessingException {
        Map<String, String> repairBay = loadRepairBay();
        return repairBay.get(systemName);
    }



}
