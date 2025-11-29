package app.mobile.BK_Kindergarten.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Data Transfer Object (DTO) for an Item.
 * This class defines the structure of the data sent to the frontend.
 */

@Getter
@AllArgsConstructor
public class DtoItem {
    private final Long id;
    private final String name;

}