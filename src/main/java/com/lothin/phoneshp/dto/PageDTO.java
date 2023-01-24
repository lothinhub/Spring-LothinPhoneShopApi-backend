package com.lothin.phoneshp.dto;

import java.util.List;

// import org.springframework.data.domain.Page;

import lombok.Data;

@Data
public class PageDTO {
    private List<?> list;
    private PaginationDTO pagination;

    // public PageDTO(Page<?> page) {
    //     this.list = page.getContent();

        /*
         * this.pagination = PaginationDTO.builder()
         * .last(page.isLast())
         * .first(page.isFirst())
         * .build();
         */

        /*
         * this.pagination = new PaginationDTO();
         * this.pagination.setEmpty(page.isEmpty());
         * this.pagination.setFirst(page.isFirst());
         * this.pagination.setLast(page.isLast());
         * this.pagination.setNumber(page.getNumber());
         * this.pagination.setNumberOfElements(page.getNumberOfElements());
         * this.pagination.setSize(page.getSize());
         * this.pagination.setTotalPages(page.getTotalPages());
         * this.pagination.setTotalElements((int) page.getTotalElements());
         */
    // }
}
