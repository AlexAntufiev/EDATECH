package ru.eda.tech.controller.api.update;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Entity update response object, which contains response information")
public class EntityUpdateResponse {

    @ApiModelProperty(notes = "Entity id")
    private Long id;

    @ApiModelProperty(notes = "Entity name")
    private String name;

    public EntityUpdateResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @JsonGetter("id")
    public Long getId() {
        return id;
    }

    @JsonGetter("name")
    public String getName() {
        return name;
    }
}
