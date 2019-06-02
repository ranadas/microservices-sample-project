package com.quebic.auth.api.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.quebic.common.model.EntityBase;
import com.quebic.common.model.Permission;
import com.quebic.common.model.image.ImageContainer;

@Getter @Setter
@Document(collection="User")
public class User extends EntityBase{

    private String email;
    
	private String username;

    private String password;
    
    private String firstName;

    private String lastName;
    
    private ImageContainer profileImageContainer = new ImageContainer();

    private ImageContainer coverImageContainer = new ImageContainer();

    private Date lastLoggedOn;

    private Date registeredOn;

    private Integer attempts;

    @DBRef
    private List<Role> roles = new ArrayList<>();

    @DBRef
    private List<Permission> permissions = new ArrayList<>();
    
    private EmailVerification emailVerification;
    
    private Date lastPasswordResetDate;
    
    private SellerProfile sellerProfile = new SellerProfile();
    private BuyerProfile buyerProfile = new BuyerProfile();

    //TODO
	@JsonIgnore
    public String getPassword() {
        return password;
    }

	public ImageContainer getProfileImageContainer() {
		return profileImageContainer;
	}

	public void setProfileImageContainer(ImageContainer profileImageContainer) {
		this.profileImageContainer = profileImageContainer;
	}

	public ImageContainer getCoverImageContainer() {
		return coverImageContainer;
	}

	public void setCoverImageContainer(ImageContainer coverImageContainer) {
		this.coverImageContainer = coverImageContainer;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	@JsonIgnore
	public List<Permission> getPermissions() {
		return permissions;
	}

	@JsonIgnore
	public EmailVerification getEmailVerification() {
		return emailVerification;
	}

	@JsonIgnore
	public Date getLastPasswordResetDate() {
		return lastPasswordResetDate;
	}

}
