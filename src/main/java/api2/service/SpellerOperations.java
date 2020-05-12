package api2.service;


import com.google.gson.Gson;
import api2.dto.SpellerDto;
import java.util.HashMap;
import java.util.Map;


import static api2.service.URI.CHECK_TEXTS;
import static api2.service.URI.CHECK_TEXT;

public class SpellerOperations {


    public SpellerDto[] checkText(String text) {
        Map<String, Object> params = new HashMap<>();
        params.put("text", text);

        return new Gson().fromJson(
                new SpellerCommonService()
                        .getWithParams(CHECK_TEXT, params)
                        .getBody().asString(), SpellerDto[].class);
    }



    public SpellerDto[] checkTexts(String text) {
        Map<String, Object> params = new HashMap<>();
        params.put("text", text);

        return new Gson().fromJson(
                new SpellerCommonService()
                        .getWithParams(CHECK_TEXTS, params)
                        .getBody().asString(), SpellerDto[].class);
    }
}
