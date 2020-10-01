package br.ufrgs.inf.pet.dinoapi.model.notes;

import br.ufrgs.inf.pet.dinoapi.constants.NoteColumnConstants;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class NoteColumnSaveRequestModel {
    private Long id;

    private Integer order;

    @NotNull(message = NoteColumnConstants.TITLE_NULL_MESSAGE)
    @Size(max = NoteColumnConstants.TITLE_MAX, min = NoteColumnConstants.TITLE_MIN, message = NoteColumnConstants.TITLE_SIZE_MESSAGE)
    private String title;

    @NotNull(message = NoteColumnConstants.LAST_UPDATE_NULL_MESSAGE)
    private Long lastUpdate;

    private Long lastOrderUpdate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Long lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Long getLastOrderUpdate() {
        return lastOrderUpdate;
    }

    public void setLastOrderUpdate(Long lastOrderUpdate) {
        this.lastOrderUpdate = lastOrderUpdate;
    }
}
