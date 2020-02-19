
package beans.managed;

import beans.session.SearchExecutorBean;
//import database.DatabaseUtil;
//import database.entity.SearchingEntity;
//import database.entity.SearchingEntityPK;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;

@ManagedBean
@SessionScoped
@XmlRootElement
public class SearchBean implements Serializable {
    private String firstString ;
    private String secondString;
    private String result;

    @EJB
    @XmlTransient
    private SearchExecutorBean searchExecutorBean;

    public SearchBean(){
    }

    public SearchBean(String firstString, String secondString, String result){
        this.firstString = firstString;
        this.secondString = secondString;
        this.result = result;
    }

    public String getFirstString(){return firstString;}
    public void setFirstString(String firstString){ this.firstString = firstString;}

    public String getSecondString(){return secondString;}
    public void setSecondString(String secondString){this.secondString = secondString;}

    public void setResult(String result){ this.result = result; }
    public String getResult() { return result;  }

    public String searchResult(){
            result = searchExecutorBean.search(firstString, secondString);
        return "/result.xhtml?faces-redirect=true";
    }
}
