/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addhandler;

import dao.GetDao;
import dao.SetDao;
import entity.AccountInfo;
import entity.Deposit;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author DELL
 */
@ManagedBean
@SessionScoped
public class DepositMB {

    Deposit dep = new Deposit();
    AccountMB accountMB = new AccountMB();
    AccountInfo account = new AccountInfo();

    public Deposit getDep() {
        return dep;
    }

    public void setDep(Deposit dep) {
        this.dep = dep;
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

    public String depositAccount(int a) {
        FacesContext context = FacesContext.getCurrentInstance();
        account.setAccountNumber(a);
        dep.setAccountInfo(account);
        dep.setDeposit(dep.getDeposit());
        dep.setDdate(new Date());
        if (a == 0) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Please Check Account Number!", ""));
        } else if (dep.getDeposit() == 0) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Please Input Minimum Amount!", ""));
        } else if (dep.getDeposit() < 100) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Minimum Deposit Amount 100 TK!", ""));
        } else if (new SetDao().depositAccount(dep)) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "" + dep.getDeposit() + " TK Deposited.", ""));
        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Something Went Wrong!", ""));
        }
        return null;
    }

}
