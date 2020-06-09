package com.example.projectname.api.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerResponse {

    @NotEmpty(message = "deve ser preenchido")
    @Pattern(regexp = "^[a-zA-ZA-Za-záàâãäéèêẽëíìĩïóòôõöúùûũüçñÁÀÂÃÄÉÈÊẼËÍÌÎĨÏÓÒÔÕÖÚÙÛŨÜÇÑ]+([a-zA-ZA-Za-záàâãäéèêẽëíìĩïóòôõöúùûũüçñÁÀÂÃÄÉÈÊẼËÍÌÎĨÏÓÒÔÕÖÚÙÛŨÜÇÑ ]" +
            "?[a-zA-ZA-Za-záàâãäéèêẽëíìĩïóòôõöúùûũüçñÁÀÂÃÄÉÈÊẼËÍÌÎĨÏÓÒÔÕÖÚÙÛŨÜÇÑ]*)*$*", message = "Apenas letras são permitidas")
    private String firstname;

    @NotEmpty(message = "deve ser preenchido")
    @Size(min = 2, max = 200, message = "Sobrenome deve ter entre 3 e 200 letras")
    @Pattern(regexp = "^[a-zA-ZA-Za-záàâãäéèêẽëíìĩïóòôõöúùûũüçñÁÀÂÃÄÉÈÊẼËÍÌÎĨÏÓÒÔÕÖÚÙÛŨÜÇÑ]+([a-zA-ZA-Za-záàâãäéèêẽëíìĩïóòôõöúùûũüçñÁÀÂÃÄÉÈÊẼËÍÌÎĨÏÓÒÔÕÖÚÙÛŨÜÇÑ ]" +
            "?[a-zA-ZA-Za-záàâãäéèêẽëíìĩïóòôõöúùûũüçñÁÀÂÃÄÉÈÊẼËÍÌÎĨÏÓÒÔÕÖÚÙÛŨÜÇÑ]*)*$*", message = "Apenas letras são permitidas")
    private String lastname;

    @NotEmpty(message = "deve ser preenchido")
    @Email(message = "Email não está em um formato válido.")
    private String email;

    @Pattern(regexp = "^[0-9]+$", message = "telefone deve ter somente números")
    private String cellphone;

    @NotEmpty(message = "deve ser preenchido")
    @Pattern(regexp = "^(((((0[1-9])|(1\\d)|(2[0-8]))/((0[1-9])|(1[0-2])))|((31/((0[13578])|(1[02])))|((29|30)/((0[1,3-9])|(1[0-2])))))/((20[0-9][0-9]))|((((0[1-9])|(1\\d)|(2[0-8]))/((0[1-9])|(1[0-2])))|((31/((0[13578])|(1[02])))|((29|30)/((0[1,3-9])|(1[0-2])))))/((19[0-9][0-9]))|(29/02/20(([02468][048])|([13579][26])))|(29/02/19(([02468][048])|([13579][26]))))$", message = "Deve estar no formato dd/MM/yyyy")
    private String birthDate;

    private String gender;

    private String dependentType;

    private String customerType;

    private String userId;

    private Boolean deviceVerified;

    private Boolean biometryEnabled;

    private String parentId;

    @NotNull(message = "termo de aceite deve ser preenchido")
    private Boolean agreed;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDependentType() {
        return dependentType;
    }

    public void setDependentType(String dependentType) {
        this.dependentType = dependentType;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Boolean getDeviceVerified() {
        return deviceVerified;
    }

    public void setDeviceVerified(Boolean deviceVerified) {
        this.deviceVerified = deviceVerified;
    }

    public Boolean getBiometryEnabled() {
        return biometryEnabled;
    }

    public void setBiometryEnabled(Boolean biometryEnabled) {
        this.biometryEnabled = biometryEnabled;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Boolean getAgreed() {
        return agreed;
    }

    public void setAgreed(Boolean agreed) {
        this.agreed = agreed;
    }

}
