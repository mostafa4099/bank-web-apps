/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addhandler;

import dao.SetDao;
import entity.AccountInfo;
import entity.Loan;
import entity.LoanPayment;
import java.io.Serializable;
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
public class LoanPaymentMB implements Serializable {

    LoanPayment payment = new LoanPayment();
    LoanMB loanMB = new LoanMB();
    AccountMB accountMB = new AccountMB();
    AccountInfo account = new AccountInfo();
    Loan loan = new Loan();

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

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public LoanMB getLoanMB() {
        return loanMB;
    }

    public void setLoanMB(LoanMB loanMB) {
        this.loanMB = loanMB;
    }

    public LoanPayment getPayment() {
        return payment;
    }

    public void setPayment(LoanPayment payment) {
        this.payment = payment;
    }

    public String loanPay(int a, int b, double d) {
        account.setAccountNumber(a);
        payment.setAccountInfo(account);
        loan.setLoanId(b);
        payment.setLoan(loan);
        payment.setPayMonth(payment.getPayMonth());
        payment.setPayAmount(payment.getPayAmount());
        payment.setPdate(new Date());
        FacesContext context = FacesContext.getCurrentInstance();
        if (a == 0) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Please Check Loan First.", ""));
        } else if (d == 0) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "You Have Not Any Loan.", ""));
        } else if (payment.getPayMonth() == 0) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Please Input Pay Month.", ""));
        } else if (payment.getPayAmount() == 0) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Please Input Pay Amount.", ""));
        } else if (new SetDao().loanPay(payment)) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Payment Successfull", ""));
        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Loan Unsuccessfull", ""));
        }
        return null;
    }
}
