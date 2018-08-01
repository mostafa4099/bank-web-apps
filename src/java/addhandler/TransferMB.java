/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addhandler;

import dao.GetDao;
import dao.SetDao;
import entity.AccountInfo;
import entity.Transfer;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;

/**
 *
 * @author DELL
 */
@ManagedBean
@SessionScoped
public class TransferMB {

    AccountMB accountMB = new AccountMB();
    Transfer transfer = new Transfer();
    AccountInfo account = new AccountInfo();

    public AccountInfo getAccount() {
        return account;
    }

    public void setAccount(AccountInfo account) {
        this.account = account;
    }

    public Transfer getTransfer() {
        return transfer;
    }

    public void setTransfer(Transfer transfer) {
        this.transfer = transfer;
    }

    public AccountMB getAccountMB() {
        return accountMB;
    }

    public void setAccountMB(AccountMB accountMB) {
        this.accountMB = accountMB;
    }

    public String transferBalance(int a, Double b) {
        FacesContext context = FacesContext.getCurrentInstance();
        account.setAccountNumber(a);
        transfer.setAccountInfo(account);
        transfer.setTransferAccount(transfer.getTransferAccount());
        transfer.setTransferAmount(transfer.getTransferAmount());
        transfer.setTdate(new Date());
        if (a == 0) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Please Check Account Number!", ""));
        } else if (transfer.getTransferAccount() == 0) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Please Input Transfer Account Number!", ""));
        } else if (transfer.getTransferAmount() == 0) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Please Input Transfer Amount!", ""));
        } else if (transfer.getTransferAmount() > (b - 500)) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Insufficient Balance!", ""));
        } else if (new SetDao().balanceTransfer(transfer)) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "" + transfer.getTransferAmount() + " Tk Transfered!", ""));
        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Somthing went wrong!", ""));
        }
        return null;
    }
}
