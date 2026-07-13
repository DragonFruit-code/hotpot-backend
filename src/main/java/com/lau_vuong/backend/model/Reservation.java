package com.lau_vuong.backend.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import java.time.LocalDateTime;

@Data
@Document(collection = "reservations")
public class Reservation {
    @Id
    private String id;
    
    @NotBlank(message = "Branch is required")
    private String branch;
    
    private String branchName;
    
    @Min(value = 1, message = "Guests count must be at least 1")
    private int guests;
    
    @NotBlank(message = "Date is required")
    private String date;
    
    @NotBlank(message = "Time slot is required")
    private String time;
    
    @NotBlank(message = "Customer name is required")
    private String name;
    
    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^(0|\\+84)(\\d{9})$", message = "Invalid Vietnamese phone number format (must start with 0 or +84 followed by 9 digits)")
    private String phone;
    
    private String notes;
    private String code; // Reservation code (e.g. LV-123456)
    
    private LocalDateTime createdAt = LocalDateTime.now();
}
