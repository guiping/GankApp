package so.lvy.app.gankapp.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ping on 2016/4/28.
 * 每日最新Entity
 */
public class LatestDailyEntity extends BaseEntity {

    @SerializedName("category")
    List<Category> get分类List;
    @SerializedName("Android")
    List<GankAppEntity> getAndroidList;
    @SerializedName("iOS")
    List<GankAppEntity> getIosList;
    @SerializedName("休息视频")
    List<GankAppEntity> get休息视频List;
    @SerializedName("拓展资源")
    List<GankAppEntity> get拓展资源List;
    @SerializedName("瞎推荐")
    List<GankAppEntity> get瞎推荐List;
    @SerializedName("福利")
    List<GankAppEntity> get福利List;

    public List<Category> getGet分类List() {
        return get分类List;
    }

    public void setGet分类List(List<Category> get分类List) {
        this.get分类List = get分类List;
    }

    public List<GankAppEntity> getGetAndroidList() {
        return getAndroidList;
    }

    public void setGetAndroidList(List<GankAppEntity> getAndroidList) {
        this.getAndroidList = getAndroidList;
    }

    public List<GankAppEntity> getGetIosList() {
        return getIosList;
    }

    public void setGetIosList(List<GankAppEntity> getIosList) {
        this.getIosList = getIosList;
    }

    public List<GankAppEntity> getGet休息视频List() {
        return get休息视频List;
    }

    public void setGet休息视频List(List<GankAppEntity> get休息视频List) {
        this.get休息视频List = get休息视频List;
    }

    public List<GankAppEntity> getGet拓展资源List() {
        return get拓展资源List;
    }

    public void setGet拓展资源List(List<GankAppEntity> get拓展资源List) {
        this.get拓展资源List = get拓展资源List;
    }

    public List<GankAppEntity> getGet瞎推荐List() {
        return get瞎推荐List;
    }

    public void setGet瞎推荐List(List<GankAppEntity> get瞎推荐List) {
        this.get瞎推荐List = get瞎推荐List;
    }

    public List<GankAppEntity> getGet福利List() {
        return get福利List;
    }

    public void setGet福利List(List<GankAppEntity> get福利List) {
        this.get福利List = get福利List;
    }

    public class Category {
        String categoryName;

        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }
    }
}
