package so.lvy.app.gankapp.bean;

import java.util.List;

/**
 * Created by ping on 2016/4/19.
 */
public class GankAppAllDataEntity extends BaseEntity {
    private List<GankAppEntity> results;

    public List<GankAppEntity> getResults() {
        return results;
    }

    public void setResults(List<GankAppEntity> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "GankAppAllDataEntity{" +
                "results=" + results +
                '}';
    }
}
