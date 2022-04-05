package com.alexeykuznetsov.currency.XMLparser;

import com.alexeykuznetsov.currency.model.Valutes;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.net.URL;

public class XMLToObject {

    public static Valutes XMLtoObject() {
        Valutes valutes = null;
        try {
            URL url = new URL("http://www.cbr.ru/scripts/XML_daily.asp");
            JAXBContext jaxbContext = JAXBContext.newInstance(Valutes.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
             valutes = (Valutes) jaxbUnmarshaller.unmarshal(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return valutes;
    }
}
