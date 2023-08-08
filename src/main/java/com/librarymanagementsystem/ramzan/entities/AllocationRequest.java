package com.librarymanagementsystem.ramzan.entities;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class AllocationRequest {
    private UUID allocatedTo;
    private UUID bookInf;
    private UUID issuedBy;

}
