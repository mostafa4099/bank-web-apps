/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addhandler;

import dao.GetDao;
import dao.SetDao;
import entity.AccountInfo;
import entity.Loan;
import java.io.Serializable;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.hibernate.type.SerializableType;

/**
 *
 * @author DELL
 */
@ManagedBean
@SessionScoped
public class LoanMB implements Serializable {

    Loan loan = new Loan();
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

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public String checkPrevLoan() {
        FacesContext context = FacesContext.getCurrentInstance();
        AccountInfo acc = new GetDao().getAccountInfo(account.getAccountNumber());
        if (acc != null) {
            Loan ln = (Loan) new GetDao().checkLoan(acc.getAccountNumber());
            if (ln != null) {
                if (ln.getTotalPayable() == 0) {
                    account.setAccountNumber(ln.getAccountInfo().getAccountNumber());
                    loan.setAccountInfo(account);
                    if (new SetDao().deleteZeroLoan(loan)) {
                        this.account = acc;
                    } else {
                        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Something Went Wrong!", ""));
                    }
                } else {
                    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "You Are Not Eligible For Loan!", ""));
                }
            } else {
                this.account = acc;
            }
        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Account Not Found!", ""));
        }
        return null;
    }

    public String loanCalc() {
        FacesContext context = FacesContext.getCurrentInstance();
        loan.setLoanAmount(loan.getLoanAmount());
        loan.setInterestRate(loan.getInterestRate());
        loan.setTotalMonth(loan.getTotalMonth());
        if (loan.getLoanAmount() == 0) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Please Input Loan Amount", ""));
        } else if (loan.getInterestRate() == 0) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Please Input Interest Rate", ""));
        } else if (loan.getTotalMonth() == 0) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Please Input Month", ""));
        } else {
            loan.setTotalPayable(loan.getLoanAmount() + (loan.getLoanAmount() * loan.getInterestRate()) / 100);
            loan.setMonthlyPayment(loan.getTotalPayable() / loan.getTotalMonth());
        }
        return null;
    }

    public String giveLoan() {
        FacesContext context = FacesContext.getCurrentInstance();
        account.setAccountNumber(account.getAccountNumber());
        loan.setAccountInfo(account);
        loan.setTotalPayable(loan.getTotalPayable());
        loan.setMonthlyPayment(loan.getMonthlyPayment());
        loan.setLdate(new Date());
        if (account.getAccountNumber() == 0) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Please Check Account First.", ""));
        } else if (loan.getTotalPayable() == 0) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Please Calculate Loan First.", ""));
        } else if (loan.getMonthlyPayment() == 0) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Please Calculate Loan First.", ""));
        } else if (new SetDao().giveLoan(loan)) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Loan Successfull", ""));
        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Loan Unsuccessfull", ""));
        }
        return null;
    }

    public String checkLoan() {
        Loan ln = (Loan) new GetDao().checkLoan(account.getAccountNumber());
        FacesContext context = FacesContext.getCurrentInstance();
        if (account.getAccountNumber() == 0) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Please Input Account Number.", ""));
        } else if (ln != null) {
            this.loan = ln;
        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Not Found", ""));
        }
        return null;
    }
}
