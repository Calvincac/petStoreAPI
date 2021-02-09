package pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Pet {

    private String id;
    private Category category;
    private String name;
    private List<String> photoUrls;
    private List<Tag> tags;
    private Status status;
}
