package pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class IncorrectOrder {
    private Long id;
    private Long petId;
    private List<String> quantity;
    private String shipDate;
    private String status;
    private String complete;
}
