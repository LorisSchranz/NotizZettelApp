package sample;


public class Note {
    private String Title;
    private String Content;
    Note(String Title, String Content){
        super();
        this.Title = Title;
        this.Content = Content;
    }

    public String toString() { return this.Title;}


    public String getTitle() {
        return this.Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getContent() {
        return this.Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}