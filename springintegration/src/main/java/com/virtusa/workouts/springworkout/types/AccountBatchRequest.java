package com.virtusa.workouts.springworkout.types;

import javax.xml.bind.annotation.*;
import java.util.List;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "accountRequests"
})
@XmlRootElement(name = "accountRequests")
public class AccountBatchRequest {
    @XmlElement
    private List<AccountRequest> accountRequests;

    public List<AccountRequest> getAccountRequests() {
        return accountRequests;
    }

    public void setAccountRequests(List<AccountRequest> accountRequests) {
        this.accountRequests = accountRequests;
    }
}
