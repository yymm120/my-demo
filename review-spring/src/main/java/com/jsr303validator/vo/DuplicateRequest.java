package com.jsr303validator.vo;

import com.jsr303validator.validation.mylistvalidate.ValidDuplicate;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;


// @ValidDuplicate
public class DuplicateRequest {

    public DuplicateRequest(String duplicateListName) {
        this.duplicateListName = duplicateListName;
    }

    @NotEmpty
    private String duplicateListName;


    public String getDuplicateListName() {
        return duplicateListName;
    }

    public void setDuplicateListName(String duplicateListName) {
        this.duplicateListName = duplicateListName;
    }
}
