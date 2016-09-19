package desu.nano.web.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by Ker on 19.09.2016.
 */
@ManagedBean(name = "navigation")
@SessionScoped
public class NavigationBean {
    private String currentPage;

    public String getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(String currentPage) {
        this.currentPage = currentPage;
    }
}
