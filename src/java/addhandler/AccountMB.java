/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addhandler;

import dao.GetDao;
import dao.SetDao;
import entity.AccountInfo;
import java.io.Serializable;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author DELL
 */
@ManagedBean
@ViewScoped
public class AccountMB implements Serializable {

    AccountInfo account = new AccountInfo();
    int accnumber;

    public int getAccnumber() {
        return accnumber;
    }

    public void setAccnumber(int accnumber) {
        this.accnumber = accnumber;
    }

    public AccountInfo getAccount() {
        return account;
    }

    public void setAccount(AccountInfo account) {
        this.account = account;
    }

    public String createAccount() {
        FacesContext context = FacesContext.getCurrentInstance();
        account.setAccountName(account.getAccountName());
        account.setFatherName(account.getFatherName());
        account.setMotherName(account.getMotherName());
        account.setAddress(account.getAddress());
        account.setMobile(account.getMobile());
        account.setNid(account.getNid());
        account.setDob(account.getDob());
        account.setBalance(account.getBalance());
        account.setAdate(new Date());
        boolean status = new SetDao().createAccount(account);
        if (account.getAccountName().equals("")) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Name Is Required!", ""));
        } else if (account.getFatherName().equals("")) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Father Name Is Required!", ""));
        } else if (account.getMotherName().equals("")) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Mother Name Is Required!", ""));
        } else if (account.getAddress().equals("")) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Address Is Required!", ""));
        } else if (account.getMobile().equals("")) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Mobile Number Is Required!", ""));
        } else if (account.getNid() == 0) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "National Id Card Number Is Required!", ""));
        } else if (account.getDob() == null) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Date Of Birth Is Required!", ""));
        } else if (account.getBalance() == 0) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Minimum Amount Is Required!", ""));
        } else if (account.getBalance() < 500) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Minimum Amount Should Be 500 TK!", ""));
        } else if (status) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Account Created!", "Your Account Number is " + account.getAccountNumber() + ""));
        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Something Went Wrong!", "Please Check Given Info Carefully."));
        }
        return null;
    }

    public String accById() {
        AccountInfo acc = new GetDao().getAccountInfo(accnumber);
        if (acc != null) {
            this.account = acc;
            System.out.println("acc: " + account.getAccountName());
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Account Not Found!", ""));
        }
        return null;
    }

    public String closeAccount() {
        FacesContext context = FacesContext.getCurrentInstance();
        account.setAccountNumber(account.getAccountNumber());
//        boolean status = ;
        if (accnumber == 0) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Please Check Account Number!", ""));
        } else if (new SetDao().closeAccount(account)) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Account Close Successfully!", ""));
        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Something Went Wrong!", ""));
        }
        return null;
    }

    public String updateAccount() {
        FacesContext context = FacesContext.getCurrentInstance();
        account.setAccountName(account.getAccountName());
        account.setFatherName(account.getFatherName());
        account.setMotherName(account.getMotherName());
        account.setAddress(account.getAddress());
        account.setMobile(account.getMobile());
        account.setNid(account.getNid());
        account.setDob(account.getDob());
        if (account.getAccountName().equals("")) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Name Is Required!", ""));
        } else if (account.getFatherName().equals("")) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Father Name Is Required!", ""));
        } else if (account.getMotherName().equals("")) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Mother Name Is Required!", ""));
        } else if (account.getAddress().equals("")) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Address Is Required!", ""));
        } else if (account.getMobile().equals("")) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Mobile Number Is Required!", ""));
        } else if (account.getNid() == 0) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "National Id Card Number Is Required!", ""));
        } else if (account.getDob() == null) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Date Of Birth Is Required!", ""));
        } else if (new SetDao().updateAccount(account)) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Account Updated", ""));
        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Something Went Wrong!", "Please Check Given Info Carefully."));
        }
        return null;
    }
}
