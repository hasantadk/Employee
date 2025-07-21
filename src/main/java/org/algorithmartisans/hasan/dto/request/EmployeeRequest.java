package org.algorithmartisans.hasan.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequest {
    @NotBlank(message = "Bu alan boş bırakılamaz")
    @Min(value = 3,message = "karakter sayısı 3ten küçük olamaz")
    @Max(value = 25,message = "karakter sayısı 25ten büyük olamaz")
    private String name;
    @NotBlank(message = "lastName alanı boş bırakılamaz.")
    @Min(value = 3,message = "karakter sayısı 3ten küçük olamaz")
    @Max(value = 5,message = "karakter sayısı 25ten büyük olamaz")
    private String lastName;
}
