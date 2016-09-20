package desu.nano.web.beans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.*;

/**
 * Created by Ker on 19.09.2016.
 */
@ManagedBean(name = "translator")
@SessionScoped
public class Translator implements Serializable {
    private String localeCode;
    private static Map<String,Locale> countries;
    static{
        countries = new HashMap<>();
        countries.put("English", Locale.ENGLISH); //label, value
        countries.put("日本語", Locale.JAPANESE);
        countries.put("Русский", new Locale("ru", "RU"));
        countries = Collections.unmodifiableMap(countries);
    }
    public String translate(String source) {
        return source;
    }

    public String getLocaleCode() {
        return localeCode;
    }

    @PostConstruct
    public void init() {
        final Locale currentLocale = Locale.ENGLISH ;
        localeCode = countries.entrySet().stream().filter(stringLocaleEntry ->
                currentLocale.getLanguage().equals(stringLocaleEntry.getValue().getLanguage())).
                findFirst().get().getKey();
    }

    public Set<String> getCountries() {
        return countries.keySet();
    }

    public void onCountryChange(String newLocaleValue) {
        FacesContext.getCurrentInstance()
                .getViewRoot().setLocale(countries.get(newLocaleValue));
        localeCode = newLocaleValue;
    }

    public void setLocaleCode(String localeCode) {
        this.localeCode = localeCode;
    }

    public Locale getLocale() {
        return countries.getOrDefault(localeCode, Locale.ENGLISH);
    }
}