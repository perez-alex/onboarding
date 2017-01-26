package com.example.aperez.retrofittest.mvp.model.db;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;
import com.example.aperez.retrofittest.mvp.model.Image;

import java.util.List;

/**
 * Created by aperez on 26/01/17.
 */

@Table(name = "Images")
public class StoredImage extends Model {

    @Column(unique = true, onUniqueConflict = Column.ConflictAction.REPLACE)
    Long imageId;
    @Column
    String url;
    @Column
    String largeUrl;

    public StoredImage() {
        super();
    }

    public StoredImage(Image image) {
        super();
        imageId = image.getImageId();
        url = image.getUrl();
        largeUrl = image.getLargeUrl();
    }

    public Long getImageId() {
        return imageId;
    }

    public String getLargeUrl() {
        return largeUrl;
    }

    public String getUrl() {
        return url;
    }

    public static List<StoredImage> getAll() {
        return new Select()
                .from(StoredImage.class)
                .execute();
    }
}
