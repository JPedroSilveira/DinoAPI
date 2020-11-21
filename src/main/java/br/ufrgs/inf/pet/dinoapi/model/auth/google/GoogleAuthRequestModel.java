package br.ufrgs.inf.pet.dinoapi.model.auth.google;

import br.ufrgs.inf.pet.dinoapi.constants.GoogleAuthConstants;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class GoogleAuthRequestModel {
    @NotNull
    private String code;

    @NotNull
    @Size(min = 1, max = 10, message = GoogleAuthConstants.SCOPE_LIST_MAX_SIZE)
    private List<String> scopeList;

    public GoogleAuthRequestModel() {}

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<String> getScopeList() {
        return scopeList;
    }

    public void setScopeList(List<String> scopeList) {
        this.scopeList = scopeList;
    }
}
