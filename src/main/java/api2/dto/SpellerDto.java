package api2.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class SpellerDto {
    private String code;
    private String pos;
    private String row;
    private String col;
    private String len;
    private String word;
    private List<String> s;
}
