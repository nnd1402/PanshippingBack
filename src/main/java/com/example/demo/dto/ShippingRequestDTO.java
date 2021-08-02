package com.example.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ShippingRequestDTO {

	private Long userId;
	private Long productId;
}
