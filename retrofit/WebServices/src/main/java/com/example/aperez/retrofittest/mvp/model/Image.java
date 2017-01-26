package com.example.aperez.retrofittest.mvp.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by aperez on 24/01/17.
 */

@Table(name = "Images")
public class Image extends Model{

    @Column(unique = true, onUniqueConflict = Column.ConflictAction.REPLACE)
    @SerializedName("id")
    Long imageId;
    @Column
    String url;
    @Column
    @SerializedName("large_url")
    String largeUrl;
    String copyright;
    String site;

    public Image(){
        super();
    }

    public Long getImageId() {
        return imageId;
    }

    public String getUrl() {
        return url;
    }

    public String getLargeUrl() {
        return largeUrl;
    }

    public String getCopyright(){
        return copyright;
    }

    public String getSite(){
        return site;
    }

    public static List<Image> getAll(){
        return new Select()
                .from(Image.class)
                .execute();
    }
}
