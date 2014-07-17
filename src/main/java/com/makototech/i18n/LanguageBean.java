package com.makototech.i18n;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.trimToNull;

@ManagedBean(name = "languageBean")
@SessionScoped
public class LanguageBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private static Map<String, Locale> countries;

    static {
        countries = new LinkedHashMap<String, Locale>(); //label, value
        countries.put("Arabic", new Locale("ar"));
        countries.put("German (Germany)", Locale.GERMANY);
        countries.put("English (United Kingdom)", Locale.UK);
        countries.put("English (United States)", Locale.US);
        countries.put("Spanish (Spain)", new Locale("es", "ES"));
        countries.put("French (France)", Locale.FRANCE);
        countries.put("Chinese (China)", Locale.SIMPLIFIED_CHINESE);
    }

    private String localeCode = "en_US";

    public Map<String, Locale> getCountriesInMap() {
        return countries;
    }

    public String getLocaleCode() {
        return localeCode;
    }

    public void setLocaleCode(String localeCode) {
        this.localeCode = localeCode;
    }

    //value change event listener
    public void countryLocaleCodeChanged() {
        if (trimToNull(localeCode) != null) {
            // Loop country map to compare the locale code
            for (Map.Entry<String, Locale> entry : countries.entrySet()) {
                if (entry.getValue().toString().equals(localeCode)) {
                    FacesContext.getCurrentInstance().getViewRoot().setLocale(entry.getValue());
                }
            }
        }
    }
}
