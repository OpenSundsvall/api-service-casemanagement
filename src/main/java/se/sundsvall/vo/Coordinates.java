package se.sundsvall.vo;

import lombok.Getter;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Getter
@Setter
public class Coordinates {

    @Schema(description = "Decimal Degrees (DD)", example = "62.390205")
    private double latitude;
    @Schema(description = "Decimal Degrees (DD)", example = "17.306616")
    private double longitude;

}
