package com.irfan.quora_sample.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestionRequestDTO {

    @NotBlank
    @Size(min = 5, max = 100, message = "Title should be min 5")
    private String title;

    @NotBlank
    @Size(min=5, max = 1000, message = "Content should be min 5")
    private String content;
}
