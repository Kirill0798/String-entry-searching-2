package beans.session;

import javax.ejb.Stateless;
import java.io.Serializable;

@Stateless
public class SearchExecutorBean implements Serializable {
    public String search(String first, String second) {
        String result;
        Integer index = first.lastIndexOf(second);
        if (index != -1) {
            result = index.toString();
            return result;
        } else {
            return null;
        }
    }
}
