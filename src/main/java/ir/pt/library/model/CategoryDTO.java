package ir.pt.library.model;

import javax.validation.constraints.NotNull;

public class CategoryDTO {
    private int id;


    @NotNull(message = "name.validation")
    private String name;

    public CategoryDTO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public CategoryDTO(String name) {
        this.name = name;
    }

    public CategoryDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
