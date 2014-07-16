package com.makototech.i18n;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

@ManagedBean(name = "languageBean")
@SessionScoped
public class LanguageBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String localeCode = "en_US";

    private static Map<String, Locale> countries;

    static {
        countries = new LinkedHashMap<String, Locale>(); //label, value
        countries.put("Arabic", new Locale("ar"));
        countries.put("Czech (Czech Republic)", new Locale("cs", "CZ"));
        countries.put("German (Germany)", Locale.GERMANY);
        countries.put("English (Australia)", new Locale("en", "AU"));
        countries.put("English (United Kingdom)", Locale.UK);
        countries.put("English (Ireland)", new Locale("en", "IE"));
        countries.put("English (United States)", Locale.US);
        countries.put("English (South Africa)", new Locale("en", "ZA"));
        countries.put("Spanish (Spain)", new Locale("es", "ES"));
        countries.put("Spanish (United States)", new Locale("es", "US"));
        countries.put("French (France)", Locale.FRANCE);
        countries.put("Italian (Italy)", Locale.ITALY);
        countries.put("Polish (Poland)", new Locale("pl", "PL"));
        countries.put("Portuguese (Brazil)", new Locale("pt", "BR"));
        countries.put("Russian (Russia)", new Locale("ru", "RU"));
        countries.put("Turkish (Turkey)", new Locale("tr", "TR"));
        countries.put("Chinese (China)", Locale.SIMPLIFIED_CHINESE);
    }

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
    public void countryLocaleCodeChanged(ValueChangeEvent e) {

        String newLocaleValue = e.getNewValue().toString();

        // Loop country map to compare the locale code
        for (Map.Entry<String, Locale> entry : countries.entrySet()) {
            if (entry.getValue().toString().equals(newLocaleValue)) {
                FacesContext.getCurrentInstance().getViewRoot().setLocale(entry.getValue());
            }
        }
    }
}
