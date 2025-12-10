package app.mobile.BK_Kindergarten.menu.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class AddNewDishRequest {
    private String dname;
    private Integer vitamin = 0;
    private Integer fat = 0;
    private Integer protein = 0;
    private Integer carbohydrate = 0;
    private String nutrients;
    private String allergy;

    public String getDname() {
        return dname;
    }
}

