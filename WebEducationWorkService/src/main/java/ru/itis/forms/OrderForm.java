package ru.itis.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderForm {
    private Long id;
    private Long userId;
    private Long productId;
    private String name;
    private String photo;
    private String theme;
    private String comment;
    private int period_of_execution;
    private int min_pages_count;
    private  int max_pages_count;
    private int cost;
}
