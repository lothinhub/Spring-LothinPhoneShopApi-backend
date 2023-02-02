package com.lothin.phoneshp.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaginationDTO {
    private Long numberOfElements;
    private Long number;
    private Long size;
    private Long totalElements;
    private Long totalPages;
    private boolean empty;
    private boolean first;
    private boolean last;
}
