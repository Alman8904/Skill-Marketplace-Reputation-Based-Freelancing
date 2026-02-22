package com.Skill.Marketplace.SM.DTO.OrderDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class DeliverWorkDTO {

    @NotNull(message = "Order ID cannot be null")
    private Long orderId;

    @NotBlank(message = "Delivery notes cannot be blank")
    private String deliveryNotes;

    @Pattern(regexp = "^$|^https?://.+", message = "Delivery URL must start with http:// or https://")
    private String deliveryUrl;
}
