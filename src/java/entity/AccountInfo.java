package entity;
// Generated Apr 12, 2018 1:14:00 AM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * AccountInfo generated by hbm2java
 */
public class AccountInfo  implements java.io.Serializable {


     private Integer accountNumber;
     private String accountName;
     private String fatherName;
     private String motherName;
     private String address;
     private String mobile;
     private int nid;
     private Date dob;
     private double balance;
     private Date adate;
     private Set transfers = new HashSet(0);
     private Set loanPayments = new HashSet(0);
     private Set loans = new HashSet(0);
     private Set withdrawals = new HashSet(0);
     private Set users = new HashSet(0);
     private Set transactionAccounts = new HashSet(0);
     private Set deposits = new HashSet(0);

    public AccountInfo() {
    }

	
    public AccountInfo(String accountName, String fatherName, String motherName, String address, String mobile, int nid, Date dob, double balance, Date adate) {
        this.accountName = accountName;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.address = address;
        this.mobile = mobile;
        this.nid = nid;
        this.dob = dob;
        this.balance = balance;
        this.adate = adate;
    }
    public AccountInfo(String accountName, String fatherName, String motherName, String address, String mobile, int nid, Date dob, double balance, Date adate, Set transfers, Set loanPayments, Set loans, Set withdrawals, Set users, Set transactionAccounts, Set deposits) {
       this.accountName = accountName;
       this.fatherName = fatherName;
       this.motherName = motherName;
       this.address = address;
       this.mobile = mobile;
       this.nid = nid;
       this.dob = dob;
       this.balance = balance;
       this.adate = adate;
       this.transfers = transfers;
       this.loanPayments = loanPayments;
       this.loans = loans;
       this.withdrawals = withdrawals;
       this.users = users;
       this.transactionAccounts = transactionAccounts;
       this.deposits = deposits;
    }
   
    public Integer getAccountNumber() {
        return this.accountNumber;
    }
    
    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }
    public String getAccountName() {
        return this.accountName;
    }
    
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    public String getFatherName() {
        return this.fatherName;
    }
    
    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }
    public String getMotherName() {
        return this.motherName;
    }
    
    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    public String getMobile() {
        return this.mobile;
    }
    
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public int getNid() {
        return this.nid;
    }
    
    public void setNid(int nid) {
        this.nid = nid;
    }
    public Date getDob() {
        return this.dob;
    }
    
    public void setDob(Date dob) {
        this.dob = dob;
    }
    public double getBalance() {
        return this.balance;
    }
    
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public Date getAdate() {
        return this.adate;
    }
    
    public void setAdate(Date adate) {
        this.adate = adate;
    }
    public Set getTransfers() {
        return this.transfers;
    }
    
    public void setTransfers(Set transfers) {
        this.transfers = transfers;
    }
    public Set getLoanPayments() {
        return this.loanPayments;
    }
    
    public void setLoanPayments(Set loanPayments) {
        this.loanPayments = loanPayments;
    }
    public Set getLoans() {
        return this.loans;
    }
    
    public void setLoans(Set loans) {
        this.loans = loans;
    }
    public Set getWithdrawals() {
        return this.withdrawals;
    }
    
    public void setWithdrawals(Set withdrawals) {
        this.withdrawals = withdrawals;
    }
    public Set getUsers() {
        return this.users;
    }
    
    public void setUsers(Set users) {
        this.users = users;
    }
    public Set getTransactionAccounts() {
        return this.transactionAccounts;
    }
    
    public void setTransactionAccounts(Set transactionAccounts) {
        this.transactionAccounts = transactionAccounts;
    }
    public Set getDeposits() {
        return this.deposits;
    }
    
    public void setDeposits(Set deposits) {
        this.deposits = deposits;
    }




}


