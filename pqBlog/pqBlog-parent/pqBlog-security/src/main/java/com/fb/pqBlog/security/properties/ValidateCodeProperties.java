package com.fb.pqBlog.security.properties;

public class ValidateCodeProperties {

    private ImageValidate image = new ImageValidate();

    private Integer expireIn = new Integer(60);


    public ImageValidate getImage() {
        return image;
    }

    public void setImage(ImageValidate image) {
        this.image = image;
    }

    public Integer getExpireIn() {
        return expireIn;
    }

    public void setExpireIn(Integer expireIn) {
        this.expireIn = expireIn;
    }
}
