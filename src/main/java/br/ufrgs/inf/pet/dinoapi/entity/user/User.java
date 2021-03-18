package br.ufrgs.inf.pet.dinoapi.entity.user;

import br.ufrgs.inf.pet.dinoapi.constants.ResponsibleAuthConstants;
import br.ufrgs.inf.pet.dinoapi.entity.auth.Auth;
import br.ufrgs.inf.pet.dinoapi.entity.auth.google.GoogleAuth;
import br.ufrgs.inf.pet.dinoapi.entity.contacts.Contact;
import br.ufrgs.inf.pet.dinoapi.entity.faq.FaqUserQuestion;
import br.ufrgs.inf.pet.dinoapi.entity.note.NoteColumn;
import br.ufrgs.inf.pet.dinoapi.entity.synchronizable.SynchronizableEntity;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

import static br.ufrgs.inf.pet.dinoapi.constants.UserConstants.*;

@Entity
@Table(name = "dino_user")
public class User extends SynchronizableEntity<Long> {
    @Column(name = "name", length = NAME_MAX, nullable = false)
    private String name;

    @Column(name = "email", length = EMAIL_MAX, unique = true, nullable = false)
    private String email;

    @Column(name = "picture_url", length = PICTURE_URL_MAX, nullable = false)
    private String pictureURL;

    @OneToOne(mappedBy = "user")
    private GoogleAuth googleAuth;

    @OneToOne(mappedBy = "user")
    private UserSettings userSettings;

    @Column(name = "responsible_token", length = ResponsibleAuthConstants.RESPONSIBLE_TOKEN_MAX)
    private String responsibleToken;

    @Column(name = "responsible_code", length = ResponsibleAuthConstants.RESPONSIBLE_CODE_LENGTH)
    private String responsibleCode;

    @Column(name = "responsible_iv", length = ResponsibleAuthConstants.RESPONSIBLE_CODE_LENGTH)
    private String responsibleIV;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Auth> auths;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<NoteColumn> noteColumns;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Contact> contacts;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<FaqUserQuestion> faqUserQuestions;

    public User() { }

    public User(String name, String email, String pictureURL) {
        this.name = name;
        this.email = email;
        this.pictureURL = pictureURL;
        this.lastUpdate = LocalDateTime.now();
    }

    public boolean hasGoogleAuth() {
        return googleAuth != null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }

    public GoogleAuth getGoogleAuth() {
        return googleAuth;
    }

    public void setGoogleAuth(GoogleAuth googleAuth) {
        this.googleAuth = googleAuth;
    }

    public UserSettings getUserAppSettings() {
        return userSettings;
    }

    public void setUserAppSettings(UserSettings userSettings) {
        this.userSettings = userSettings;
    }

    public String getResponsibleToken() {
        return responsibleToken;
    }

    public void setResponsibleToken(String responsibleToken) {
        this.responsibleToken = responsibleToken;
    }

    public String getResponsibleCode() {
        return responsibleCode;
    }

    public void setResponsibleCode(String responsibleCode) {
        this.responsibleCode = responsibleCode;
    }

    public String getResponsibleIV() {
        return responsibleIV;
    }

    public void setResponsibleIV(String responsibleIV) {
        this.responsibleIV = responsibleIV;
    }
}
