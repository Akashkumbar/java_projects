package com.BankProject.DAO;
import com.BankProject.dto.*;
import java.util.List;


public interface TransactionDAO {
	public boolean insertTransaction(Transaction t);
	public List getTransaction(long user);
	List getTransaction();

}
