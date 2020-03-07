package Gson;

public class Image {
    private String title;
    private String ImageUrl;

    public Image(String imageUrl){
        this.ImageUrl=imageUrl;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return ImageUrl;
    }
}
