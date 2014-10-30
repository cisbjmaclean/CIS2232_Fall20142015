package beans;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 *
 * @author BJ
 */
public class CodeValue {

    private String description;
    private String descriptionShort;

    //This must be between 1-16 inclusive
    @Min(value = 1, message = "Code must be greater than 1.")
    @Max(value = 17, message = "Code must not be greater than 17.")
    private int codeTypeId;

    private int codeValueSequence;

    public CodeValue(String description, String descriptionShort, int codeTypeId, int codeValueSequence) {
        this.description = description;
        this.descriptionShort = descriptionShort;
        this.codeTypeId = codeTypeId;
        this.codeValueSequence = codeValueSequence;
    }

    public CodeValue() {
        //nothing.
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescriptionShort() {
        return descriptionShort;
    }

    public void setDescriptionShort(String descriptionShort) {
        this.descriptionShort = descriptionShort;
    }

    public int getCodeTypeId() {
        return codeTypeId;
    }

    public void setCodeTypeId(int codeTypeId) {
        this.codeTypeId = codeTypeId;
    }

    public int getCodeValueSequence() {
        return codeValueSequence;
    }

    public void setCodeValueSequence(int codeValueSequence) {
        this.codeValueSequence = codeValueSequence;
    }

}
