package com.quebic.auth.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.quebic.common.model.EntityBase;
import com.quebic.common.model.Permission;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@Document(collection = "Role")
@NoArgsConstructor
public class Role extends EntityBase {

    public static final String ROLE_ADMIN = "role.admin";
    public static final String ROLE_SELLER_ADMIN = "role.seller.admin";
    public static final String ROLE_SELLER = "role.seller";
    public static final String ROLE_BUYER = "role.buyer";

    private String code;

    @DBRef
    private List<Permission> permissions = new ArrayList<>();

    public Role(String id) {
        setId(id);
    }

    //TODO
    @JsonIgnore
    public List<Permission> getPermissions() {
        return permissions;
    }

    public static Role Create_Admin() { return new Role(Role.ROLE_ADMIN); }

    public static Role Create_Seller_Admin() { return new Role(Role.ROLE_SELLER_ADMIN); }

    public static Role Create_Seller() { return new Role(Role.ROLE_SELLER); }

    public static Role Create_Buyer() { return new Role(Role.ROLE_BUYER); }

    public static boolean checkUserIs_Admin(User user) { return checkUserType(user, Role.Create_Admin()); }

    public static boolean checkUserIs_Seller_Admin(User user) { return checkUserType(user, Role.Create_Seller_Admin()); }

    public static boolean checkUserIs_Seller(User user) { return checkUserType(user, Role.Create_Seller()); }

    public static boolean checkUserIs_Buyer(User user) { return checkUserType(user, Role.Create_Buyer()); }

    public static boolean checkUserType(User user, Role... roles) {
        boolean containsRole = Arrays.stream(roles).anyMatch(checkRole -> user.getRoles().contains(checkRole));
        return containsRole;
//		for(Role checkRole : roles){
//
//			if(user.getRoles().contains(checkRole))
//				return true;
//
//		}
//		return false;
    }
}