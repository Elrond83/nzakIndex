package ua.nox.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * Created by onitsov on 10/7/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class NzakResponse {
    @JsonProperty("items")
    private List<NzakItem> items;
}
