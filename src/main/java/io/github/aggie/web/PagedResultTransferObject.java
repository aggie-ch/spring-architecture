package io.github.aggie.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PagedResultTransferObject<T> {

    private List<T> data;
    private int pageNumber;
    private int totalPages;
}
