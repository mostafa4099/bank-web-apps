/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addhandler;

import dao.GetDao;
import dao.SetDao;
import entity.AccountInfo;
import entity.User;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author Mostafa(R-34)
 */
@ManagedBean
public class UserMB {

    User user = new User();
    AccountMB accountMB = new AccountMB();
    AccountInfo account = new AccountInfo();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public AccountMB getAccountMB() {
        return accountMB;
    }

    public void setAccountMB(AccountMB accountMB) {
        this.accountMB = accountMB;
    }

    public AccountInfo getAccount() {
        return account;
    }

    public void setAccount(AccountInfo account) {
        this.account = account;
    }

    public String userSignUp() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (accountMB.getAccnumber() == 0) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Account Number Is Required!", ""));
        } else {
            AccountInfo acc = new GetDao().getAccountInfo(accountMB.getAccnumber());
            if (acc != null) {
                user.setAccountInfo(acc);
                user.setName(user.getName());
                user.setEmail(user.getEmail());
                user.setUserName(user.getUserName());
                user.setPassword(user.getPassword());
                boolean status = new SetDao().createUser(user);
                if (user.getName().equals("")) {
                    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Name Is Required!", ""));
                } else if (user.getEmail().equals("")) {
                    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Email Is Required!", ""));
                } else if (user.getUserName().equals("")) {
                    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "User Name Is Required!", ""));
                } else if (user.getPassword().equals("")) {
                    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Password Is Required!", ""));
                } else if (status) {
                    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "User Created", ""));
                } else {
                    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Something Went Wrong!", "Please Check Given Info Carefully."));
                }
                System.out.println("acc: " + account.getAccountName());
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Account Not Found!", ""));
            }
        }
        return null;
    }
}
