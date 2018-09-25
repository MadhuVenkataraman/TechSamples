package com.virtusa.workouts.springworkout.types;

import javax.xml.bind.annotation.*;
import java.util.List;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "accountBatchRequest"
})
@XmlRootElement(name = "accountRequests")
public class AccountBatchRequest {
    @XmlElement
    private List<AccountRequest> accountBatchRequest;

    public List<AccountRequest> getAccountBatchRequest() {
        return accountBatchRequest;
    }

    public void setAccountBatchRequest(List<AccountRequest> accountBatchRequest) {
        this.accountBatchRequest = accountBatchRequest;
    }
}
