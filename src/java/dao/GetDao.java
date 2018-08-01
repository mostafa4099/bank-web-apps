/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import addhandler.DepositMB;
import entity.AccountInfo;
import entity.Deposit;
import entity.Loan;
import entity.Transfer;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

/**
 *
 * @author DELL
 */
public class GetDao {

    public AccountInfo getAccountInfo(int number) {
        try {
            SessionFactory factory = HibernateUtil.getSessionFactory();
            Session session = factory.openSession();
            session.beginTransaction();

            AccountInfo accInfo = (AccountInfo) session.get(AccountInfo.class, number);

            session.getTransaction().commit();
            session.close();
            System.out.println("bbb "+ accInfo.getAccountName());
            return accInfo;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Loan checkLoan(int accountNumber) {
        try {
            SessionFactory factory = HibernateUtil.getSessionFactory();
            Session session = factory.openSession();
            session.beginTransaction();

            //Loan ln = (Loan) session.get(Loan.class, loan);
            Query query=session.createQuery("SELECT l from Loan l where l.accountInfo.accountNumber='"+accountNumber+"'");
            List<Loan> lnList=query.list();
            Loan ln=lnList.get(0);
            
            System.out.println("aaa" + ln.getInterestRate());

            session.getTransaction().commit();
            session.close();
            return ln;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
