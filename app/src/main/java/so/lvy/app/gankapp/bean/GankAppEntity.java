package so.lvy.app.gankapp.bean;

/**
 * Created by ping on 2016/4/19.
 */
public class GankAppEntity {

    /**
     * _id : 5715097267765974f5e27db0
     * createdAt : 2016-04-19T00:21:06.420Z  //创建时间
     * desc : 水平进度条                       //介绍
     * publishedAt : 2016-04-19T12:13:58.869Z   //提交时间
     * source : chrome                         //资源
     * type : Android                          //类型   福利 | Android | iOS | 休息视频 | 拓展资源 | 前端 | all
     * url : https://github.com/MasayukiSuda/AnimateHorizontalProgressBar   //链接
     * used : true
     * who : Jason                                                    //作者
     */

    private String _id;
    private String createdAt;
    private String desc;
    private String publishedAt;
    private String source;
    private String type;
    private String url;
    private boolean used;
    private String who;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }
}
