/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addhandler;

import dao.SetDao;
import entity.AccountInfo;
import entity.Withdrawal;
import java.util.Date;
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
public class WithdrawMB {

    Withdrawal withdraw = new Withdrawal();
    AccountMB accountMB = new AccountMB();
    AccountInfo account = new AccountInfo();

    public AccountInfo getAccount() {
        return account;
    }

    public void setAccount(AccountInfo account) {
        this.account = account;
    }

    public AccountMB getAccountMB() {
        return accountMB;
    }

    public void setAccountMB(AccountMB accountMB) {
        this.accountMB = accountMB;
    }

    public Withdrawal getWithdraw() {
        return withdraw;
    }

    public void setWithdraw(Withdrawal withdraw) {
        this.withdraw = withdraw;
    }

    public String withdrawAccount(int a, double b) {
        FacesContext context = FacesContext.getCurrentInstance();
        account.setAccountNumber(a);
        withdraw.setAccountInfo(account);
        withdraw.setWithdraw(withdraw.getWithdraw());
        withdraw.setWdate(new Date());
        if (a == 0) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Please Check Account Number!", ""));
        } else if (withdraw.getWithdraw() == 0) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Please Input Minimum Amount!", ""));
        } else if (withdraw.getWithdraw() < 500) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Minimum Withdraw Amount 500 TK!", ""));
        } else if (withdraw.getWithdraw() > (b - 500)) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Insufficient Balance!", ""));
        } else if (new SetDao().withDraw(withdraw)) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "" + withdraw.getWithdraw() + " TK Withdrawn.", ""));
        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Something Went Wrong!", ""));
        }
        return null;
    }
}
