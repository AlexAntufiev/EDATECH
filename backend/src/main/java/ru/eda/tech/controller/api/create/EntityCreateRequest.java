package ru.eda.tech.controller.api.create;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Entity create request object, which contains request information")
public class EntityCreateRequest {

    @ApiModelProperty(notes = "Entity name")
    private String name;

    @JsonCreator
    public EntityCreateRequest(@JsonProperty("name") String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
