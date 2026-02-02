package com.Skill.Marketplace.SM.DTO.OrderDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class createOrderDTO {

    @NotNull
    private Long providerId;
    @NotNull
    private Long skillId;
    @NotBlank
    @Size(min = 10, max = 500)
    private String description;
}
