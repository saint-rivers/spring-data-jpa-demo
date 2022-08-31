package com.ksga.jpademo.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public
class PageResponse<T> {
    private Integer totalPages;
    private Long totalElements;
    private T payload;
}
