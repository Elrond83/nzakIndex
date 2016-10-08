package ua.nox.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

/**
 * Created by onitsov on 10/6/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Data
public class NzakItem {

    @Id
    @Column(columnDefinition =  "BINARY(16)")
    private UUID id;
    @JsonProperty("firstname")
    private String firstName;
    @JsonProperty("lastname")
    private String lastName;
    private String placeOfWork;
    private String position;
    @JsonProperty("linkPDF")
    private String linkPdf;
}
