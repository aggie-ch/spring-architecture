package io.github.aggie.common;

import lombok.Value;

import java.util.List;

@Value
public class PageResult<T> {

    List<T> data;
    int pageNumber;
    int totalPages;
}
