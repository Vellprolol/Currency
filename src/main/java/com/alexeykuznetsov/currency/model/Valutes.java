package com.alexeykuznetsov.currency.model;

import javax.xml.bind.annotation.*;
import java.util.List;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "ValCurs")
public class Valutes {
    @XmlElement(name = "Valute")
    private List<Currency> currencyList;

    public List<Currency> getCurrencyList() {
        return currencyList;
    }

    public void setCurrencyList(List<Currency> currencyList) {
        this.currencyList = currencyList;
    }
}
