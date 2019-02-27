package army.helpful.app.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Title extends BasicModel {
    @JsonIgnoreProperties("title")
    @OneToMany(mappedBy = "title", cascade = CascadeType.ALL)
    private List<Content> contents = new ArrayList<>();

    public Title() {
    }
    public List<Content> getContents() {
        return contents;
    }

    public void setContents(List<Content> contents) {
        this.contents = contents;
    }
}
