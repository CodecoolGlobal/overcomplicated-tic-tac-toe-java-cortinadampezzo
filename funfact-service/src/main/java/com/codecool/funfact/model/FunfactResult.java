package com.codecool.funfact.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FunfactResult {

    private String category;
    private String icon_url;
    private String id;
    private String url;
    private String value;

}
