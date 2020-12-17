package br.ufrgs.inf.pet.dinoapi.entity.faq;

import br.ufrgs.inf.pet.dinoapi.entity.contacts.EssentialContact;
import br.ufrgs.inf.pet.dinoapi.model.faq.FaqSaveRequestModel;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static br.ufrgs.inf.pet.dinoapi.constants.FaqConstants.TITLE_MAX;
import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "faq")
public class Faq implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final String SEQUENCE_NAME = "faq_seq";

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(name = SEQUENCE_NAME, sequenceName = SEQUENCE_NAME)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "version", nullable = false)
    private Long version;

    @Column(name = "title", length = TITLE_MAX, nullable = false, unique = true)
    private String title;

    @OneToMany(mappedBy = "faq", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<FaqItem> items;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<FaqUser> faqUsers;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<FaqUserQuestion> faqFaqUserQuestions;

    @OneToMany(mappedBy = "faq")
    private List<EssentialContact> essentialContacts;

    public Faq() {
        this.items = new ArrayList<>();
    }

    public Faq(FaqSaveRequestModel faqSaveRequestModel) {
        this.setVersion(1L);
        this.setTitle(faqSaveRequestModel.getTitle());
        this.setItems(new ArrayList<>());
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<FaqItem> getItems() {
        return items;
    }

    public void setItems(List<FaqItem> items) {
        this.items = items;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public List<FaqUser> getFaqUsers() {
        return faqUsers;
    }

    public void setFaqUsers(List<FaqUser> faqUsers) {
        this.faqUsers = faqUsers;
    }

    public List<FaqUserQuestion> getFaqFaqUserQuestions() {
        return faqFaqUserQuestions;
    }

    public void setFaqFaqUserQuestions(List<FaqUserQuestion> faqFaqUserQuestions) {
        this.faqFaqUserQuestions = faqFaqUserQuestions;
    }

    public void updateVersion() {
        this.version = version + 1l;
    }

}
