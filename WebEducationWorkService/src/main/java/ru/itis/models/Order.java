package ru.itis.models;


import lombok.*;

@Data
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Order {
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
