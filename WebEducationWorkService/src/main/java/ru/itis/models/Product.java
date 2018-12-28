package ru.itis.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Product {
    private long id;
    private String name;
    private int pageCost;
    private String photo;
    private int count;
}
